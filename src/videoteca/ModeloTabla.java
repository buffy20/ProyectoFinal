/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videoteca;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lou
 */
public class ModeloTabla extends AbstractTableModel {

    private List<Pelicula> list;

    public void setDataList(List<Pelicula> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Título";
            case 1:
                return "Director";
            case 2:
                return "Estreno";
            case 3:
                return "Género";
            case 4:
                return "Recaudación";
            case 5:
                return "Óscars";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pelicula pelicula = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pelicula.getTitulo();
            case 1:
                if (pelicula.getIdDirector() != null) {
                    return (pelicula.getIdDirector().getNombre() + " " + pelicula.getIdDirector().getApellidos());
                } else {
                    return "";
                }
            case 2:
                return pelicula.getFechaEstreno();
            case 3:
                if (pelicula.getIdGenero() != null) {
                    return pelicula.getIdGenero().getGenero();
                } else {
                    return "";
                }
            case 4:
                return pelicula.getRecaudacion();
            case 5:
                return pelicula.getOscars();
            default:
                return null;
        }
    }
}
