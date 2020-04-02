/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assignment2.DupFlixJpaController.DupFlixJPAController;

import com.mycompany.assignment2.DupFlixJpaController.DupFlixJPAController.exceptions.NonexistentEntityException;
import com.mycompany.assignment2.DupFlixJpaController.DupFlixJPAController.exceptions.PreexistingEntityException;
import com.mycompany.assignment2.entities.Dupflix;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Niya
 */
public class DupflixJpaController implements Serializable {

    public DupflixJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dupflix dupflix) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(dupflix);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDupflix(dupflix.getDupflixId()) != null) {
                throw new PreexistingEntityException("Dupflix " + dupflix + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dupflix dupflix) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            dupflix = em.merge(dupflix);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dupflix.getDupflixId();
                if (findDupflix(id) == null) {
                    throw new NonexistentEntityException("The dupflix with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dupflix dupflix;
            try {
                dupflix = em.getReference(Dupflix.class, id);
                dupflix.getDupflixId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dupflix with id " + id + " no longer exists.", enfe);
            }
            em.remove(dupflix);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dupflix> findDupflixEntities() {
        return findDupflixEntities(true, -1, -1);
    }

    public List<Dupflix> findDupflixEntities(int maxResults, int firstResult) {
        return findDupflixEntities(false, maxResults, firstResult);
    }

    private List<Dupflix> findDupflixEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dupflix.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Dupflix findDupflix(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dupflix.class, id);
        } finally {
            em.close();
        }
    }

    public int getDupflixCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dupflix> rt = cq.from(Dupflix.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
