package br.com.alura.aula6.minhasClasses;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.alura.aula6.R;
import br.com.alura.aula6.model.Aluno;

public class MyAdpter extends BaseAdapter {

    private final List<Aluno> listaDeAlunos;
    private final Activity activity;

    public MyAdpter(List<Aluno> listaDeAlunos,Activity activity){
        this.listaDeAlunos = listaDeAlunos;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listaDeAlunos.size();
    }

    @Override
    public Aluno getItem(int position) {
        return listaDeAlunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Criando uma view a partir da referência da activity recebida por parâmetro.
        View viewCriada = activity.getLayoutInflater().inflate(R.layout.item_aluno, parent, false);

        Aluno exibirAluno = listaDeAlunos.get(position);

        TextView nome =  viewCriada.findViewById(R.id.item_aluno_nome);
        TextView telefone = viewCriada.findViewById(R.id.item_aluno_telefone);


        nome.setText(exibirAluno.getNome());
        telefone.setText(exibirAluno.getTelefone());

        return viewCriada;
    }

    public void clear() {
        listaDeAlunos.clear();
    }


    public void addAll(List<Aluno> todosAlunos) {
        this.listaDeAlunos.addAll(todosAlunos);
    }

    public void remove(Aluno aluno) {
        listaDeAlunos.remove(aluno);
    }
}
