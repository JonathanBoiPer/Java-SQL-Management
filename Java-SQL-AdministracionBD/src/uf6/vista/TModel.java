package uf6.vista;

import javax.swing.table.AbstractTableModel;

public class TModel extends AbstractTableModel {

    private String[] nomColumnes;
    private Object[][] data;

    public TModel(Object[][] dada, String[] col) {
        data = dada;
        nomColumnes = col;
    }

    @Override
    public int getRowCount() {
        return  data.length;
    }

    @Override
    public int getColumnCount() {
        return nomColumnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    public String getColumnName(int col) {
        return nomColumnes[col];
    }

    public Class getColumnClass(int col) {
        return getValueAt(0,col).getClass();
    }
}
