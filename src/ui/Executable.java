package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

    private Scanner reader;
    private Controladora cont;
    private static boolean flag;

    private Executable() {
        reader = new Scanner(System.in);
        cont = new Controladora();
    }

    public void run(boolean flag) {

        flag = false;

        while (!flag) {

            System.out.println("\n\nBienvenido al menu:\n");
            System.out.println("Opciones:\n" + "1. Imprimir tablero \n" + "2. Jugada de la máquina \n"
                    + "3. Jugada de humano \n" + "4. Verificar ganador \n" + "5. Salir del programa \n");

            int option = reader.nextInt();
            reader.nextLine();

            switch (option) {
                case 1:
                    imprimirTablero();
                    break;
                case 2:
                    jugadaMaquina();
                    break;
                case 3:
                    jugadaHumano();
                    break;
                case 4:
                    validarGanador();
                    break;
                case 5:
                    flag = true;
                    System.exit(0);
                    break;
                default:
                    System.out.print("Por favor ingrese una opcion valida");
                    continue;
            }

        }

    }

    public static void main(String[] args) {
        Executable mainApp = new Executable();
        mainApp.run(flag);
    }

    private void imprimirTablero() {
        System.out.println(cont.obtenerTableroComoString());
    }

    private void jugadaMaquina() {
        cont.jugadaAleatoria();
        System.out.println("La máquina ha realizado su jugada.");
        imprimirTablero();
    }

    private void jugadaHumano() {

        System.out.println("ingrese en que columna desea realizar su jugada.(1,2 o 3)");
        int cL = reader.nextInt();
        int columna = 0;
        int fila = 0;
        switch (cL) {
            case 1:
                columna = 0;
                break;
            case 2:
                columna = 1;
                break;
            case 3:
                columna = 2;
                break;

            default:
                System.out.print("Por favor ingrese una opcion valida");
        }

        System.out.println("ingrese en que fila desea realizar su jugada.(1,2 o 3)");
        int fL = reader.nextInt();
        switch (fL) {
            case 1:
                fila = 0;
                break;
            case 2:
                fila = 1;
                break;
            case 3:
                fila = 2;
                break;

            default:
                System.out.print("Por favor ingrese una opcion valida");

        }

        System.out.println(cont.jugadaHumano(columna, fila));
        System.out.println("El humano ha realizado su jugada.");
        imprimirTablero();
    }

    private void validarGanador() {
        System.out.println("\nEl jugador humano es: " + "'O'");
        System.out.println("La maquina es: " + "'X'\n");
        System.out.println(cont.validarGanador());
    }
}