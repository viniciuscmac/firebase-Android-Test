package com.example.viniciuscarvalhomachado.projetofirebase.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.viniciuscarvalhomachado.projetofirebase.DAO.ListaLocaisDAO;
import com.example.viniciuscarvalhomachado.projetofirebase.Entidades.Local;
import com.example.viniciuscarvalhomachado.projetofirebase.R;

public class PrincipalActivity extends AppCompatActivity {

    ListaLocaisDAO listaLocaisDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.listaLocaisDAO = new ListaLocaisDAO();
        this.pushData();
        setContentView(R.layout.activity_principal);
    }

    private void pushData(){
        Local local = new Local(
                "Teste",
                -15.817856324778173,
                -48.98803851562644
        );

        this.listaLocaisDAO.writeLocal(local);
    }
}
