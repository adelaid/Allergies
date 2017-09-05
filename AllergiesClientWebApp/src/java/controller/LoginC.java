/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.LocationFactors;
import domain.Risk;
import domain.TriggerFactor;
import domain.TriggerLocation;
import domain.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessions.EventManagementLocal;
import sessions.LocationFactorsManagementLocal;
import sessions.RiskManagamentLocal;
import sessions.TriggerFactorManagementLocal;
import sessions.TriggerLocationManagementLocal;
import sessions.UsersManagementLocal;

/**
 *
 * @author Ada
 */
public class LoginC extends HttpServlet {

    @EJB
    private TriggerFactorManagementLocal triggerFactorManagement;

    @EJB
    private TriggerLocationManagementLocal triggerLocationManagement;

    @EJB
    private LocationFactorsManagementLocal locationFactorsManagement;

    @EJB
    private RiskManagamentLocal riskManagament;

    @EJB
    private UsersManagementLocal usersManagement;

    @EJB
    private EventManagementLocal eventManagement;

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
        User user = usersManagement.getUser(username);
        if (user != null) {
            Vector<TriggerLocation> allLocations = triggerLocationManagement.getAllLocations();
            Vector<TriggerFactor> factors = triggerFactorManagement.getFactors();
            
            if (user.getFactor() != null) {
                Vector<LocationFactors> allowedLocationsFactors = locationFactorsManagement.getAllowedLocations(user.getFactor().getId());
                Vector<LocationFactors> avoidedLocationsFactors = locationFactorsManagement.getAvoidLocations(user.getFactor().getId());
                Vector<TriggerLocation> allowedDisplayLocations = new Vector<TriggerLocation>();
                Vector<TriggerLocation> avoidedDisplayLocations = new Vector<TriggerLocation>();
                ArrayList<Risk> risks = riskManagament.getRiskMap(user.getId(), user.getFactor().getId());
                HashMap<TriggerLocation,String> locWithEvents = eventManagement.getAllLocationsWithEventProb();
                for (LocationFactors lf : allowedLocationsFactors) {
                    allowedDisplayLocations.add(triggerLocationManagement.getLocation(lf.getLocationid()));
             
                }
                for (LocationFactors lf : avoidedLocationsFactors) {
                    System.out.println("intra in for");
                    avoidedDisplayLocations.add(triggerLocationManagement.getLocation(lf.getLocationid()));
             
                }
                request.getSession().setAttribute("riskMap", risks);
                request.getSession().setAttribute("locWithProb",locWithEvents);
                request.getSession().setAttribute("allowedFactorLocations", allowedDisplayLocations);
                request.getSession().setAttribute("avoidedFactorLocations", avoidedDisplayLocations);
                System.out.println(avoidedDisplayLocations.size());
            }
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("locations", allLocations);
            request.getSession().setAttribute("factors", factors);

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
