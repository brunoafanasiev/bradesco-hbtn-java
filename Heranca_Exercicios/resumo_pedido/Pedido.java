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

        double totalProdutos = 0.0;

        System.out.println("RESUMO PEDIDO");
        for (ItemPedido item : itens) {
            Produto produto = item.getProduto();
            String tipo = produto instanceof produtos.Livro ? "Livro" :
                    produto instanceof produtos.Dvd ? "DvD" : "Produtos";

            String titulo = produto.getTitulo();
            double precoUnitario = produto.obterPrecoLiquido();
            int quantidade = item.getQuantidade();
            double totalItem = precoUnitario * quantidade;

            totalProdutos += totalItem;

            System.out.printf("Tipo: %s  Titilo: %s  Preco: %.2f  Quant: %d  Total: %.2f%n",
                    tipo, titulo, precoUnitario, quantidade, totalItem);
        }
        double valorDesconto = totalProdutos * (percentualDesconto / 100.0);
        double totalPedido = totalProdutos - valorDesconto;

        System.out.printf("DECONTO: %.2f%n", valorDesconto);
        System.out.printf("TOTAL PRODUTOS: %.2f%n", totalProdutos);
        System.out.println("---------");
        System.out.printf("TOTAL PEDIDO: %.2f%n", totalPedido);
        System.out.println("---------");
    }
}
