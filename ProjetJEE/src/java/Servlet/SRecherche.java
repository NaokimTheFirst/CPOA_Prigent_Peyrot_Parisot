package Servlet;

import BD.*;
import Beans.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SRecherche extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/Recherche.jsp").forward( request, response );
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        if(request.getParameter("action").equals("Rechercher")){
            int jour = Integer.parseInt(request.getParameter("jour"));
            String statut = request.getParameter("statut");
            session.setAttribute("cible", statut);
            session.setAttribute("jour", jour);


            ArrayList<Hebergement> Hotels = DAODispo.GetHotels(jour,statut);
            request.setAttribute("hotels", Hotels);
        }
        
        if(request.getParameter("action").equals("Valider") && !request.getParameter("choix").equals("")){
            String nomHotel = request.getParameter("choix");
            String cible = (String) session.getAttribute("cible");
            DAOHebergements.SetCibleHotel(nomHotel, cible);
            
            //Diminue le nombre de chambre disponible de 1 ce jour là
            int jour = (int) session.getAttribute("jour");
            DAODispo.ChangeChambreHotel(nomHotel,jour);
            session.setAttribute("cible", null);

        }
        
        this.getServletContext().getRequestDispatcher("/Recherche.jsp").forward( request, response );
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
