import javax.swing.*;

public class Principal {
    public static void main(String[] x){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame miVen = new Procesos_IMC();
                miVen.setVisible(true);
            }
        });
    }
}
