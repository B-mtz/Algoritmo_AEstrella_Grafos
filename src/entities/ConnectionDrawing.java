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

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    public City getDestine() {
        return destine;
    }

    public void setDestine(City destine) {
        this.destine = destine;
    }
}
