package fr.uga.l3miage.photonum.data.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Commande {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Basic(optional = false)
    private Date createdate;

    @Basic(optional = false)
    private Double totalPrice;

    private String status;

    @OneToMany
    private Set<Article> articles;

    @ManyToOne
    private Client client;

    public void setStatus(boolean stat){
        if(stat){
            this.status = "en cours";
        }else{
            this.status = "expédiée";
        }
    }

}
