import produtos.Produto;
public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            double precoLiquido = item.getProduto().obterPrecoLiquido();
            total += precoLiquido * item.getQuantidade();
        }
        double desconto = total * (percentualDesconto / 100.0);
        return total - desconto;
    }

    public void apresentarResumoPedido() {

        System.out.println("------- RESUMO PEDIDO -------");
        double totalProdutos = 0.0;

        for (ItemPedido item : itens) {
            Produto produto = item.getProduto();
            String tipo = produto instanceof produtos.Livro ? "Livro" :
                    produto instanceof produtos.Dvd ? "Dvd" : "Produto";

            String titulo = produto.getTitulo();
            double precoUnitario = produto.obterPrecoLiquido();
            int quantidade = item.getQuantidade();
            double totalItem = precoUnitario * quantidade;

            totalProdutos += totalItem;

            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2fn  Quant: %d  Total: %.2f%n",
                    tipo, titulo, precoUnitario, quantidade, totalItem);
        }
        System.out.println("----------------------------");

        double valorDesconto = totalProdutos * (percentualDesconto / 100.0);
        double totalPedido = totalProdutos - valorDesconto;

        System.out.printf("DESCONTO: %.2f%n", valorDesconto);
        System.out.printf("TOTAL PRODUTOS: %.2f%n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f%n", totalPedido);
        System.out.println("----------------------------");
    }
}
