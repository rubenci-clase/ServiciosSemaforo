package paquete1;

import java.util.Random;

class HiloEjemplo extends Thread {
    private final Semaforo semaforo;
    Random random = new Random();
    public HiloEjemplo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    public void run() {
        try {
            semaforo.espera();
            //System.out.println(Thread.currentThread().getName() + " se esta ejecutando.");
            
            Thread.sleep(1000 + random.nextInt(100,900));
            
            System.out.println(Thread.currentThread().getName() + " se acabo de ejecutar.");
            semaforo.senal();
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}