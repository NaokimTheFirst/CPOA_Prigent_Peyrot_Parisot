package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Beans.*;
import BD.DAOClient;


@WebServlet(urlPatterns = {"/SClient"})
public class SClient extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* Récupération des données saisies, envoyées en tant que paramètres de
         * la requête Post générée à la validation du formulaire*/
        String nom = request.getParameter( "nomClient" );
        String prenom = request.getParameter( "prenomClient" );
        String fonction = request.getParameter( "fonctionClient" );
        String page;
        
        // Création du bean Client et initialisation avec les données récupérées
        Client client = new Client();
        client.setNom( nom );
        client.setPrenom( prenom );
        client.setFonction( fonction );
        
        
        if(DAOClient.TransformClient(client) == true){                          //Si l'ajout à la Base de donnée se passe bien
            page ="/AffichageClient.jsp";                                       //On se redirige vers la page des informations du client

        } else {                                                                //Sinon on reste sur la même page
            String message = "Le client existe déjà !";
            request.setAttribute( "message", message );

            page ="/Client.jsp";
        }
        
        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( "client", client );
        
        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher(page).forward( request, response );
        
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
