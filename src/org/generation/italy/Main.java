package org.generation.italy;

import java.util.Scanner;

import org.generation.italy.model.Televisore;

public class Main {

	public static void main(String[] args) {
		/* TODO :
		 * 	- Aggiungere classe canali
		 */
		Scanner sc= new Scanner(System.in);
		Televisore tv;
		int nrPollici=0;
		
		System.out.println("Creazione televisione\nInserire i dati");
		
		System.out.print("Inserire la marca: ");
		String marca=sc.nextLine();
		System.out.print("Inserire il modello: ");
		String modello=sc.nextLine();
		do {
			try {
				System.out.print("Inserire numero pollici: ");
				nrPollici=Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.err.println("Attenzione! Inserimento non valido! Premere INVIO per riprovare.");
				sc.nextLine();
			}
		} while (nrPollici==0);
		System.out.println("La TV è dotata di modalità hotel?");
		String risposta=sc.nextLine().toLowerCase();
		while (!(risposta.equals("si"))&&!(risposta.equals("sì"))&&!(risposta.equals("no"))) {
			System.out.println("Non ho capito, la TV è dotata di modalità hotel?");
			risposta=sc.nextLine().toLowerCase();
		}
		if (risposta.equals("si")||risposta.equals("sì")) {
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
			System.out.println("\n"+tv.toString()+"\n");
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
				if (tv.cambiaCanale(sc)) {
					System.out.println("Canale cambiato a "+tv.getCanaleCorrente());
				}
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


