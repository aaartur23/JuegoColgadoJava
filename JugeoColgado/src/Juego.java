import java.util.Scanner;
import java.util.Random;
public class Juego {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int numeroDeJugadores = 0;
		String[] palabras = new String[1];// Crear un array con un solo espacio para la palabra a ingresar
		
		System.out.println("*-------------------------------*");
		System.out.println("|BIENVENIDO AL JUEGO DEL COLGADO|");
		System.out.println("*-------------------------------*");
		
		// Pedir al usuario que ingrese una palabra
		System.out.print("Por favor, ingresa la palabra para adivinar: ");
		palabras[0] = sc.nextLine(); // Leer la palabra y guardarla en el array
        
        // Preguntar cuántos jugadores van a jugar
        System.out.print("¿Cuántos jugadores van a jugar? ");
        numeroDeJugadores = sc.nextInt();  // Leer el número de jugadores
        
        // Crear un array con el número de jugadores
        String[] jugadores = new String[numeroDeJugadores];
        
        // Pedir el nombre de cada jugador
        for (int i = 0; i < jugadores.length; i++) {
            System.out.print("Ingresa el nombre del jugador " + (i + 1) + ": ");
            jugadores[i] = sc.next();  // Leer el nombre del jugador y almacenarlo en el array
        }
        
        
		// Mostrar la palabra ingresada
		System.out.println("La palabra secreta es: " + palabras[0]);
		
		
	}

}
