import javax.swing.JOptionPane;

// ==========================================
// CLASE PRINCIPAL
// ==========================================
public class BancoJAVA2 {

    public static void main(String[] args) {
        int N;
        long cuenta;
        String fecha;
        int tipo;
        double saldo;
        double valorInteres;
        double saldoNuevo;

        double valorTotalIntereses = 0;
        double valorTotalSaldos = 0;

        try {
            String strN = JOptionPane.showInputDialog(null, "Ingrese cantidad de cuentas a procesar:", "Inicio",
                    JOptionPane.QUESTION_MESSAGE);
            if (strN == null)
                return;
            N = Integer.parseInt(strN);

            for (int i = 1; i <= N; i++) {
                String strCuenta = JOptionPane.showInputDialog(null, "Cuenta #" + i + "\nIngrese numero de cuenta:",
                        "Datos de la Cuenta", JOptionPane.QUESTION_MESSAGE);
                if (strCuenta == null)
                    return;
                cuenta = Long.parseLong(strCuenta);

                fecha = JOptionPane.showInputDialog(null, "Cuenta #" + i + "\nIngrese fecha de apertura (aaaa/mm/dd):",
                        "Datos de la Cuenta", JOptionPane.QUESTION_MESSAGE);
                if (fecha == null)
                    return;

                String strTipo = JOptionPane.showInputDialog(null, "Cuenta #" + i
                        + "\nSeleccione el tipo de cuenta:\n1 - Ahorro (1.5%)\n2 - Corriente (1.7%)\n3 - Empresarial (1.6%)",
                        "Datos de la Cuenta", JOptionPane.QUESTION_MESSAGE);
                if (strTipo == null)
                    return;
                tipo = Integer.parseInt(strTipo);

                String strSaldo = JOptionPane.showInputDialog(null, "Cuenta #" + i + "\nIngrese saldo de la cuenta:",
                        "Datos de la Cuenta", JOptionPane.QUESTION_MESSAGE);
                if (strSaldo == null)
                    return;
                saldo = Double.parseDouble(strSaldo);

                // validación preventiva para mantener el mensaje de advertencia original
                if (tipo < 1 || tipo > 3) {
                    JOptionPane.showMessageDialog(null, "Tipo de cuenta invalido. Se aplicara 0% de interes.",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
                }

                // INSTANCIACIÓN DEL OBJETO CUENTA (Aplicando POO)
                Cuenta objetoCuenta = new Cuenta(cuenta, fecha, tipo, saldo);

                // USO DE MÉTODOS DE LA CLASE CUENTA
                valorInteres = objetoCuenta.calcular_interes();
                saldoNuevo = objetoCuenta.getSaldo() + valorInteres;

                valorTotalIntereses += valorInteres;
                valorTotalSaldos += saldoNuevo;

                String mensaje = "--- RESULTADOS DE LA CUENTA ---\n"
                        + "Cuenta: " + objetoCuenta.getCuenta() + "\n"
                        + "Valor interes: $" + String.format("%.2f", valorInteres) + "\n"
                        + "Saldo nuevo: $" + String.format("%.2f", saldoNuevo);

                JOptionPane.showMessageDialog(null, mensaje, "Resultados Cuenta #" + i,
                        JOptionPane.INFORMATION_MESSAGE);
            }

            String totales = "=== TOTALES FINALES ===\n"
                    + "Valor total intereses: $" + String.format("%.2f", valorTotalIntereses) + "\n"
                    + "Valor total saldos: $" + String.format("%.2f", valorTotalSaldos);

            JOptionPane.showMessageDialog(null, totales, "Totales de la Sesion", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Error: Por favor ingrese un valor numerico valido.\nSe cancelara la operacion.",
                    "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
}

// ==========================================
// CLASE CUENTA
// ==========================================
class Cuenta {

    private long cuenta; // Número de cuenta
    private String fecha; // Fecha de apertura (aaaa/mm/dd
    private int tipo; // Tipo de cuenta (1, 2 o 3)
    private double saldo; // Saldo de la cuenta

    public Cuenta(long cuenta, String fecha, int tipo, double saldo) {
        this.cuenta = cuenta;
        this.fecha = fecha;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public double calcular_interes() {
        double interesMensual = 0;

        switch (this.tipo) {
            case 1:
                interesMensual = 1.5 / 100; // AhorroDiario
                break;
            case 2:
                interesMensual = 1.7 / 100; // CuentaJoven
                break;
            case 3:
                interesMensual = 1.6 / 100; // Tradicional
                break;
            default:
                interesMensual = 0.0;
        }
        return this.saldo * interesMensual;
    }

    public long getCuenta() {
        return cuenta;
    }

    public void setCuenta(long cuenta) {
        this.cuenta = cuenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}