package br.com.alura.aula6.ui.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

import br.com.alura.aula6.R;
import br.com.alura.aula6.dao.AlunoDAO;
import br.com.alura.aula6.model.Aluno;

import static br.com.alura.aula6.ui.activity.ConstantesActivities.CHAVE_ALUNO;

public class NovoAlunoActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

    private static final String TITULO_APPBAR = "Novo Aluno";
    private static final String TITULO_APPBAR_EDITA_ALUNO = "Editar Aluno";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    private boolean edita = true;
    final AlunoDAO alunoDAO = new AlunoDAO();
    private Aluno aluno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_aluno);

        inicializacaoDosCampos();
        //configuraBotaoSalvar();

        Intent dados = getIntent();
        if(dados.hasExtra(CHAVE_ALUNO)){
            setTitle(TITULO_APPBAR_EDITA_ALUNO);
            aluno = (Aluno) dados.getSerializableExtra(CHAVE_ALUNO);
            campoNome.setText(aluno.getNome());
            campoTelefone.setText(aluno.getTelefone());
            campoEmail.setText(aluno.getEmail());
        }
        else {
            setTitle(TITULO_APPBAR);
            aluno = new Aluno();
            edita = false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_formulario_novo_aluno,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.activity_formulario_novo_aluno_salvar){
            preenchaAluno();
            definirAcao(edita);
        }

        return super.onOptionsItemSelected(item);
    }

    //Configuração do botão Salvar
    /*private void configuraBotaoSalvar() {
        Button btnSalvar = findViewById(R.id.activity_novo_aluno_botao_salvar);
        btnSalvar.setOnClickListener(this);
    }*/

    //Inicializar atributos
    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.activity_novo_aluno_campo_nome);
        campoTelefone = findViewById(R.id.activity_novo_aluno_campo_telefone);
        campoEmail = findViewById(R.id.activity_novo_aluno_campo_email);
    }


    //Criando/editando aluno
    private void preenchaAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        aluno.setNome(nome);
        aluno.setTelefone(telefone);
        aluno.setEmail(email);
    }

    //onClick do botão "SALVAR"
    /*@Override
    public void onClick(View v) {
        preenchaAluno();
        definirAcao(edita);
    }*/

    private void definirAcao(boolean acao){
        if(acao){
            alunoDAO.edita(aluno);
        }
        else {
            alunoDAO.salvar(aluno);
        }
        finish();
    }
}
