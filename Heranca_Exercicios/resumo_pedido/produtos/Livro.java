package produtos;

public class Livro extends Produto {
    private int paginas;
    private String autor;
    private int edicao;

    public Livro(String titulo, int ano, String pais, double precoBruto, int paginas, String autor, int edicao) {
        super(titulo, ano, pais, precoBruto);
        this.paginas = paginas;
        this.autor = autor;
        this.edicao = edicao;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public double obterPrecoLiquido() {
        return precoBruto * 1.15;
    }
}
