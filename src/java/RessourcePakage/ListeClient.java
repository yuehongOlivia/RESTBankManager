/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RessourcePakage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author zhaow
 */
public class ListeClient {
    private List<Client> clientList;
    
    public ListeClient () {
        this.clientList = new ArrayList<Client>();
    }
    public boolean ajouterClientdansListe(Client c) {
        return this.clientList.add(c);
    }
    
    public void modifierClient(int id, String nom, String prenom) {
       Client o = this.clientList.get(id-1);
       o.setNom(nom);
       o.setPrenom(prenom);
    }
    
    public Client consulterClient(int id) {
        return this.clientList.get(id-1);
    }
    
    public List consulterListeClient() {
        return this.clientList;
    }
    
    public Client supprimerClient(int id) {
        return clientList.remove(id-1);
    }
}
