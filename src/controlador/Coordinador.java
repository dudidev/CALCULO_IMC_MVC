package controlador;

import modelo.Procesos;
import modelo.conexion.ConexionBD;
import modelo.dao.PersonaDAO;
import modelo.dto.PersonaDTO;
import vista.*;

import java.util.ArrayList;

public class Coordinador {
    private VentanaPrincipal ventanaPrincipal;
    private VentanaRegistro ventanaRegistro;
    private Procesos procesos;
    private PersonaDAO miPersonaDAO;
    private ConexionBD miConexionBD;
    private VentanaConsultaIndividual ventanaConsultaIndividual;
    private VentanaConsultarLista ventanaConsultarLista;

    // Métodos setters para establecer las relaciones

    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    public void setVentanaRegistro(VentanaRegistro ventanaRegistro) {
        this.ventanaRegistro = ventanaRegistro;
    }

    public void setProcesos(Procesos procesos) {
        this.procesos = procesos;
    }

    public void setMiPersonaDAO(PersonaDAO miPersonaDAO) {
        this.miPersonaDAO = miPersonaDAO;
    }

    public void setMiConexionBD(ConexionBD miConexionBD) {
        this.miConexionBD = miConexionBD;
    }

    public void setVentanaConsultaIndividual(VentanaConsultaIndividual ventanaConsultaIndividual) {
        this.ventanaConsultaIndividual = ventanaConsultaIndividual;
    }

    public void setVentanaConsultarLista(VentanaConsultarLista ventanaConsultarLista) {
        this.ventanaConsultarLista = ventanaConsultarLista;
    }

    //Metodo para mostrar la ventana principal
    public void mostrarVentanaPrincipal() {
        ventanaPrincipal.setVisible(true);
    }

    //Métodos para mostrar las ventanas

    public void mostrarVentanaRegistro() {
        ventanaRegistro.limpiarFormulario();
        ventanaRegistro.setVisible(true);
    }

    public void mostrarVentanaConsultaIndividual() {
        ventanaConsultaIndividual.setVisible(true);
    }

    public void mostrarVentanaConsultarLista() {
        ventanaConsultarLista.consultarListaPersonas();
        ventanaConsultarLista.setVisible(true);
    }

    public String obtenerMensajeConsulta() {
        return procesos.obtenerMensajeEjemplo();
    }

    /////////////////////////

    //Metodo que delega el llamado a la clase de procesos y devuelve una respuesta
    public String consultarDatos(String nombre) {
        String datos = procesos.obtenerDatos(nombre);
        return datos;
    }


    public String calcularOperacion(String seleccion, String num1, String num2) {
        return procesos.calcularOperaciones(seleccion, num1, num2);
    }

    public boolean validarDatoTexto(String campo) {

        return procesos.validarCampo(campo);
    }

    public boolean validarNumero(String valor) {

        return procesos.validarNumero(valor);
    }

    public String registrarPersona(PersonaDTO persona) {
        return miPersonaDAO.registrarPersona(persona);
    }

    public String actualizarPersona(PersonaDTO personaNueva) {
        return miPersonaDAO.actualizarPersona(personaNueva);
    }

    public PersonaDTO consultarPersona(String documento) {

        return miPersonaDAO.consultarPersonaPorDocumento(documento);
    }

    public ArrayList<PersonaDTO> consultarListaPersonas() {

        return miPersonaDAO.consultarListaPersonas();
    }

    public String eliminarPersona(String documento) {

        return miPersonaDAO.eliminarPersona(documento);
    }

    public String resultadoIMC(double peso, double talla){
        return procesos.calcularIMC(peso, talla);
    }

    public void mostrarCalculos(String doc, String nombre, int edad, double peso, double talla) {
        String estado = resultadoIMC(peso, talla);
        procesos.imprimirDatos(doc, nombre, edad, peso, talla, estado);
    }
}
