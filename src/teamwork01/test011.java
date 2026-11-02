package teamwork01;

import java.io.FileInputStream;
import java.util.Scanner;

import javazoom.jl.player.Player;

public class test011 {
	public static void main(String[] args) throws Exception {
		String RESET = "\u001B[0m";
		String RED = "\u001B[31m";
		String GREEN = "\u001B[32m";
		String YELLOW = "\u001B[33m";
		String BLUE = "\u001B[34m";

		Scanner scan = new Scanner(System.in);

		System.out.println("+---------------------------------------+");
		System.out.println("+       SCHOOL DETECTIVE EASY GAME      +");
		System.out.println("+         THE MISSING TROPHY           +");
		System.out.println("+---------------------------------------+\n");

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String story = "Today is the school festival.\n"
				+ "But the lucky trophy has disappeared.\n\n"
				+ "You are the school detective.\n"
				+ "Find the missing trophy!";

		for (int i = 0; i < story.length(); i++) {

			System.out.print(BLUE + story.charAt(i));

			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(RESET);

		boolean memoFound = false;
		boolean keyFound = false;
		boolean footprintFound = false;

		while (true) {

			System.out.println("+---------------------------------------+");
			System.out.println("|              ACTION MENU             |");
			System.out.println("+---------------------------------------+");
			System.out.println("| 1. Investigate Library               |");
			System.out.println("| 2. Investigate Classroom             |");
			System.out.println("| 3. Investigate Gym                   |");
			System.out.println("| 4. View Clues                        |");
			System.out.println("| 5. Find the Trophy                   |");
			System.out.println("| 6. Exit                              |");
			System.out.println("+---------------------------------------+");
			int choice = scan.nextInt();

			switch (choice) {

			case 1:

				if (!memoFound) {
					System.out.println("🔍 Searching in Library...");
					System.out.println();

					System.out.print("[");

					for (int i = 0; i < 20; i++) {

						System.out.print("█");

						try {
							Thread.sleep(150);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					System.out.println("] 100%");
					System.out.println();

					while (true) {

						System.out.println(YELLOW + "Slove The Puzzle！" + RESET);
						System.out.println();

						System.out.println("20 18 15 16 8 25");
						System.out.println("Hint:T=20");
						System.out.print("Answer: ");

						String answer = scan.next();

						if (answer.equalsIgnoreCase("TROPHY")) {

							System.out.println();

							victorysong1();
							System.out.println(GREEN + "🎉 Correct！" + RESET);
							System.out.println("📝 Memo Found！");
							//System.out.println("『トロフィーは特別な場所にある』");

							String memo = "『The trophy is hidden in a special place.』";
							for (int i = 0; i < memo.length(); i++) {

								System.out.print(YELLOW + memo.charAt(i));

								try {
									Thread.sleep(30);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							System.out.println(RESET);

							memoFound = true;
							break;

						} else {

							failsong1();

							System.err.println("❌ Wrong Answer！");
						}

					}
				} else {

					System.out.println("You have already sloved it。");
				}
				break;

			case 2:

				if (!keyFound) {
					System.out.println("🔒 You found a key box!");
					System.out.println("But it is locked...");
					System.out.println();
					while (true) {
						System.out.println(YELLOW + "Math Skill Test！" + RESET);
						System.out.println();
						System.out.println("Question:");
						System.out.println("25 24 22 19 15 ?");
						System.out.print("Answer: ");
						int answer = scan.nextInt();

						if (answer == 10) {

							System.out.println();

							victorysong1();

							System.out.println(GREEN + "🎉 Correct！");
							System.out.println("🔑 You found the key！" + RESET);
							keyFound = true;
							break;

						} else {

							System.out.println();

							failsong1();
							System.err.println("❌ Wrong Answer！");

							System.out.println("Try Again。");
						}
					}
				} else {
					System.out.println("You have already sloved it。");
				}

				break;

			case 3:

				if (!footprintFound) {
					System.out.println(" You found the footprint!You need a key...");
					footprintFound = true;
				} else {
					System.out.println("You have already sloved it。");
				}
				break;

			case 4:

				System.out.println(GREEN + "[    Collected Clues    ]" + RESET);

				if (memoFound)
					System.out.println(GREEN + "✅Memo" + RESET);

				if (keyFound)
					System.out.println(GREEN + "✅Key" + RESET);

				if (footprintFound)
					System.out.println(GREEN + "✅Footstep" + RESET);

				break;

			case 5:

				if (memoFound && keyFound && footprintFound) {

					System.out.println();

					victorysong1();
					System.out.println(GREEN);

					System.out.println("+--------------------------------------+");
					System.out.println("+            🎉 GAME CLEAR 🎉         +");
					System.out.println("+--------------------------------------+");
					System.out.println();

					System.out.println("🏆🏆🏆 You found the trophy!");
					System.out.println();
					System.out.println("Ryo hid the trophy as a surprise");
					System.out.println("for the school festival.");
					System.out.println();
					System.out.println("Nobody did anything wrong.");
					System.out.println("Everyone enjoyed the festival!");
					System.out.println();
					System.out.println("✨ HAPPY END ✨");
					System.out.println();
					System.out.println(RESET);

				} else {

					System.out.println();

					failsong1();
					System.out.println("+--------------------------------------+");
					System.out.print("+          ");
					System.err.print("❌ NOT ENOUGH CLUES");
					System.out.println("		+");
					System.out.println("+--------------------------------------+");
					System.out.println();

					System.out.println("You have not collected all clues");
					System.out.println("Keep investigating。");
				}

				break;

			case 6:
				return;

			default:
				System.out.println("Try Again");
			}

		}

	}

	public static void failsong1() throws Exception {
		FileInputStream fis = new FileInputStream("freesound_community-buzzer2-6109.mp3");

		Player player = new Player(fis);
		player.play();
	}

	public static void victorysong1() throws Exception {
		FileInputStream fis = new FileInputStream(
				"jesuschristisgod-children-saying-yay-praise-and-worship-jesus-299607.mp3");

		Player player = new Player(fis);
		player.play();
	}
}
