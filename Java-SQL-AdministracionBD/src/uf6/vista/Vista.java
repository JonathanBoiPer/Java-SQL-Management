package uf6.vista;

import uf6.controlador.Controlador;
import uf6.model.ClientDAOBD;

import javax.swing.*;
import java.awt.*;

public class Vista extends JFrame {

    private static JTable t;

    public Vista() {
        JFrame finestra = new JFrame();

        Container contenidor = finestra.getContentPane();

        finestra.setPreferredSize(new Dimension(600, 600));
        finestra.setMinimumSize(new Dimension(200, 350));


        JMenu client = new JMenu("Client");
        JMenu viatge = new JMenu("Viatge");
        JMenu consultes = new JMenu("Consultes");

        JMenuItem afegirClient = new JMenuItem("Afegir client");
        JMenuItem modificarClient = new JMenuItem("Modificar client");
        JMenuItem mostrarClient = new JMenuItem("Mostrar clients");

        JMenuItem afegirViatge = new JMenuItem("Afegir viatge");
        JMenuItem eliminarViatge = new JMenuItem("Eliminar viatge");
        JMenuItem mostrarViatges = new JMenuItem("Mostrar viatges");

        JMenuItem ordenarCognoms = new JMenuItem("Ordenar cognoms");
        JMenuItem ordenarDataInici = new JMenuItem("Ordenar dataInici");
        JMenuItem viatgesPendents = new JMenuItem("Viatges pendents");
        JMenuItem consultarVips = new JMenuItem("Consultar VIPS");

        afegirClient.addActionListener(Controlador.clicBotons);
        modificarClient.addActionListener(Controlador.clicBotons);
        mostrarClient.addActionListener(Controlador.clicBotons);
        afegirViatge.addActionListener(Controlador.clicBotons);
        eliminarViatge.addActionListener(Controlador.clicBotons);
        mostrarViatges.addActionListener(Controlador.clicBotons);
        ordenarCognoms.addActionListener(Controlador.clicBotons);
        ordenarDataInici.addActionListener(Controlador.clicBotons);
        viatgesPendents.addActionListener(Controlador.clicBotons);
        consultarVips.addActionListener(Controlador.clicBotons);

        client.add(afegirClient);
        client.add(modificarClient);
        client.add(mostrarClient);
        viatge.add(afegirViatge);
        viatge.add(eliminarViatge);
        viatge.add(mostrarViatges);
        consultes.add(ordenarCognoms);
        consultes.add(ordenarDataInici);
        consultes.add(viatgesPendents);
        consultes.add(consultarVips);

        JMenuBar mb = new JMenuBar();

        mb.add(client);
        mb.add(viatge);
        mb.add(consultes);

        t = new JTable();
        t.getAutoCreateRowSorter();
        JScrollPane taules = new JScrollPane(t);

        contenidor.add(mb, BorderLayout.PAGE_START);
        contenidor.add(taules, BorderLayout.CENTER);

        finestra.pack();
        //finestra.setResizable(false);
        finestra.setVisible(true);
        finestra.setTitle("Programa");
        finestra.setLocationRelativeTo(null);
        finestra.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void novaTaula(String[][] registres, String[] camps){
        t.setModel(new TModel(registres, camps));
    }

    public static String preguntar(String text) {
        JFrame jFrame = new JFrame();
        return JOptionPane.showInputDialog(jFrame, text);
    }

    public static void text(String text) {
        JOptionPane.showInternalMessageDialog(null,text,"Advertència",JOptionPane.WARNING_MESSAGE);

    }
}
