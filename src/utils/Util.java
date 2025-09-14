package utils;

import java.lang.Thread;
import java.util.concurrent.Semaphore;

public final class Util {
	
// ####################################################
// ##################### PRINTS #######################
// ####################################################
	/**
	 * Prints a message with the current time of the operation.
	 * 
	 * @param message The message that needs to be printed
	 * <p>
	 * @author Roukan
	 */
	public static void printWithTimeStamps(String message) {
		System.out.printf("[%tT] %s%n", System.currentTimeMillis(), message);

	}
	
	/**
	 * Prints an error with the current time of the operation.
	 * 
	 * @param message The error that needs to be printed
	 * <p>
	 * @author Roukan
	 */
	public static void printErrorWithTimeStamps(String message) {
		System.err.printf("[%tT] %s%n", System.currentTimeMillis(), message);

	}
	
	/**
	 * Converts from milliseconds to seconds 
	 * 
	 * @param timeMillis The amount of time in milliseconds
	 * @return Returns the time in seconds as an integer
	 * 
	 * @author Roukan
	 */
	public static int convertToSeconds(int timeMillis) {
		int timeSeconds = timeMillis / 1000;
		return timeSeconds;

	}
	
	 /** Converts from milliseconds to seconds
	 * 
	 * @param timeMillis The amount of time in milliseconds
	 * @return Returns the time in seconds as a double
	 * 
	 * @author Roukan
	 */
	public static double convertToSeconds(double timeMillis) {
		double timeSeconds = timeMillis / 1000.0;
		return timeSeconds;

	}
	
// ####################################################
// ############## RANDOM NUMBERS ######################
// ####################################################

	
	/**
	 * Generate random integers in a range utilizing the Math 
	 * class random() method.
	 *
	 * @param min The minimum value
	 * @param max The maximum value
	 * @return Returns a random number between the minimum and maximum
	 * 
	 * @author Roukan
	 */
	public static int genRandomInteger(int min, int max) {
		int randomNumber = (int) (Math.random() * (max - min + 1) + min);
		return randomNumber;

	}
	
	/**
	 * Generate random integers between 0 and a maximum value utilizing the Math 
	 * class random() method.
	 *
	 * @param max The maximum value
	 * @return Returns a random number between the minimum and maximum
	 * 
	 * @author Roukan
	 */
	public static int genRandomInteger(int max) {
		int randomNumber = (int) (Math.random() * (max + 1));
		return randomNumber;

	}

// ####################################################
// ##################### THREADS ######################
// ####################################################
	/**
	 * Gets the id of the current thread and converts it to an integer
	 * 
	 * @return The thread id in Integer format
	 * 
	 * @author Roukan
	 */
	public static int threadIdInt() {
		Thread thread = Thread.currentThread();
		return (int) thread.getId();
		
	}
	
	/**
	 * Gets the id of the current thread
	 * 
	 * @return The thread id in Long format
	 * 
	 * @author Roukan
	 */
	public static long threadId() {
		Thread thread = Thread.currentThread();
		return thread.getId();

	}
	
	/**
	 * Makes the thread sleep for the amount of time in milliseconds
	 * 
	 * @param time The time in milliseconds
	 */
	public static void sleep(int time) {
		if (time < 0) {
			throw new IllegalArgumentException("Tempo não pode ser menor do que 0 cara de mamão (° - °)");
		}
		Thread thread = Thread.currentThread();
		try {
			Thread.sleep(time);
			
		} catch (InterruptedException e) {
			thread.interrupt();
			throw new RuntimeException("Thread Interrompida");
			
		}
	}
	
	/**
	 * A generic error handler to run threads and stop others from coming 
	 * through until the semaphore (from the Semaphore class) is available
	 * 
	 * @param method The method that needs to be handled
	 * @param stop The semaphore with the amount of threads that can pass through
	 * 
	 * @author Roukan
	 */
	public static void genericCriticalSessionHandler(Runnable method, Semaphore stop) {
		Thread thread = Thread.currentThread();
		try {
			printWithTimeStamps("Thread #"+threadIdInt()+" esta tentando realizar uma operacao...\n");
			stop.acquire();
			method.run();
			printWithTimeStamps("Thread #"+threadIdInt()+" finalizou uma operacao...");
			
		} catch (InterruptedException e) {
			thread.interrupt();
			throw new RuntimeException("Thread Interrompida");
			
		} finally {
			stop.release();
			printWithTimeStamps("Thread #"+threadIdInt()+ " liberou espaco para outras threads...\n");
			
		}
	}

}
