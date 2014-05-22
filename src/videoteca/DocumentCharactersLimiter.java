
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Lou
 */
public class DocumentCharactersLimiter extends PlainDocument {
    
    private int limit; 
    //Establecemos el límite
    public void setLimit(int limit) { 
        this.limit = limit; 
    }     
    //Sobreescribimos el insertString para establecer el límite de escritura para un jTextField
    @Override 
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException { 
        
        if (str == null) { 
            return; 
        } 
        //Inserta el String en el campo de texto si no excede el límite
        if ((getLength() + str.length()) <= limit) { 
            super.insertString(offset, str, attr); 
        }else{
            String mensaje="Ha excedido el número de caracteres";
            JOptionPane.showMessageDialog(null, mensaje);
        } 
    } 
}
