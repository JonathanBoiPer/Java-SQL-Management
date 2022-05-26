package uf6.model;

import java.sql.Date;

public class Vip {
    private String nif;
    private String nom;
    private Date dNaixement;
    private boolean vacunat;
    private float total;
    private int totalViatges;

    public Vip(String nif, String nom, Date dNaixement, boolean vacunat, float total, int totalViatges) {
        this.nif = nif;
        this.nom = nom;
        this.dNaixement = dNaixement;
        this.vacunat = vacunat;
        this.total = total;
        this.totalViatges = totalViatges;
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
    public float getTotal() {
        return total;
    }
    public int getTotalViatges() {
        return totalViatges;
    }
}
