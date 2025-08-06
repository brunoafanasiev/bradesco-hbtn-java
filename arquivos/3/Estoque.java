import java.io.*;
import java.util.*;

public class Estoque {
    private List<Produto> produtos = new ArrayList<>();
    private final String arquivo = "estoque.csv";

    public Estoque(String valor) {
        carregarEstoque(valor);
    }

    public void carregarEstoque(String valor) {
        produtos.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(valor))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                String[] partes = linha.split(",");
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                int quantidade = Integer.parseInt(partes[2]);
                double preco = Double.parseDouble(partes[3]);
                produtos.add(new Produto(id, nome, quantidade, preco));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar");
        }
    }

    public void salvarEstoque() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (Produto p : produtos) {
                writer.write(p.toCsv());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar");
        }
    }

    public boolean idExiste(int id) {
        return produtos.stream().anyMatch(p -> p.getId() == id);
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        int novoId = produtos.size()+1;
        System.out.println("novoid = " + novoId);
        produtos.add(new Produto(novoId, nome, quantidade, preco));
        salvarEstoque();
    }

    public boolean excluirProduto(int id) {
        boolean removido = produtos.removeIf(p -> p.getId() == id);
        if (removido) salvarEstoque();
        return removido;
    }

    public boolean atualizarQuantidade(int id, int novaQuantidade) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                salvarEstoque();
                return true;
            }
        }
        return false;
    }

    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }
}
