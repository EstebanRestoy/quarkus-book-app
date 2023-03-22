package org.acme;

public class Livre {
    private String titre;
    private String auteur;
    private String editeur;
    private String image;
    private String date;
    private String prix;

    public Livre(String titre, String auteur, String editeur, String image, String date, String prix) {
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.image = image;
        this.date = date;
        this.prix = prix;
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

    public String getImage() {
        return image;
    }

    public String getDate() {
        return date;
    }

    public String getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", editeur='" + editeur + '\'' +
                ", image='" + image + '\'' +
                ", date='" + date + '\'' +
                ", prix='" + prix + '\'' +
                '}';
    }
}
