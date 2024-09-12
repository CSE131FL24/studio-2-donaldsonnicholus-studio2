package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("What is the starting amount?");
		double startAmount = in.nextDouble();
		System.out.println("What is the win chance?");
		double winChance = in.nextDouble();
		System.out.println("What is the win limit?");
		double winLimit = in.nextDouble();
		System.out.println("How many simulations do you want to run?");
		double simulations = in.nextDouble();
		int numLosses = 0;
		for (int i = 1; i <= simulations; i++) {
			double money = startAmount;
			int gamesPlayed = 0;
			while ((money > 0) && (money < winLimit)) {
				double chance = Math.random();
				if (chance <= winChance) {
					money++;
					gamesPlayed++;}
				else {
					money--;
					gamesPlayed++;}
				}
			if (money == 0) {
				numLosses++;
				System.out.println("Simulation " + i + ": " + gamesPlayed + " LOSS");
			}
			if (money == winLimit) {
				System.out.println("Simulation " + i + ": " + gamesPlayed + " WIN");

			}
			
		}
		System.out.println("Losses: " + numLosses + " Simulations: " + simulations);
		double ruinRate = numLosses / simulations;
		double expectedRuinRate;
		double a = ((1 - winChance) / (winChance));
		if (winChance == 0.5) {
			expectedRuinRate = (1 - (startAmount / winLimit));
		}
		else {
			expectedRuinRate = (Math.pow(a, startAmount) - Math.pow(a, winLimit)) / (1 - Math.pow(a, winLimit));
		}
		System.out.println("Ruin Rate from Simulation: " + ruinRate + " Expected Ruin Rate: " + expectedRuinRate);
	}

}
