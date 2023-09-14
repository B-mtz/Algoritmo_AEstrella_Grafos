package entities;

public class Registers {
    private Cities city, origin;
    double cost, heuristic,total;

    public Registers(Cities city, double cost, double heuristic, double total, Cities origin) {
        this.city = city;
        this.origin = origin;
        this.cost = cost;
        this.heuristic = heuristic;
        this.total = total;
    }

}
