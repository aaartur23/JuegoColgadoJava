import java.util.Scanner;

public class Juego {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numeroDeJugadores = 0;
        int option = 0;
        String palabraSecreta = "";
        String[] jugadores;
        String palabraGuiones = "";
        int intentosMax = 6;
        int turnoActual = 0;

        System.out.println("*-------------------------------*");
        System.out.println("|BIENVENIDO AL JUEGO DEL COLGADO|");
        System.out.println("*-------------------------------*");

        do {
            System.out.println("¿Vas a querer jugar? 1=si 2=no");
            option = sc.nextInt();
            sc.nextLine(); // Sacar el salto de línea por error

            if (option == 1) {
                System.out.println("*EMPECEMOS*");

                // Pido al usuario que ingrese la palabra
                System.out.print("Por favor, ingresa la palabra para adivinar: ");
                palabraSecreta = sc.nextLine().toLowerCase(); // Convertir la palabra a minúsculas

                // Pregunto cuántos jugadores van a jugar
                System.out.print("¿Cuántos jugadores van a jugar? ");
                numeroDeJugadores = sc.nextInt(); // Leer el número de jugadores
                
                //Verifico que al menos jueguen dos jugadores
                if (numeroDeJugadores < 2) {
                    System.out.println("ERROR --> El numero mínimo de jugadores debe ser dos");
                } else {
                    // Creo un array con el número de jugadores
                    jugadores = new String[numeroDeJugadores];

                    // Pido el nombre de cada jugador
                    for (int i = 0; i < jugadores.length; i++) {
                        System.out.print("Ingresa el nombre del jugador " + (i + 1) + ": ");
                        jugadores[i] = sc.next(); // Leer el nombre del jugador y almacenarlo en el array
                    }

                    // Inicializo la palabra oculta con guiones
                    palabraGuiones = "_ ".repeat(palabraSecreta.length()); // Muestro tantos guiones como letras de la palabra 
                    System.out.println("La palabra secreta tiene " + palabraSecreta.length() + " letras.");
                    System.out.println("La palabra oculta es: " + palabraGuiones);

                    // Variables para el juego
                    int intentosRestantes = intentosMax;
                    String palabraActual = palabraGuiones;
                    boolean palabraAdivinada = false;

                    // Empiezo los turnos mediante un while
                    while (intentosRestantes > 0 && !palabraAdivinada) {
                    	//Muestro el turno y como se veria la palabra en su momento
                        System.out.println("\nTurno de " + jugadores[turnoActual]);
                        System.out.println("Palabra actual: " + palabraActual);
                        System.out.println("Intentos restantes: " + intentosRestantes);

                        System.out.print("Ingresa una letra: ");
                        char letra = sc.next().toLowerCase().charAt(0); // Leer la letra ingresada

                        // Verifico si la letra está en la palabra
                        if (palabraSecreta.contains(String.valueOf(letra))) {
                            // Reemplazo la letra por un guion si se encuentra en la palabra
                            String nuevaPalabra = "";
                            for (int i = 0; i < palabraSecreta.length(); i++) {
                                if (palabraSecreta.charAt(i) == letra) {
                                	nuevaPalabra += letra + " "; // Si la letra esta, la agrego                                
                                }else {
                                	nuevaPalabra += palabraActual.charAt(i * 2) + " "; // Si no, se queda el guion actual 
                                }
                            }
                            palabraActual = nuevaPalabra; //Actualizo la palabra oculta
                            System.out.println("¡Correcto! La palabra ahora es: " + palabraActual);
                        } else {
                        	//Si la letra no esta se reduciran los intentos restantes
                            intentosRestantes--;
                            System.out.println("¡Incorrecto! Te quedan " + intentosRestantes + " intentos.");
                        }

                        // Verifico si se ha acertado la palabra
                        if (!palabraActual.contains("_")) {
                            palabraAdivinada = true;
                            System.out.println("¡Felicidades " + jugadores[turnoActual] + ", has adivinado la palabra!");
                        }

                        turnoActual = (turnoActual + 1) % numeroDeJugadores; // Ciclo el turno entre jugadores
                    }

                    // If por si se terminan los intentos y no se ha acertado la palabra
                    if (!palabraAdivinada) {
                        System.out.println("Se han agotado los intentos. La palabra secreta era: " + palabraSecreta);
                    }
                }
            } else {
                System.out.println("Has salido correctamente.");
            }
        } while (option != 2);
    }
}
