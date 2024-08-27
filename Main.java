public class Main {
    public static void main(String[] args) {
        ContaBancaria cc = new ContaCorrente(1000);
        ContaBancaria cp = new ContaPoupanca(1000);
        ContaBancaria ci = new ContaInvestimento(1000, 2);

        cc.sacar(200); // Funciona corretamente
        cp.sacar(200); // Funciona com uma verificação a mais
        ci.sacar(200); // Mensagem de erro por bloqueio
        ((ContaInvestimento) ci).reduzirPeriodoBloqueio(); // Diminui o período de bloqueio
        ci.sacar(200); //Apos a alteração, será possivel o saque
    }
}