package co.edu.uniquindio.poo.app;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

import co.edu.uniquindio.poo.model.*;

public class Main {
    static void main() {
        EmpresaEnvios empresaEnvios= new EmpresaEnvios("Empresa");

        int opcion;

        do {
            opcion = Integer.valueOf(JOptionPane.showInputDialog(null,
                    "Por favor selecciones una opcion :\n ---Menu--\n" +
                            "1. Agregar un envio nacional\n" +
                            " 2. Agregar un envio internacional\n" +
                            " 3. Agregar empleado express\n" +
                            " 4. Mostrar envios\n" +
                            " 5. Buscar envio por su codigo\n" +
                            " 6. Mostrar envio más caro"));

            switch (opcion) {
                case 1:
                    registrarEnvioNacional(empresaEnvios);
                    break;
                case 2:
                    registrarEnvioInternacional(empresaEnvios);
                    break;
                case 3:
                    registrarEnvioExpress(empresaEnvios);
                    break;
                case 4:
                    mostrarEnvios(empresaEnvios);
                    break;
                case 5:
                    buscarEnvio(empresaEnvios);
                    break;
                case 6:
                    mostrarEnvioMasCaro(empresaEnvios);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Muchas " +
                            "gracias por usar nuestro sistema");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion " +
                            "Invalida");

            }
        }while(opcion!=0);

    }
    public static void registrarEnvioNacional(EmpresaEnvios empresaEnvios){

        String codigo= JOptionPane.showInputDialog("Ingrese el codigo del envio.");

        String destinatario= JOptionPane.showInputDialog("Ingrese el destinatario. ");

        String pesoEnvio= JOptionPane.showInputDialog("Ingrese el peso (kg) del envio. ");

        int pesoKilogramos= Integer.parseInt(pesoEnvio);

        int precioPeso=2000;

        String precioEnvio= JOptionPane.showInputDialog("Ingrese el precio fijo del envio. ");

        float precioFijo = Float.parseFloat(precioEnvio);

        int adicional=0;

        String cuidadDestino= JOptionPane.showInputDialog("Ingrese la cuidad de destino. ");

        String domicilioEnvio=JOptionPane.showInputDialog("¿Requiere entrega a domicilio?");

        boolean domicilio=false;
            if(domicilioEnvio.equals("Sí")){
                domicilio=true;
                adicional+=3000;
            }
        String agregado= empresaEnvios.registrarEnvio(new EnvioNacional(codigo,
                destinatario, pesoKilogramos, precioPeso, precioFijo, adicional,
                cuidadDestino, domicilio));

        System.out.println("Envio nacional agregado con exito");
    }
    public static void registrarEnvioInternacional(EmpresaEnvios empresaEnvios){

        String codigo= JOptionPane.showInputDialog("Ingrese el codigo del envio.");

        String destinatario= JOptionPane.showInputDialog("Ingrese el destinatario. ");

        String pesoEnvio= JOptionPane.showInputDialog("Ingrese el peso (kg) del envio. ");

        int pesoKilogramos= Integer.parseInt(pesoEnvio);

        int precioPeso=9000;

        String precioEnvio= JOptionPane.showInputDialog("Ingrese el precio fijo del envio. ");

        float precioFijo = Float.parseFloat(precioEnvio);

        String adicionalEnvio= JOptionPane.showInputDialog("Ingrese el costo addicional.");

        float adicional= Float.parseFloat(adicionalEnvio);

        String paisDestino= JOptionPane.showInputDialog("¿Cual es el país de destino. ");

        String seguroEnvio= JOptionPane.showInputDialog("¿Requiere seguro seguro?");

        boolean seguro=false;

        if(seguroEnvio.equalsIgnoreCase("Sí")){
            seguro= true;
        }

        String agregado= empresaEnvios.registrarEnvio(new EnvioInternacional(codigo,
                destinatario, pesoKilogramos, precioPeso, precioFijo, adicional,
                paisDestino, seguro));

        System.out.println("Envio express agregado con exito");
    }
    public static void registrarEnvioExpress(EmpresaEnvios empresaEnvios){

        String codigo= JOptionPane.showInputDialog("Ingrese el codigo del envio.");

        String destinatario= JOptionPane.showInputDialog("Ingrese el destinatario. ");

        String pesoEnvio= JOptionPane.showInputDialog("Ingrese el peso (kg) del envio. ");

        int pesoKilogramos= Integer.parseInt(pesoEnvio);

        int precioPeso=2000;

        String precioEnvio= JOptionPane.showInputDialog("Ingrese el precio fijo del envio. ");

        float precioFijo = Float.parseFloat(precioEnvio);

        precioFijo+= precioFijo*0.5;

        float adicional=0;

        String cuidadDestino= JOptionPane.showInputDialog("Ingrese la cuidad de destino. ");

        String domicilioEnvio=JOptionPane.showInputDialog("¿Requiere entrega a domicilio?");

        boolean domicilio=false;
        if(domicilioEnvio.equalsIgnoreCase("Sí")){
            domicilio=true;
        }

        String horasEnvio= JOptionPane.showInputDialog("Ingrese las horas maximas " +
                "para la entrega. ");

        int horasMaximas= Integer.parseInt(horasEnvio);

        if(horasMaximas<24){
            adicional+=5000;
        }

        String agregado= empresaEnvios.registrarEnvio(new EnvioExpress(codigo,
                destinatario, pesoKilogramos, precioPeso, precioFijo, adicional,
                cuidadDestino, domicilio, horasMaximas));

        System.out.println("Envio express agregado con exito");
    }
    public static String mostrarEnvios(EmpresaEnvios empresaEnvios){
        return empresaEnvios.mostrarEnvios();
    }
    public static void buscarEnvio(EmpresaEnvios empresaEnvios){
        String codigoE= JOptionPane.showInputDialog("Ingrese codigo del envio a buscar.");
        Optional<Envio> envioBuscado= empresaEnvios.buscarEnvio(codigoE);

        if(envioBuscado.isEmpty()){
            System.out.println("Envio encontrado en el sistema. ");
        }else{
            System.out.println("Este codigo no corresponde a ningun envio. ");
        }
    }
    public static void mostrarEnvioMasCaro(EmpresaEnvios empresaEnvios){
        Envio envioCaro= empresaEnvios.buscarMasCostoso();
        System.out.println("El envio más caro registrado es: "+envioCaro);
    }
}
