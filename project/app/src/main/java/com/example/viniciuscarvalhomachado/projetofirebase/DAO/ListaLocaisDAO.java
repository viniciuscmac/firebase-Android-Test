package com.example.viniciuscarvalhomachado.projetofirebase.DAO;

import com.example.viniciuscarvalhomachado.projetofirebase.Controller.ConfiguracaoFirebase;
import com.example.viniciuscarvalhomachado.projetofirebase.Controller.FirebaseEventListener;
import com.example.viniciuscarvalhomachado.projetofirebase.Entidades.AssyncronousListController;
import com.example.viniciuscarvalhomachado.projetofirebase.Entidades.Local;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by pedro on 13/11/17.
 */

public class ListaLocaisDAO {

    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    private FirebaseEventListener listener;

    public ListaLocaisDAO(AssyncronousListController assyncronousListController){

        this.firebaseAuth = ConfiguracaoFirebase.getFirebaseAutenticacao();
        this.databaseReference = ConfiguracaoFirebase.getFirebase()
                .child("lista")
                .child(this.firebaseAuth.getUid());

        this.databaseReference.keepSynced(true);
        this.listener = new FirebaseEventListener(assyncronousListController);
    }

    public void writeLocal(Local local){
        this.databaseReference.push().setValue(local);
    }

    public void removeLocalById(String identificador) {
        DatabaseReference queryRef = this.databaseReference
                .orderByChild("identificador")
                .equalTo(identificador)
                .getRef();

        //queryRef.removeValue();
    }

    public void startAssyncronousData(){
        this.databaseReference.addValueEventListener(this.listener);
    }

    public void stopAssyncronousData(){
        this.databaseReference.removeEventListener(this.listener);
    }
}
