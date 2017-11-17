package com.example.viniciuscarvalhomachado.projetofirebase.DAO;

import com.example.viniciuscarvalhomachado.projetofirebase.Controller.ConfiguracaoFirebase;
import com.example.viniciuscarvalhomachado.projetofirebase.Controller.FirebaseEventListener;
import com.example.viniciuscarvalhomachado.projetofirebase.Entidades.Local;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by pedro on 13/11/17.
 */

public class ListaLocaisDAO {

    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    public ListaLocaisDAO(){

        this.firebaseAuth = ConfiguracaoFirebase.getFirebaseAutenticacao();
        this.databaseReference = ConfiguracaoFirebase.getFirebase()
                .child("lista")
                .child(this.firebaseAuth.getUid());
    }

    public void writeLocal(Local local){
        this.databaseReference.push().setValue(local);
    }

    public void readAssyncronousData(){
        this.databaseReference.addValueEventListener(new FirebaseEventListener());
    }
}
