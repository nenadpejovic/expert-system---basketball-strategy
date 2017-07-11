package org.silab.expertsystem.init;

import org.silab.expertsystem.consumer.StatsMessageConsumer;

public class Initializer {
	public static void main(String[] args) {
		Thread thread = new Thread(new StatsMessageConsumer());
		thread.start();
		while(true){
			
		}
	}
}