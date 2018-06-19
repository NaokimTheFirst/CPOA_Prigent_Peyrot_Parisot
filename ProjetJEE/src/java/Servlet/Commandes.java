package Servlet;

import BD.DAOCommandes;
import Beans.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Commandes extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        //Si l'utilisateur veut ajouter une commande à la liste
        if(request.getParameter("action")!=null && request.getParameter("action").equals("ajouter")){
            //On récupère la commande du panier
            Commande commande = (Commande) session.getAttribute("commande");
            //On ajoute la commande à la BD
            DAOCommandes.AddClientBD(commande);
            
            //On vide le panier
            session.setAttribute("commande", null);
            
            //On redirige l'utilisateur vers l'affichage des Commandes
            response.sendRedirect("Commandes");
            return;
        }
        
        if(session.getAttribute("client") != null){
            Client client = (Client) session.getAttribute("client");
            ArrayList<Commande> commandes = DAOCommandes.GetAllCommands(client);
            request.setAttribute("commandes", commandes);
        }
        
        processRequest(request, response);
        this.getServletContext().getRequestDispatcher("/Commandes.jsp").forward( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
