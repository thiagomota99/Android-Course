package br.com.alura.aula6.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.com.alura.aula6.R;
import br.com.alura.aula6.dao.AlunoDAO;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        setTitle("Lista de Alunos");
        AlunoDAO alunoDAO = new AlunoDAO();
        ListView listView = findViewById(R.id.activity_lista_de_alunos_listview);
        listView.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,alunoDAO.todos()));

    }
}
