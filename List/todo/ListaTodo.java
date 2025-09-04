import java.util.ArrayList;
import java.util.List;

public class ListaTodo {
    private List<Tarefa> tarefas;

    public ListaTodo() {
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa novaTarefa) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getIdentificador() == novaTarefa.getIdentificador()) {
                throw new IllegalArgumentException("Tarefa com identificador " + novaTarefa.getIdentificador() + " ja existente na lista");
            }
        }
        tarefas.add(novaTarefa);
    }

    public boolean marcarTarefaFeita(int identificador) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getIdentificador() == identificador) {
                tarefa.marcarFeita();
                return true;
            }
        }
        return false;
    }

    public boolean desfazerTarefa(int identificador) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getIdentificador() == identificador) {
                tarefa.desfazer();
                return true;
            }
        }
        return false;
    }

    public void fazerTodas() {
        for (Tarefa tarefa : tarefas) {
            tarefa.marcarFeita();
        }
    }

    public void desfazerTodas() {
        for (Tarefa tarefa : tarefas) {
            tarefa.desfazer();
        }
    }

    public void listarTarefas() {
        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa);
        }
    }
}
