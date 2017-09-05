<%-- 
    Document   : AllergyReactionProb
    Created on : Jan 17, 2017, 6:07:17 PM
    Author     : Ada
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="domain.TriggerLocation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <title>Register Allergy Reaction!</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">

    </head>

<% HashMap<TriggerLocation, String> riskMap = (HashMap<TriggerLocation, String>) session.getAttribute("locWithProb");%>

    <%
        String error = "";
        if (request.getAttribute("LOGIN_ERROR") != null) {
            error = (String) request.getAttribute("LOGIN_ERROR");
        }

    %>
    <body>
        <div id="bigmenu">

            <div id="bigmenulinks">
                <%if (session.getAttribute("user") == null) {%>
                <a href="LoginJSP.jsp">Login</a>
                <a href="RegistrationJSP.jsp">Register</a>

                <%} else {%>
                You are logged in as <b><%=session.getAttribute("user")%></b>
                <a href="LogoutC">Logout</a>
                <%}%>

            </div>
        </div>
        <div id="sidebar">
            <h1><img id="pizzalogo" src="imgs/allergy-free.png" alt="#" width="120px"/></h1>


            <div id="menu">
                <a class="active" href="indexJSP.jsp">Home</a>
                <a href="ProfileJSP.jsp">Profile</a>
                <a href="RegisterAllergyReaction.jsp">Register Allergy Reaction Location</a>
               <a href="RegisterNoAllergyLocation.jsp">Register Visit To Location</a>
                <a href="CheckLocationJSP.jsp">Check Location</a>
                   <a href="RiskJSP.jsp">Risk Map</a>
                <a href="AllergyReactionProb.jsp">Allergy Reactions Probabilities</a>



            </div>
            <br><br>
            <br><br>
            <br><br>
            <img id="logo" src="imgs/allogo.png" >
        </div>
        <div id="sidebar2">

            <div id="menu2">

            </div>
        </div>

        <div id="contentUser" style='background-size: 100% auto; background-attachment: fixed;'>
            <div id="uppermenu">
                <nav>
                    <ul>

                        <li><a class="PolyLogo" href="indexJSP.jsp"></a></li>


                    </ul>
                </nav>
            </div>
      
            <h1>Allergy Reaction Probabilities</h1>
            <div class="loginform">

                <div class="form-element">

                     
                                <ul>
                                    <ul>
                                        <%for (Map.Entry<TriggerLocation, String> entry : riskMap.entrySet()) {%>
                                        <li> <label for="name">  <%=entry.getKey().getName()%> : <%=entry.getValue()%></h2>  </label>
                                            <%}%>
                                    </ul>

                                </ul>
                </div>




            </div>
        </div>
    </body>
</html>
