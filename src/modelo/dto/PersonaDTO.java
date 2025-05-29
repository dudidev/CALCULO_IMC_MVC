package modelo.dto;

public class PersonaDTO {

    private String documento;
    private String nombre;
    private int edad;
    private double peso;
    private double talla;

    public PersonaDTO() {

    }

    public PersonaDTO(String documento, String nombre, int edad, double peso, double talla) {
        super();
        this.documento = documento;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.talla = talla;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    @Override
    public String toString() {
        return "PersonaDTO [documento=" + documento + ", nombre=" + nombre + ", edad=" + edad + "]";
    }
}
