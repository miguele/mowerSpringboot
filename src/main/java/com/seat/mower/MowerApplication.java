package com.seat.mower;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seat.mower.model.Mower;

@SpringBootApplication
public class MowerApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(MowerApplication.class, args);
	}

	/**
	 * Command line process to declare and move mowers
	 */
	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);
		String finalPoint = "";
		boolean exit = false;
		finalPoint = scanner.nextLine();

		while (!exit) {
			Mower mower = setMower(scanner);
			moveMower(scanner, mower);
			System.out.println(mower.toString());
			exit = askAnotherMower(scanner);
		}

		scanner.close();
	}

	private boolean askAnotherMower(Scanner scanner) {
		System.out.println("Do you to declare and move another mower? (Press S if you want another mower) \n");
		String option = scanner.nextLine();
		if (option != null && option.equalsIgnoreCase("S")) {
			return false;
		} else {
			return true;
		}
	}

	private void moveMower(Scanner scanner, Mower mower) {
		String movements;
		movements = scanner.nextLine();
		char[] movementsArray = getCharArrayFromString(movements);
		mower.move(movementsArray);
	}

	private Mower setMower(Scanner scanner) {
		String mowerValues;
		mowerValues = scanner.nextLine();
		char[] mowerArray = getCharArrayFromString(mowerValues);
		Mower mower = new Mower(Character.getNumericValue(mowerArray[0]), Character.getNumericValue(mowerArray[1]),
				mowerArray[2]);
		return mower;
	}

	private char[] getCharArrayFromString(String stringValue) {
		stringValue = stringValue.replaceAll("\\s+", "");
		return stringValue.toUpperCase().toCharArray();
	}
}