public class Cliente {

    String nombre;
    double saldo;

    public Cliente(String nombre, double saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
}


public void mostrarSaldo() {
    System.out.println( "Cliente: " + nombre);
    System.out.println( "Saldo: $" + saldo);
}

public void comprar(double monto) {
    saldo = saldo - monto;
    System.out.println(nombre + " realizo una compra de $" + monto); 
}

public void pagar(double monto) {
    saldo = saldo + monto;
    System.out.println(nombre + " pago $" + monto); 
}
}