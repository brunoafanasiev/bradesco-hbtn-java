import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {
    private String numeracao;
    private double saldo;
    private double taxaJurosAnual;

    public ContaBancariaBasica(String numeracao, double taxaJurosAnual) {
        this.numeracao = numeracao;
        this.taxaJurosAnual = taxaJurosAnual;
        this.saldo = 0.0;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void depositar(double valor)
            throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
        }
        saldo += valor;
    }

    public void sacar(double valor)
            throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
        }
        if (this.saldo < valor) {
            throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");
        }
        saldo -= valor;
    }

    public double calcularTarifaMensal() {
        double porcentagemSaldo = saldo * 0.10;
        if (porcentagemSaldo >= 10.0) {
            return 10.0;
        }
        return porcentagemSaldo;
    }

    public double calcularJurosMensal() {
        return saldo * (taxaJurosAnual / 12.0 / 100.0);
    }

    public void aplicarAtualizacaoMensal() {
        saldo = saldo - calcularTarifaMensal() + calcularJurosMensal();
    }

}