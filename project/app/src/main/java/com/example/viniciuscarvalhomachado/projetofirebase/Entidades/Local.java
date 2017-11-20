package com.example.viniciuscarvalhomachado.projetofirebase.Entidades;

import com.google.firebase.database.IgnoreExtraProperties;

import io.reactivex.annotations.NonNull;

/**
 * Created by pedro on 13/11/17.
 */

@IgnoreExtraProperties
public class Local {

    private double latitude;
    private double longitude;
    private String identificador;

    public Local(@NonNull String identificador,
                 @NonNull double latitude,
                 @NonNull double longitude) {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Local local = (Local) o;

        if (Double.compare(local.latitude, latitude) != 0) return false;
        if (Double.compare(local.longitude, longitude) != 0) return false;
        return identificador.equals(local.identificador);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(latitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + identificador.hashCode();
        return result;
    }
}
