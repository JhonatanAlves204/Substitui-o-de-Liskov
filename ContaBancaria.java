class ContaBancaria {
    protected double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void sacar(double valor) {
        //primeiro faz a validação de saldo referente ao valor solicitado de saque
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para saque de " + valor);
            } else {
                //dps de passar a verificação, ele faz a alteração do valor do saldo
                saldo -= valor;
                System.out.println("Saque de " + valor + " realizado. Saldo atual: " + saldo);
        }
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de " + valor + " realizado. Saldo atual: " + saldo);
    }

    public double getSaldo() {
        return saldo;
    }
}

class ContaCorrente extends ContaBancaria {
    public ContaCorrente(double saldoInicial) {
        super(saldoInicial);
    }

    // Funciona normalmente
}

class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Não é permitido sacar mais do que o saldo em uma conta poupança.");
        } else {
            //apos essa mudança, seu comportamento nao saira do padrao da class pai(sacar)
            super.sacar(valor);
        }
    }
}

class ContaInvestimento extends ContaBancaria {
    private int periodosBloqueio;

    public ContaInvestimento(double saldoInicial, int periodosBloqueio) {
        super(saldoInicial);
        this.periodosBloqueio = periodosBloqueio;
    }

    @Override
    public void sacar(double valor) {
        if (periodosBloqueio > 0) {
            System.out.println("Não é permitido sacar de uma conta de investimento antes do fim do período de bloqueio.");
        } else {
            //apos essa mudança, seu comportamento nao saira do padrao da class pai(sacar)
            super.sacar(valor);
        }
    }

    public void reduzirPeriodoBloqueio() {
        if (periodosBloqueio > 0) {
            periodosBloqueio--;
        }
    }
    //get a baixo pra puxar o valor e retornar ao usuario
        public int getPeriodosBloqueio() {
            return periodosBloqueio;
        }
}
