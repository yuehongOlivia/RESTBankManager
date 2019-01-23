/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RessourcePakage;

import java.util.List;

/**
 *
 * @author zhaow
 */
public class ClientDAO extends DAO<Client> {
    ClientDAO() {
        super("RestBankPU");
    }

    public void init() {
        this.em.getTransaction().begin();
    }

     public List<Client> findAll() {    //consulterListClient
        return em.createQuery("select c from Client c").getResultList();
    }
    
    @Override
    public Client find(int id) {    //consulterClient
       return em.find(Client.class,id);
    }

    public void end() {
        this.em.getTransaction().commit();
        this.em.close();
    }

    @Override
    public Client create(Client obj) { //ajouterClientdansList
        em.persist(obj);
        em.getTransaction().commit();
        return obj;
    }

    @Override
    public Client delete(Client obj) {  //supprimerClient
        obj = em.merge(obj);
        em.remove(obj);
        em.getTransaction().commit();
        return obj;
    }
    
    @Override
    public Client update(Client obj) {  //modifierClient
        obj=em.merge(obj);
        return obj;
    }
}
