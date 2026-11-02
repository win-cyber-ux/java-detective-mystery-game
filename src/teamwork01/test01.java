package teamwork01;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javazoom.jl.player.Player;

public class test01 {

	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);

		ArrayList<String> clues = new ArrayList<>();
		boolean sceneInvestigated = false;
		boolean cameraInvestigated = false;
		boolean wifeInterviewed = false;
		boolean partnerInterviewed = false;
		boolean secretaryInterviewed = false;
		boolean developerInterviewed = false;

		String murderer = "Secretary";

		System.out.println("=================================================");
		System.out.println("Detective Game");
		System.out.println("=================================================");

		System.out.println(
				"Mr. Yamada, CEO of a tech startup, is found dead in his" + "\n" + "locked office at June 1, 10:31PM."
						+ "\n"
						+ " Police suspect suicide, but a deleted email hints at foul play.\n"
						+ "\n"
						+ "Four suspects had motives:\n"
						+ "\n"
						+ "Yuki Yamada (wife) — hiding a major secret\n"
						+ "Ken Sato (partner) — fighting over company ownership\n"
						+ "Mika Suzuki (secretary) — recently had problems with management\n"
						+ "Ryo Nakamura (developer) — claims stolen credit\n"
						+ "\n"
						+ "Key evidence emerges: a deleted email, a missing office key, security footage," + "\n"
						+ "and suspicious statements." + "\n"
						+ "Everyone is hiding something—but only one is the killer.");
		play2();
		scan.nextLine();

		while (true) {
			System.out.println("\nWhat would you like to do?");
			System.out.println("1.Investigate the Crime Scene");
			System.out.println("2.Watch the Cameras");
			System.out.println("3.Interview the Wife");
			System.out.println("4.Phone call the Partner");
			System.out.println("5.Interview the Secretary");
			System.out.println("6.Interview the developer");
			System.out.println("7.View the Clues");
			System.out.println("8.Accuse Someone");
			int choice = scan.nextInt();

			switch (choice) {

			case 1:
				if (!sceneInvestigated) {

					System.out.println("\nYou found");
					System.out.println("- Text Message from Wife:(We are settling this tonight)");
					System.out.println("- Deleted Document");
					System.out.println("- An angry email from Ryo");
					System.out.println("- A missing spare key");

					clues.add("Text Message");
					clues.add("Deleted Document");
					clues.add("Angry Email");
					clues.add("Missing key");

					sceneInvestigated = true;
				} else {
					System.out.println("You already investigated the scene");
				}
				break;

			case 2:
				if (!cameraInvestigated) {

					System.out.println("\nYou saw");
					System.out.println("- Camera disabled from 10:25PM to 10:40PM");
					System.out.println("- Camera was disabled from Yamada's Office");
					System.out.println("- Ken(Partner) entering the company at 10:15PM");
					System.out.println("- Mysterious figure exiting building at 10:42PM");

					clues.add("Camera disabled");
					clues.add("Ken entering company");
					clues.add("Mysterious figure");

					cameraInvestigated = true;
				} else {
					System.out.println("You already investigated the camera");
				}
				break;

			case 3:
				if (!wifeInterviewed) {

					System.out.println("\nWife:");
					System.out.println("I was at home all evening");
					clues.add("Wife claims she was at home");
					wifeInterviewed = true;

				} else {
					System.out.println("You have already interviewed the wife");
				}
				break;

			case 4:
				if (!partnerInterviewed) {

					System.out.println("\nPartner:");
					System.out.println("I was on a leave from work");

					clues.add("Business Partner was not working");
					partnerInterviewed = true;
				} else {
					System.out.println("You have already called the Partner");
				}
				break;

			case 5:
				if (!secretaryInterviewed) {
					System.out.println("\nSecretary:");
					System.out.println("I left work at 9PM and went straight home");

					clues.add("Secretary left work at 9PM and went home");
					secretaryInterviewed = true;

				} else {
					System.out.println("You have already interviewed Secretary");
				}
				break;
			case 6:
				if (!developerInterviewed) {
					System.out.println("\nDeveloper:");
					System.out.println("I was still in the office around 10PM.");
					System.out.println("I remember seeing Mika near the storage room.");
					System.out.println("She was looking for a key or something.");
					clues.add("Mika was seen in the storage room");

					developerInterviewed = true;
				} else {
					System.out.println("You have already interviewed Developer");
				}
				break;

			case 7:
				System.out.println("\nCollected Clues:");

				if (clues.isEmpty()) {
					System.out.println("No clues found yet");
				} else {

					for (String clue : clues) {
						System.out.println("- " + clue);
					}
				}
				break;

			case 8:

				System.out.println("\nWho is the Murderer?");
				System.out.println("1.Yuki Yamada - Wife");
				System.out.println("2.Ken Sato - Partner");
				System.out.println("3.Mika Suzuki- Secretary");
				System.out.println("4.Ryo Nakamura - Developer");

				int accusation = scan.nextInt();

				String accused = "";

				switch (accusation) {

				case 1:
					accused = "Wife";
					break;

				case 2:
					accused = "Partner";
					break;
				case 3:
					accused = "Secretary";
					break;
				case 4:
					accused = "Developer";
					break;

				default:
					System.out.println("Invalid Choice");
					continue;

				}

				System.out.println("You accused:" + accused);

				if (accused.equals(murderer)) {

					play3();
					System.out.println("\n🎉Case Solved");
					System.out.println("The Secretary was the Killer");
					System.out.println("She was about to get fired.");
					play1();
				} else {

					play3();
					System.out.println("\n❌Wrong Accusation");
					System.out.println("The real Killer escaped");
					play1();
				}

				return;
			default:
				System.out.println("Invalid Choice");

			}

		}

	}

	public static void play1() throws Exception {

		FileInputStream fis = new FileInputStream("不安（ピアノ演奏）.mp3");
		Player player = new Player(fis);
		player.play();
	}

	public static void play2() throws Exception {

		FileInputStream fis = new FileInputStream("ピアノの単音.mp3");
		Player player = new Player(fis);
		player.play();
	}

	public static void play3() throws Exception {

		FileInputStream fis = new FileInputStream("ドラムロール.mp3");
		Player player = new Player(fis);
		player.play();
	}
}
