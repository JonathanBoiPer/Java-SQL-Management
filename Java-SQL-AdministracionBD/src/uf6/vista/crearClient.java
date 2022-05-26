package uf6.vista;

import javax.swing.*;
import java.awt.event.*;

public class crearClient extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel Camps;
    private JTextField nif;
    private JTextField cognomsNom;
    private JTextField dataNaix;
    private JCheckBox vacunat;
    public String[] result;

    public crearClient() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        result = new String[4];
        result[0] =  nif.getText();
        result[1] =  cognomsNom.getText();
        result[2] =  dataNaix.getText();
        result[3] =  vacunat.getText();

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public String[] getResult() {
        return result;
    }

    public static void main(String[] args) {
        crearClient dialog = new crearClient();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
