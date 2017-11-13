package com.example.viniciuscarvalhomachado.projetofirebase.Entidades;

/**
 * Created by pedro on 13/11/17.
 */

public class Local {

    private double latitude;
    private double longitude;
    private String identificador;

    public Local(String identificador, double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.identificador = identificador;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getIdentificador() {
        return identificador;
    }
}
