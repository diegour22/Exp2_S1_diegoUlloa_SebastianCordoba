import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Método para buscar un cliente por su RUT
    public static Cliente buscarClientePorRut(ArrayList<Cliente> clientes, String rutBuscado) {
        for (Cliente c : clientes) {
            if (c.getRut().equalsIgnoreCase(rutBuscado)) {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú Bank Boston ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver datos del cliente");
            System.out.println("3. Depositar");
            System.out.println("4. Girar");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese Rut: ");
                    String rut = sc.nextLine();

                    System.out.print("Ingrese nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Ingrese apellido paterno: ");
                    String apePat = sc.nextLine();

                    System.out.print("Ingrese apellido materno: ");
                    String apeMat = sc.nextLine();

                    System.out.print("Ingrese domicilio: ");
                    String domicilio = sc.nextLine();

                    System.out.print("Ingrese comuna: ");
                    String comuna = sc.nextLine();

                    System.out.print("Ingrese teléfono: ");
                    String telefono = sc.nextLine();

                    System.out.print("Ingrese número de cuenta corriente (9 dígitos): ");
                    int numeroCuenta = sc.nextInt();
                    sc.nextLine(); // limpiar buffer

                    try {
                        Cliente nuevoCliente = new Cliente(rut, nombre, apePat, apeMat, domicilio, comuna, telefono, numeroCuenta);
                        clientes.add(nuevoCliente);
                        System.out.println("¡Cliente registrado exitosamente!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el RUT del cliente: ");
                    String rutConsulta = sc.nextLine();
                    Cliente c2 = buscarClientePorRut(clientes, rutConsulta);
                    if (c2 != null) {
                        c2.mostrarDatos();
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el RUT del cliente: ");
                    String rutDep = sc.nextLine();
                    Cliente c3 = buscarClientePorRut(clientes, rutDep);
                    if (c3 != null) {
                        System.out.print("Ingrese monto a depositar: ");
                        int monto = sc.nextInt();
                        sc.nextLine();
                        c3.getCuenta().depositar(monto);
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el RUT del cliente: ");
                    String rutGiro = sc.nextLine();
                    Cliente c4 = buscarClientePorRut(clientes, rutGiro);
                    if (c4 != null) {
                        System.out.print("Ingrese monto a girar: ");
                        int monto = sc.nextInt();
                        sc.nextLine();
                        c4.getCuenta().girar(monto);
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese el RUT del cliente: ");
                    String rutSaldo = sc.nextLine();
                    Cliente c5 = buscarClientePorRut(clientes, rutSaldo);
                    if (c5 != null) {
                        c5.getCuenta().consultarSaldo();
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 6:
                    salir = true;
                    System.out.println("Gracias por usar Bank Boston. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        sc.close();
    }
}
