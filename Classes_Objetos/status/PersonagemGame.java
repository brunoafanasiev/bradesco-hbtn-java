public class PersonagemGame {
    private int saudeAtual;
    private String nome;

    private String status;

    public int getSaudeAtual(){
        return saudeAtual;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void tomarDano(int quantidadeDeDano) {
        setSaudeAtual(this.saudeAtual - quantidadeDeDano);
    }

    public void receberCura(int quantidadeDeCura) {
        setSaudeAtual(this.saudeAtual + quantidadeDeCura);
    }

    public void setSaudeAtual(int valor) {
        if (valor < 0) {
            valor = 0;
        } else if (valor > 100) {
            valor = 100;
        }

        this.saudeAtual = valor;

        if (valor > 0) {
            this.status = "vivo";
        } else {
            this.status = "morto";
        }
    }
}