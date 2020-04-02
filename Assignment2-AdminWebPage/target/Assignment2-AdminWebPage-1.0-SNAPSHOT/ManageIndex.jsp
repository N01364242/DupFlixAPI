
<%-- 
    Document   : index
    Created on : 12 Mar, 2020, 7:23:16 PM
    Author     : Niya
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="service.Dupflix"%>
<%@page import="java.util.Base64"%>
<%@page import="service.AdminDatabaseService"%>;
<%@page import="service.AdminDatabaseService_Service"%>;
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Candal|Lora&amp;display=swap" rel="stylesheet">

        <title>Admin</title>
        <style>

            *{
                box-sizing: border-box;
            }

            body{
                padding: 0px;
                margin: 0px;
                height: 100%;
                width: 100%;
                background: white;
                font-family:'Lora', serif ;
            }

            header{
                background: #014042;
                height: 66px;
            }
            header *{
                color: white;
            }
            header .logo{
                float:left;
                height: inherit;
                margin-left: 2em;
            }

            header .logo-text{
                margin: 5px;
                font-family: 'Canda', serif;
            }
            header .logo-text span{
                color: blue;

            }

            header ul{
                float:right;
                margin: 0px;
                padding: 0px;
                list-style: none;

            }
            header ul li{
                float: left;
                position: relative;
            }
            header ul li ul{
                position: absolute;
                top: 66px;
                right: 0px;
                width: 180px;
                display: none;

            }
            header ul li:hover ul{
                display: block;
            }


            header ul li ul li{
                width: 100%;
                background: white;
                color: #444;

            }
            header ul li ul a{
                background: #d5d6d6;

            }

            header ul li ul a.logout{
                color: red;

            }

            header ul li ul a:hover{
                padding: 10px;

            }

            header ul li a{
                display: block;
                padding: 21px;
                font-size: 1.1em;
                text-decoration: none;
            }
            header ul li a:hover{
                background: #006669;
                transition: 0.5s;
            }
            header .menu-toggle{
                display: none;
            }

            /* Media queries */
            @media only screen and (max-width: 750px){
                header{
                    position: relative;
                }
                .showing{

                    max-height: 100em;
                }

                header ul {
                    width: 100%;
                    background: #0E94A0;
                    max-height: 0px;
                    overflow: hidden;
                }
                header ul li{
                    width: 100%;
                }  
                header ul li ul{
                    position: static;
                    display: block;
                    width: 100%;
                } 
                header ul li ul li a{
                    padding: 10px;
                    background: #0E94A0;
                    color:white;
                    padding-left: 50px;

                }
                header ul li ul a.logout{
                    color: red;

                }
                header ul li ul a{
                    background: #006669;
                }
                header .menu-toggle{
                    display: block;
                    position: absolute;
                    right:20px;
                    top: 10px;
                    font-size: 1.9em;
                } 

                header .logo{
                    margin-left: .8em;
                }



            }
            .admin-wrapper {
                display: flex;
                height: 100%;


            }

            .admin-wrapper .left-sidebar {
                flex: 2;
                height: 100%;
                background: #234a57;

            }

            .admin-wrapper .left-sidebar ul{

                list-style: none;
                margin: 0px;
                padding: 0px;
                color: aliceblue;

            }

            .admin-wrapper .left-sidebar ul li a{

                padding: 18px;
                display: block;
                border-bottom: 1px solid #004044;

            }

            .admin-wrapper .left-sidebar ul li a:hover{

                background:#004044;

            }

            .admin-wrapper .admin-content {
                flex: 8;
                height: 100%;
                padding: 40px 100px 100px;
                overflow-y: scroll;

            }

            .admin-content .page-title{
                text-align: center;
                margin-bottom: 1.5rem;
            }
            table {
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even){background-color: #f2f2f2}

            th {
                background-color: #234a57;
                color: white;
            }
        </style>
    </head>
    <body>
        <header>
            <div class="logo">
                <h1 class="logo-text"><span>Dup</span>Flix</h1>
            </div>
            <i class="fa fa-bars menu-toggle"></i>
            <ul class="nav">

                <li><a href="#" class="logout">Logout</a></li>

            </ul>
        </header>

        <div class="admin-wrapper" style="height:900px;">
            <!--Admin wrapper starts-->


            <div class="left-sidebar">
                <!--Left side bar starts-->
                <ul>
                   
                    <li><a href="index.jsp">Add Videos</a></li>
                    <li><a href="ManageIndex.jsp">Manage Videos</a></li>
                </ul>


            </div>
            <!--Left side bar ends-->

<% AdminDatabaseService_Service adminService = new AdminDatabaseService_Service();
            AdminDatabaseService port = adminService.getAdminDatabaseServicePort();
            List<Dupflix> dupFlixList = new ArrayList<Dupflix>();
            dupFlixList = port.getAllDupFlixData();%>

            <div class="admin-content"><!--Admin Content starts-->

                <div class="content">
                    <form action="AdminManageServlet" method="post">
                    <h2 class="page-title"> Manage Post</h2>
                    <table>
                        <tr>
                            <th>Movie Id</th>
                            <th>Movie Name</th>
                            <th>Thumbnail</th>
                            <th>Subtitle</th>
                            <th>Category</th>
                            <th>Description</th>
                            <th>Director</th>
                            <th>Producer</th>
                            <th class="text-right">ACTIONS</th>
                        </tr>
                        <%
                           
                            for (Dupflix dupflix : dupFlixList) {
                                String base64Image = Base64.getEncoder().encodeToString(dupflix.getThumbnail());
                                


                        %>
                        <tr>
                            <td> <%=dupflix.getDupflixId()%> </td>
                            <td contenteditable="false"><%=dupflix.getMovieName()%></td>
                            <td><img src="data:image/jpg;base64,<%=base64Image%>" width="50" height="80"/></td>
                           
                            <td><%=dupflix.getMovieSubtitle()%></td>
                            <td><%=dupflix.getCategoryType()%></td>
                            <td><%=dupflix.getMovieDescription()%></td>
                            <td><%=dupflix.getDirector()%></td>
                            <td><%=dupflix.getProducer()%></td>

                            <td class="text-right">
                               <input type="hidden" name="post_id" value="<%=dupflix.getDupflixId()%>"/>
                                
                                    <input type="submit" name="UPDATE" class="btn btn-primary badge-pill btn-sm" value="UPDATE"/>
                                    
                                    <input type="submit" name="DELETE" class="btn btn-danger badge-pill btn-sm" value="DELETE">
                                   
                                </form>
                            </td>

                        </tr>

                        <%  }%>

                    </table>
                </div>

            </div><!--Admin Content ends-->
        </div> <!--Admin wrapper ends-->

<script>
            $(document).on("change", ".file_multi_video", function (evt) {
                var $source = $('#video_here');
                $source[0].src = URL.createObjectURL(this.files[0]);
                $source.parent()[0].load();
            });
            
           
        </script>

    </body>
</html>
