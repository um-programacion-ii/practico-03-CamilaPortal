package entity;

import java.util.HashMap;
import java.util.Map;

public class Despensa {
    private Map<String, Ingrediente> ingredientes;
    private Map<String, Utensilio> utensilios;

    public Despensa(){
        this.ingredientes = new HashMap<>();
        this.utensilios = new HashMap<>();
    }

    public void addIngrediente(Ingrediente newIngrediente){
        ingredientes.put(newIngrediente.getNombre(), newIngrediente);
        System.out.println("Se agregó a la despensa: " + newIngrediente.getNombre());
    }

    public void addUtensilio(Utensilio newUtensilio){
        utensilios.put(newUtensilio.getNombre(), newUtensilio);
        System.out.println("Se agregó a la despensa: " + newUtensilio.getNombre());
    }

    public void getIngrediente(String nombre, int cantidad){
        Ingrediente ingrediente = ingredientes.get(nombre);
        if (ingrediente != null) {
            ingrediente.sacar(cantidad);
        } else {
            System.out.println("No tenés " + nombre + " en la despensa");
        }
    }

    public void getUtensilio(String nombre, int uso){
        Utensilio utensilio = utensilios.get(nombre);
        if (utensilio != null) {
            utensilio.usar(uso);
        } else {
            System.out.println("No tenés " + nombre + " en la despensa");
        }
    }

    public Map<String, Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public Map<String, Utensilio> getUtensilios() {
        return utensilios;
    }
}
