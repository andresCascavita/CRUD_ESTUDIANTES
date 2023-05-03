/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerServlet;

import estudiantesJEE.entity.Untitled;
import estudiantesJEE.session.UntitledFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.hibernate.validator.internal.util.privilegedactions.ConstructorInstance.action;

/**
 *
 * @author ANDRES CASCAVITA
 */
public class StudentServlet extends HttpServlet {

    @EJB
    private UntitledFacadeLocal untitledFacade;
    

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
        response.setContentType("text/html;charset=UTF-8");
        String idStr=request.getParameter("studentId");
        
        
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        int id=Integer.parseInt(idStr);
        
        String yearStr=request.getParameter("yearLevel");
        
        String action =  request.getParameter("action");
        
        Untitled student = new Untitled(idStr, firstName, lastName, yearStr);
        switch (action){
            case "Edit":
                untitledFacade.edit(student);
                break;
            case "Delete":
                untitledFacade.remove(student);
                break;
            case "Add":
                untitledFacade.create(student);
                break;
            case "Search":
                if (id != -1) {
                    student = untitledFacade.find(id);
                } else {
                    student.setStudentid(idStr);
                    
                }
                break;
        }
        
        response.setContentType("text/html;charset=UTF-8");
       
        request.setAttribute("student", student);
        request.setAttribute("allStudents", untitledFacade.findAll());
        request.getRequestDispatcher("stundentInfo.jsp").forward (request,response);
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
