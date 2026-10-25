package co.edu.uniquindio.poo.app;

import javax.swing.*;
import java.awt.*;

import co.edu.uniquindio.poo.model.EmpresaEnvios;
import co.edu.uniquindio.poo.model.EnvioNacional;

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
                            " 6. Mostrar envio más caro \n" +
                            " 7. "));

            switch (opcion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

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
        String agregado= empresaEnvios.registrarEnvio(new EnvioNacional(nombreEmpleadoNuevo,
                documentoEmpleadoNuevo, edad, salarioBasico, categoria, descuentoSalud,
                descuentoPension,diasTrabajadosE, valorDia));

        System.out.println("Empleado Temporal agregado con exito");
    }
}
