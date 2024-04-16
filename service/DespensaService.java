package service;

import Excepciones.StockInsuficiente;
import Excepciones.VidaUtilInsuficiente;
import entity.Ingrediente;
import entity.Receta;
import entity.Utensilio;

import java.util.Map;


public class DespensaService {
    public static void verificarStock(Map<String, Ingrediente> despensaIngredientes, Receta receta) throws StockInsuficiente {
        for (Ingrediente ingredienteReceta : receta.getIngredientes()) {
            Ingrediente ingredienteDespensa = despensaIngredientes.get(ingredienteReceta.getNombre());
            if (ingredienteDespensa == null || ingredienteDespensa.getCantidad() < ingredienteReceta.getCantidad()) {
                throw new StockInsuficiente("No hay suficiente " + ingredienteReceta.getNombre() +
                        " en la despensa. Faltan " + (ingredienteReceta.getCantidad()) + " unidades.");
            }
        }
    }

    public static void verificarVidaUtil(Map<String, Utensilio> despensaUtensilios, Receta receta) throws VidaUtilInsuficiente {
        for (Utensilio utensilioReceta : receta.getUtensilios()) {
            Utensilio utensilioDespensa = despensaUtensilios.get(utensilioReceta.getNombre());
            if (utensilioDespensa == null || utensilioDespensa.getVidaUtil() < utensilioReceta.getVidaUtil()) {
                throw new VidaUtilInsuficiente("La vida útil del utensilio " + utensilioReceta.getNombre() +
                        " en la despensa no es suficiente para cocinar esta receta.");
            }
        }
    }

    public static void renovarUtensilios(Map<String, Utensilio> despensaUtensilios) {
        for (Utensilio utensilio : despensaUtensilios.values()) {
            if (utensilio.getVidaUtil() == 0) {
                utensilio.setVidaUtil(100);
            }
        }
    }
}
