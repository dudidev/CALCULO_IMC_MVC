import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Procesos_IMC extends JFrame {
    private JPanel panel1;
    private JLabel lblTitulo;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblEdad;
    private JTextField txtEdad;
    private JLabel lblPeso;
    private JTextField txtPeso;
    private JLabel lblTalla;
    private JTextField txtTalla;
    private JButton btnCalcular;
    private JButton btnLimpiar;

    public Procesos_IMC() {
        super("FORMULARIO");
        setContentPane(panel1);
        System.out.println("Ingresa a la ventana");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean esValido = validarDatos();
                if (esValido){
                    String estado = calcularIMC();
                    mostrarDatos(estado);
                }
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNombre.setText("");
                txtEdad.setText("");
                txtPeso.setText("");
                txtTalla.setText("");
            }
        });
    }

    private boolean validarDatos() {
        int edad = Integer.parseInt(txtEdad.getText());
        double peso = Double.parseDouble(txtPeso.getText());
        double talla = Double.parseDouble(txtTalla.getText());

        boolean res = true;
        if (edad<0 || peso<0 || talla<0){
            JOptionPane.showMessageDialog(null, "Ingrese numeros positivos");
            res = false;
        }
        return res;
    }

    private void mostrarDatos(String estado) {
        String msj = "---------TUS DATOS-----------";

        msj+="\n\nNombre: " + txtNombre.getText();
        msj+="\nEdad: " + txtEdad.getText();
        msj+="\nPeso: " + txtPeso.getText();
        msj+="\nTalla: " + txtTalla.getText();
        msj+="\nEstado: " + estado;

        JOptionPane.showMessageDialog(null, msj);
    }

    private String calcularIMC() {
        double peso = Double.parseDouble(txtPeso.getText());
        double talla = Double.parseDouble(txtTalla.getText());

        double imc = peso/(talla*talla);
        System.out.println(imc);

        String estado = "";

        if (imc < 18){
            System.out.println("Tienes Anorexia");
            estado = "Anorexia";
        } else if (imc >= 18 && imc <20) {
            System.out.println("Tienes Delgadez");
            estado = "Delgadez";
        }else if (imc >= 20 && imc <27) {
            System.out.println("Tienes Normalidad");
            estado = "Normal";
        }else if (imc >= 27 && imc <30) {
            System.out.println("Tienes Obesidad (Grado 1)");
            estado = "Obesidad (Grado 1)";
        }else if (imc >= 30 && imc <35) {
            System.out.println("Tienes Obesidad (Grado 2)");
            estado = "Obesidad (Grado 2)";
        }else if (imc >= 30 && imc <40) {
            System.out.println("Tienes Obesidad (Grado 3)");
            estado = "Obesidad (Grado 3)";
        } else if (imc >=40) {
            System.out.println("Tienes Obesidad Morbida");
            estado = "Obesidad Morbida";
        } else {
            System.out.println("No cae");
        }
        return estado;
    }

}
