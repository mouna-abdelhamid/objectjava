public class CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito de " + cantidad + " realizado.");
        } else {
            System.out.println("Cantidad inválida para depositar.");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("Cantidad inválida para retirar.");
        } else if (cantidad > saldo) {
            System.out.println("Saldo insuficiente para retirar " + cantidad);
        } else {
            saldo -= cantidad;
            System.out.println("Retiro de " + cantidad + " realizado.");
        }
    }

    public void mostrarResumen() {
        System.out.println("Resumen de la cuenta:");
        System.out.println("Titular: " + titular);
        System.out.println("Saldo actual: " + saldo);
    }

    // Método para simular operaciones
    public void calling() {
        System.out.println("Creando cuenta bancaria para " + titular + " con saldo inicial " + saldo);
        depositar(500);
        retirar(200);
        retirar(1000);
        depositar(-50);
        retirar(-20);

        System.out.println("Saldo final: " + consultarSaldo());
        mostrarResumen();
    }
}
