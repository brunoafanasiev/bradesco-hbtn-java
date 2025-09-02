import java.util.ArrayList;
import java.util.List;

public class GestaoAlunos {
    private List<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(String nome, int idade) {
        alunos.add(new Aluno(nome, idade));
    }

    public void excluirAluno(String nome){
        boolean removido = alunos.removeIf(aluno -> aluno.getNome().equalsIgnoreCase(nome));
        if (removido) {
            System.out.println("Aluno removido: " + nome);
        } else {
            System.out.println("Aluno não encontrado: " + nome);
        }
    }

    public void buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Aluno encontrado: " + aluno.getNome());
                return;
            }
        }
    }

    public void listarAlunos() {
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}