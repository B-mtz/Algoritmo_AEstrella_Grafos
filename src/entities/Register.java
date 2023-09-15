package entities;

public class Register {
    private City city, origin;
    double cost, heuristic,total;

    public Register(City city, double cost, double heuristic, double total, City origin) {
        this.city = city;
        this.origin = origin;
        this.cost = cost;
        this.heuristic = heuristic;
        this.total = total;
    }

}
