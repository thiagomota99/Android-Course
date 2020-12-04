package br.com.alura.aula6.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.alura.aula6.R;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        setTitle("Lista de Alunos");
    }
}
