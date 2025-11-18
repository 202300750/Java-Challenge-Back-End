import java.util.Scanner;

public class Conversor {

    private ServicioCambio servicio = new ServicioCambio();

    // MÉTODO convertir CORRECTO
    public double convertir(String monedaOrigen, String monedaDestino, double cantidad) {
        double tasa = servicio.obtenerTasa(monedaOrigen, monedaDestino);
        return cantidad * tasa;
    }   // ← ESTA LLAVE FALTABA

    // MÉTODO DEL MENÚ
    public void exibirMenu() {

        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 7) {
            System.out.println("""
                *******************************************************
                Sea bienvenido/a al Conversor de Moneda =]

                1) Dólar ==> Peso argentino
                2) Peso argentino ==> Dólar
                3) Dólar ==> Real brasileño
                4) Real brasileño ==> Dólar
                5) Dólar ==> Peso colombiano
                6) Peso colombiano ==> Dólar
                7) Salir

                Elija una opción válida:
                *******************************************************
                """);

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1 -> {
                    System.out.print("Ingrese el valor en USD: ");
                    double valor = teclado.nextDouble();
                    double resultado = convertir("USD", "ARS", valor);
                    System.out.println("Resultado: " + resultado + " ARS");
                }

                case 2 -> {
                    System.out.print("Ingrese el valor en ARS: ");
                    double valor = teclado.nextDouble();
                    double resultado = convertir("ARS", "USD", valor);
                    System.out.println("Resultado: " + resultado + " USD");
                }

                case 3 -> {
                    System.out.print("Ingrese el valor en USD: ");
                    double valor = teclado.nextDouble();
                    double resultado = convertir("USD", "BRL", valor);
                    System.out.println("Resultado: " + resultado + " BRL");
                }

                case 4 -> {
                    System.out.print("Ingrese el valor en BRL: ");
                    double valor = teclado.nextDouble();
                    double resultado = convertir("BRL", "USD", valor);
                    System.out.println("Resultado: " + resultado + " USD");
                }

                case 5 -> {
                    System.out.print("Ingrese el valor en USD: ");
                    double valor = teclado.nextDouble();
                    double resultado = convertir("USD", "COP", valor);
                    System.out.println("Resultado: " + resultado + " COP");
                }

                case 6 -> {
                    System.out.print("Ingrese el valor en COP: ");
                    double valor = teclado.nextDouble();
                    double resultado = convertir("COP", "USD", valor);
                    System.out.println("Resultado: " + resultado + " USD");
                }

                case 7 -> System.out.println("Finalizando programa...");

                default -> System.out.println("Opción inválida, intente nuevamente.");
            }

            System.out.println();
        }

        teclado.close();
    }
}
