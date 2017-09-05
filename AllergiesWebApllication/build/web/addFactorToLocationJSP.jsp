<%-- 
    Document   : addFactorToLocationJSP
    Created on : Jan 12, 2017, 7:15:22 PM
    Author     : Ada
--%>

<%@page import="domain.TriggerFactor"%>
<%@page import="java.util.Vector"%>
<%@page import="domain.TriggerLocation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style.css" type="text/css"/>
    </head>
    <body>
        <div id="bigmenu">

            <div id="bigmenulinks">
                <% Vector<TriggerLocation> locations = (Vector<TriggerLocation>) session.getAttribute("locations"); %>
                <% Vector<TriggerFactor> factors = (Vector<TriggerFactor>) session.getAttribute("factors");%>
                <%if (session.getAttribute("user") == null) {%>
                <a href="LoginJSP.jsp">Login</a>
          

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
                <a href="addFactorJSP.jsp">Add Factor</a> 
                <a href="addLocation.jsp">Add Location</a> 
                <a href="addSensorJSP.jsp">Add Sensor</a>
                <a class="active" href="addFactorToLocationJSP.jsp">Add Factor To Location</a>
                <a href="addSensorToLocationJSP.jsp">Add Sensor To Location</a>

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

            <h1>Add Factor to Location!</h1>
            <div class="loginform">
                <form method="post" action="AddFactorToLocationC">
                    <div class="form-element">
                        <label for="cmbLocation">Location </label>
                        <select id="cmbLocation" name="cmbLocation">
                            <%  for (int i = 0; i < locations.size(); i++) {
                                    TriggerLocation option = locations.get(i);
                            %>
                            <option value="<%= option.getId()%>"><%= option.getName()%></option>
                            <% }%>
                        </select>
                    </div>
                       <div class="form-element">
                           <label for="cmbFactor">Factor </label>
                                <select id="cmbFactor" name="cmbFactor">
                                    <%  for (int i = 0; i < factors.size(); i++) {
                                            TriggerFactor option = factors.get(i);
                                    %>
                                    <option value="<%= option.getId()%>"><%= option.getFactorName()%></option>
                                    <% }%>
                                </select>
                       </div>
 
                    <div class="form-element">
                        <label for="username">Percentage</label>
                        <input type="text" name="percent" id="name" required>
                    </div>



                    <div class="form-element">
                        <input id="formBt" style="background-color: #EB865B;" type="submit" value="Submit">
                        <input id="formBt" style="background-color: #EB865B;" type="reset" value="Reset">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
