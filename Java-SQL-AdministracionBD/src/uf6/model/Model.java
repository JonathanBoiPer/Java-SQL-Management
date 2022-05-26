package uf6.model;

import java.util.ArrayList;

public class Model {
    private static ClientDAOBD cd = new ClientDAOBD();
    private static ViatgeDAODB vd = new ViatgeDAODB();
    private static String[]camps;
    private static String[][] dades;

    public static void setCamps(String[] camps) {
        Model.camps = camps;
    }

    public static void setnRows(int nRows) {
    }

    public static void setTmpRegistres(ArrayList<String[]> registres) {
    }

    public static String[][] getClients() {
        ArrayList<Client> c = cd.readTables();
        dades = new String[c.size()][4];

        for (int i = 0; i < c.size(); i++) {
            dades[i][0] = c.get(i).getNif();
            dades[i][1] = c.get(i).getNom();
            dades[i][2] = String.valueOf(c.get(i).getdNaixement());
            dades[i][3] = String.valueOf(c.get(i).getVacunat());
        }

        return dades;
    }

    public static String[][] getViatges() {
        ArrayList<Viatge> c = vd.readTables();
        dades = new String[c.size()][6];

        for (int i = 0; i < c.size(); i++) {
            dades[i][0] = String.valueOf(c.get(i).getId());
            dades[i][1] = String.valueOf(c.get(i).getIdClient());
            dades[i][2] = c.get(i).getDesti();
            dades[i][3] = String.valueOf(c.get(i).getDataInici());
            dades[i][4] = String.valueOf(c.get(i).getDurada());
            dades[i][5] = String.valueOf(c.get(i).getPreu());
        }

        return dades;
    }

    public static String[][] getViatgesOrdenats() {
        ArrayList<Viatge> c = vd.ordenarTaules();
        dades = new String[c.size()][6];

        for (int i = 0; i < c.size(); i++) {
            dades[i][0] = String.valueOf(c.get(i).getId());
            dades[i][1] = String.valueOf(c.get(i).getIdClient());
            dades[i][2] = c.get(i).getDesti();
            dades[i][3] = String.valueOf(c.get(i).getDataInici());
            dades[i][4] = String.valueOf(c.get(i).getDurada());
            dades[i][5] = String.valueOf(c.get(i).getPreu());
        }

        return dades;
    }

    public static String[][] getClientsOrdenats() {
        ArrayList<Client> c = cd.ordenarTaules();
        dades = new String[c.size()][4];

        for (int i = 0; i < c.size(); i++) {
            dades[i][0] = c.get(i).getNif();
            dades[i][1] = c.get(i).getNom();
            dades[i][2] = String.valueOf(c.get(i).getdNaixement());
            dades[i][3] = String.valueOf(c.get(i).getVacunat());
        }

        return dades;
    }

    public static String[][] getVips(){
        ArrayList<Vip> c = cd.consultarTaules();
        dades = new String[c.size()][6];

        for (int i = 0; i < c.size(); i++) {
            dades[i][0] = c.get(i).getNif();
            dades[i][1] = c.get(i).getNom();
            dades[i][2] = String.valueOf(c.get(i).getdNaixement());
            dades[i][3] = String.valueOf(c.get(i).getVacunat());
            dades[i][4] = String.valueOf(c.get(i).getTotal());
            dades[i][5] = String.valueOf(c.get(i).getTotalViatges());
        }

        return dades;
    }

    public static String[][] getViatgesPendents() {
        ArrayList<Viatge> c = vd.consultarTaules();
        dades = new String[c.size()][6];

        for (int i = 0; i < c.size(); i++) {
            dades[i][0] = String.valueOf(c.get(i).getId());
            dades[i][1] = String.valueOf(c.get(i).getIdClient());
            dades[i][2] = c.get(i).getDesti();
            dades[i][3] = String.valueOf(c.get(i).getDataInici());
            dades[i][4] = String.valueOf(c.get(i).getDurada());
            dades[i][5] = String.valueOf(c.get(i).getPreu());
        }

        return dades;
    }

    public static void crearViatge(Viatge v) {
        vd.create(v);
    }

    public static void crearClient(Client c) {
        cd.create(c);
    }

    public static void actualitzarClient(String nif, Client c) {
        cd.update(nif, c);
    }

    public static void eliminarViatge(int id) {
        vd.delete(id);
    }

    public static String[] getCamps() {
        return camps;
    }

    public static Object[][] getDades() {
        return dades;
    }

    public static boolean comprovacioV(Viatge v) {
        if(vd.exists(v)) return true;
        else return false;

    }

    public static boolean comprovacioC(Client c) {
        if(cd.exists(c)) return true;
        else return false;

    }
}
