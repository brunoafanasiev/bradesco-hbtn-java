public class Pessoa {
    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;

    public Pessoa(int codigo, String nome, String cargo, int idade, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        String formatado = String.format("%.2f", salario).replace('.', ',');
        return String.format("[%s] %s %s %d R$ %s", codigo, nome, cargo, idade, formatado);
    }
}