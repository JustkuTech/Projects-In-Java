import javax.swing.JOptionPane;

public class BancoJAVA {

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

                double interesMensual = 0;

                switch (tipo) {
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
                        JOptionPane.showMessageDialog(null, "Tipo de cuenta invalido. Se aplicara 0% de interes.",
                                "Advertencia", JOptionPane.WARNING_MESSAGE);
                }

                valorInteres = saldo * interesMensual;
                saldoNuevo = saldo + valorInteres;

                valorTotalIntereses += valorInteres;
                valorTotalSaldos += saldoNuevo;

                String mensaje = "--- RESULTADOS DE LA CUENTA ---\n"
                        + "Cuenta: " + cuenta + "\n"
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