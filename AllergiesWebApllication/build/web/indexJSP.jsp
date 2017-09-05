<%-- 
    Document   : indexJSP
    Created on : Jan 12, 2017, 3:34:29 PM
    Author     : Ada
--%>
<%@page import="domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
        <title>Allergies</title>
        <link rel="stylesheet" href="style.css" type="text/css" />
    </head>
    <body>
        <%String user="";
            if(session.getAttribute("user")==null){
         user="Guest";
        }
            else{
                user=(String)session.getAttribute("user");
    }%>
        <div id="bigmenu">

            <div id="bigmenulinks">
                You are logged in as: <%=user%>
                <a href="LoginJSP.jsp">Login</a>

            </div>
        </div>
        <div id="sidebar">
            <h1><img id="pizzalogo" src="imgs/allergy-free.png" alt="#" width="120px"/></h1>


            <div id="menu">
                <a class="active" href="indexJSP.jsp">Home</a>
                <%
                 
                    if(user.equals("admin")){%>
                <a href="addFactorJSP.jsp">Add Factor</a> 
                <a href="addLocation.jsp">Add Location</a> 
                <a href="addSensorJSP.jsp">Add Sensor</a>
                <a href="addFactorToLocationJSP.jsp">Add Factor To Location</a>
                <a href="addSensorToLocationJSP.jsp">Add Sensor To Location</a>
<%}%>

            </div>
            <img id="logo" src="imgs/allogo.png" >
        </div>
        <div id="sidebar2">

            <div id="menu2">

            </div>
        </div>
        <div id="uppermenu">
            <nav>
                <ul>
                    <li><a class="PolyLogo" href="indexJSP.jsp"></a></li>
                   
                </ul>
            </nav>
        </div>
        <div id="content" ">

            <div class="slideshow">

                <div class="slideshowDisplay">
                    <img src="imgs/al1.jpg" style="width:100%">

                </div>

                <div class="slideshowDisplay">
                    <img src="imgs/al2.jpg" style="width:100%">

                </div>

                <div class="slideshowDisplay">
                    <img src="imgs/al3.jpg" style="width:100%">

                </div>

                <div class="slideshowDisplay">
                    <img src="imgs/al4.jpg" style="width:100%">

                </div>

                <div class="slideshowDisplay">
                    <img src="imgs/al1.jpg" style="width:100%">

                </div>


                <a id="left" style="position:absolute;top:52%;left:0;opacity:0.4" onclick="plusDivs(-1)"><img src="imgs/left.png"></a>
                <a id="right" style="position:absolute;top:52%;right:0;opacity:0.4" onclick="plusDivs(1)"><img src="imgs/right.png"></a>

            </div>

            <script>
                var slideIndex = 0;
                carousel();
                showDivs(slideIndex);

                function carousel() {
                    var i;
                    var x = document.getElementsByClassName("slideshowDisplay");
                    for (i = 0; i < x.length; i++) {
                        x[i].style.display = "none";
                    }
                    slideIndex++;
                    if (slideIndex > x.length) {
                        slideIndex = 1;
                    }
                    x[slideIndex - 1].style.display = "block";
                    setTimeout(carousel, 4000); // Change image every 2 seconds
                }


                function plusDivs(n) {
                    showDivs(slideIndex += n);
                }

                function showDivs(n) {
                    var i;
                    var x = document.getElementsByClassName("slideshowDisplay");
                    if (n > x.length) {
                        slideIndex = 1;
                    }
                    if (n < 1) {
                        slideIndex = x.length;
                    }
                    ;
                    for (i = 0; i < x.length; i++) {
                        x[i].style.display = "none";
                    }
                    x[slideIndex - 1].style.display = "block";
                }

            </script>

        



        </div>

    </body>
</html>