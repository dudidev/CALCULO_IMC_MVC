package modelo.conexion;

import controlador.Coordinador;
import modelo.dto.PersonaDTO;

import java.util.HashMap;

public class ConexionBD {

    public static HashMap<String, PersonaDTO> personasMap;
    private Coordinador miCoordinador;

    public ConexionBD() {
        personasMap=new HashMap<String, PersonaDTO>();
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador=miCoordinador;
    }
}
