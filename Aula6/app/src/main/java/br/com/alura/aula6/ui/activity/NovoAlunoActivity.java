package br.com.alura.aula6.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.alura.aula6.R;
import br.com.alura.aula6.dao.AlunoDAO;
import br.com.alura.aula6.model.Aluno;

public class NovoAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_aluno);

        final AlunoDAO alunoDAO = new AlunoDAO();

        final EditText campoNome = findViewById(R.id.activity_novo_aluno_campo_nome);
        final EditText campoTelefone = findViewById(R.id.activity_novo_aluno_campo_telefone);
        final EditText campoEmail = findViewById(R.id.activity_novo_aluno_campo_email);

        Button btnSalvar = findViewById(R.id.activity_novo_aluno_botao_salvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = campoNome.getText().toString();
                String telefone = campoTelefone.getText().toString();
                String email = campoEmail.getText().toString();

                Aluno alunoCriado = new Aluno(nome,telefone,email);
                alunoDAO.salvar(alunoCriado);

                //Inializnado outra activity
                startActivity(new Intent(NovoAlunoActivity.this, ListaAlunosActivity.class));
            }
        });
    }
}
