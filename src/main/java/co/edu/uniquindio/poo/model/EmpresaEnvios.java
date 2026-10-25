package co.edu.uniquindio.poo.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class EmpresaEnvios {

    private String nombre;
    private List <Envio> listaEnvios = new LinkedList<>();

    public EmpresaEnvios(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Envio> getListaEnvios() {
        return listaEnvios;
    }

    public void setListaEnvios(List<Envio> listaEnvios) {
        this.listaEnvios = listaEnvios;
    }

    //Metodos
    public String registrarEnvio(Envio envio){
        Optional<Envio> encontrado = buscarEnvio(envio.getCodigo());
        if(encontrado.isPresent()){
            return "El envio ya existe.";
        }else {
            listaEnvios.add(envio);
            return "Envio registrado exitosamente.";
        }
    }

    private Optional<Envio> buscarEnvio(String codigo) {
        return listaEnvios.
                stream().
                filter(e -> e.getCodigo().equals(codigo)).findFirst();
    }
    public Envio buscarMasCostoso(){
        Envio envioCaro= null;

        for(int i=0; i<listaEnvios.size(); i++){
            if(listaEnvios.get(i).calcularCosto()> listaEnvios.get(i+1).calcularCosto()){
                envioCaro= listaEnvios.get(i);
            }
        }
        return envioCaro;
    }
}
