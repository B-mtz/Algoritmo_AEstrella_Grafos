package entities;

public class CityDrawing {
    private City city;
    private int index;

    public CityDrawing(City city,int index){
        this.city = city;
        this.index = index;
    }

    public City getCity() {
        return city;
    }

    public int getIndex() {
        return index;
    }
}
