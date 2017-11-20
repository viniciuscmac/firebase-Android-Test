package com.example.viniciuscarvalhomachado.projetofirebase.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.viniciuscarvalhomachado.projetofirebase.DAO.ListaLocaisDAO;
import com.example.viniciuscarvalhomachado.projetofirebase.Controller.LocalListController;
import com.example.viniciuscarvalhomachado.projetofirebase.Entidades.Local;
import com.example.viniciuscarvalhomachado.projetofirebase.R;

public class PrincipalActivity extends AppCompatActivity {

    private ListaLocaisDAO listaLocaisDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Local local = new Local("Teste1", 0.1234, -2.9876);

        this.listaLocaisDAO = new ListaLocaisDAO(new LocalListController());
        this.listaLocaisDAO.startAssyncronousData();
        //this.listaLocaisDAO.writeLocal(local);

        setContentView(R.layout.activity_principal);
    }

}
