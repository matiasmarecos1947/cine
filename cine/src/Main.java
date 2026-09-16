import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Matriz que indica si el asiento está reservado
        boolean[][] asientos = new boolean[10][10];

        // Matriz que guarda el nombre del cliente
        String[][] nombres = new String[10][10];

        // Matriz que guarda el teléfono del cliente
        String[][] telefonos = new String[10][10];

        int opcion;

        do {

            System.out.println("\n===== SISTEMA DE RESERVA DE ASIENTOS =====");
            System.out.println("1. Ver mapa de asientos");
            System.out.println("2. Reservar asiento");
            System.out.println("3. Eliminar reserva");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opcion: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:

                    System.out.println("\n========== MAPA DE ASIENTOS ==========");

                    System.out.print("       ");

                    for (int columna = 0; columna < 10; columna++) {
                        System.out.printf("%4d", columna + 1);
                    }

                    System.out.println();

                    for (int fila = 0; fila < 10; fila++) {

                        System.out.printf("Fila %2d", fila + 1);

                        for (int columna = 0; columna < 10; columna++) {

                            if (asientos[fila][columna]) {
                                System.out.print(" [X]");
                            } else {
                                System.out.print(" [L]");
                            }
                        }

                        System.out.println();
                    }

                    System.out.println("\n[L] = Libre");
                    System.out.println("[X] = Reservado");

                    break;

                case 2:

                    System.out.println("\n========== RESERVAR ASIENTO ==========");

                    System.out.print("Ingrese su nombre: ");
                    teclado.nextLine();
                    String nombre = teclado.nextLine();

                    System.out.print("Ingrese su telefono: ");
                    String telefono = teclado.nextLine();

                    System.out.print("Ingrese la fila (1-10): ");
                    int fila = teclado.nextInt();

                    System.out.print("Ingrese el numero de asiento (1-10): ");
                    int columna = teclado.nextInt();

                    if (fila < 1 || fila > 10 || columna < 1 || columna > 10) {

                        System.out.println("La ubicacion ingresada no es valida.");

                    } else {

                        fila = fila - 1;
                        columna = columna - 1;

                        if (asientos[fila][columna]) {

                            System.out.println("El asiento ya esta reservado.");
                            System.out.println("La reserva pertenece a: "
                                    + nombres[fila][columna]);

                            System.out.println("Telefono: "
                                    + telefonos[fila][columna]);

                        } else {

                            asientos[fila][columna] = true;
                            nombres[fila][columna] = nombre;
                            telefonos[fila][columna] = telefono;

                            System.out.println("Reserva realizada correctamente.");
                            System.out.println("Asiento: Fila " + (fila + 1)
                                    + ", Numero " + (columna + 1));
                        }
                    }

                    break;

                case 3:

                    System.out.println("\n========== ELIMINAR RESERVA ==========");

                    System.out.print("Ingrese la fila (1-10): ");
                    fila = teclado.nextInt();

                    System.out.print("Ingrese el numero de asiento (1-10): ");
                    columna = teclado.nextInt();

                    if (fila < 1 || fila > 10 || columna < 1 || columna > 10) {

                        System.out.println("La ubicacion ingresada no es valida.");

                    } else {

                        fila = fila - 1;
                        columna = columna - 1;

                        if (asientos[fila][columna]) {

                            System.out.println("Reserva encontrada.");
                            System.out.println("Cliente: "
                                    + nombres[fila][columna]);

                            asientos[fila][columna] = false;
                            nombres[fila][columna] = null;
                            telefonos[fila][columna] = null;

                            System.out.println("La reserva fue eliminada correctamente.");
                            System.out.println("El asiento quedo disponible.");

                        } else {

                            System.out.println("El asiento seleccionado no tiene ninguna reserva.");
                        }
                    }

                    break;

                case 4:

                    System.out.println("\nGracias por utilizar el sistema.");

                    break;

                default:

                    System.out.println("\nOpcion no valida. Intente nuevamente.");
            }

        } while (opcion != 4);

        teclado.close();
    }
}