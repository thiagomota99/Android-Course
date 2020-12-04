package br.com.alura.aula6.ui.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.com.alura.aula6.R;
import br.com.alura.aula6.dao.AlunoDAO;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Lista de Alunos";
    private AlunoDAO alunoDAO = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        //Alterando nome da App bar
        setTitle(TITULO_APPBAR);
        configuraFabNovoAluno();


    }

    private void configuraFabNovoAluno() {
        //Pegando referência da View FloatingActionButton
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_novo_aluno_fab);

        //Setando o método de onclick do listener
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chamando nova activity
                abriFormularioAlunoActivity();
            }
        });
    }

    private void abriFormularioAlunoActivity() {
        startActivity(new Intent(this,NovoAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Criando instância do dao.
        configuraLista();
    }

    private void configuraLista() {
        //Pegando a referência da View ListView
        ListView listView = findViewById(R.id.activity_lista_de_alunos_listview);

        //setando o adpater da view para exibição dos dados na lista.
        listView.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,alunoDAO.todos()));
    }
}
