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
                font-size: 32;
                margin-bottom: 1.5rem;
            }
            .imagePreview {
    width: 180px;
    height: 180px;
    background-position: center center;
  background:url(http://cliquecities.com/assets/no-image-e3699ae23f866f6cbdf8ba2443ee5c4e.jpg);
  background-color:#fff;
    background-size: cover;
  background-repeat:no-repeat;
    display: inline-block;
  box-shadow:0px -3px 6px 2px rgba(0,0,0,0.2);
}
.btn-primary
{
  display:block;
  width: 180px;
  border-radius:0px;
  box-shadow:0px 4px 6px 2px rgba(0,0,0,0.2);
  margin-top:-5px;
}
.imgUp
{
  margin-bottom:15px;
}
input[type=text],textarea, select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
button[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button[type=submit]:hover {
  background-color: #45a049;
}

        </style>
    </head>
    <body>
        <script>
             $(function () {
      $(document).on("change", ".uploadFile", function () {
        var uploadFile = $(this);
        var files = !!this.files ? this.files : [];
        if (!files.length || !window.FileReader) return; // no file selected, or no FileReader support

        if (/^image/.test(files[0].type)) { // only image file
          var reader = new FileReader(); // instance of the FileReader
          reader.readAsDataURL(files[0]); // read the local file

          reader.onloadend = function () { // set image data as background of div
            //alert(uploadFile.closest(".upimage").find('.imagePreview').length);
            uploadFile.closest(".imgUp").find('.imagePreview').before('</label>').css("background-image", "url(" + this.result + ")");
          }
        }

      });
    });
            </script>
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
                    <h2 class="page-title"><b> ADD POST</b></h2>
                    <form action="AdminServlet" method="post" enctype="multipart/form-data">
                    <div class="row" style="border: 1px solid white;">

                        <div class="col-sm-6">
                           <div class="col-sm-2 text-center imgUp" style="margin: 1rem;">
                        <div class="imagePreview"></div>
                        <label class="btn btn-primary">
                          Upload<input type="file" id="eventLogo" class="uploadFile img" name="thumbnail" value="Upload Photo"
                            style="width: 0px;height: 0px;overflow: hidden;">
                        </label>
                      </div>
                             <label>Title</label><br>
                             <input type="text" name="title" class="text-input" required><br>
                             <label>Subtitle</label><br>
                             <input type="text" name="subtitle" class="text-input" required><br>
                        </div>

                        <div class="col-sm-6">
                           
                            <label>Director</label><br>
                            <input type="text" name="director" class="text-input" required><br>
                            <label>Producer</label><br>
                            <input type="text" name="producer" class="text-input" required><br>
                            <label>Description</label><br>
                            <textarea name="description" id="desc" required></textarea><br>
                            <label>Category</label><br>
                            <select id="category" name="category" required>
                                <option value="Romantic">Romantic</option>
                                <option value="Fiction&Science">Fiction&Science</option>
                                <option value="Crime Thriller">Crime Thriller</option>
                                 <option value="Horror">Horror</option>
                                  <option value="Family">Family</option> 
                                  <option value="Adventure">Adventure</option>
                                  
                                <option value="Comedy">Comedy</option>
                            </select><br>
                            
                            <button type="submit" class="btn btn-big">POST!!!</button>
                        </div>

                    </div>
                 </form>
                </div>

            </div><!--Admin Content ends-->



        </div>
        <!--Admin wrapper ends-->

        <script>
            $(document).on("change", ".file_multi_video", function (evt) {
                var $source = $('#video_here');
                $source[0].src = URL.createObjectURL(this.files[0]);
                $source.parent()[0].load();
            });
            
           
        </script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
       
    



</body>
</html>
