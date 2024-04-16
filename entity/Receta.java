package entity;

import java.util.List;

public class Receta {
    private List<Ingrediente> ingredientes;
    private List<Utensilio> utensilios;
    private int tiempoCoccion;
    private String preparacion;

    public Receta(List<Ingrediente> ingredientes, List<Utensilio> utensilios, int tiempoCoccion, String preparacion){
        this.ingredientes = ingredientes;
        this.utensilios = utensilios;
        this.tiempoCoccion = tiempoCoccion;
        this.preparacion = preparacion;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<Utensilio> getUtensilios() {
        return utensilios;
    }

    public void setUtensilios(List<Utensilio> utensilios) {
        this.utensilios = utensilios;
    }

    public int getTiempoCoccion() {
        return tiempoCoccion;
    }

    public void setTiempoCoccion(int tiempoCoccion) {
        this.tiempoCoccion = tiempoCoccion;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public String toString(){
        String resultado = "Ingredientes:\n";
        for (Ingrediente ingrediente : ingredientes) {
            resultado += "- " + ingrediente.getNombre() + ": " + ingrediente.getCantidad() + "\n";
        }
        resultado += "Utensilios necesarios:\n";
        for (Utensilio utensilio : utensilios) {
            resultado += "- " + utensilio + "\n";
        }
        resultado += "Tiempo de cocción: " + tiempoCoccion + " minutos\n";
        resultado += "Preparación: " + preparacion + "\n";
        return resultado;
    }
}
