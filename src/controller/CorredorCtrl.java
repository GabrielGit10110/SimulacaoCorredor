package controller;

import java.util.concurrent.Semaphore;

import utils.Util;

public class CorredorCtrl extends Thread {
	private static final int corridorSize = 200;
	private static final String[] corridors = {"Setor A",
										   	   "Setor B",
										   	   "Setor C",
										   	   "Setor D"
										  	  };
	private static int[] avaibleCorridos = {1, 1, 1, 1}; 

	String corridor = "";
	private Semaphore mutex;
	
	public CorredorCtrl(Semaphore mutex) {
		this.mutex = mutex;
		
	}
	
	// default constructor
	public CorredorCtrl() {
		this.mutex = new Semaphore(1);
	}
	
	@Override
	public void run() {
		selectCorridor();
		walk();
		Util.genericCriticalSessionHandler(this::openDoor, mutex);
		
	}
	
	private void selectCorridor() {
		int randomCorridor = 0;
		
		do {

			randomCorridor = Util.genRandomInteger(3);
		} while (avaibleCorridos[randomCorridor] < 1);

		avaibleCorridos[randomCorridor]--;
		corridor = corridors[randomCorridor];

		
	}

	private void walk() {
		int traveledDistance = 0;
		int step = 0;
		int minStep = 4;
		int maxStep = 6;
		int time = 1000;
		
		Util.printWithTimeStamps("Pessoa: "+getId()+" esta andando no "+corridor);
		while (traveledDistance < corridorSize) {
			step = Util.genRandomInteger(minStep, maxStep);
			
			traveledDistance += step;
			
			Util.sleep(time);
			
		}
		Util.printWithTimeStamps("Pessoa: "+getId()+" chegou ate a porta...");

	}
	
	private void openDoor() {
		int minTime = 1000;
		int maxTime = 2000;
		int timeTaken = Util.genRandomInteger(minTime, maxTime);
		double timeTakenSeconds = Util.convertToSeconds((double)timeTaken);

		Util.printWithTimeStamps("Pessoa: "+getId()+" esta abrindo a porta...");
		Util.sleep(timeTaken);
		
		Util.printWithTimeStamps("Pessoa: "+getId()+" abriu a porta e foi embora!"+
								" Levou "+timeTakenSeconds + " segundos para abrir a porta.");
		
	}

}
