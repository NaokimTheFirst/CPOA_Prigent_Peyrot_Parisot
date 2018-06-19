package Servlet;

import BD.DAOClient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Beans.Client;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public class SConnection extends HttpServlet {
    private static final String COOKIE_NOM = "nom";
    private static final String COOKIE_PRENOM = "prenom";
    private static final String COOKIE_FONCTION = "fonction";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {      
        
        /* Tentative de récupération du cookie depuis la requête */
        String nom = getCookieValue( request,COOKIE_NOM);
        String prenom = getCookieValue( request,COOKIE_PRENOM);
        String fonction = getCookieValue( request,COOKIE_FONCTION);
        if(nom != null && prenom != null){
            request.setAttribute("nom", nom);
            request.setAttribute("prenom", prenom);
            request.setAttribute("fonction", fonction);
        }
        
        this.getServletContext().getRequestDispatcher("/Connection.jsp").forward( request, response );
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String page;
        String message;
        Client client = null;
        
        String nom = request.getParameter( "nomClient" );
        String prenom = request.getParameter( "prenomClient" );
        String fonction = request.getParameter( "fonctionClient" );

        if(DAOClient.CheckBD(nom, prenom) == true){
            page ="/AffichageClient.jsp";                                       //On se redirige vers la page des informations du client
            client = DAOClient.GetClient(nom, prenom);
            message = "Bienvenu(e) "+client.getPrenom()+" "+client.getNom()+" !";
            //On crée une session et on lui ajoute l'attribut client
            HttpSession session = request.getSession();                         
            session.setAttribute( "client", client );
            //Si l'utilisateur souhaite un cookie
            if (request.getParameter( "memoire" ) != null) {
                setCookie(response,COOKIE_PRENOM, prenom);
                setCookie(response,COOKIE_NOM, nom);
                setCookie(response,COOKIE_FONCTION, fonction);
            }
        } else {
            page ="/Connection.jsp";
            message = "Identifiant ou Mot de Passe incorrect";
        }
        
        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( "client", client );
        request.setAttribute( "message", message );
        request.setAttribute( "fonciton", fonction );
        
        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher(page).forward( request, response );
        processRequest(request, response);
    }
    
    //Fonction de création d'un cookie
    private static void setCookie( HttpServletResponse response, String nom, String valeur) {
        Cookie cookie = new Cookie( nom, valeur );
        cookie.setMaxAge(60 * 60 * 24 * 365);                                   //1 an en seconde
        response.addCookie(cookie);
    }
    
    //Fonction qui récupère les cookies s'ils existent
    private static String getCookieValue( HttpServletRequest request, String nom ) {
        Cookie[] cookies = request.getCookies();
        if ( cookies != null ) {
            for ( Cookie cookie : cookies ) {
                if ( cookie != null && nom.equals( cookie.getName() ) ) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
