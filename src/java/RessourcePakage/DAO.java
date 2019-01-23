/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RessourcePakage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public abstract class DAO<T> {
    
    public EntityManager em;
    public DAO (String entitymanagerName) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory(entitymanagerName);
    EntityManager em = emf.createEntityManager();
    this.em=em;
    }
    
    public abstract Object create(T obj);

    public abstract Object delete(T obj);

    public abstract Object update(T obj);

    public abstract T find(int id);
    
    public abstract List<T> findAll();
    
}
