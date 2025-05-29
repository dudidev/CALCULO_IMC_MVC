package controlador;


import modelo.Procesos;
import modelo.conexion.ConexionBD;
import modelo.dao.PersonaDAO;
import vista.*;

public class Relaciones {

	public Relaciones() {
		// Se instancian las clases
		VentanaPrincipal ventanaPrincipal=new VentanaPrincipal();
		VentanaRegistro ventanaRegistro = new VentanaRegistro(ventanaPrincipal,true);
		VentanaOperaciones ventanaOperaciones = new VentanaOperaciones(ventanaRegistro, true);
		VentanaConsultaIndividual ventanaConsultaIndividual=new VentanaConsultaIndividual(ventanaPrincipal, true);
		VentanaConsultarLista ventanaConsultarLista=new VentanaConsultarLista(ventanaPrincipal,true);
		Procesos misProcesos = new Procesos();
		PersonaDAO miPersonaDAO=new PersonaDAO();
		ConexionBD miConexionBD=new ConexionBD();
		Coordinador miCoordinador = new Coordinador();

		// Se establecen las relaciones entre clases
		ventanaPrincipal.setCoordinador(miCoordinador);
		ventanaRegistro.setCoordinador(miCoordinador);
		ventanaOperaciones.setCoordinador(miCoordinador);
		ventanaConsultaIndividual.setCoordinador(miCoordinador);
		ventanaConsultarLista.setCoordinador(miCoordinador);
		miPersonaDAO.setCoordinador(miCoordinador);
		miConexionBD.setCoordinador(miCoordinador);
		misProcesos.setCoordinador(miCoordinador);

		// Se establecen relaciones con la clase coordinador
		miCoordinador.setVentanaPrincipal(ventanaPrincipal);
		miCoordinador.setVentanaRegistro(ventanaRegistro);
		miCoordinador.setVentanaOperaciones(ventanaOperaciones);
		miCoordinador.setVentanaConsultaIndividual(ventanaConsultaIndividual);
		miCoordinador.setVentanaConsultarLista(ventanaConsultarLista);
		miCoordinador.setProcesos(misProcesos);
		miCoordinador.setMiPersonaDAO(miPersonaDAO);
		miCoordinador.setMiConexionBD(miConexionBD);

		// Mostrar ventana principal
		miCoordinador.mostrarVentanaPrincipal();
	}

}
