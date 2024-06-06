package org.generation.italy;

import java.util.Scanner;

import org.generation.italy.model.Televisore;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		Televisore tv;
		
		System.out.println("Creazione televisione\nInserire i dati");
		
		System.out.print("Inserire la marca: ");
		String marca=sc.nextLine();
		System.out.print("Inserire il modello: ");
		String modello=sc.nextLine();
		System.out.print("Inserire numero pollici: ");
		int nrPollici=sc.nextInt();
		sc.nextLine();
		System.out.println("La TV è dotata di modalità hotel?");
		String risposta=sc.nextLine();
		if (risposta.equals("si")) {
			boolean modalitaHotel=true;
			try {
					
				tv=new Televisore (marca, modello, nrPollici, modalitaHotel);
				controlloTv(tv, sc);
					
			} catch (Exception e) {
				System.err.print("Impossibile creare la televisione! "+e.getMessage());
			}
		} else {
			try {
					
				tv=new Televisore (marca, modello, nrPollici);	
				controlloTv(tv, sc);
					
			} catch (Exception e) {
				System.err.print("Impossibile creare la televisione! "+e.getMessage());
			}
		}
				
	}
	public static void controlloTv (Televisore tv, Scanner sc) {
		String scelta;
		System.out.println("--- Controllo televisore ---");
		do {
			System.out.println("\n\n\n\nScegli l'operazione da eseguire:");
			System.out.println("1) On/Off\n2) Aumenta volume\n3) Diminuisci volume\n4) Cambia canale\n5) Mostra canale\n6) Visualizza elenco canali\n7) Esci");
			scelta=sc.nextLine();
			switch (scelta) {
			case "1":
				tv.accendiSpegni();
				break;
				
			case "2":
				tv.aumentaVolume();
				break;
				
			case "3":
				tv.diminuisciVolume();
				break;
			
			case "4":
				System.out.println("Quale canale vuoi vedere?");
				String canale=sc.nextLine();
				tv.cambiaCanale(canale);
				break;
				
			case "5":
				String messaggio = tv.mostraCanale();
				System.out.println(messaggio);
				break;
				
			case "6":
				tv.visualizzaElencoCanali();
				break;
				
			case "7":
				System.out.println("Arrivederci!");
				break;
				
			default:
				System.out.println("Inserimento non valido!");
			}
		} while (!scelta.equals("7"));
	}
}


