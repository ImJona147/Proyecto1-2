//Paquete en donde se encuentra la clase
package practicas.practica2;

//Librerias usadas
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;

//Nombre de la clase Teclas que extiende de la clase JFrame
public class Teclas extends JFrame implements KeyListener {
    //Creación de un objeto de tipo JTextArea y de tipo String
    JTextArea txt_area;
    String msg1, msg2, msg3;
    
    //Constructor de la clase Teclas
    public Teclas() {
        //Con la palabra super y con parámetros de entrada
        //establecemos el titulo al frame
        super("Práctica de KeyListener");
        //se instancia la clase JTextArea metiendo parámetros de entrada
        //que sirve para indicar el tamaño del área del texto.
        txt_area = new JTextArea(40, 80);
        //Se coloca un texto dentro del Jtexarea
        txt_area.setText("Oprime cualquier tecla");
        //Se cambia la fuente y su tamaño
        txt_area.setFont(new Font("Dialog", 1, 18));
        //Se desabilita el poder editar el área de texto
        txt_area.setEnabled(false);
        //Se establece un color al texto que se muestra en pantalla
        txt_area.setDisabledTextColor(Color.BLACK);
        //Se cambia el color de fondo a CYAN
        txt_area.setBackground(Color.CYAN);
        //Se agrega el contenido de textArea al frame
        this.getContentPane().add(txt_area);
        //Se indica que todo los eventos de la tecla deben ser tomados en esta clase.
        addKeyListener(this);
        //Se establece el tamaño del frame
        setSize(800,400);
        //La posición en donde aparecerá cuando se ejecute
        //en este caso, al ser 'null' su posición será en el centro.
        setLocationRelativeTo(null);
        //Con esto mantendra el diseño por defecto, dependiendo la maquina que uses.
        setDefaultLookAndFeelDecorated(true);
        //El frame será visible en nuestra pantalla
        setVisible(true);
        //La operación que se ejecutará cuando se cierre el programa
        //en este caso, cierra por completo y no lo deja en 2do plano
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    //Método implementado por KeyListener
    @Override
    public void keyTyped(KeyEvent e) {
        //Se coloca el valor dependiendo la acción que se haga.
        msg1 = "Se escribió el carácter: " + e.getKeyChar();
        //Se llama al método 'mensaje' que indica la acción de cada tecla
        mensaje(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        msg1 = "Se oprimió la tecla: " + KeyEvent.getKeyText(e.getKeyCode());
        mensaje(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        msg1 = "Se liberó la tecla: " + KeyEvent.getKeyText(e.getKeyCode());
        mensaje(e);
    }
    
    
    //Método que detecta la tecla y arroja si es una tecla de acción
    //o si no es una tecla de acción
    private void mensaje(KeyEvent e) {
        if (e.isActionKey()) {
            msg2 = "Esta es una tecla de acción";
        } else {
            msg2 = "Esta tecla NO ES DE ACCIÓN";
        }
        //O si la tecla es modificadora
        msg3 = "Es una tecla modificadora: " + KeyEvent.getModifiersExText(e.getModifiersEx());
        //Se agrega el valor establecido al area de texto de nuestro Frame
        txt_area.setText(msg1 + "\n" + msg2 + "\n" + msg3);
    }
}
