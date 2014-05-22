/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Renderers;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Lou
 */
public class FechaRenderer extends DefaultTableCellRenderer{
    //Para dar formato a Fecha
    public FechaRenderer(){
        //Alinear al centro
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    protected void setValue(Object aValue) {
        Object result = aValue;  
        //pregunta si es un fecha
        if ((aValue != null) && (aValue instanceof Date)) { 
            Date dateValue = (Date) result; 
            //Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd'/'MM'/'yyyy");
            result = formatoFecha.format(dateValue);
        } 
        super.setValue(result);
    }
    
}
