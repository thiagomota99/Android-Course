package br.com.alura.aula6.ui.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import br.com.alura.aula6.R;
import br.com.alura.aula6.dao.AlunoDAO;
import br.com.alura.aula6.minhasClasses.MyAdpter;
import br.com.alura.aula6.model.Aluno;

import static br.com.alura.aula6.ui.activity.ConstantesActivities.CHAVE_ALUNO;

public class ListaAlunosActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener/*, AdapterView.OnItemLongClickListener*/ {

    public static final String TITULO_APPBAR = "Lista de Alunos";
    private AlunoDAO alunoDAO = new AlunoDAO();
    private ListView listView;
    private MyAdpter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        //Alterando nome da App bar
        setTitle(TITULO_APPBAR);
        configuraFabNovoAluno();

        alunoDAO.salvar(new Aluno("Thiago", "62985660543", "thiagomota99@outlook.com"));
        alunoDAO.salvar(new Aluno("Maria", "62985747694", "maria73@outlook.com"));
        //Carrega o ListView
        configuraLista();
    }


    //Método de onCreate do menu de contexto
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //Atribuindo um menu estático para a activity ListaAlunosActivity
        getMenuInflater().inflate(R.menu.activity_lista_alunos_menu, menu); //O primeiro parâmetro é o arquivo estático, o segundo é o tipo de menu, no caso "menu de contexto"
    }


    //Método de onCreate do menu de opções
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Atribuindo um menu estático para a activity ListaAlunosActivity
        getMenuInflater().inflate(R.menu.activity_lista_alunos_option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Listener do botão do menu de opções: "Apagar tudo"
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Pega o id da opção clicada
        int itemId = item.getItemId();

        //Verifica se a opção clicada é a que se espera, no caso "Apagar Tudo"
        if(itemId == R.id.activity_lista_alunos_optionMenu_deletar_todos){
            //Remove todos os alunos no dao.
            alunoDAO.removerTodos();
            //Remove todos os item da lista
            adapter.clear();
        }

        return super.onOptionsItemSelected(item);
    }

    //Listener do botão do menu de contexto: "Remover"
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        //Pegando o Id do item do menu de contexto
        int itemId = item.getItemId();

        //Verificando se o título é "Remover"
        if(itemId == R.id.activity_lista_alunos_menu_remover){
            AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            Aluno alunoEscolhido = adapter.getItem(menuInfo.position);
            alunoDAO.remove(alunoEscolhido);
            adapter.remove(alunoEscolhido);
        }
        return super.onContextItemSelected(item);
    }

    private void configuraFabNovoAluno() {
        //Pegando referência da View FloatingActionButton
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_alunos_novo_aluno_fab);

        //Implementando a interface OnClickListener da classe View
        botaoNovoAluno.setOnClickListener(this);
    }

    private void abriFormularioAlunoActivity() {
        Intent intent = new Intent(this,NovoAlunoActivity.class);

        startActivity(intent);
    }

    @Override //Método onResume: Será o método que carregará a lista todaVez que a Activity estiver ativa.
    protected void onResume() {
        super.onResume();

        //Limpa todos os dados do adapter
        adapter.clear();

        //Adiciona novamente os dados novamente da referência especificada. No caso, alunoDAO.todos()
        adapter.addAll(alunoDAO.todos());

    }

    private void configuraLista() {
        //Pegando a referência da View ListView
        listView = findViewById(R.id.activity_lista_de_alunos_listview);

        //setando o adpater da view para exibição dos dados na lista.
        adapter = new MyAdpter(this);
        listView.setAdapter(adapter);

        //Implementando a interface OnItemClickListener da classe AdapterView
        listView.setOnItemClickListener(this);

        //Implementando a infertace setOnItemLongClickListener da classe AdapterView
        //listView.setOnItemLongClickListener(this);

        //Colocando o menu de contexto para os filhos do listview (item da lista)
        registerForContextMenu(listView);
    }


    //onClick do botão flutuante Adicionar Novo Aluno
    @Override
    public void onClick(View v) {
        abriFormularioAlunoActivity();
    }

    //Click do item da ListView onItemClick(listView)
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
        Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(posicao);
        Intent vaiParaActivityNovoAluno = new Intent(this,NovoAlunoActivity.class);

        //Envio de dados para outra activity
        vaiParaActivityNovoAluno.putExtra(CHAVE_ALUNO,alunoEscolhido);

        //Chamando activity de destino
        startActivity(vaiParaActivityNovoAluno);
    }

}
