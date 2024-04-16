package entity;

import java.util.List;

public class EnsaladaDeFrutas extends Receta{
    public EnsaladaDeFrutas() {
        super(List.of(
                new Ingrediente("Manzana", 2),
                new Ingrediente("Banana", 2),
                new Ingrediente("Naranja", 2),
                new Ingrediente("Frutilla", 10)),
                List.of(new Utensilio("Bol", 2),
                        new Utensilio("Cuchillo", 2)),
                10,
                "Pelar y cortar las frutas. Mezclar todas las frutas en un bol y servir.");
    }
}
