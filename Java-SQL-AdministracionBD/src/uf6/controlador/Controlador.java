package uf6.controlador;

import uf6.model.Client;
import uf6.model.Model;
import uf6.model.Viatge;
import uf6.vista.Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import uf6.vista.*;

public class Controlador {

    private static crearClient afegirC;
    private static crearViatge afergirV;
    private static updateClient actualitzarC;
    private static String[] resultat;
    private static String nif;
    private static String cognomsNom;
    private static Date dataNaix;
    private static boolean vacunat;

    public static ActionListener clicBotons = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem boto = (JMenuItem) e.getSource();
            String opcio = boto.getText();
            String[][] dades;
            String[] camps;

            switch (opcio) {
                case "Afegir client":
                    afegirC = new crearClient();
                    afegirC.pack();
                    afegirC.setTitle("Afegir Client");
                    afegirC.setResizable(false);
                    afegirC.setLocationRelativeTo(null);
                    afegirC.setVisible(true);

                    resultat = afegirC.getResult();
                    nif = resultat[0];
                    cognomsNom = resultat[1];
                    dataNaix = Date.valueOf(resultat[2]);
                    vacunat = Boolean.parseBoolean(resultat[3]);
                    Client c = new Client(nif, cognomsNom, dataNaix, vacunat);
                    Model.crearClient(c);
                    break;
                case "Modificar client":
                    String dni = Vista.preguntar("Introdueix el nif del client");

                    actualitzarC = new updateClient();
                    actualitzarC.pack();
                    actualitzarC.setTitle("Actualitzar Client");
                    actualitzarC.setResizable(false);
                    actualitzarC.setLocationRelativeTo(null);
                    actualitzarC.setVisible(true);

                    resultat = actualitzarC.getResult();
                    nif = resultat[0];
                    cognomsNom = resultat[1];
                    dataNaix = Date.valueOf(resultat[2]);
                    vacunat = Boolean.parseBoolean(resultat[3]);
                    Client c1 = new Client(dni, cognomsNom, dataNaix, vacunat);
                    Client c2 = new Client(nif, cognomsNom, dataNaix, vacunat);
                    if(Model.comprovacioC(c1)) {
                        Model.actualitzarClient(dni, c2);
                    } else {
                        Vista.text("El client amb el nif: " + dni + " NO existeix.");
                    }
                    break;
                case "Mostrar clients":
                    camps = new String[]{"Nif", "Nom", "Data Naixement", "Vacunat"};
                    dades = Model.getClients();
                    Vista.novaTaula(dades, camps);
                    break;
                case "Afegir viatge":
                    afergirV = new crearViatge();
                    afergirV.pack();
                    afergirV.setTitle("Afegir Viatge");
                    afergirV.setResizable(false);
                    afergirV.setLocationRelativeTo(null);
                    afergirV.setVisible(true);

                    resultat = afergirV.getResult();
                    String id_client = resultat[0];
                    String desti = resultat[1];
                    Date dataInici = Date.valueOf(resultat[2]);
                    int durada = Integer.parseInt(resultat[3]);
                    float preu = Float.parseFloat(resultat[4]);
                    Viatge v = new Viatge(id_client, desti, dataInici, durada, preu);
                    Client c3 = new Client(id_client, null, null, false);
                    if(Model.comprovacioC(c3)) {
                        Model.crearViatge(v);
                    } else {
                        Vista.text("El client amb el nif: \"" + id_client + "\" NO EXISTEIX i per tant no es pot associar a cap viatge.");
                    }
                    break;
                case "Eliminar viatge":
                    String viatge = Vista.preguntar("Introdueix la id del viatge");
                    int id = Integer.parseInt(viatge);
                    Viatge v1 = new Viatge(id, null, null, null,0,0);
                    if(Model.comprovacioV(v1)) {
                        Model.eliminarViatge(id);
                    } else {
                        Vista.text("Aquest viatge no existeix.");
                    }
                    break;
                case "Mostrar viatges":
                    camps = new String[] {"id", "idClient", "desti", "data_inici", "durada", "preu"};
                    dades = Model.getViatges();
                    Vista.novaTaula(dades, camps);
                    break;
                case "Ordenar cognoms":
                    camps = new String[]{"Nif", "Nom", "Data Naixement", "Vacunat"};
                    dades = Model.getClientsOrdenats();
                    Vista.novaTaula(dades, camps);
                    break;
                case "Ordenar dataInici":
                    camps = new String[] {"id", "idClient", "desti", "data inici", "durada", "preu"};
                    dades = Model.getViatgesOrdenats();
                    Vista.novaTaula(dades, camps);
                    break;
                case "Viatges pendents":
                    camps = new String[] {"id", "idClient", "desti", "data_inici", "durada", "preu"};
                    dades = Model.getViatgesPendents();
                    Vista.novaTaula(dades, camps);
                    break;
                case "Consultar VIPS":
                    camps = new String[]{"Nif", "Nom", "Data Naixement", "Vacunat", "Preu Total", "Total Viatges"};
                    dades = Model.getVips();
                    Vista.novaTaula(dades, camps);
                    break;
                default:
            }
        }
    };
}
