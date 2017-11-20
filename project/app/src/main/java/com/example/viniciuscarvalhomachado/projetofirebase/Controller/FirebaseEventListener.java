package com.example.viniciuscarvalhomachado.projetofirebase.Controller;

import android.util.Log;

import com.example.viniciuscarvalhomachado.projetofirebase.Entidades.AssyncronousListController;
import com.example.viniciuscarvalhomachado.projetofirebase.Entidades.Local;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by pedro on 16/11/17.
 */

public class FirebaseEventListener implements ValueEventListener {

    private String tag = "RXFIREBASE";
    private AssyncronousListController assyncronousListController;

    public FirebaseEventListener(AssyncronousListController assyncronousListController){
        this.assyncronousListController = assyncronousListController;
    }


    private void publish(DataSnapshot dataSnapshot){

        Map<String,Local> local = (HashMap<String,Local>) dataSnapshot.getValue();

        Observable.fromIterable(local.values())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new FirebaseDataObserver(this.assyncronousListController));
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
            Log.d(tag, "data changed:" + dataSnapshot.getValue());
            this.publish(dataSnapshot);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
            Log.d(tag, "error:" + databaseError.getMessage());
    }

}
