package Servlet;

import BD.*;
import Beans.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SHebergement extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();

        if(session.getAttribute("client") != null){
            Client client = (Client) session.getAttribute("client");
            ArrayList<Beans.Hebergement> hebergements = DAOHebergements.GetAllHeb(client);
            request.setAttribute("hebergements", hebergements);
        }
        

        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
        this.getServletContext().getRequestDispatcher("/Hebergements.jsp").forward( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        //Si l'utilisateur veut ajouter une hebergement à la liste
        if(request.getParameter("nomH")!=null){
            Beans.Hebergement hebergement = new Beans.Hebergement();
            String Services = request.getParameter("services");
            hebergement.setNumhebergement(0);
            hebergement.setNomhebergement(request.getParameter("nomH"));
            hebergement.setType(request.getParameter("type"));
            hebergement.setAdresse(request.getParameter("adresse"));
            hebergement.setClient((Client) session.getAttribute("client"));
            hebergement.setServices(Services);

            //On ajoute la hebergement à la BD
            DAOHebergements.AddHebergementBD(hebergement);
            
            for(int i = 1;i<=30;i++){
                String day = "d"+i;
                if(!request.getParameter(day).equals("")){
                   int param = Integer.parseInt(request.getParameter(day));
                   Dispo dispo = new Dispo(request.getParameter("nomH"),i, param);
                   DAODispo.AddDispo(dispo); 
                }
            }
        }
        processRequest(request, response);
        this.getServletContext().getRequestDispatcher("/Hebergements.jsp").forward( request, response );
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
