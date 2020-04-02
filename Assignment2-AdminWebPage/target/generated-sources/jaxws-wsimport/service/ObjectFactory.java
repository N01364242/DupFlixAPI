
package service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllDupFlixData_QNAME = new QName("http://service/", "getAllDupFlixData");
    private final static QName _Upload_QNAME = new QName("http://service/", "upload");
    private final static QName _Dupflix_QNAME = new QName("http://service/", "dupflix");
    private final static QName _DeleteDupFlixDataResponse_QNAME = new QName("http://service/", "deleteDupFlixDataResponse");
    private final static QName _EditDupFlixDataResponse_QNAME = new QName("http://service/", "editDupFlixDataResponse");
    private final static QName _GetDupFlixData_QNAME = new QName("http://service/", "getDupFlixData");
    private final static QName _DeleteDupFlixData_QNAME = new QName("http://service/", "deleteDupFlixData");
    private final static QName _GetDupFlixDataResponse_QNAME = new QName("http://service/", "getDupFlixDataResponse");
    private final static QName _UploadResponse_QNAME = new QName("http://service/", "uploadResponse");
    private final static QName _EditDupFlixData_QNAME = new QName("http://service/", "editDupFlixData");
    private final static QName _GetAllDupFlixDataResponse_QNAME = new QName("http://service/", "getAllDupFlixDataResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDupFlixData }
     * 
     */
    public GetDupFlixData createGetDupFlixData() {
        return new GetDupFlixData();
    }

    /**
     * Create an instance of {@link EditDupFlixDataResponse }
     * 
     */
    public EditDupFlixDataResponse createEditDupFlixDataResponse() {
        return new EditDupFlixDataResponse();
    }

    /**
     * Create an instance of {@link DeleteDupFlixDataResponse }
     * 
     */
    public DeleteDupFlixDataResponse createDeleteDupFlixDataResponse() {
        return new DeleteDupFlixDataResponse();
    }

    /**
     * Create an instance of {@link Dupflix }
     * 
     */
    public Dupflix createDupflix() {
        return new Dupflix();
    }

    /**
     * Create an instance of {@link Upload }
     * 
     */
    public Upload createUpload() {
        return new Upload();
    }

    /**
     * Create an instance of {@link GetAllDupFlixData }
     * 
     */
    public GetAllDupFlixData createGetAllDupFlixData() {
        return new GetAllDupFlixData();
    }

    /**
     * Create an instance of {@link EditDupFlixData }
     * 
     */
    public EditDupFlixData createEditDupFlixData() {
        return new EditDupFlixData();
    }

    /**
     * Create an instance of {@link GetAllDupFlixDataResponse }
     * 
     */
    public GetAllDupFlixDataResponse createGetAllDupFlixDataResponse() {
        return new GetAllDupFlixDataResponse();
    }

    /**
     * Create an instance of {@link DeleteDupFlixData }
     * 
     */
    public DeleteDupFlixData createDeleteDupFlixData() {
        return new DeleteDupFlixData();
    }

    /**
     * Create an instance of {@link GetDupFlixDataResponse }
     * 
     */
    public GetDupFlixDataResponse createGetDupFlixDataResponse() {
        return new GetDupFlixDataResponse();
    }

    /**
     * Create an instance of {@link UploadResponse }
     * 
     */
    public UploadResponse createUploadResponse() {
        return new UploadResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllDupFlixData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllDupFlixData")
    public JAXBElement<GetAllDupFlixData> createGetAllDupFlixData(GetAllDupFlixData value) {
        return new JAXBElement<GetAllDupFlixData>(_GetAllDupFlixData_QNAME, GetAllDupFlixData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Upload }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "upload")
    public JAXBElement<Upload> createUpload(Upload value) {
        return new JAXBElement<Upload>(_Upload_QNAME, Upload.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Dupflix }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "dupflix")
    public JAXBElement<Dupflix> createDupflix(Dupflix value) {
        return new JAXBElement<Dupflix>(_Dupflix_QNAME, Dupflix.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteDupFlixDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deleteDupFlixDataResponse")
    public JAXBElement<DeleteDupFlixDataResponse> createDeleteDupFlixDataResponse(DeleteDupFlixDataResponse value) {
        return new JAXBElement<DeleteDupFlixDataResponse>(_DeleteDupFlixDataResponse_QNAME, DeleteDupFlixDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditDupFlixDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "editDupFlixDataResponse")
    public JAXBElement<EditDupFlixDataResponse> createEditDupFlixDataResponse(EditDupFlixDataResponse value) {
        return new JAXBElement<EditDupFlixDataResponse>(_EditDupFlixDataResponse_QNAME, EditDupFlixDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDupFlixData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getDupFlixData")
    public JAXBElement<GetDupFlixData> createGetDupFlixData(GetDupFlixData value) {
        return new JAXBElement<GetDupFlixData>(_GetDupFlixData_QNAME, GetDupFlixData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteDupFlixData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deleteDupFlixData")
    public JAXBElement<DeleteDupFlixData> createDeleteDupFlixData(DeleteDupFlixData value) {
        return new JAXBElement<DeleteDupFlixData>(_DeleteDupFlixData_QNAME, DeleteDupFlixData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDupFlixDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getDupFlixDataResponse")
    public JAXBElement<GetDupFlixDataResponse> createGetDupFlixDataResponse(GetDupFlixDataResponse value) {
        return new JAXBElement<GetDupFlixDataResponse>(_GetDupFlixDataResponse_QNAME, GetDupFlixDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "uploadResponse")
    public JAXBElement<UploadResponse> createUploadResponse(UploadResponse value) {
        return new JAXBElement<UploadResponse>(_UploadResponse_QNAME, UploadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditDupFlixData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "editDupFlixData")
    public JAXBElement<EditDupFlixData> createEditDupFlixData(EditDupFlixData value) {
        return new JAXBElement<EditDupFlixData>(_EditDupFlixData_QNAME, EditDupFlixData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllDupFlixDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getAllDupFlixDataResponse")
    public JAXBElement<GetAllDupFlixDataResponse> createGetAllDupFlixDataResponse(GetAllDupFlixDataResponse value) {
        return new JAXBElement<GetAllDupFlixDataResponse>(_GetAllDupFlixDataResponse_QNAME, GetAllDupFlixDataResponse.class, null, value);
    }

}
