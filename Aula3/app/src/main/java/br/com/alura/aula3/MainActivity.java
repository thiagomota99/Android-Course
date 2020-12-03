package br.com.alura.aula3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Criando uma view do TextView
        //TextView aluno = new TextView(this);

        //Atribuindo um texto ao objeto da view TextView
        //aluno.setText("Thiago Mota");

        //Settando uma view na actvity
        //Utilizando a classe R para localizar todos os recursos utilizado no projeto
        setContentView(R.layout.activity_main);
    }
}
