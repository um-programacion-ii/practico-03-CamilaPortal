package entity;

import interfaces.Cocinable;
import interfaces.Despensable;

public class Ingrediente implements Cocinable, Despensable {
    private String nombre;
    private int cantidad;

    public Ingrediente (String nombre, int cantidad){
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public void sacar(int cantRetirada){

        if (cantidad >= cantRetirada){
            this.cantidad -= cantRetirada;
            System.out.println("Retiraste exitosamente " + nombre );
        }
        else {
            System.out.println("La cantidad de " + nombre+ " retirar es mayor que la cantidad actual");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String toString(){
        return "Ingrediente: " + nombre + " Cantidad: " + cantidad;
    }
}
