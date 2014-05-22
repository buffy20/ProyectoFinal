/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoteca;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Lou
 */
public class ListaGeneros {

    private ArrayList<Genero> generos = new ArrayList();
    private Connection connection = null;
    private final String HOST = "localhost";
    private final String NAME = "videoteca";
    private final String USER = "root";
    private final String PASSWORD = "";
    private Genero generoSeleccionado = null;
    private Genero[] arrayGeneros;
    Frame frameParent = Frame.getFrames()[0];
    
    public Genero getGeneroSelected() {
        return generoSeleccionado;
    }
    
        public void connectBD() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + HOST + "/" + NAME,
                    USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaActores.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(frameParent, "No se ha encontrado la librería MySQL", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (InstantiationException ex) {
            Logger.getLogger(ListaActores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ListaActores.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(frameParent, "No se ha podido conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (SQLException ex) {
            Logger.getLogger(ListaActores.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(frameParent, "No se ha podido conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public void loadList() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSetGenero = statement.executeQuery(
                    "SELECT * FROM Genero");
            while (resultSetGenero.next()) {
                Short id = resultSetGenero.getShort("IdGenero");
                String nombreGenero = resultSetGenero.getString("Genero");
                //Guardar el actor en la lista
                Genero listaGenero = new Genero();
                listaGenero.setIdGenero(id);
                listaGenero.setGenero(nombreGenero);
                generos.add(listaGenero);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListaActores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Genero[] getArrayGeneros(){
        return arrayGeneros = (Genero[])generos.toArray();
    }
}
