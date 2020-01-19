import java.util.Scanner;

//Laura Tamath 19365
//Orlando Cabrera 19943

public class Main{
	static Scanner sc = new Scanner(System.in);
	static RadioLo radio = new RadioLo();
	static boolean estado = radio.estado();
	static int n = 0;
	static int i = 0;
	public static void main (String args []){
		if (estado == false) {
			System.out.println("Radio apagado");
			while (n<2 ) {
				do {
					try {
						System.out.println("1.Escuchar musica: ");						
						n = sc.nextInt();
						if (n == 1) {
							break;
						}
					}catch(Exception e) {
						System.out.println("Introduzca correctamente el numero");
						sc.nextLine();
					}
					} 
					while (n > 1||n < 0);
			}
		}
		System.out.println("Radio esta encendido");
		
		while (n<6) {
			do {
				try {
					System.out.println("Escuchando la estacion " + radio.estacionActual());
					System.out.println("¿Que desea hacer?"); 
					System.out.println("1.Avanzar de estacion: ");
					System.out.println("2.Cambiar de emisora (Am, Fm): ");
					System.out.println("3.Guardar estacion actual: ");
					System.out.println("4.Cambiar estacion con alguna guardada: ");
					System.out.println("5.Apagar radio: ");					
					n = sc.nextInt();
					
				}catch (Exception e) {
					System.out.println("Introduzca correctamente el numero");
					sc.nextLine();
				}
			}while (n>6||n<0);
			cuerpo ();
		}
		
		
		 
	}
	public static void cuerpo() {
		if (n == 1) {
			radio.avanzar();
		}
		if (n == 2) {
			radio.cambiarFrecuencia();
		}
		if (n == 3) {
			System.out.println("¿En que boton (1-12) desea guardar la estacion actual? ");
				do {
					try {
						System.out.println("Boton 1");
						System.out.println("Boton 2");
						System.out.println("Boton 3");
						System.out.println("Boton 4");
						System.out.println("Boton 5");
						System.out.println("Boton 6");
						System.out.println("Boton 7");
						System.out.println("Boton 8");
						System.out.println("Boton 9");
						System.out.println("Boton 10");
						System.out.println("Boton 11");
						System.out.println("Boton 12");
						i = sc.nextInt();
						
					}catch (Exception e) {
						System.out.println("Introduzca correctamente el numero");
						sc.nextLine();
					}
				}while (i>13||i<0);
			radio.guardar(i);
			System.out.println(radio.getCancion(i));
		}
		if (n == 4) {
			System.out.println("¿A que emisora (1-12) desea cambiarl? ");
			do {
				try {
					System.out.println("Boton 1");
					System.out.println("Boton 2");
					System.out.println("Boton 3");
					System.out.println("Boton 4");
					System.out.println("Boton 5");
					System.out.println("Boton 6");
					System.out.println("Boton 7");
					System.out.println("Boton 8");
					System.out.println("Boton 9");
					System.out.println("Boton 10");
					System.out.println("Boton 11");
					System.out.println("Boton 12");
					i = sc.nextInt();
					
				}catch (Exception e) {
					System.out.println("Introduzca correctamente el numero");
					sc.nextLine();
				}
			}while (i>13||i<0);
			radio.seleccionarEmisora(i);
		}
	}
}