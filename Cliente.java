public class Cliente {
    // Atributos privados (encapsulados)
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String comuna;
    private String telefono;
    private CuentaCorriente cuenta;

    // Constructor con parámetros
    public Cliente(String rut, String nombre, String apellidoPaterno, String apellidoMaterno,
                   String domicilio, String comuna, String telefono, int numeroCuenta) {
        // Validación del largo del RUT
        if (rut.length() < 8 || rut.length() > 9) {
            throw new IllegalArgumentException("El RUT debe tener entre 8 y 9 caracteres.");
        }
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuenta = new CuentaCorriente(numeroCuenta); // Se crea Cliente
    }

    // Métodos GET (accesadores)
    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getComuna() {
        return comuna;
    }

    public String getTelefono() {
        return telefono;
    }

    public CuentaCorriente getCuenta() {
        return cuenta;
    }

    // Metodos para mostrar los datos del cliente
    public void mostrarDatos() {
        System.out.println("Rut:(Solo Digitos, sin guion)" + rut);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido paterno: " + apellidoPaterno);
        System.out.println("Apellido materno: " + apellidoMaterno);
        System.out.println("Domicilio: " + domicilio);
        System.out.println("Comuna: " + comuna);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Número de cuenta corriente: " + cuenta.getNumeroCuenta());
        System.out.println("Saldo: " + cuenta.getSaldo() + " pesos");
    }
}
