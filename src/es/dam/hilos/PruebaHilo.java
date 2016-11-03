package es.dam.hilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PruebaHilo {

	public static void main(String[] args) throws IOException, InterruptedException {
		HiloInterrupt hilo = new HiloInterrupt();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String tecla;
		
		while (hilo.getVivo()) {
			System.out.println("Hilo vivo, {i} interrumpir, {k} matar: ");
			tecla = br.readLine();			
			if (tecla.equals("i")) {
				hilo.interrumpir();
			}
			if (tecla.equals("k")) {
				hilo.detener();
			}
		}
		
		hilo.esperar();
		System.out.println("Hilo principal finalizado!");
		
	}

}
