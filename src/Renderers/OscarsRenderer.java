/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Renderers;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Lou
 */
public class OscarsRenderer extends DefaultTableCellRenderer {

    public OscarsRenderer() {
        //Alinear la imagen en el centro
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    protected void setValue(Object aValue) {
        Boolean prizes = (Boolean)aValue;
        if(prizes){
            setText("");
            setIcon(new ImageIcon(getClass().getResource("/resources/v.png")));
        }else{
            setText("");
            setIcon(new ImageIcon(getClass().getResource("/resources/x.png")));
        }
        //super.setValue(prizes);
    }
}
