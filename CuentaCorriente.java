public class CuentaCorriente {
    // Atributos privados (encapsulados)
    private int numeroCuenta;
    private int saldo;

    // Constructor con parámetros
    public CuentaCorriente(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0; // Saldo siempre comienza en 0
    }

    // Getter del número de cuenta
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    // Getter del saldo
    public int getSaldo() {
        return saldo;
    }

    // metodo para deposito de dinero
    public void depositar(int monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("¡Depósito realizado de manera exitosa!");
            System.out.println("Usted tiene un saldo actual de " + saldo + " pesos.");
        } else {
            System.out.println("El monto debe ser mayor que cero.");
        }
    }

    // Metodo para retiro de dinero
    public void girar(int monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor que cero.");
        } else if (monto > saldo) {
            System.out.println("Saldo insuficiente. No puede girar más de " + saldo + " pesos.");
        } else {
            saldo -= monto;
            System.out.println("¡Giro realizado de manera exitosa!");
            System.out.println("Usted tiene un saldo actual de " + saldo + " pesos.");
        }
    }

    // Metodo para saber cuanto dinero hay en la cuenta del cliente
    public void consultarSaldo() {
        System.out.println("Saldo actual: " + saldo + " pesos.");
    }
}
