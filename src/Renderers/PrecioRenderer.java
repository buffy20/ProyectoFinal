/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Renderers;

import java.text.NumberFormat;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Lou
 */
public class PrecioRenderer extends DefaultTableCellRenderer{
    //Para dar formato a precios
    public PrecioRenderer(){
        //Alinear a la derecha
        setHorizontalAlignment(SwingConstants.RIGHT);
    }

    @Override
    protected void setValue(Object aValue) {
        Object result = aValue;
        //pregunta si es un número
        if ((aValue != null) && (aValue instanceof Number)) { 
            Number numberValue = (Number) aValue; 
            NumberFormat formatter = NumberFormat.getCurrencyInstance(); 
            result = formatter.format(numberValue.doubleValue()); 
        } 
        super.setValue(result);
    }
    
}
