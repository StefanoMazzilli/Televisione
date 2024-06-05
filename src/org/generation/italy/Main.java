package org.generation.italy;

import java.util.Scanner;

import org.generation.italy.model.Televisore;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		String scelta;
		
		System.out.println("Scegli cosa vuoi fare");
		System.out.println("1) Crea televisione\n2) Controlla una televisione esistente\n3) Esci");
		scelta=sc.nextLine();
		switch (scelta) {
		case "1":
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
					Televisore tv=new Televisore (marca, modello, nrPollici, modalitaHotel);
				} catch (Exception e) {
					System.err.print("Impossibile creare la televisione "+e.getMessage());
				}
			}
		}
		
	}

}
