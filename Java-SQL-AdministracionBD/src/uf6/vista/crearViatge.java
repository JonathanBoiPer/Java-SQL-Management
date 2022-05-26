package uf6.vista;

import javax.swing.*;
import java.awt.event.*;

public class crearViatge extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField id;
    private JTextField idClient;
    private JTextField desti;
    private JTextField dataInici;
    private JTextField durada;
    private JTextField preuTotal;
    private String[] result;

    public crearViatge() {
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
        result = new String[5];
        result[0] = idClient.getText();
        result[1] = desti.getText();
        result[2] = dataInici.getText();
        result[3] = durada.getText();
        result[4] = preuTotal.getText();

        dispose();
    }

    public String[] getResult() {
        return result;
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        crearViatge dialog = new crearViatge();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
