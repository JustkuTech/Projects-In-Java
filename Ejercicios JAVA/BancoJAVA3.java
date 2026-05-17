import javax.swing.JOptionPane;

// =================
// CLASE PRINCIPAL
// =================
public class BancoJAVA3 {

    public static void main(String[] args) {
        int N;

        // Variables para Datos del Cliente
        long documento;
        String nombre;
        String correo;
        int celular;
        String direccion;

        // Variables para Datos de los Productos
        long cuenta;
        String fecha;
        int tipoAhorro;
        double saldo;
        double porcentajeInteres;
        double sobregiro;

        double valorTotalIntereses = 0;
        double valorTotalSaldos = 0;

        try {
            String strN = JOptionPane.showInputDialog(null, "Ingrese cantidad de cuentas a procesar:", "Inicio Reto 3",
                    JOptionPane.QUESTION_MESSAGE);
            if (strN == null)
                return;
            N = Integer.parseInt(strN);

            for (int i = 1; i <= N; i++) {

                String strDoc = JOptionPane.showInputDialog(null, "Cliente #" + i + "\nIngrese documento de identidad:",
                        "Datos del Cliente", JOptionPane.QUESTION_MESSAGE);
                if (strDoc == null)
                    return;
                documento = Long.parseLong(strDoc);

                nombre = JOptionPane.showInputDialog(null, "Cliente #" + i + "\nIngrese nombre completo:",
                        "Datos del Cliente", JOptionPane.QUESTION_MESSAGE);
                if (nombre == null)
                    return;

                correo = JOptionPane.showInputDialog(null, "Cliente #" + i + "\nIngrese correo electrónico:",
                        "Datos del Cliente", JOptionPane.QUESTION_MESSAGE);
                if (correo == null)
                    return;

                String strCel = JOptionPane.showInputDialog(null, "Cliente #" + i + "\nIngrese número de celular:",
                        "Datos del Cliente", JOptionPane.QUESTION_MESSAGE);
                if (strCel == null)
                    return;
                celular = Integer.parseInt(strCel);

                direccion = JOptionPane.showInputDialog(null, "Cliente #" + i + "\nIngrese dirección de residencia:",
                        "Datos del Cliente", JOptionPane.QUESTION_MESSAGE);
                if (direccion == null)
                    return;

                String strProd = JOptionPane.showInputDialog(null,
                        "Seleccione el producto a registrar:\n1 - Cuenta de Ahorros\n2 - Cuenta Corriente",
                        "Selección de Producto", JOptionPane.QUESTION_MESSAGE);
                if (strProd == null)
                    return;
                int opcionProducto = Integer.parseInt(strProd);

                ClienteR3 objetoCliente = null;
                double saldoActual = 0;

                if (opcionProducto == 1) {
                    String strCuenta = JOptionPane.showInputDialog(null,
                            "Cuenta de Ahorros #" + i + "\nIngrese número de cuenta:",
                            "Datos Cuenta de Ahorros", JOptionPane.QUESTION_MESSAGE);
                    if (strCuenta == null)
                        return;
                    cuenta = Long.parseLong(strCuenta);

                    fecha = JOptionPane.showInputDialog(null,
                            "Cuenta de Ahorros #" + i + "\nIngrese fecha de apertura (aaaa/mm/dd):",
                            "Datos Cuenta de Ahorros", JOptionPane.QUESTION_MESSAGE);
                    if (fecha == null)
                        return;

                    String strTipo = JOptionPane.showInputDialog(null, "Cuenta de Ahorros #" + i
                            + "\nSeleccione el tipo de cuenta:\n1 - AhorroDiario (1.5%)\n2 - CuentaJoven (1.7%)\n3 - Tradicional (1.6%)",
                            "Datos Cuenta de Ahorros", JOptionPane.QUESTION_MESSAGE);
                    if (strTipo == null)
                        return;
                    tipoAhorro = Integer.parseInt(strTipo);

                    String strSaldo = JOptionPane.showInputDialog(null,
                            "Cuenta de Ahorros #" + i + "\nIngrese saldo de la cuenta:",
                            "Datos Cuenta de Ahorros", JOptionPane.QUESTION_MESSAGE);
                    if (strSaldo == null)
                        return;
                    saldo = Double.parseDouble(strSaldo);

                    if (tipoAhorro < 1 || tipoAhorro > 3) {
                        JOptionPane.showMessageDialog(null, "Tipo de cuenta inválido. Se aplicará 0% de interés.",
                                "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }

                    objetoCliente = new CuentaAhorrosR3(documento, nombre, correo, celular, direccion, cuenta, fecha,
                            tipoAhorro, saldo);
                    saldoActual = saldo;

                } else if (opcionProducto == 2) {
                    // --- FLUJO CUENTA CORRIENTE ---
                    String strCuenta = JOptionPane.showInputDialog(null,
                            "Cuenta Corriente #" + i + "\nIngrese número de cuenta:",
                            "Datos Cuenta Corriente", JOptionPane.QUESTION_MESSAGE);
                    if (strCuenta == null)
                        return;
                    cuenta = Long.parseLong(strCuenta);

                    fecha = JOptionPane.showInputDialog(null,
                            "Cuenta Corriente #" + i + "\nIngrese fecha de apertura (aaaa/mm/dd):",
                            "Datos Cuenta Corriente", JOptionPane.QUESTION_MESSAGE);
                    if (fecha == null)
                        return;

                    String strSaldo = JOptionPane.showInputDialog(null,
                            "Cuenta Corriente #" + i + "\nIngrese saldo de la cuenta:",
                            "Datos Cuenta Corriente", JOptionPane.QUESTION_MESSAGE);
                    if (strSaldo == null)
                        return;
                    saldo = Double.parseDouble(strSaldo);

                    String strPct = JOptionPane.showInputDialog(null,
                            "Cuenta Corriente #" + i + "\nIngrese porcentaje de interés mensual (%):",
                            "Datos Cuenta Corriente", JOptionPane.QUESTION_MESSAGE);
                    if (strPct == null)
                        return;
                    porcentajeInteres = Double.parseDouble(strPct);

                    String strSob = JOptionPane.showInputDialog(null,
                            "Cuenta Corriente #" + i + "\nIngrese valor permitido de sobregiro:",
                            "Datos Cuenta Corriente", JOptionPane.QUESTION_MESSAGE);
                    if (strSob == null)
                        return;
                    sobregiro = Double.parseDouble(strSob);

                    objetoCliente = new CuentaCorrienteR3(documento, nombre, correo, celular, direccion, cuenta, fecha,
                            saldo, porcentajeInteres, sobregiro);
                    saldoActual = saldo;

                } else {
                    JOptionPane.showMessageDialog(null, "Opción de producto no válida. Se saltará este registro.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                // 3. POLIMORFISMO
                double valorInteres = objetoCliente.calcular_interes();
                double saldoNuevo = saldoActual + valorInteres;

                valorTotalIntereses += valorInteres;
                valorTotalSaldos += saldoNuevo;

                String tipoProdTexto = (opcionProducto == 1) ? "Cuenta de Ahorros" : "Cuenta Corriente";
                String mensaje = "--- RESULTADOS DEL REGISTRO ---\n"
                        + "Tipo de Producto: " + tipoProdTexto + "\n"
                        + "Titular: " + objetoCliente.getNombre() + "\n"
                        + "Documento: " + objetoCliente.getDocumento() + "\n"
                        + "Valor interés: $" + String.format("%.2f", valorInteres) + "\n"
                        + "Saldo nuevo: $" + String.format("%.2f", saldoNuevo);

                JOptionPane.showMessageDialog(null, mensaje, "Resultados Registro #" + i,
                        JOptionPane.INFORMATION_MESSAGE);
            }

            String totales = "=== TOTALES FINALES DE LA SESIÓN ===\n"
                    + "Valor total intereses: $" + String.format("%.2f", valorTotalIntereses) + "\n"
                    + "Valor total saldos: $" + String.format("%.2f", valorTotalSaldos);

            JOptionPane.showMessageDialog(null, totales, "Totales de la Sesión", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Error: Por favor ingrese un valor numérico válido.\nSe cancelará la operación.",
                    "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
}

// =================
// CLASES DERIVADAS
// =================
class ClienteR3 {
    private long documento;
    private String nombre;
    private String correo;
    private int celular;
    private String direccion;

    public ClienteR3(long documento, String nombre, String correo, int celular, String direccion) {
        this.documento = documento;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.direccion = direccion;
    }

    public double calcular_interes() {
        return 0.0;
    }

    public long getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public int getCelular() {
        return celular;
    }

    public String getDireccion() {
        return direccion;
    }
}

class CuentaAhorrosR3 extends ClienteR3 {
    private long cuenta;
    private String fecha;
    private int tipo;
    private double saldo;

    public CuentaAhorrosR3(long documento, String nombre, String correo, int celular, String direccion,
            long cuenta, String fecha, int tipo, double saldo) {
        super(documento, nombre, correo, celular, direccion);
        this.cuenta = cuenta;
        this.fecha = fecha;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    @Override
    public double calcular_interes() {
        double interesMensual = 0;
        switch (this.tipo) {
            case 1:
                interesMensual = 1.5 / 100;
                break;
            case 2:
                interesMensual = 1.7 / 100;
                break;
            case 3:
                interesMensual = 1.6 / 100;
                break;
            default:
                interesMensual = 0.0;
        }
        return this.saldo * interesMensual;
    }

    public long getCuenta() {
        return cuenta;
    }

    public String getFecha() {
        return fecha;
    }

    public int getTipo() {
        return tipo;
    }

    public double getSaldo() {
        return saldo;
    }
}

class CuentaCorrienteR3 extends ClienteR3 {
    private long cuenta;
    private String fecha;
    private double saldo;
    private double porcentajeInteres;
    private double sobregiro;

    public CuentaCorrienteR3(long documento, String nombre, String correo, int celular, String direccion,
            long cuenta, String fecha, double saldo, double porcentajeInteres, double sobregiro) {
        super(documento, nombre, correo, celular, direccion);
        this.cuenta = cuenta;
        this.fecha = fecha;
        this.saldo = saldo;
        this.porcentajeInteres = porcentajeInteres;
        this.sobregiro = sobregiro;
    }

    @Override
    public double calcular_interes() {
        return this.saldo * (this.porcentajeInteres / 100);
    }

    public long getCuenta() {
        return cuenta;
    }

    public String getFecha() {
        return fecha;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getPorcentajeInteres() {
        return porcentajeInteres;
    }

    public double getSobregiro() {
        return sobregiro;
    }
}