<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="service.Dupflix"%>
<%@page import="java.util.Base64"%>

<%-- 
    Document   : index
    Created on : 12 Mar, 2020, 7:23:16 PM
    Author     : Niya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            input[type=text], select, textarea {
                width: 100%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                resize: vertical;
            }

            label {
                padding: 12px 12px 12px 0;
                display: inline-block;
            }

            input[type=submit] {
                background-color: #4CAF50;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                float: right;
            }

            input[type=submit]:hover {
                background-color: #45a049;
            }

            .container {
                border-radius: 5px;
                background-color: #f2f2f2;
                padding: 20px;
            }

            .col-25 {
                float: left;
                width: 25%;
                margin-top: 6px;
            }

            .col-75 {
                float: left;
                width: 75%;
                margin-top: 6px;
            }

            /* Clear floats after the columns */
            .row:after {
                content: "";
                display: table;
                clear: both;
            }

            /* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
            @media screen and (max-width: 600px) {
                .col-25, .col-75, input[type=submit] {
                    width: 100%;
                    margin-top: 0;
                }
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



            <div class="admin-content"><!--Admin Content starts-->

                <div class="content">
                    <h2 class="page-title"> Manage Post</h2>
                    <div class="container">
                        <form action="AdminUpdateServlet" method="post" enctype="multipart/form-data">
                            <%
                                Dupflix dupFlix = (Dupflix) request.getAttribute("dupFlix");

                                String base64Image = Base64.getEncoder().encodeToString(dupFlix.getThumbnail());
                                


                            %>
                            <div class="row">
                                <div class="col-25">
                                    <label for="fname">Movie Name</label>
                                </div>
                                <div class="col-75">
                                    <input type="text"  name="title" value="<%=dupFlix.getMovieName()%>" placeholder="Movie name..">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-25">
                                    <label for="subtitle">Movie Subtitle</label>
                                </div>
                                <div class="col-75">
                                    <input type="text"  name="subtitle" value="<%=dupFlix.getMovieSubtitle()%>" placeholder="Movie subtitle..">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-25">
                                    <label for="category">Category</label>
                                </div>
                                <div class="col-75">
                                    <select id="category" name="category" value="<%=dupFlix.getCategoryType()%>">
                                        <option value="Romantic">Romantic</option>
                                        <option value="Fiction&Science">Fiction&Science</option>
                                        <option value="Crime Thriller">Crime Thriller</option>
                                         <option value="Horror">Horror</option>
                                  <option value="Family">Family</option> 
                                  <option value="Adventure">Adventure</option>
                                        <option value="Comedy">Comedy</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-25">
                                    <label for="desc">Movie Description</label>
                                </div>
                                <div class="col-75">
                                    <textarea  name="description" placeholder="Write something.." style="height:200px"><%=dupFlix.getMovieDescription()%></textarea>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-25">
                                    <label for="director">Movie Director</label>
                                </div>
                                <div class="col-75">
                                    <input type="text"  name="director" value="<%=dupFlix.getDirector()%>"placeholder="Movie Director..">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-25">
                                    <label for="producer">Movie Producer</label>
                                </div>
                                <div class="col-75">
                                    <input type="text" name="producer" value="<%=dupFlix.getProducer()%>" placeholder="Movie subtitle..">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-25">
                                    <label for="thumbnail">Movie Thumbnail Image</label>
                                </div>
                                <div class="col-75">
                                    <img src="data:image/jpg;base64,<%=base64Image%>" width="50" height="80"/><br/>
                                    
                                </div>
                            </div>
                           
                            
                            <div class="row">
                                <input type="hidden" name="thumbnail" value="<%=base64Image%>"/>
                            
                                <input type="hidden" name="post_id" value="<%=dupFlix.getDupflixId()%>"/>
                                <input type="submit" value="Submit">
                            </div>
                        </form>
                    </div>

                </div>

            </div><!--Admin Content ends-->


        </div>

    </div>
    <!--Admin wrapper ends-->

    <script>
        $(document).on("change", ".file_multi_video", function (evt) {
            var $source = $('#video_here');
            $source[0].src = URL.createObjectURL(this.files[0]);
            $source.parent()[0].load();
        });

        $(document).ready(function() {



    </script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>





</body>
</html>
