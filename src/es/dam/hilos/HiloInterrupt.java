package es.dam.hilos;

import sun.management.VMOptionCompositeData;

public class HiloInterrupt implements Runnable{

	private Thread miHilo;
	private volatile boolean vivo; // garantizamos lecturas no cacheadas
	
	public HiloInterrupt() {
		miHilo = new Thread(this, "hilo hijo");
		miHilo.start();
		this.vivo = true;
	}
	
	public void detener(){
		this.vivo = false;
		// TENTACION: this.miHilo.stop(); Desaconsejado usar
	}
	
	public void interrumpir() {
		if (this.miHilo != null) {
			this.miHilo.interrupt();
		}	
	}
	
	public boolean getVivo(){
		return this.vivo;
		// return this.mihilo.isAlive();
	}
	
	public void esperar() throws InterruptedException {
		this.miHilo.join();
	}
	
	@Override
	public void run() {
		System.out.println("Corriendo el hilo ahora...");
		
		while (this.vivo) {
			System.out.println("El hilo va a dormir un rato...");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("El hilo hijo ha sido interrumpido...");
			}
		}
		
		System.out.println("Hilo finalizado y saliendo de forma ordenada...");
	}

}
