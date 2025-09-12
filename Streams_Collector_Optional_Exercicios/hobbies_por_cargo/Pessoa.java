import java.util.List;

public class Pessoa implements Comparable<Pessoa> {
    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;
    private List<String> hobbies;

    public Pessoa(int codigo, String nome, String cargo, int idade, double salario, List<String> hobbies) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
        this.hobbies = hobbies;
    }

    public String getCargo() {
        return cargo;
    }

    public int getIdade() {
        return idade;
    }

    public double getSalario() {
        return salario;
    }

    public List<String> getHobbies() { return hobbies; }

    @Override
    public String toString() {
        String formatado = String.format("%f", salario).replace('.',',');
        return String.format("[%s] %s %s %d R$ %s", codigo, nome, cargo, idade, formatado);
    }

    @Override
    public int compareTo(Pessoa outra) {
        return this.nome.compareToIgnoreCase(outra.nome);
    }
}