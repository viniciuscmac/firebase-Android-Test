package com.example.viniciuscarvalhomachado.projetofirebase.Controller;

import android.util.Log;

import com.example.viniciuscarvalhomachado.projetofirebase.Entidades.AssyncronousListController;
import com.example.viniciuscarvalhomachado.projetofirebase.Entidades.Local;

import java.util.List;

/**
 * Created by pedro on 20/11/17.
 */

public class LocalListController implements AssyncronousListController {

    private String tag = "RXCONTROLLER";
    private List<Local> lista;

    @Override
    public void setList(List<Local> lista) {
        this.lista = lista;

        for(Local l : this.lista){
            Log.d(this.tag, "Identificador: " + l.getIdentificador());
            Log.d(this.tag, "Latitude: " + l.getLatitude());
            Log.d(this.tag, "Longitude: " + l.getLongitude());
            Log.d(this.tag, "---");
        }
    }

    @Override
    public List<Local> getList() {
        return this.lista;
    }
}
