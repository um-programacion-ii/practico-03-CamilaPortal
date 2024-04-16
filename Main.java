import Excepciones.StockInsuficiente;
import Excepciones.VidaUtilInsuficiente;
import entity.*;
import service.CocinaService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws StockInsuficiente, VidaUtilInsuficiente {
        List<Ingrediente> ingredientes = new ArrayList<>();
        ingredientes.add(new Ingrediente("Agua", 500));
        ingredientes.add(new Ingrediente("Huevos", 6));
        ingredientes.add(new Ingrediente("Lechuga", 6));
        ingredientes.add(new Ingrediente("Tomate", 6));
        ingredientes.add(new Ingrediente("Aceite de oliva", 500));

        List<Utensilio> utensilios = new ArrayList<>();
        utensilios.add(new Utensilio("Cuchillo", 10));
        utensilios.add(new Utensilio("Olla", 10));
        utensilios.add(new Utensilio("Bol", 10));

        Despensa despensa1 = new Despensa();
        Despensa despensa2 = new Despensa();
        Despensa despensa3 = new Despensa();
        Despensa despensa4 = new Despensa();
        Despensa despensa5 = new Despensa();
        Despensa despensa6 = new Despensa();
        Despensa despensa7 = new Despensa();
        Despensa despensa8 = new Despensa();

        agregarIngredientesUtensilios(despensa1, new ArrayList<>(ingredientes), new ArrayList<>(utensilios));
        agregarIngredientesUtensilios(despensa2, new ArrayList<>(ingredientes), new ArrayList<>(utensilios));
        agregarIngredientesUtensilios(despensa3, new ArrayList<>(ingredientes), new ArrayList<>(utensilios));
        agregarIngredientesUtensilios(despensa4, new ArrayList<>(ingredientes), new ArrayList<>(utensilios));
        agregarIngredientesUtensilios(despensa5, new ArrayList<>(ingredientes), new ArrayList<>(utensilios));
        agregarIngredientesUtensilios(despensa6, new ArrayList<>(ingredientes), new ArrayList<>(utensilios));
        agregarIngredientesUtensilios(despensa7, new ArrayList<>(ingredientes), new ArrayList<>(utensilios));
        agregarIngredientesUtensilios(despensa8, new ArrayList<>(ingredientes), new ArrayList<>(utensilios));

        Chef chef1 = new Chef("Juan", 1, despensa1);
        Chef chef2 = new Chef("Pepe", 2, despensa2);
        Chef chef3 = new Chef("Luis", 3, despensa3);
        Chef chef4 = new Chef("Ana", 4, despensa4);
        Chef chef5 = new Chef("Maria", 5, despensa5);
        Chef chef6 = new Chef("Pedro", 1, despensa6);
        Chef chef7 = new Chef("Carlos", 4, despensa7);
        Chef chef8 = new Chef("Sofia", 3, despensa8);

        List<Chef> chefsDomingoAJueves = new ArrayList<>();
        List<Chef> chefsFinDeSemanaFeriados = new ArrayList<>();

        chefsDomingoAJueves.add(chef1);
        chefsDomingoAJueves.add(chef2);
        chefsDomingoAJueves.add(chef3);

        chefsFinDeSemanaFeriados.add(chef4);
        chefsFinDeSemanaFeriados.add(chef5);
        chefsFinDeSemanaFeriados.add(chef6);
        chefsFinDeSemanaFeriados.add(chef7);
        chefsFinDeSemanaFeriados.add(chef8);

        HuevoDuro huevoDuro = new HuevoDuro();
        Ensalada ensalada = new Ensalada();
        EnsaladaDeFrutas ensaladaDeFrutas = new EnsaladaDeFrutas();

//        try {
//            CocinaService.prepararReceta(ensalada, chef1, despensa1.getIngredientes(), despensa1.getUtensilios());
//        } catch (StockInsuficiente e) {
//            System.out.println("Error: " + e.getMessage());
//        }catch (VidaUtilInsuficiente e) {
//            System.out.println("Error de vida útil insuficiente: " + e.getMessage());
//        }
//
//        try {
//            CocinaService.prepararReceta(ensalada, chef2, despensa2.getIngredientes(), despensa2.getUtensilios());
//        } catch (StockInsuficiente e) {
//            System.out.println("Error: " + e.getMessage());
//        }catch (VidaUtilInsuficiente e) {
//            System.out.println("Error de vida útil insuficiente: " + e.getMessage());
//        }

        ExecutorService domingoAJuevesService = Executors.newFixedThreadPool(3);
        ExecutorService findesYFeriadosService = Executors.newFixedThreadPool(5);

        domingoAJuevesService.submit(() -> {
            try {
                CocinaService.prepararReceta(huevoDuro, chef1, despensa1.getIngredientes(), despensa1.getUtensilios());
            } catch (StockInsuficiente | VidaUtilInsuficiente e) {
                System.out.println("Error en la receta de HuevoDuro: " + e.getMessage());
            }
        });

        domingoAJuevesService.submit(() -> {
            try {
                CocinaService.prepararReceta(ensalada, chef2, despensa2.getIngredientes(), despensa2.getUtensilios());
            } catch (StockInsuficiente | VidaUtilInsuficiente e) {
                System.out.println("Error en la receta de Ensalada: " + e.getMessage());
            }
        });

        domingoAJuevesService.submit(() -> {
            try {
                CocinaService.prepararReceta(ensaladaDeFrutas, chef3, despensa3.getIngredientes(), despensa3.getUtensilios());
            } catch (StockInsuficiente | VidaUtilInsuficiente e) {
                System.out.println("Error en la receta de EnsaladaDeFrutas: " + e.getMessage());
            }
        });

        domingoAJuevesService.shutdown();
    }


    public static void agregarIngredientesUtensilios(Despensa despensa, List<Ingrediente> ingredientes, List<Utensilio> utensilios) {
        for (Ingrediente ingrediente : ingredientes) {
            Ingrediente nuevoIngrediente = new Ingrediente(ingrediente.getNombre(), ingrediente.getCantidad());
            despensa.addIngrediente(nuevoIngrediente);
        }

        for (Utensilio utensilio : utensilios) {
            Utensilio nuevoUtensilio = new Utensilio(utensilio.getNombre(), utensilio.getVidaUtil());
            despensa.addUtensilio(nuevoUtensilio);
        }
    }

}
