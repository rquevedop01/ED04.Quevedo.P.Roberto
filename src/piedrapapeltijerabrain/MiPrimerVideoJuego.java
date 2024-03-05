/*
* Programa para jugar a Piedra, Papel, Tijera.
* Propone al jugador ganar o perder según lo indicado.
* Calcula el tiempo en completar el juego y la penaliza los errores.
*/
package piedrapapeltijerabrain;

import java.util.Scanner;

/**
 * @author rquevedop01


 La clase MiPrimerVideoJuego implementa el juego Piedra, Papel, Tijera.
 Método principal que inicia el juego y métodos auxiliares para cada opción del juego.
*/
public class MiPrimerVideoJuego {

    /**
    * Método principal que inicia el juego.
    * 
    */
    public static void main(String[] args) {
        // Inicialización de variables
        int chiquipuntos = 0; // Puntos del jugador
        Scanner sc = new Scanner(System.in); // Objeto Scanner para entrada de usuario
        String opcionJugador = ""; // Opción elegida por el jugador
        String opcionBot = ""; // Opción generada por el programa
        int exitoEnProposito = 1; // Variable para determinar si el jugador tuvo éxito en su objetivo

        // Inicio del contador de tiempo
        long inicio = System.currentTimeMillis();

        // Bucle para 5 juegos
        for (int i = 0; i < 5; i++) {
            // Determina el propósito del juego: ganar o perder
            int proposito = (int) Math.floor(Math.random() * 2 + 1);
            if (proposito == 1) {
                System.out.println("\n\tIntenta ganar");
            }
            if (proposito == 2) {
                System.out.println("\n\tIntenta perder");
            }

            // Generar una opción aleatoria para el bot (máquina)
            int j = (int) Math.floor(Math.random() * 3 + 1);
            if (j == 1) {
                opcionBot = "tijera";
                System.out.println(opcionBot);
                tijera(); /** Llama al método para mostrar la opción "tijera"*/
            }
            if (j == 2) {
                opcionBot = "papel";
                System.out.println(opcionBot);
                papel(); /** Llama al método para mostrar la opción "papel"*/
            }
            if (j == 3) {
                opcionBot = "piedra";
                System.out.println(opcionBot);
                piedra(); /** Llama al método para mostrar la opción "piedra"*/
            }

            // Bucle para asegurarse de que el jugador no elija la misma opción que el bot
            do {
                System.out.println("Introduce tu jugada");
                opcionJugador = sc.nextLine();
                if (opcionBot.equals(opcionJugador)) {
                    System.out.println("No tiene sentido que intentes empatar");
                }
            } while (opcionBot == opcionJugador);

             // Determina el resultado del juego y actualizar los puntos del jugador
            if (opcionJugador.equals("tijera") && (opcionBot.equals("papel"))) {
                exitoEnProposito = 1;
            }
            if (opcionJugador.equals("papel") && (opcionBot.equals("tijera"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("tijera") && (opcionBot.equals("piedra"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("piedra") && (opcionBot.equals("tijera"))) {
                exitoEnProposito = 1;
            }
            if (opcionJugador.equals("piedra") && (opcionBot.equals("papel"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("papel") && (opcionBot.equals("piedra"))) {
                exitoEnProposito = 1;
            }

            // Actualizar puntos según el propósito del juego
            if (proposito == 2) {
                exitoEnProposito *= -1;
            }
            if (exitoEnProposito == 1) {
                chiquipuntos++;
            }
        }

        // Fin del contador de tiempo y cálculo del tiempo transcurrido
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio) / 1000);

        // Calcula penalizacion por errores y tiempo final
        int nFallos = 5 - chiquipuntos;
        double tiempoFinal = tiempo + nFallos * 5;

        // Muestra los resultados
        System.out.println("Has realizado el ejercicio en " + tiempo + " segundos");
        System.out.println("Penalización: " + nFallos + " x 5s = " + nFallos * 5);
        System.out.println("Tu tiempo final es de " + tiempoFinal + " segundos");
        System.out.println("Vuelve a jugar con nosotros");
        System.out.println("Es muy divertido!");
    }

    /**
    * Método para mostrar la representación visual de la opción "tijera".
    */
    public static void tijera() {
        System.out.println("'''\n"
                + " _______\n"
                + "---' ____)____\n"
                + "______)\n"
                + "__________)\n"
                + "(____)\n"
                + "---.__(___)\n"
                + "'''");
    }

    /**
    * Método para mostrar la representación visual de la opción "papel".
    */
    public static void papel() {
        System.out.println("'''\n"
                + " _______\n"
                + "---' ____)____\n"
                + "______)\n"
                + "_______)\n"
                + "_______)\n"
                + "---.__________)");
    }

    /**
    * Método para mostrar la representación visual de la opción "piedra".
    */
    public static void piedra() {
        System.out.println("'''\n"
                + " _______\n"
                + "---' ____)\n"
                + "(_____)\n"
                + "(_____)\n"
                + "(____)\n"
                + "---.__(___)\n"
                + "'''");
    }
}
