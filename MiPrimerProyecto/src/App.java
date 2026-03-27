import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Cliente cliente1 = new Cliente("Marcos", 1000);

        int opcion;

        do {

            System.out.println("----- MENU -----");
            System.out.println("1 - Ver saldo");
            System.out.println("2 - Comprar");
            System.out.println("3 - Pagar");
            System.out.println("4 - Salir");
            System.out.print("Elegir opcion: ");

            opcion = teclado.nextInt();

            if (opcion == 1) {
                cliente1.mostrarSaldo();
            }

            if (opcion == 2) {
                System.out.print("Monto de compra: ");
                double monto = teclado.nextDouble();
                cliente1.comprar(monto);
            }

            if (opcion == 3) {
                System.out.print("Monto de pago: ");
                double monto = teclado.nextDouble();
                cliente1.pagar(monto);
            }

        } while (opcion != 4);

        System.out.println("Programa finalizado");

        teclado.close();
    }
}