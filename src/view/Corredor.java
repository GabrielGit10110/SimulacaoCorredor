package view;

import java.util.concurrent.Semaphore;

import controller.CorredorCtrl;

public class Corredor {

	public static void main(String[] args) {
		int person = 0;
		Semaphore mutex = new Semaphore(1);
		
		for (person = 0; person < 4; person++) {
			CorredorCtrl newPerson = new CorredorCtrl(mutex);
			newPerson.start();
			
		}

	}

}
