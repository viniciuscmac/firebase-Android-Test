package com.example.viniciuscarvalhomachado.projetofirebase.Controller;

import android.util.Log;

import com.example.viniciuscarvalhomachado.projetofirebase.Entidades.AssyncronousListController;
import com.example.viniciuscarvalhomachado.projetofirebase.Entidades.Local;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by pedro on 16/11/17.
 */

public class FirebaseDataObserver implements Observer<Object> {

    private String tag = "RXANDROID";
    private List<Local> localList;
    private AssyncronousListController assyncronousListController;

    public FirebaseDataObserver(AssyncronousListController assyncronousListController){
        this.assyncronousListController = assyncronousListController;
        this.localList = new ArrayList<>();
    }

    @Override
    public void onSubscribe(Disposable d) {
        Log.d(this.tag, "onSubscribe");
    }

    @Override
    public void onNext(Object object) {
        Map<String,Object> localMap = (HashMap<String,Object>) object;

        String identificador = (String) localMap.get("identificador");
        double latitude = (double) localMap.get("latitude");
        double longitude = (double) localMap.get("longitude");

        Local local = new Local(identificador, latitude, longitude);
        this.localList.add(local);
    }

    @Override
    public void onError(Throwable e) {
        Log.d(this.tag, "onError");
    }

    @Override
    public void onComplete() {
        Log.d(this.tag, "onComplete");
        this.assyncronousListController.setList(this.localList);
    }
}
