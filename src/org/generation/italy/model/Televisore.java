package org.generation.italy.model;

import java.lang.reflect.Array;

public class Televisore {
	/*
	 * i seguenti metodi:



void accendi()  //cambia lo stato a true (acceso) e imposta il canale corrente a 1
void spegni()
void aumentaVolume(): incrementa (se possibile) il volume di 1
void diminuisciVolume(): decrementa (se possibile) il volume di 1
boolean cambiaCanale(int canale): //imposta (se possibile) il canale corrente. Se è stato possibile cambiare il canale restituisce true, altrimenti false
String mostraCanale()  //restituisce la stringa "Stai guardando il canale <nomeCanale>"
void visualizzaElencoCanali()   //mostra l'elenco dei canali
ogni attributo è incapsulato (private)
per ogni attributo generare un metodo getter
generare un metodo setter per l'attributo modalitàHotel 
generare un metodo toString() per visualizzare tutti gli attributi della classe (tranne l'elencoCanali)
 
	 */
	private String marca;
	private String modello;
	private int nrPollici;
	private boolean stato;
	private int volume;
	private boolean modalitaHotel;
	private String[] elencoCanali= {"Rai 1", "Rai 2", "Rai 3", "Rete 4", "Canale 5", "Italia 1", "La 7", "TV8", "Nove", "Canale 10"};
	private String canaleCorrente;
	
	public Televisore (String marca, String modello, int nrPollici) throws Exception {
		if (!marca.isEmpty()) {
			this.marca=marca;
		}
		if (!modello.isEmpty()) {
			this.modello=modello;
		}
		if (nrPollici>0) {
			this.nrPollici=nrPollici;
		}
		
		this.stato=false;
		this.canaleCorrente=elencoCanali[0];
		this.modalitaHotel=false;
		this.volume=0;
	}
	
	public Televisore (String marca, String modello, int nrPollici, boolean modalitaHotel) throws Exception {
		if (!marca.isEmpty()) {
			this.marca=marca;
		}
		if (!modello.isEmpty()) {
			this.modello=modello;
		}
		if (nrPollici>0) {
			this.nrPollici=nrPollici;
		}
		this.stato=false;
		this.canaleCorrente=elencoCanali[0];
		this.modalitaHotel=modalitaHotel;
		this.volume=0;
	}
	
	public void accendi () {
		if (this.stato=false) {
			this.stato=true;
			this.canaleCorrente=elencoCanali[0];
		} else {
			System.out.println("Televisione già accesa");
		}
	}
	
	public void spegni() {
		if (this.stato=true) {
			this.stato=false;
		} else {
			System.out.println("Televisione già spenta");
		}
	}
	
	public void aumentaVolume () {
		int volumeMax;
		if (modalitaHotel==true) {
			volumeMax=5;
		} else {
			volumeMax=10;
		}
		
		if (this.stato=true) {
			if (this.volume>=volumeMax) {
				System.out.println("Il volume è già al massimo");
			} else {
				this.volume++;
				System.out.println("Volume: "+this.volume);
			}
		}
	}
	
	public void diminuisciVolume () {
		if (this.stato=true) {
			if (this.volume==0) {
				System.out.println("Il volume è già al minimo");
			} else {
				this.volume--;
				System.out.println("Volume: "+this.volume);
			}
		}
	}
	
	public boolean cambiaCanale (String canale) {
		boolean cambiato=false;
		if (!this.canaleCorrente.equals(canale)) {
			for (int i = 0; i<10; i++) {
				if (this.elencoCanali[i].equals(canale)) {
					this.canaleCorrente=canale;
					cambiato=true;
				}
			}
		} else {
			System.out.println("Sei già su questo canale");
		}
		
		return cambiato;
	}
	
	public String mostraCanale () {
		String messaggio="Stai guardando il canale "+this.canaleCorrente;
		return messaggio;
	}
	
	public void visualizzaElencoCanali() {
		System.out.println("Elenco canali:");
		for (int j=0; j<10; j++) {
			System.out.println("Canale "+ this.elencoCanali[j]);
		}
	}

	public boolean isModalitaHotel() {
		return modalitaHotel;
	}

	public void setModalitaHotel(boolean modalitaHotel) {
		this.modalitaHotel = modalitaHotel;
	}

	public String getMarca() {
		return marca;
	}

	public String getModello() {
		return modello;
	}

	public int getNrPollici() {
		return nrPollici;
	}

	public boolean isStato() {
		return stato;
	}

	public int getVolume() {
		return volume;
	}

	public String getCanaleCorrente() {
		return canaleCorrente;
	}

	@Override
	public String toString() {
		return "Televisore [marca=" + marca + ", modello=" + modello + ", nrPollici=" + nrPollici + ", stato=" + stato
				+ ", volume=" + volume + ", modalitaHotel=" + modalitaHotel + ", canaleCorrente=" + canaleCorrente
				+ "]";
	}
	
	
}
