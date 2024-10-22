class CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) throws MontoNegativoException {
        if (monto < 0) {
            throw new MontoNegativoException("No se puede depositar un monto negativo.");
        }
        saldo += monto;
        System.out.println("Depósito realizado: " + monto + ". Nuevo saldo: " + saldo);
    }

    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para retirar " + monto + ".");
        }
        saldo -= monto;
        System.out.println("Retiro realizado: " + monto + ". Nuevo saldo: " + saldo);
    }

    public void transferir(CuentaBancaria cuentaDestino, double monto) throws SaldoInsuficienteException, MontoNegativoException {
        retirar(monto);
        cuentaDestino.depositar(monto);
        System.out.println("Transferencia de " + monto + " a " + cuentaDestino.titular + " realizada.");
    }
}