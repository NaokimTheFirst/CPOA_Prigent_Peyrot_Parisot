package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Beans.*;
import BD.*;
import javax.servlet.http.HttpSession;

public class Panier extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Si un article est envoyé par la requête
        if(request.getParameter("article")!=null){
            int i = Integer.parseInt(request.getParameter("article"));
            //On récupère l'article dans la BD grâce à l'indice
            Article article = DAOArticle.GetArticle(i);
            //On lui donne 1 en quantité
            AddQuantité(article, 1);
            //On récupère le client et la commande de la Session actuelle
            HttpSession session = request.getSession();
            Client client = (Client) session.getAttribute("client");
            Commande commande = (Commande) session.getAttribute("commande");
            //Si la commande est null on en crée une
            if(commande == null){
                commande = new Commande();
            }
            //On ajoute l'article à la commande
            AddArticle(commande, article);
            commande.setClient(client);
            //On redéfinit la commande de la session en cours
            session.setAttribute("commande", commande);
            //On redirige l'utilisateur vers le panier sans l'article en paramètre à ajouter
            response.sendRedirect("Panier");
            return;   
        }
        
        //Si l'utilisateur veut vider le panier
        if(request.getParameter("action")!=null && request.getParameter("action").equals("vider")){
            HttpSession session = request.getSession();
            session.setAttribute("commande", null);
            //On redirige l'utilisateur vers le panier sans l'article en paramètre à ajouter
            response.sendRedirect("Panier");
            return;
        }
        
        this.getServletContext().getRequestDispatcher("/Panier.jsp").forward( request, response );
        processRequest(request, response);
    }
    
    //Fonction qui vérifie si l'article est déjà dans la liste et l'ajoute
    private void AddArticle(Commande commande,Article article){
        //Pour chaque article de la commande
        for(Article a :commande.getArticle()){
            //S'il correpond à l'aricle à ajouter augmente la quantité
            if(a.getIdarticle() == article.getIdarticle()){
                AddQuantité(a,1);
                commande.setMontant();
                return;
            }
        }
        //Sinon ajoute l'article à la liste
        commande.addArticle(article);
        commande.setMontant();
        return;
    }
    
    //Fonction qui ajoute une certaines quantité d'article à un objet article
    private void AddQuantité(Article a, int quantité){
        a.setQuantité(a.getQuantité()+quantité);
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
