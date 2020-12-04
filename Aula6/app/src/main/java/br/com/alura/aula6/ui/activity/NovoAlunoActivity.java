package br.com.alura.aula6.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.alura.aula6.R;

public class NovoAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_aluno);

        Button btnSalvar = findViewById(R.id.activity_novo_aluno_botao_salvar);
        
    }
}
