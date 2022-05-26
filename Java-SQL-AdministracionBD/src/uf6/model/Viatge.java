package uf6.model;

import java.sql.Date;

public class Viatge {
    private int id;
    private String idClient;
    private String desti;
    private Date dataInici;
    private int durada;
    private float preu;

    public Viatge(int id, String idClient, String desti, Date dataInici, int durada, float preu) {
        this.id = id;
        this.idClient = idClient;
        this.desti = desti;
        this.dataInici = dataInici;
        this.durada = durada;
        this.preu = preu;
    }

    public Viatge(String idClient, String desti, Date dataInici, int durada, float preu) {
        this.idClient = idClient;
        this.desti = desti;
        this.dataInici = dataInici;
        this.durada = durada;
        this.preu = preu;
    }

    public int getId() {
        return id;
    }
    public String getIdClient() {
        return idClient;
    }
    public String getDesti() {
        return desti;
    }
    public Date getDataInici() {
        return dataInici;
    }
    public int getDurada() {
        return durada;
    }
    public float getPreu() {
        return preu;
    }

    public void setId(int id) {
        this.id = id;
    }
}
