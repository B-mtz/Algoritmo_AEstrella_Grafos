package entities;

public class ConnectionDrawing {
    City origin, destine;

    public ConnectionDrawing(City origin,City destine){
        this.origin = origin;
        this.destine = destine;
    }

    public City getOrigin() {
        return origin;
    }

    public City getDestine() {
        return destine;
    }
}
