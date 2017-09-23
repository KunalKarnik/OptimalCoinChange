package OptimalCoinChange;

import java.io.*;
import java.util.*;

/*
 * Kunal A. Karnik
 * Dynamic Programming brush up
 * The minimum coin change problem , give it a shot!
 */

public class OptimalCoinChangeProblem {

	private int coins[];
	private int used[];
	private int no[];
	private int n;
	private int amount;

	public static void main(String[] args) throws IOException {
		OptimalCoinChangeProblem ob = new OptimalCoinChangeProblem(true);
		while (true) {
			try {
				ob.getCurrencySystem();
			} catch (Exception e) {
				System.out.println("I guess you did this!\n" + e.toString());
				System.out.println("\n\tBut thats all right; try again!\n\n");
				continue;
			}
			break;
		}
		ob.run();
		System.out.println("That's all Folks!");
	}

	void run() {
		if (OptimalbreakDown()) {
			displayOptput();
		} else {
			System.out.println(
					amount + " cannot be converted to change using only " + Arrays.toString(coins) + " coins!");
		}
	}

	private void getCurrencySystem() {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter the number of types of coins you have --> ");
		n = in.nextInt();
		coins = new int[n];
		System.out.println("Please enter an the denominations ");
		for (int i = 0; i < n; i++)
			coins[i] = in.nextInt();
		System.out.println("Please enter an amount to find its Optimal change in " + Arrays.toString(coins) + ": ");
		amount = in.nextInt();
		in.close();
	}

	private void displayOptput() {
		System.out.print(
				amount + " can be conver to change with a minimum of " + no[amount] + " coins.\n" + amount + " --> ");
		int temp = amount;
		while ((temp - coins[used[temp]]) > 0) {
			System.out.print(coins[used[temp]] + ", ");
			temp -= coins[used[temp]];
		}
		System.out.println(coins[used[temp]] + ".");
	}

	private boolean OptimalbreakDown() {
		int l = coins.length;
		used = new int[amount + 1];
		no = new int[amount + 1];
		for (int i = 0; i <= amount; i++) {
			used[i] = -1;
			no[i] = Integer.MAX_VALUE - 2;
		}
		no[0] = 0;
		for (int i = 0; i < l; i++) {
			for (int j = 1; j <= amount; j++) {
				if (j - coins[i] >= 0) {
					if (no[j] > (1 + no[j - coins[i]])) {
						no[j] = (1 + no[j - coins[i]]);
						used[j] = i;
					}
				}
			}
		}
		if (used[amount] == -1) {
			return false;
		}
		return true;
	}

	OptimalCoinChangeProblem(boolean isTest) {
		if (!isTest) {
			coins = new int[] { 7, 2, 3, 6 };
			n = 4;
			amount = 13;
			used = new int[amount + 1];
			no = new int[amount + 1];
			for (int i = 0; i <= amount; i++) {
				used[i] = -1;
				no[i] = Integer.MAX_VALUE - 2;
			}
		}
	}
	
	int getMinNumberOfCoins() {
		return used[amount];
	}
}