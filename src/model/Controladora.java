package model;

import java.util.Random;

public class Controladora {

    private String[][] tableroTresEnRaya;

    /**
     * Constructor de la clase Controladora para inicializar
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controladora
     */
    public Controladora() {
        tableroTresEnRaya = new String[3][3];
        inicializarTablero();
    }

    /**
     * Inicializa el tablero con valores vacíos.
     */
    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableroTresEnRaya[i][j] = " ";
            }
        }
    }

    /**
     * Devuelve el tablero en formato String.
     */
    public String obtenerTableroComoString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(tableroTresEnRaya[i][j]);
                if (j < 2)
                    sb.append("|");
            }
            sb.append("\n");
            if (i < 2)
                sb.append("-----\n");
        }
        return sb.toString();
    }

    /**
     * Realiza una jugada aleatoria para la máquina.
     */
    public void jugadaAleatoria() {
        Random rand = new Random();
        int i, j;
        do {
            i = rand.nextInt(3);
            j = rand.nextInt(3);
        } while (!tableroTresEnRaya[i][j].equals(" "));
        tableroTresEnRaya[i][j] = "X";
    }

    public String jugadaHumano(int columna, int fila) {
        if (columna >= 0 && columna < 3) {
            if (fila >= 0 && fila < 3) {
                if (tableroTresEnRaya[fila][columna].equals(" ")) {
                    tableroTresEnRaya[fila][columna] = "O";
                } else {
                    return " " + Mensaje();
                }

            }
        }
        return "";
    }

    public String Mensaje() {
        return " La celda esta ocupada, vuelve a intentarlo ";
    }

    public String validarGanador() {

        for (int i = 0; i < 3; i++) {
            if (tableroTresEnRaya[i][0].equals(tableroTresEnRaya[i][1]) &&
                    tableroTresEnRaya[i][1].equals(tableroTresEnRaya[i][2]) &&
                    !tableroTresEnRaya[i][0].equals(" ")) {
                return "¡" + tableroTresEnRaya[i][0] + " es el ganador!";
            }
        }

        for (int j = 0; j < 3; j++) {
            if (tableroTresEnRaya[0][j].equals(tableroTresEnRaya[1][j]) &&
                    tableroTresEnRaya[1][j].equals(tableroTresEnRaya[2][j]) &&
                    !tableroTresEnRaya[0][j].equals(" ")) {
                return "¡" + tableroTresEnRaya[0][j] + " es el ganador!";
            }
        }

        if (tableroTresEnRaya[0][0].equals(tableroTresEnRaya[1][1]) &&
                tableroTresEnRaya[1][1].equals(tableroTresEnRaya[2][2]) &&
                !tableroTresEnRaya[0][0].equals(" ")) {
            return "¡" + tableroTresEnRaya[0][0] + " es el ganador!";
        }

        if (tableroTresEnRaya[0][2].equals(tableroTresEnRaya[1][1]) &&
                tableroTresEnRaya[1][1].equals(tableroTresEnRaya[2][0]) &&
                !tableroTresEnRaya[0][2].equals(" ")) {
            return "¡" + tableroTresEnRaya[0][2] + " es el ganador!";
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tableroTresEnRaya[i][j].equals(" ")) {
                    return "El juego continua.";
                }
            }
        }

        return "Es un empate!";
    }

}
