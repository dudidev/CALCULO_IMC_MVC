package modelo;
import javax.swing.*;

import controlador.Coordinador;

public class Procesos {
    //En caso de que se requiera usar el coordinador desde aquí
    private Coordinador coordinador;

    // Establecer el coordinador
    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public String obtenerDatos(String nombre) {
        //Aquí van los procesos que se delegan a la clase
        return "Bienvenido "+nombre.toUpperCase();
    }

    public String obtenerMensajeEjemplo() {

        return "Este es un mensaje de ejemplo";
    }

    /*
     * Metodo de ejemplo para validar que no se permita datos
     * numericos
     */
    public boolean validarCampo(String campo) {

        try {
            //si transforma el dato a numero y no lanza la excepcion es
            //porque es un dato numerico, por lo tanto no deberia permitir
            //el ingreso por esa razon retorna false
            int val=Integer.parseInt(campo.trim());

            return false;

        } catch (Exception e) {

            //si entra al catch es porque es un texto que no pudo convertir a numero por lo tanto
            //es correcto que sea un nombre, pero ahora valida que no sea vacio, si es vacio es porque
            //no ingresaron nada y no se debe permitir, en caso contrario retorna true
            if (campo.trim().equals("")) {
                return false;
            }else {
                return true;
            }

        }
    }

    /*
     * Valida que los numeros del formulario no sean negativos ni vacios
     */
    public boolean validarNumero(String valor) {
        boolean retorno=false;
        try {
            double num=Double.parseDouble(valor);

            if (num>=0) {
                retorno= true;
            }else {
                retorno = false;
            }

        } catch (Exception e) {
            retorno = false;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return retorno;
    }

    public String calcularIMC(double peso, double talla) {

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

    public void imprimirDatos(String doc, String nombre, int edad, double peso, double talla, String estado) {
        String msj = "\nDocumento: " + doc;
        msj += "\nNombre: " + nombre;
        msj += "\nEdad: " + edad;
        msj += "\nPeso: " + peso;
        msj += "\nTalla: " + talla;
        msj += "\nEstado: " + estado;

        JOptionPane.showMessageDialog(null, msj, "TUS CALCULOS DE IMC", JOptionPane.INFORMATION_MESSAGE);
    }
}
