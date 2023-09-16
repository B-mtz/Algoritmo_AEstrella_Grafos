package logic;

public class HaversineFormula {
    private double lat1, lon1, lat2, lon2, radio;
    public double calculateDistance(double latitude, double longitude, double latitude2, double longitude2){
        this.lat1 = Math.toRadians(latitude);
        this.lon1 = Math.toRadians(longitude);
        this.lat2= Math.toRadians(latitude2);
        this.lon2 = Math.toRadians(longitude2);;
        this.radio = 6378;
        return calculate(radio);
    }
    //Formula : d = 2 * R * arcsin(√(hav(φ2 - φ1) + cos(φ1) * cos(φ2) * hav(λ2 - λ1)))
    public double calculate(double radio) {
        // Calculamos los cambios de latitud y longitud
        double deltaLat = lat2 - lat1;
        double deltaLon = lon2 - lon1;

        // Calculamos la distancia entre los dos puntos
        double sinSquaredDeltaLat = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2);
        double cosLat1CosLat2 = Math.cos(lat1) * Math.cos(lat2);
        double sinSquaredDeltaLon = Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);

        double distance = 2 * Math.asin(Math.sqrt(sinSquaredDeltaLat + cosLat1CosLat2 * sinSquaredDeltaLon))*radio;

        // Devolvemos la distancia en kilómetros
        return distance;
    }
}
