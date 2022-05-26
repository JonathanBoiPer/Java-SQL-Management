package uf6.model;

import java.sql.*;
import java.util.ArrayList;

public class ClientDAOBD implements DAODB<Client>{

    public boolean create(Client c) {
        Connection con = Connexio.openCon();
        PreparedStatement stmt;

        try {
            stmt = con.prepareStatement("INSERT INTO clients(nif, cognoms_nom, data_naix, vacunat) VALUES(?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, c.getNif());
            stmt.setString(2, c.getNom());
            stmt.setString(3, c.getdNaixement().toString());
            stmt.setBoolean(4, c.getVacunat());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Connexio.closeCon(con);
        }
    }

    @Override
    public Client read(int t) {
        return null;
    }

    public Client readV(String nif) {
        Connection con = null;
        PreparedStatement stmt;

        try {
            con = Connexio.openCon();
            stmt = con.prepareStatement("SELECT * FROM clients WHERE nif=?");
            stmt.setString(1, nif);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Client c = new Client(rs.getString("nif"),
                        rs.getString("cognoms_nom"),
                        Date.valueOf(rs.getString("data_naix")),
                        rs.getBoolean("vacunat"));
                return c;
            } else {
                return null;
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            Connexio.closeCon(con);
        }
    }

    public boolean update(String nif, Client c) {
        Connection con = Connexio.openCon();
        PreparedStatement stmt;

        try {
            stmt = con.prepareStatement("UPDATE clients SET nif=?, cognoms_nom=?, data_naix=?, vacunat=? WHERE nif=?");
            stmt.setString(5, nif);
            stmt.setString(1, c.getNif());
            stmt.setString(2, c.getNom());
            stmt.setString(3, c.getdNaixement().toString());
            stmt.setBoolean(4, c.getVacunat());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Connexio.closeCon(con);
        }
    }

    public void delete(int c) {
    }

    public boolean exists(Client c) {
        if (((readV(c.getNif())) == null)) {
            return false;
        } else {
            return true;
        }
    }

    public int count() {
        return 0;
    }

    public ArrayList readTables() {
        Connection con = Connexio.openCon();

        ArrayList<Client> dadesClients = null;
        Statement stmt;
        ResultSet rs;

        if (con == null) {

        } else {
            try {
                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT * FROM clients");

                dadesClients = new ArrayList<>();

                //Guardar dades de la taula
                while(rs.next()) {
                    String nif = rs.getString(1);
                    String nom = rs.getString(2);
                    Date data = Date.valueOf(rs.getString(3));
                    boolean vacunat = rs.getBoolean(4);

                    Client c = new Client(nif, nom, data, vacunat);
                    dadesClients.add(c);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Connexio.closeCon(con);
            }

        }
        return  dadesClients;
    }

    @Override
    public ArrayList ordenarTaules() {
        Connection con = Connexio.openCon();

        ArrayList<Client> dadesClients = null;
        Statement stmt;
        ResultSet rs;

        if (con == null) {

        } else {
            try {
                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT * FROM clients ORDER BY cognoms_nom");

                dadesClients = new ArrayList<>();

                //Guardar dades de la taula
                while(rs.next()) {
                    String nif = rs.getString(1);
                    String nom = rs.getString(2);
                    Date data = Date.valueOf(rs.getString(3));
                    boolean vacunat = rs.getBoolean(4);
                    Client c = new Client(nif, nom, data, vacunat);
                    dadesClients.add(c);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Connexio.closeCon(con);
            }

        }
        return  dadesClients;
    }

    @Override
    public ArrayList consultarTaules() {
        Connection con = Connexio.openCon();

        ArrayList<Vip> dadesClients = null;
        Statement stmt;
        ResultSet rs;

        if (con == null) {

        } else {
            try {
                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT c.*,sum(preu) as totalGastat,count(v.Id) as totalViatges\n" +
                        "\tfrom clients c\n" +
                        "\tINNER JOIN viatges v on v.idClient = c.nif\n" +
                        "GROUP by nif\n" +
                        "HAVING count(*) >= 3 AND sum(preu) >= 3000");

                dadesClients = new ArrayList<>();

                //Guardar dades de la taula
                while(rs.next()) {
                    String nif = rs.getString(1);
                    String nom = rs.getString(2);
                    Date data = Date.valueOf(rs.getString(3));
                    boolean vacunat = rs.getBoolean(4);
                    float total = rs.getFloat(5);
                    int totalViatges = rs.getInt(6);
                    Vip v = new Vip(nif, nom, data, vacunat, total, totalViatges);
                    dadesClients.add(v);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Connexio.closeCon(con);
            }

        }
        return  dadesClients;
    }
}
