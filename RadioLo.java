import java.text.DecimalFormat;

//Laura Tamath 19365
//Orlando Cabrera 19943

//import java.util.Random; //Al encenderlo, tira un número aleatorio de alguna estación
public class RadioLo implements InRadio{
	//Declaración de variables
	private boolean encendido;//Indica si la radio esta encendida o apagada
	private String[] estacionAm; //Indica las estacione existentes
	private String[] estacionFm; //Indica las estacione existentes
	private String[] favFM; //guarda las estaciones favoritas de Fm
	private String[] favAm; //guarda las estaciones favoritas de Am
	private boolean amFM; //indica en qué frecuencia est?(true para Am y false para Fm)
	private String estacionActual; //La estacion que esta sonando actualmente
	private int numeroEstacion; // Indica en que numero esta de la estacion (0-19)
	
	public RadioLo () {
		encendido = true;
		estacionAm = new String [20];
		estacionFm = new String [20];
		favAm = new String [12];
		favFM = new String [12];
		estacionActual = "";
		numeroEstacion = 0;
		amFM = true;
		
		
		//Ciclo para crear los nombres de las estaciones
		int a = 600;
		double b = 835;
		int c = 0;
		DecimalFormat df = new DecimalFormat("#.0");
		for (int i = 0; i<estacionAm.length;i++) {
			a += 10;
			estacionAm[i] =  a + " AM";
			
		}
		for (int i = 0; i<estacionFm.length;i++) {
			b += 0.2;
			estacionFm[i] = df.format(b) + " FM";
			
		}
		for (int i = 0; i<favAm.length;i++) {
			c = i + 1;
			favAm[i] = "Estacion " + c + " AM";
			
		}
		for (int i = 0; i<favFM.length;i++) {
			c = i + 1;
			favFM[i] = "Estacion " + c + " AM";
			
		}
		////////////////
	}
	//Metodos------------------------------------------

	@Override
	/*
	 * Muesta la estacion que esta sonando actualmente
	 */
	public String estacionActual() {
		// TODO Auto-generated method stub
		if (amFM == true) {
		estacionActual = estacionAm [numeroEstacion];
		}
		if (amFM == false) {
			estacionActual = estacionFm [numeroEstacion];
			}
		
		return estacionActual;
	}
	@Override
	/*
	 * Metodo para mostrar si la radio esta encendida o apagada
	 */
	public boolean estado() {
		// TODO Auto-generated method stub				
		return encendido;
	}
	@Override
	/**
	 * Metodo para encender o apagar la radio
	 */
	public void onOff() {
		if (encendido == true) {
			encendido = false;
		}
		if (encendido == false) {
			encendido = true;
		}
		
	}
	@Override
	/*
	 * Metodo para cambiar de frecuencia Am a Fm y viceversa
	 */
	public void cambiarFrecuencia() {
		boolean frecuencia = true;
		if (amFM == true) {
			frecuencia = false;
		}
		if (amFM == false) {
			frecuencia = true;
		}
		amFM = frecuencia;
		
	}
	@Override
	public void avanzar() {
		// TODO Auto-generated method stub
		numeroEstacion +=1;
		if (numeroEstacion > 19) {
			numeroEstacion = 0;
		}
		if (amFM == true) {
			estacionActual = estacionAm [numeroEstacion];
		}
		if (amFM == false) {
			estacionActual = estacionFm [numeroEstacion];
		}
		
		
	}
	@Override
	/*
	 * Guarda la estacion que esta sonando actualmente en los botones de "favoritos"
	 */
	public void guardar(int boton) {
		// TODO Auto-generated method stub
		if (amFM == true) {
			favAm [boton - 1] = estacionActual;
		}
		if (amFM == false) {
			favFM [boton - 1] = estacionActual;
		}
		
	}
	@Override
	/**
	 * 
	 * Cambia directamente la estacion con alguna estacion favorita
	 **/
	public void seleccionarEmisora(int boton) {
		if (amFM == true) {
			estacionActual = favAm [boton - 1];
			//Ciclo para cambiar el numero de estacion 
			for (int i = 0; i<estacionAm.length;i++) {
				if (estacionAm[i] == estacionActual) {
					numeroEstacion = i ;
				}
			}
		}
		if (amFM == false) {
			estacionActual = favFM [boton - 1];
			//Ciclo para cambiar el numero de estacion 
			for (int i = 0; i<estacionAm.length;i++) {
				if (estacionAm[i] == estacionActual) {
					numeroEstacion = i;
				}
			}
		}
		
	}
} /////////////////////////////////////////////////////////////