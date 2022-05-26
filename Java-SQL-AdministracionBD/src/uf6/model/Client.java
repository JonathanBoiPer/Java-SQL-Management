package uf6.model;

import java.sql.Date;

public class Client{

    private String nif;
    private String nom;
    private Date dNaixement;
    private boolean vacunat;

    public Client(String nif, String nom, Date dNaixement, boolean vacunat) {
        this.nif = nif;
        this.nom = nom;
        this.dNaixement = dNaixement;
        this.vacunat = vacunat;
    }

    public String getNif() {
        return nif;
    }
    public String getNom() {
        return nom;
    }
    public Date getdNaixement() {
        return dNaixement;
    }
    public boolean getVacunat() {
        return vacunat;
    }

}
