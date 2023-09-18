package entities;

import logic.HaversineFormula;

public class Register {
    private City city, origin, destination;
    private double cost, heuristic,total;
    private HaversineFormula formula;

    public Register(City city,City origin,City destination) {
        this.city = city;
        this.origin = origin;
        this.destination = destination;
        formula = new HaversineFormula();
        this.cost = formula.calculateDistance(origin.getLatitude(),origin.getLongitude(),city.getLatitude(),city.getLongitude());
        this.heuristic = formula.calculateDistance(city.getLatitude(),city.getLongitude(),destination.getLatitude(),destination.getLongitude());
        this.total = cost+ heuristic;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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
