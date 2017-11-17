package com.example.viniciuscarvalhomachado.projetofirebase.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.viniciuscarvalhomachado.projetofirebase.DAO.ListaLocaisDAO;
import com.example.viniciuscarvalhomachado.projetofirebase.R;

public class PrincipalActivity extends AppCompatActivity {

    private ListaLocaisDAO listaLocaisDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.listaLocaisDAO = new ListaLocaisDAO();
        this.listaLocaisDAO.readAssyncronousData();

        setContentView(R.layout.activity_principal);
    }

}
