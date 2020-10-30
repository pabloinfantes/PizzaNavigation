package com.example.pizzafragment.Repository;

import com.example.pizzafragment.model.Pizza;

import java.util.ArrayList;

public class PizzaRepository {
  private static ArrayList<Pizza> list;

    private PizzaRepository() {

    }

    //Estructura que inicializa los campos static o de clase
  //ya que no se puede inicializar en un objeto.
  //static es comun a todos los objetos de la clase
  static {
       list = new ArrayList<>();
       list.add(new Pizza("Vegetariana","Cebolla ,pimiento",12.5f));
       list.add(new Pizza("4 estaciones","Cebolla ,pimiento",10.5f));
       list.add(new Pizza("Americana","Cebolla ,pimiento",13.5F));

  }

    /**
     * metodo que devuelve una lista de Pizza
     * @return
     */
    public static ArrayList<Pizza> getList() {
        return list;
    }

    /**
     * metodo que dado una posicion te devuelve la pizza
     * @param position
     * @return
     */
    public  static Pizza getPizza(int position){
        return list.get(position);
    }
}
