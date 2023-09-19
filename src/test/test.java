package test;

import logic.HaversineFormula;

import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        HaversineFormula formula = new HaversineFormula();
        Double distancia = formula.calculateDistance(16.284433,-97.822641
                ,16.343718,-98.051421);
    System.out.println(distancia);
    }
}
