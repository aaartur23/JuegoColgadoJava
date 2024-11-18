import java.util.Scanner;
import java.util.Random;
public class Juego {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int numeroDeJugadores = 0;
		int option = 0;
		String palabraSecreta = "";
		String[] jugadores;
		
		System.out.println("*-------------------------------*");
		System.out.println("|BIENVENIDO AL JUEGO DEL COLGADO|");
		System.out.println("*-------------------------------*");
		
		do {
		System.out.println("Vas a querer jugar? 1=si 2=no");
		option = sc.nextInt();
		sc.nextLine(); // Sacar el salto de linea por error
		
		if(option == 1) {
			System.out.println("*EMPECEMOS*");
		
		// Pedir al usuario que ingrese la palabra
        System.out.print("Por favor, ingresa la palabra para adivinar: ");
        palabraSecreta = sc.nextLine().toLowerCase(); // Convertir la palabra a minúsculas para evitar problemas con mayúsculas
        
        // Preguntar cuántos jugadores van a jugar
        System.out.print("¿Cuántos jugadores van a jugar? ");
        numeroDeJugadores = sc.nextInt();  // Leer el número de jugadores
        
        if (numeroDeJugadores < 2) {
        	System.out.println("ERROR --> El numero minimo de jugadores ha de ser dos");
        	
        } else {
        	
        
        // Crear un array con el número de jugadores
        jugadores = new String[numeroDeJugadores];
        
        // Pedir el nombre de cada jugador
        for (int i = 0; i < jugadores.length; i++) {
            System.out.print("Ingresa el nombre del jugador " + (i + 1) + ": ");
            jugadores[i] = sc.next();  // Leer el nombre del jugador y almacenarlo en el array
           }
        // Mostrar la palabra ingresada
        System.out.println("La palabra secreta es: " + palabraSecreta);
        }
		} else {
			System.out.println("Has salido correctamente");
		}
		} while (option != 2);
        
        
		
	}
}