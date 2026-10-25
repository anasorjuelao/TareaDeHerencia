package co.edu.uniquindio.poo.model;

public class EnvioInternacional extends Envio{

    private String paisDestino;
    private boolean seguro;
    private final float PRECIO_FIJO=15000;

    public EnvioInternacional(String codigo, String destinatario, int pesoKilogramos,
                              float precioPeso, float precioFijo, float adicional,
                              String paisDestino, boolean seguro) {
        super(codigo, destinatario, pesoKilogramos, precioPeso, precioFijo, adicional);
        this.paisDestino = paisDestino;
        this.seguro= seguro;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    @Override
    public double calcularCosto() {
        double costo=PRECIO_FIJO;
        if(seguro){
            costo+=20000;
        }
        return costo;
    }
}
