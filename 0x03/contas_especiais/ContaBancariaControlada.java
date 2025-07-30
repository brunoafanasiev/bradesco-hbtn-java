public class ContaBancariaControlada extends ContaBancariaBasica {
    private double saldoMinimo;
    private double valorPenalidade;

    public ContaBancariaControlada(String numeracao, double taxaJurosAnual,
                                   double saldoMinimo, double valorPenalidade) {
        super(numeracao, taxaJurosAnual);
        this.saldoMinimo = saldoMinimo;
        this.valorPenalidade = valorPenalidade;
    }

    @Override
    public void aplicarAtualizacaoMensal() {
        double saldo = getSaldo() - calcularTarifaMensal() + calcularJurosMensal();

        if (saldo < saldoMinimo) {
            saldo -= valorPenalidade;
        }

        try {
            double reajuste = saldo - getSaldo();
            if (reajuste > 0) {
                depositar(reajuste);
            } else {
                sacar(-reajuste);
            }
        } catch (Exception e) {
            System.out.println("Erro na atualização mensal");
        }
    }
}