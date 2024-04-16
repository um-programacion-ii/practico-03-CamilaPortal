package entity;

import interfaces.Despensable;
import interfaces.Reutilizable;

public class Utensilio implements Despensable, Reutilizable {
    private String nombre;
    private int vidaUtil;

    public Utensilio(String nombre, int vidaUtil){
        this.nombre = nombre;
        this.vidaUtil = vidaUtil;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public void usar(int uso) {
        if (vidaUtil >= uso) {
            vidaUtil-= uso;
            System.out.println("El utensilio " + nombre + " ha sido utilizado.");
        } else {
            System.out.println("El utensilio " + nombre + " no puede ser utilizado.");
        }
    }

    public String toString(){
        return nombre + " (vida util: " + vidaUtil + ")";
    }
}
