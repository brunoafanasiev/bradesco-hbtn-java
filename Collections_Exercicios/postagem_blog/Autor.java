public class Autor implements Comparable<Autor> {
    private String nome;
    private String sobrenome;

    public Autor(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return nome + " " + sobrenome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Autor)) return false;
        Autor outro = (Autor) obj;
        return nome.equalsIgnoreCase(outro.nome) && sobrenome.equalsIgnoreCase(outro.sobrenome);
    }

    @Override
    public int hashCode() {
        return (nome + sobrenome).toLowerCase().hashCode();
    }

    @Override
    public int compareTo(Autor outro) {
        return this.toString().compareToIgnoreCase(outro.toString());
    }
}
