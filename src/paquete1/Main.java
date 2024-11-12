package paquete1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner entrada = new Scanner(System.in);
    	
    	System.out.println("Introduce el numero de hilos simultaneos");
    	int hilosSimultaneos = entrada.nextInt();
    	
    	System.out.println("Introduce el numero de hilos totales");
    	int cantidadDeHilos = entrada.nextInt();
    	
        Semaforo semaforo = new Semaforo(hilosSimultaneos); // Inicialmente un recurso disponible

        HiloEjemplo[] listaHilos = new HiloEjemplo[cantidadDeHilos];
        
        for (int i = 0; i < cantidadDeHilos; i++) {
        	listaHilos[i] = new HiloEjemplo(semaforo);
        }

        for (int j = 0; j < cantidadDeHilos; j++) {
        	listaHilos[j].start();
        }
    }
}