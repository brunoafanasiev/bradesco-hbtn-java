import java.util.function.Consumer;
import java.util.function.Supplier;

public class Produto {
    private String nome;
    private double preco;
    private double percentualMarkup = 10.0;

    public Produto(double preco, String nome) {
        this.preco = preco;
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public Supplier<Double> precoComMarkup= () -> preco + (preco * percentualMarkup / 100);

    public Consumer<Double> atualizarMarkup = novoMarkup -> {
        if (novoMarkup < 0) {
            throw new IllegalArgumentException("Markup não pode ser negativo");
        }
        this.percentualMarkup = novoMarkup;
    };
}
