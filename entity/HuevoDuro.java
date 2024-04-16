package entity;

import java.util.List;

public class HuevoDuro extends Receta{
    public HuevoDuro() {
        super(List.of(new Ingrediente("Huevo", 1),
                        new Ingrediente("Agua", 200)),
                List.of(new Utensilio("Olla", 2)),
                10,
                "Poner un huevo en agua hirviendo durante 10 minutos.");
    }
}
