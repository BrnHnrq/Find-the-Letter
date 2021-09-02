package main;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Random rnd = new Random();
			boolean play = true;

			System.out.println("Welcome!");

			while (play == true) {

				System.out.println("First, how many rows and line you want? ");
				int row = sc.nextInt();

				while (row == 1) {
					if (row == 1) {
						System.out.println("Number too low, try again: ");
						row = sc.nextInt();
					}
				}
				String[][] rows = new String[row][row];

				for (int i = 0; i < rows.length; i++) {
					for (int j = 0; j < rows[i].length; j++) {
						rows[i][j] = "I ";
					}
				}

				rows[rnd.nextInt(row)][rnd.nextInt(row)] = "l ";

				generator(rows);

				System.out.println("Where's the @ ?");
				int c = sc.nextInt();
				int l = sc.nextInt();

				if (rows[c][l].equals("l ")) {
					System.out.println("Congratulations, you found it!");
				} else {
					System.out.println(rows[c][l]);
					System.out.println("Too bad! you missed it!");
					System.out.println("The l was in ");
				}
				System.out.println("Want to play again? yes / no ");
				sc.nextLine();
				String option = sc.nextLine();
				if (option.equals("yes") || option.equals("Yes")) {
					System.out.println("Restarting the game... \n\n\n\n\n");
				} else if (option.equals("no") || option.equals("No")) {
					play = false;
				} else {
					System.out.println("What?? let's play again then... \n\n\n\n\n");
				}
			}

			System.out.println("Application now closing...");
			sc.close();

		} catch (RuntimeException e) {
			System.out.println("Error! Closing the application...");
		}
	}

	public static void generator(String[][] rows) {
		System.out.println("\n \n");
		for (int x = 0; x < rows.length; x++) {
			for (int l = 0; l < rows[x].length; l++) {
				System.out.print(rows[x][l]);
			}
			System.out.println();

		}
	}
}