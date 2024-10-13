package com.backend.backend.classe;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="classe")
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name= "nomClasse")
    private String nomClasse;

    @Column(name="niveauClasse")
    private String niveauClasse;



    public Classe(int id, String nomClasse, String niveauClasse) {
        this.id=id;
        this.nomClasse=nomClasse;
        this.niveauClasse=niveauClasse;




    }
    public Classe(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public String getNiveauClasse() {
        return niveauClasse;
    }

    public void setNiveauClasse(String niveauClasse) {
        this.niveauClasse = niveauClasse;
    }
}
