package br.com.alura.aula6.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.aula6.model.Aluno;

public class AlunoDAO {
    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadorDeIds = 1;

    public void salvar(Aluno aluno) {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        contadorDeIds++;
    }

    public void edita(Aluno aluno){
        Aluno alunoEncontrado = buscarAluno(aluno);

        if(alunoEncontrado != null){
            int posicaoDoAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(posicaoDoAluno,aluno);
        }
    }

    public Aluno buscarAluno(Aluno aluno){
        for (Aluno a: alunos) {
            if(a.getId() == aluno.getId()){
                return a;
            }
        }
        return null;
    }

    public List<Aluno> todos() {

        return new ArrayList<>(alunos);
    }

    public void remove(Aluno aluno) {
        Aluno removerAluno = buscarAluno(aluno);

        if(removerAluno != null){
            alunos.remove(removerAluno);
        }
    }

    public void removerTodos(){
        alunos.removeAll(alunos);
    }
}
