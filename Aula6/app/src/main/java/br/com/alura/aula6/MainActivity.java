package br.com.alura.aula6;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Settando um layout estático para a Activity.
        setContentView(R.layout.activity_main);

        setTitle("Aula 6");

        //Criando uma lista de alunos
        List<String> listaAlunos = new ArrayList<>(Arrays.asList("Maria","Thiago","Francivaldo"));

        //Pegando a referência da view criada: ListView]
        ListView listaAlunosView = findViewById(R.id.activity_main_lista_de_alunos);

        //setando ArrayAdapter
        listaAlunosView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listaAlunos));

    }
}
