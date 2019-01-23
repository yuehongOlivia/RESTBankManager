/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RessourcePakage;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.*;


@XmlRootElement(name = "client")
@Entity
public class Client {
    @Id
    @Column(length = 8)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num;
    
    @Column(nullable = false, length = 30)
    private String nom;
    
    @Column(nullable = false, length = 30)
    private String prenom;
    
    public Client() {}
    
    public Client(String fname, String lname) {
        this.num +=1;
        this.nom=fname;
        this.prenom=lname;
    }

    public int getNum() {
        return num;
    }

    
    public void setNum(int num) {
        this.num = num;
    }

    public String getNom() {
        return nom;
    }

    
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
}
