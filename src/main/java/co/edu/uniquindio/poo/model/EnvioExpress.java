package co.edu.uniquindio.poo.model;

public class EnvioExpress extends EnvioNacional{

    private int horasMaximas;
    private final double PRECIO_FIJO=getPrecioFijo()*0.3;

    public EnvioExpress(String codigo, String destinatario, int pesoKilogramos,
                        float precioPeso, float precioFijo, float adicional,
                        String cuidadDestino, boolean domicilio, int horasMaximas) {
        super(codigo, destinatario, pesoKilogramos, precioPeso, precioFijo, adicional,
                cuidadDestino, domicilio);
        this.horasMaximas = horasMaximas;
    }

    @Override
    public double calcularCosto() {
        double costo= PRECIO_FIJO;
        if(horasMaximas<=24){
            costo+=5000;
        }
        return costo;
    }
}
