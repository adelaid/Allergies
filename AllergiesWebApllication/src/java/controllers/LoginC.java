/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domain.Sensor;
import domain.TriggerFactor;
import domain.TriggerLocation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessions.SensorManagementLocal;
import sessions.TriggerFactorManagementLocal;
import sessions.TriggerLocationManagementLocal;
import sessions.UsersManagementLocal;

/**
 *
 * @author Ada
 */
public class LoginC extends HttpServlet {

    @EJB
    private TriggerLocationManagementLocal triggerLocationManagement;

    @EJB
    private SensorManagementLocal sensorManagement;

    @EJB
    private TriggerFactorManagementLocal triggerFactorManagement;

    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("uname");
        String password = request.getParameter("password");
       
        if (username.equals("admin") && password.equals("admin")) {
            System.out.println("bef");
            Vector<TriggerLocation> allLocations = triggerLocationManagement.getAllLocations();
            System.out.println("loc");
            Vector<TriggerFactor> factors = triggerFactorManagement.getFactors();
            Vector<Sensor> sensors = sensorManagement.getSensors();
            System.out.println("in servlet" + sensors.size());
            request.getSession().setAttribute("sensors", sensors);
            request.getSession().setAttribute("locations", allLocations);
            request.getSession().setAttribute("factors", factors);
            request.getSession().setAttribute("user", "admin");
            request.getRequestDispatcher("indexJSP.jsp").forward(request, response);
        }
        
        
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
