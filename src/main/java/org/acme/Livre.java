package org.acme;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Livre extends PanacheEntity {
    private String titre;
    private String auteur;
    private String editeur;
    private String date;
    private Float prix;

    public Livre(String titre, String auteur, String editeur, String date, Float prix) {
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.date = date;
        this.prix = prix;
    }

    public Livre() {

    }


    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public String getDate() {
        return date;
    }

    public Float getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", editeur='" + editeur + '\'' +
                ", date='" + date + '\'' +
                ", prix=" + prix +
                '}';
    }
}
