import java.util.LinkedList;
import java.util.Random;

public class Fila {
    private final LinkedList<Integer> fila = new LinkedList<>();
    private final int capacidade;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
    }

    public synchronized void adicionar(int item) throws InterruptedException {
        while (fila.size() == capacidade) {
            wait(); // Espera espaço na fila
        }
        fila.add(item);
        System.out.println("Produtor adicionou: " + item);
        notifyAll(); // Notifica consumidores
    }

    public synchronized int retirar() throws InterruptedException {
        while (fila.isEmpty()) {
            wait(); // Espera item na fila
        }
        int item = fila.removeFirst();
        System.out.println("Consumidor retirou: " + item);
        notifyAll(); // Notifica produtores
        return item;
    }
}