package co.edu.uniquindio.poo.model;

public abstract class Envio {

    protected String codigo;
    protected String destinatario;
    protected int pesoKilogramos;
    protected float precioPeso;
    protected float precioFijo;
    protected float adicional;

    public Envio(String codigo, String destinatario, int pesoKilogramos,
                 float precioPeso, float precioFijo, float adicional) {
        this.codigo = codigo;
        this.destinatario= destinatario;
        this.pesoKilogramos= pesoKilogramos;
        this.precioPeso= precioPeso;
        this.precioFijo= precioFijo;
        this.adicional= adicional;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public int getPesoKilogramos() {
        return pesoKilogramos;
    }

    public void setPesoKilogramos(int pesoKilogramos) {
        this.pesoKilogramos = pesoKilogramos;
    }

    public double getPrecioPeso() {
        return precioPeso;
    }

    public void setPrecioPeso(float precioPeso) {
        this.precioPeso = precioPeso;
    }

    public float getPrecioFijo() {
        return precioFijo;
    }

    public void setPrecioFijo(float precioFijo) {
        this.precioFijo = precioFijo;
    }

    public float getAdicional() {
        return adicional;
    }

    public void setAdicional(float adicional) {
        this.adicional = adicional;
    }


    public double calcularFijo(){
        return precioFijo + pesoKilogramos*precioFijo;
    }

    public abstract double calcularCosto();

}
