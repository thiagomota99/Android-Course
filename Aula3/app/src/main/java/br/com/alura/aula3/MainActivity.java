package br.com.alura.aula3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*Criando uma view do TextView
        TextView aluno = new TextView(this);

        Atribuindo um texto ao objeto da view TextView
        aluno.setText("Thiago Mota");

        Settando uma view na actvity
        Utilizando a classe R para localizar todos os recursos utilizado no projeto
        setContentView(R.layout.activity_main);*/

        setContentView(R.layout.activity_main);

        List<String> listaAlunos = new ArrayList<>(Arrays.asList("Maria","Thiago","Francivaldo"));
        ListView listaViewAlunos = findViewById(R.id.activity_main_lista_de_alunos);

        /*Como a ListView não possui um método add para adicionarmos e exibir a lista que criamos
          utilizamos o setAdapter. Ele é um intermediário utilizado para pegar os dados da lista
          e redenriza-los em uma view desejada, no caso a ListView. Para isso, ele espera como parâmetro a
          implementação de uma interface do tipo ListAdapter.
          Usaremos o ArrayAdapter que é um dos adapters mais comuns para a exibição
          de uma simples lista. A sobrecarga utulizada espera 3 argumentos, sendo o primeiro
          o contexto que será nossa activity, um resource de layout que possua apenas uma view do tipo TextView
          e por fim, nossa lista de elementos que desejamos exibir na ListView.
        */
        listaViewAlunos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaAlunos));

    }
}
