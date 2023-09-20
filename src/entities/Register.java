package entities;

import logic.HaversineFormula;

public class Register {
    private City city, origin;
    private double cost, heuristic,total;

    public Register(City city,City origin) {
        this.city = city;
        this.origin = origin;
        this.cost = 0;
        this.heuristic = 0;
        this.total = 0;
    }

    public City getCity() {
        return city;
    }

    public City getOrigin() {
        return origin;
    }

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(double heuristic) {
        this.heuristic = heuristic;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
