package com.example.viniciuscarvalhomachado.projetofirebase.DAO;

import com.example.viniciuscarvalhomachado.projetofirebase.Entidades.Local;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by pedro on 13/11/17.
 */

public class ListaLocaisDAO {

    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    public ListaLocaisDAO(){
        this.databaseReference = ConfiguracaoFirebase.getFirebase();
        this.firebaseAuth = ConfiguracaoFirebase.getFirebaseAutenticacao();
    }

    public void writeLocal(Local local){
        FirebaseUser user = this.firebaseAuth.getCurrentUser();
        this.databaseReference.child("lista").child(user.getUid()).push().setValue(local);
    }

}
