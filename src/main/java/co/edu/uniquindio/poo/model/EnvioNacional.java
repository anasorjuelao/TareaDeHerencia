package co.edu.uniquindio.poo.model;

public class EnvioNacional extends Envio {

    private String cuidadDestino;
    private boolean domicilio;

    public EnvioNacional(String codigo, String destinatario, int pesoKilogramos,
                         float precioPeso, float precioFijo, float adicional,
                         String cuidadDestino, boolean domicilio) {
        super(codigo, destinatario, pesoKilogramos, precioPeso , precioFijo, adicional);
        this.cuidadDestino = cuidadDestino;
        this.domicilio= domicilio;
    }

    public String getCuidadDestino() {
        return cuidadDestino;
    }

    public void setCuidadDestino(String cuidadDestino) {
        this.cuidadDestino = cuidadDestino;
    }

    public boolean isDomicilio() {
        return domicilio;
    }

    public void setDomicilio(boolean domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public double calcularCosto() {
        double costo=calcularFijo();
        if(domicilio){
            costo+=3000;
        }
        return costo;
    }
}
