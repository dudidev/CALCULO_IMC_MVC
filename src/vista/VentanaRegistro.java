package vista;

import controlador.Coordinador;
import modelo.dto.PersonaDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistro extends JDialog implements ActionListener{

    private Coordinador coordinador;
    private JButton btnRegistrar;
    private JTextField txtNombre;
    private JLabel lblResultado;
    private JButton btnCalculos;
    private JLabel lblDocumento;
    private JTextField txtDocumento;
    private JLabel lblEdad;
    private JTextField txtEdad;
    private JButton btnConsultar;
    private JLabel lblRegistrarUsuarios;
    private JLabel lblTalla;
    private JTextField txtTalla;
    private JLabel lblPeso;
    private JTextField txtPeso;
    private double peso;
    private double talla;

    public VentanaRegistro(VentanaPrincipal ventanaPrincipal, boolean modal) {
        /**Al llamar al constructor super(), le enviamos el
         * JFrame Padre y la propiedad booleana que determina
         * que es hija*/
        super(ventanaPrincipal, modal);
        setTitle("Ventana Registro Persona");
        setSize(382, 377);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        iniciarComponentes();
    }

    private void iniciarComponentes() {
        txtNombre = new JTextField();
        txtNombre.setBounds(50, 74, 200, 30);
        getContentPane().add(txtNombre);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(260, 74, 100, 30);
        btnRegistrar.addActionListener(this);
        getContentPane().add(btnRegistrar);

        lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(50, 178, 300, 30);
        getContentPane().add(lblResultado);

        btnCalculos = new JButton("Hacer Calculos");
        btnCalculos.setBounds(39, 213, 160, 30);
        btnCalculos.addActionListener(this);
        btnCalculos.setVisible(false);
        getContentPane().add(btnCalculos);

        JLabel lblNombre = new JLabel("Ingrese su nombre");
        lblNombre.setBounds(50, 48, 300, 30);
        getContentPane().add(lblNombre);

        lblDocumento = new JLabel("Documento");
        lblDocumento.setBounds(50, 110, 91, 30);
        getContentPane().add(lblDocumento);

        txtDocumento = new JTextField();
        txtDocumento.setBounds(140, 110, 110, 30);
        getContentPane().add(txtDocumento);

        lblTalla = new JLabel("Talla");
        lblTalla.setBounds(50, 150, 91, 30);
        getContentPane().add(lblTalla);

        txtTalla = new JTextField();
        txtTalla.setBounds(140, 150, 110, 30);
        getContentPane().add(txtTalla);

        lblPeso = new JLabel("Peso");
        lblPeso.setBounds(270, 150, 50, 30);
        getContentPane().add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(313, 150, 40, 30);
        getContentPane().add(txtPeso);

        lblEdad = new JLabel("Edad");
        lblEdad.setBounds(270, 110, 49, 30);
        getContentPane().add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(313, 110, 41, 30);
        getContentPane().add(txtEdad);

        btnConsultar = new JButton("Consultar Registros");
        btnConsultar.setBounds(211, 214, 149, 29);
        btnConsultar.setVisible(false);
        btnConsultar.addActionListener(this);
        getContentPane().add(btnConsultar);

        lblRegistrarUsuarios = new JLabel("REGISTRAR USUARIOS");
        lblRegistrarUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegistrarUsuarios.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblRegistrarUsuarios.setBounds(0, 6, 376, 30);
        getContentPane().add(lblRegistrarUsuarios);
    }

    // Método para establecer el coordinador
    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnRegistrar) {
            validaRegistro();

        }else if(e.getSource()==btnCalculos) {
            String doc = txtDocumento.getText();
            String nombre = txtNombre.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            peso = Double.parseDouble(txtPeso.getText());
            talla = Double.parseDouble(txtTalla.getText());
            coordinador.mostrarCalculos(doc, nombre, edad, peso, talla);

        }else if(e.getSource()==btnConsultar) {
            coordinador.mostrarVentanaConsultarLista();;
        }
    }


    private void validaRegistro() {
        boolean validaNombre=coordinador.validarDatoTexto(txtNombre.getText());
        boolean validaDocumento=coordinador.validarDatoTexto(txtNombre.getText());
        boolean validaEdad=coordinador.validarNumero(txtEdad.getText());
        boolean validaTalla=coordinador.validarNumero(txtTalla.getText());
        boolean validaPeso=coordinador.validarNumero(txtPeso.getText());

        verificaCampo(validaNombre, txtNombre);
        verificaCampo(validaDocumento, txtDocumento);
        verificaCampo(validaEdad, txtEdad);
        verificaCampo(validaTalla, txtTalla);
        verificaCampo(validaPeso, txtPeso);

        if(validaNombre==true && validaDocumento==true && validaEdad==true && validaTalla==true && validaPeso==true) {

            String res=coordinador.consultarDatos(txtNombre.getText());

            if(registrarPersona()==true) {

                lblResultado.setText("Resultado: "+res+", Registro Ok");
            }else {
                lblResultado.setText("Resultado: "+res+", No Registra");
            }


            lblResultado.setForeground(Color.black);
            btnCalculos.setVisible(true);
            btnConsultar.setVisible(true);
        }else {
            lblResultado.setText("Valide los tipos de datos ingresados");
            lblResultado.setForeground(Color.red);
            btnCalculos.setVisible(false);
            btnConsultar.setVisible(false);
        }
    }

    private boolean registrarPersona() {
        PersonaDTO miPersonaDTO=new PersonaDTO();
        miPersonaDTO.setDocumento(txtDocumento.getText());
        miPersonaDTO.setNombre(txtNombre.getText());
        miPersonaDTO.setEdad(Integer.parseInt(txtEdad.getText()));
        miPersonaDTO.setPeso(Double.parseDouble(txtPeso.getText()));
        miPersonaDTO.setTalla(Double.parseDouble(txtTalla.getText()));
        miPersonaDTO.setEstado(coordinador.resultadoIMC(peso, talla));

        String resp=coordinador.registrarPersona(miPersonaDTO);

        if (resp.equals("si")) {
            return true;
        }else {
            return false;
        }
    }

    public void limpiarFormulario() {
        txtNombre.setText("");
        txtDocumento.setText("");
        txtEdad.setText("");
        txtPeso.setText("");
        txtTalla.setText("");
        lblResultado.setText("");
        btnCalculos.setVisible(false);
        btnConsultar.setVisible(false);
    }

    private void verificaCampo(boolean validarCampo, JTextField campo) {

        if (validarCampo==true) {
            campo.setBackground(Color.white);
        }else {
            campo.setBackground(Color.red);
        }

    }
}

