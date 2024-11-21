package paquete1;
class Semaforo {
    private int contador;
    
    
    public Semaforo(int contadorInicial) {
        this.contador = contadorInicial;
        
    }

    public synchronized void espera() throws InterruptedException {
        // Decrementamos el contador y comprobamos si es negativo
        while (contador <= 0) {
        	long startTime = System.nanoTime();
            wait(); // Esperar hasta que haya un recurso disponible
            long waitTime = System.nanoTime() - startTime; // Tiempo de espera en nanosegundos
            System.out.println("Tiempo esperando en el bloque synchronized: " + waitTime + " nanosegundos");
        }
        contador--; // Consumir un recurso
    }

    public synchronized void senal() {
        contador++; // Liberar un recurso
        notify(); // Notificar a un hilo en espera, si hay alguno
        
    }
}