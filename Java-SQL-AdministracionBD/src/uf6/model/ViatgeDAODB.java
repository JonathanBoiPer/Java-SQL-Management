package uf6.model;

import java.sql.*;
import java.util.ArrayList;

public class ViatgeDAODB implements DAODB<Viatge>{

    public boolean create(Viatge viatge) {
        Connection con = Connexio.openCon();
        PreparedStatement stmt;

        try {
            stmt = con.prepareStatement("INSERT INTO viatges(idClient, desti, dataInici, durada, preu) VALUES(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, viatge.getIdClient());
            stmt.setString(2, viatge.getDesti());
            stmt.setString(3, viatge.getDataInici().toString());
            stmt.setInt(4, viatge.getDurada());
            stmt.setFloat(5, viatge.getPreu());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                viatge.setId(rs.getInt(1));
            }


            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            Connexio.closeCon(con);
        }
    }

    public Viatge read(int id) {
        Connection con = null;
        PreparedStatement stmt;

        try {
            con = Connexio.openCon();
            stmt = con.prepareStatement("SELECT * FROM viatges WHERE id=?");
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Viatge v = new Viatge(rs.getInt("id"),
                        rs.getString("idClient"),
                        rs.getString("desti"),
                        Date.valueOf(rs.getString("dataInici")),
                        rs.getInt("durada"),
                        rs.getFloat("preu"));
                return v;
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

    public boolean update(String viatge, Viatge v) {
        return false;
    }

    public void delete(int id) {
        Connection con = Connexio.openCon();
        PreparedStatement stmt;

        try {
            stmt = con.prepareStatement("DELETE FROM viatges WHERE id =? ");
            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connexio.closeCon(con);
        }
    }

    public boolean exists(Viatge v) {
        if (((read(v.getId())) == null)) {
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

        ArrayList<Viatge> dadesViatges = null;
        Statement stmt;
        ResultSet rs;

        if (con == null) {

        } else {
            try {
                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT * FROM viatges");

                dadesViatges = new ArrayList<>();

                //Guardar dades de la taula
                while(rs.next()) {
                    int id = rs.getInt(1);
                    String idClient = rs.getString(2);
                    String desti = rs.getString(3);
                    Date dataInici = Date.valueOf(rs.getString(4));
                    int durada = rs.getInt(5);
                    float preu = rs.getFloat(6);
                    Viatge v = new Viatge(id, idClient, desti, dataInici, durada, preu);
                    dadesViatges.add(v);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Connexio.closeCon(con);
            }

        }
        return  dadesViatges;
    }

    public ArrayList ordenarTaules(){
        Connection con = Connexio.openCon();

        ArrayList<Viatge> dadesViatges = null;
        Statement stmt;
        ResultSet rs;

        if (con == null) {

        } else {
            try {
                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT * FROM viatges ORDER BY dataInici");

                dadesViatges = new ArrayList<>();

                //Guardar dades de la taula
                while(rs.next()) {
                    int id = rs.getInt(1);
                    String idClient = rs.getString(2);
                    String desti = rs.getString(3);
                    Date dataInici = Date.valueOf(rs.getString(4));
                    int durada = rs.getInt(5);
                    float preu = rs.getFloat(6);
                    Viatge v = new Viatge(id, idClient, desti, dataInici, durada, preu);
                    dadesViatges.add(v);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Connexio.closeCon(con);
            }

        }
        return  dadesViatges;
    }

    @Override
    public ArrayList consultarTaules() {
        Connection con = Connexio.openCon();

        ArrayList<Viatge> dadesViatges = null;
        Statement stmt;
        ResultSet rs;

        if (con == null) {

        } else {
            try {
                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT * FROM viatges WHERE dataInici >= CURRENT_DATE");

                dadesViatges = new ArrayList<>();

                //Guardar dades de la taula
                while(rs.next()) {
                    int id = rs.getInt(1);
                    String idClient = rs.getString(2);
                    String desti = rs.getString(3);
                    Date dataInici = Date.valueOf(rs.getString(4));
                    int durada = rs.getInt(5);
                    float preu = rs.getFloat(6);
                    Viatge v = new Viatge(id, idClient, desti, dataInici, durada, preu);
                    dadesViatges.add(v);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Connexio.closeCon(con);
            }

        }
        return  dadesViatges;
    }
}
