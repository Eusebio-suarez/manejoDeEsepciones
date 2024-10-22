// Clase principal para simular operaciones bancarias
public class BancoApp {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria("juan", 1000);
        CuentaBancaria cuenta2 = new CuentaBancaria("maria", 500);

        try {
            cuenta1.depositar(200);
            cuenta1.retirar(150);
            cuenta1.transferir(cuenta2, 300);
            cuenta1.retirar(1200);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (MontoNegativoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            cuenta1.depositar(-50);
        } catch (MontoNegativoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}