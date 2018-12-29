/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 *
 * @author DIVYANSH
 */
public class serv extends HttpServlet {

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
        try (PrintWriter o = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
        FileReader f=new FileReader("C:\\Users\\DIVYANSH\\Documents\\NetBeansProjects\\spam\\src\\java\\python_file1.txt");
	BufferedReader bf =new BufferedReader(f);
	String x="";
	String line;
	while ((line = bf.readLine()) != null) {
        x=x+line;
        x=x+"\n";
	}    
        
        x=x+"test=\"" ;
        x=x+request.getParameter("passage") ;
        x=x+"\"" + "\n";
        
        f=new FileReader("C:\\Users\\DIVYANSH\\Documents\\NetBeansProjects\\spam\\src\\java\\python_file2.txt");
	bf =new BufferedReader(f);
	while ((line = bf.readLine()) != null) {
        x=x+line;
        x=x+"\n";
	}   
        
        
         BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\DIVYANSH\\Documents\\NetBeansProjects\\spam\\src\\java\\delete1.py"));
         out.write(x);
         out.flush();
         out.close();
           

       
	Process p = Runtime.getRuntime().exec("python C:\\Users\\DIVYANSH\\Documents\\NetBeansProjects\\spam\\src\\java\\delete1.py");
	BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
	String ret = in.readLine();
	if(ret.equals("['ham']"))
        {
            response.sendRedirect("ham.html");
        }
        else if(ret.equals("['spam']"))
        {
            response.sendRedirect("unsafe.html");
        }

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
