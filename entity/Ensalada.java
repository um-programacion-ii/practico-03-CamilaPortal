package entity;

import java.util.List;

public class Ensalada extends Receta{
    public Ensalada(){
        super(List.of(
                new Ingrediente("Lechuga", 1),
                new Ingrediente("Tomate", 2),
                new Ingrediente("Aceite de oliva", 10)),
                List.of(
                        new Utensilio("Cuchillo", 2),
                        new Utensilio("Bol", 10)),
                10,
                "Lavar y cortar la lechuga y el tomate. Mezclar con aceite de oliva en el bol.");
    }
}
