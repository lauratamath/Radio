import java.util.Scanner;

//Laura Tamath 19365
//Orlando Cabrera 19943

public class Main{
	static Scanner sc = new Scanner(System.in);
	static InRadio radio = new RadioLo();
	//public Vista view = Vista();
	static boolean estado = radio.estado();
	static int n = 0;
	static int i = 0;
	static int k;
	static boolean active = true;
	public static void main (String args []){
		if (estado == false) {
			System.out.println("Radio apagado");
			
				do {
					try {
						System.out.println("1.Escuchar musica: ");						
						n = sc.nextInt();
						radio.onOff();
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
		
		System.out.println("Radio esta encendido");
		
		while (n<6) {
			do {
				try {
					System.out.println("Escuchando la estacion " + radio.estacionActual());
					System.out.println("Que desea hacer?"); 
					System.out.println("1.Avanzar de estacion");
					System.out.println("2.Cambiar de emisora (Am, Fm)");
					System.out.println("3.Guardar estacion actual");
					System.out.println("4.Cambiar estacion con alguna guardada");
					System.out.println("5.Apagar radio: \n");	
					System.out.println("\t\t---------------------");				
					n = sc.nextInt();
					System.out.println("\n");
					
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
			System.out.println("En que boton (1-12) desea guardar la estacion actual? ");
			System.out.println("\t\t--------------------");
				do {
					try {
						System.out.println("Boton 1-12\nBoton 2\nBoton 3\nBoton 4\nBoton 5\nBoton 6\nBoton 7\nBoton 8");
					System.out.println("Boton 9 \nBoton 10\nBoton 11\nBoton 12\n");
						i = sc.nextInt();
						System.out.println("Guardado con exito en el boton " +i);
						
					}catch (Exception e) {
						System.out.println("Introduzca correctamente el numero");
						sc.nextLine();
					}
				}while (i>13||i<0);
			radio.guardar(i);
		}
		if (n == 4) {
			System.out.println("A que emisora (1-12) desea cambiarl? ");
			do {
				try {
					System.out.println("Boton 1-12\nBoton 2\nBoton 3\nBoton 4\nBoton 5\nBoton 6\nBoton 7\nBoton 8");
					System.out.println("Boton 9 \nBoton 10\nBoton 11\nBoton 12\n");
					i = sc.nextInt();
					System.out.println("Guardado con exito en el boton " +i);
				}catch (Exception e) {
					System.out.println("Introduzca correctamente el numero");
					sc.nextLine();
				}
			}while (i>13||i<0);
			radio.seleccionarEmisora(i);

		}
		if (n == 5) {
			while (active){
			System.out.println("Esta seguro que quiere apagarlo, escriba el numero?\n1. Si\n2.No");

			k = sc.nextInt();
			
				if(k==1){
					radio.onOff();
					n =6;
					active = false;
				}
				else if(k==2){
					System.out.println("Se omitira esta decision");
					active = false;
				}
				else{
					System.out.println("Opcion invalida");	
				}
			}
			active = true;
		}
	}
}
