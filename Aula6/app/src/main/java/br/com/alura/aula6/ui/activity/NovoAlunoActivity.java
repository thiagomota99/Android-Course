package br.com.alura.aula6.ui.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
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

    public static final String TITULO_APPBAR = "Novo Aluno";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    final AlunoDAO alunoDAO = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_aluno);
        setTitle(TITULO_APPBAR);
        inicializacaoDosCampos();
        configuraBotaoSalvar();
    }


    //Configuração do botão Salvar
    private void configuraBotaoSalvar() {
        Button btnSalvar = findViewById(R.id.activity_novo_aluno_botao_salvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aluno alunoCriado = criaAluno();
                salva(alunoCriado);
            }
        });
    }

    //Inicializr atributos
    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.activity_novo_aluno_campo_nome);
        campoTelefone = findViewById(R.id.activity_novo_aluno_campo_telefone);
        campoEmail = findViewById(R.id.activity_novo_aluno_campo_email);
    }

    //Salvar aluno
    private void salva(Aluno aluno) {
        alunoDAO.salvar(aluno);

        //Destruir activity
        finish();
    }

    //Criando aluno
    @NonNull
    private Aluno criaAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        return new Aluno(nome,telefone,email);
    }
}
