package vista;

import controlador.Coordinador;
import modelo.dto.PersonaDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConsultaIndividual extends JDialog implements ActionListener{

    private Coordinador coordinador;
    private JButton btnConsulta;
    private JTextField txtNombre;
    private JButton btnActualizar;
    private JLabel lblDocumento;
    private JTextField txtDocumento;
    private JLabel lblEdad;
    private JTextField txtEdad;
    private JLabel lblConsultaDeUsuarios;
    private JButton btnEliminar;
    private JLabel lblPeso;
    private JTextField txtPeso;
    private JLabel lblTalla;
    private JTextField txtTalla;
    private JLabel lblEstado;
    private JTextField txtEstado;

    public VentanaConsultaIndividual(VentanaPrincipal ventanaPrincipal, boolean modal) {
        /**Al llamar al constructor super(), le enviamos el
         * JFrame Padre y la propiedad booleana que determina
         * que es hija*/
        super(ventanaPrincipal, modal);
        setTitle("Ventana Registro Persona");
        setSize(370, 277);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        iniciarComponentes();
    }

    private void iniciarComponentes() {

        btnConsulta = new JButton("\uD83D\uDD0D");
        btnConsulta.setBounds(200, 49, 56, 30);
        btnConsulta.addActionListener(this);
        getContentPane().add(btnConsulta);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(17, 194, 159, 30);
        btnActualizar.addActionListener(this);
        getContentPane().add(btnActualizar);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(17, 91, 144, 30);
        getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(17, 117, 200, 30);
        getContentPane().add(txtNombre);

        lblPeso = new JLabel("Peso");
        lblPeso.setBounds(17, 160, 50, 30);
        getContentPane().add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(50, 160, 50, 30);
        getContentPane().add(txtPeso);

        lblTalla = new JLabel("Talla");
        lblTalla.setBounds(110, 160, 50, 30);
        getContentPane().add(lblTalla);

        txtTalla = new JTextField();
        txtTalla.setBounds(150, 160, 50, 30);
        getContentPane().add(txtTalla);

        lblEstado = new JLabel("Estado");
        lblEstado.setBounds(210, 160, 50, 30);
        getContentPane().add(lblEstado);

        txtEstado = new JTextField();
        txtEstado.setBounds(260, 160, 80, 30);
        getContentPane().add(txtEstado);

        lblDocumento = new JLabel("Documento");
        lblDocumento.setBounds(17, 48, 90, 30);
        getContentPane().add(lblDocumento);

        txtDocumento = new JTextField();
        txtDocumento.setBounds(100, 48, 85, 30);
        getContentPane().add(txtDocumento);

        lblEdad = new JLabel("Edad");
        lblEdad.setBounds(250, 91, 50, 30);
        getContentPane().add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(250, 117, 90, 30);
        getContentPane().add(txtEdad);

        lblConsultaDeUsuarios = new JLabel("CONSULTA DE USUARIOS");
        lblConsultaDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
        lblConsultaDeUsuarios.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblConsultaDeUsuarios.setBounds(17, 6, 335, 30);
        getContentPane().add(lblConsultaDeUsuarios);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(188, 195, 151, 29);
        btnEliminar.addActionListener(this);
        getContentPane().add(btnEliminar);
    }

    // Método para establecer el coordinador
    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnConsulta) {

            PersonaDTO miPersona=coordinador.consultarPersona(txtDocumento.getText());

            if (miPersona!=null) {
                txtNombre.setText(miPersona.getNombre());
                txtEdad.setText(miPersona.getEdad()+"");
                txtPeso.setText(miPersona.getPeso()+"");
                txtTalla.setText(miPersona.getTalla()+"");
                txtEstado.setText(miPersona.getEstado());

            }else {
                JOptionPane.showMessageDialog(null, "NO SE ENCUENTRA LA PERSONA","NO REGISTRA",JOptionPane.ERROR_MESSAGE);
                txtNombre.setText("");
                txtEdad.setText("");
                txtPeso.setText("");
                txtTalla.setText("");
                txtEstado.setText("");
            }

        }else if(e.getSource()==btnActualizar) {
            actualizarUsuario();
        }else if(e.getSource()==btnEliminar) {
            eliminarUsuario();
        }
    }

    private void eliminarUsuario() {
        String resp=coordinador.eliminarPersona(txtDocumento.getText());
        if (resp.equals("ok")) {
            JOptionPane.showMessageDialog(null, "Se elimina exitosamente","Elimina",JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR","ERROR",JOptionPane.ERROR_MESSAGE);

        }
    }

    private void actualizarUsuario() {
        PersonaDTO personaNueva=coordinador.consultarPersona(txtDocumento.getText());
        personaNueva.setNombre(txtNombre.getText());
        personaNueva.setEdad(Integer.parseInt(txtEdad.getText()));
        personaNueva.setPeso(Double.parseDouble(txtPeso.getText()));
        personaNueva.setTalla(Double.parseDouble(txtTalla.getText()));
        personaNueva.setEstado(txtEstado.getText());

        String resp=coordinador.actualizarPersona(personaNueva);

        if (resp.equals("ok")) {
            JOptionPane.showMessageDialog(null, "Se Actualiza exitosamente","Actualizado",JOptionPane.WARNING_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "NO SE PUDO ACTUALIZAR","ERROR",JOptionPane.ERROR_MESSAGE);

        }

    }
}

