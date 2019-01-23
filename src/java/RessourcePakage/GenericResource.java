/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RessourcePakage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author zhaow
 */
@Path("/RestBankService")
public class GenericResource {

    @Context
    private UriInfo context;
    // private static final String SUCCESS_RESULT = "<result>success</result>";
    //private static final String FAILURE_RESULT = "<result>failure</result>";
    ListeClient l = new ListeClient();
    ClientDAO cd = new ClientDAO();

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of
     * RessourcePakage.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/clients/{clientid}")
    @Produces(MediaType.APPLICATION_XML)
    public Client getClient(@PathParam("clientid") int clientid) {
        // Client c = new Client("AAA", "aaa");
        // l.ajouterClientdansListe(c);
        //return l.consulterClient(clientid);
        return cd.find(clientid);
    }

    @POST
    @Path("/clients/add")
    @Produces(MediaType.APPLICATION_XML)
    public Client addClient(
            @FormParam("nom") String nom,
            @FormParam("prenom") String prenom) {
        // Client c = new Client(nom, prenom);
        // l.ajouterClientdansListe(c);
        Client obj = new Client(nom,prenom);
        cd.create(obj);
        return obj;
    }

    @PUT
    @Path("/clients/update")
    @Produces(MediaType.APPLICATION_XML)
    public Client updateClient(
            @FormParam("id") int id,
            @FormParam("nom") String nom,
            @FormParam("prenom") String prenom) {
        //Client c = new Client("INIT", "init");
        //l.ajouterClientdansListe(c);
        //l.consulterClient(id).setNom(nom);
        //l.consulterClient(id).setPrenom(prenom);
        //return l.consulterClient(id);
        Client c = new Client(nom,prenom);
        return cd.update(cd.find(id));
    }

    @GET
    @Path("/clients/getall")
    @Produces(MediaType.APPLICATION_XML)
    public List getAllClients() {
        //Client c1 = new Client("A", "a");
        //Client c2 = new Client("B", "b");
        //Client c3 = new Client("C", "c");
        //l.ajouterClientdansListe(c1);
        //l.ajouterClientdansListe(c2);
        //l.ajouterClientdansListe(c3);
        //System.out.println(l.consulterListeClient().size());
        //return l.consulterListeClient();
        return cd.findAll();
    }

    @POST
    @Path("/clients/delete")
    @Produces(MediaType.APPLICATION_XML)
    public Client deleteClient(
            @FormParam("id") int id) {
        //Client c = new Client("INIT", "init");
        //Client c1 = new Client("A", "a");
        //Client c2 = new Client("B", "b");
        //Client c3 = new Client("C", "c");
        //l.ajouterClientdansListe(c);
        //l.ajouterClientdansListe(c1);
        //l.ajouterClientdansListe(c2);
        //l.ajouterClientdansListe(c3);
        //return l.supprimerClient(id);
        return cd.delete(cd.find(id));
    }

    @GET
    @Produces("text/plain")
    public String getText() {
        return "Mon premier service REST";
    }
}
