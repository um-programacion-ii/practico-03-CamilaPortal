import Excepciones.StockInsuficiente;
import Excepciones.VidaUtilInsuficiente;
import entity.*;
import service.CocinaService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws StockInsuficiente, VidaUtilInsuficiente {
        List<Ingrediente> ingredientes = new ArrayList<>();
        ingredientes.add(new Ingrediente("Agua", 500));
        ingredientes.add(new Ingrediente("Huevo", 100));
        ingredientes.add(new Ingrediente("Lechuga", 6));
        ingredientes.add(new Ingrediente("Tomate", 6));
        ingredientes.add(new Ingrediente("Manzana", 6));
        ingredientes.add(new Ingrediente("Aceite de oliva", 500));

        List<Utensilio> utensilios = new ArrayList<>();
        utensilios.add(new Utensilio("Cuchillo", 10));
        utensilios.add(new Utensilio("Olla", 10));
        utensilios.add(new Utensilio("Bol", 10));


        ArrayList<Despensa> despensas = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            despensas.add(new Despensa());
        }

        for (int i = 0; i < despensas.size(); i++) {
            agregarIngredientesUtensilios(despensas, i, new ArrayList<>(ingredientes), new ArrayList<>(utensilios));
        }

        Chef chef1 = new Chef("Juan", 1, despensas.get(0));
        Chef chef2 = new Chef("Pepe", 2, despensas.get(1));
        Chef chef3 = new Chef("Luis", 3, despensas.get(2));
        Chef chef4 = new Chef("Ana", 4, despensas.get(3));
        Chef chef5 = new Chef("Maria", 5, despensas.get(4));
        Chef chef6 = new Chef("Pedro", 1, despensas.get(5));
        Chef chef7 = new Chef("Carlos", 4, despensas.get(6));
        Chef chef8 = new Chef("Sofia", 3, despensas.get(7));

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

        ExecutorService domingoAJuevesService = Executors.newFixedThreadPool(3);
        ExecutorService findesYFeriadosService = Executors.newFixedThreadPool(5);

        for (Chef chef : chefsDomingoAJueves) {
            domingoAJuevesService.execute(() -> {
                try {
                    CocinaService.prepararReceta(obtenerRecetaAleatoria(), chef, chef.getDespensa().getIngredientes(), chef.getDespensa().getUtensilios());
                } catch (StockInsuficiente e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (VidaUtilInsuficiente e) {
                    System.out.println("Error de vida útil insuficiente: " + e.getMessage());
                }
            });
        }

        for (Chef chef : chefsFinDeSemanaFeriados) {
            findesYFeriadosService.execute(() -> {
                try {
                    CocinaService.prepararReceta(obtenerRecetaAleatoria(), chef, chef.getDespensa().getIngredientes(), chef.getDespensa().getUtensilios());
                } catch (StockInsuficiente e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (VidaUtilInsuficiente e) {
                    System.out.println("Error de vida útil insuficiente: " + e.getMessage());
                }
            });
        }
        domingoAJuevesService.shutdown();
        findesYFeriadosService.shutdown();
    }
    private static Receta obtenerRecetaAleatoria() {
        List<Receta> recetasDisponibles = Arrays.asList(new Ensalada(), new HuevoDuro(), new EnsaladaDeFrutas());
        Random random = new Random();
        return recetasDisponibles.get(random.nextInt(recetasDisponibles.size()));
    }
    public static void agregarIngredientesUtensilios(List<Despensa> despensas, int indiceDespensa, List<Ingrediente> ingredientes, List<Utensilio> utensilios) {
        Despensa despensa = despensas.get(indiceDespensa);

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
