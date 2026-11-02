package teamwork01;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javazoom.jl.player.Player;

public class DetectiveGame {

	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);
		String RESET = "\u001B[0m";
		String BLUE = "\u001B[34m";

		while (true) {

			System.out.println();
			System.out.println("+--------------------------------------+");
			System.out.println("|       " + BLUE + "🎮 DETECTIVE MYSTERY GAME" + RESET + "     |");
			System.out.println("+--------------------------------------+");

			System.out.println("1.English Mode");
			System.out.println("2.Japanese Mode");
			int lang = scan.nextInt();

			if (lang == 2) {

				//System.out.println(BLUE);
				System.out.println("      レベルを選んでください");
				System.out.println();
				System.out.println("[1] EASY  😊");
				System.out.println("[2] HARD  😈");
				System.out.println("[3] EXIT  🚪");
				System.out.println();
				System.out.print(">>> ");

				int level = scan.nextInt();

				if (level == 1) {
					easyMode();
				} else if (level == 2) {
					hardMode();
				} else {
					System.out.println("💕💕💕ありがとうございました。💕💕💕");
					break;

				}

			} else {

				//System.out.println(BLUE);
				System.out.println("      Select level");
				System.out.println();
				System.out.println("[1] EASY  😊");

				System.out.println("[2] HARD  😈");
				System.out.println("[3] EXIT  🚪");
				System.out.println();
				System.out.print(">>> ");

				int level = scan.nextInt();
				if (level == 2) {

					test01.main(args);
				} else if (level == 1) {
					test011.main(args);

				} else {
					System.out.println("💕💕💕Thank You💕💕💕");
					break;

				}

			}
		}
	}

	public static void easyMode() throws Exception {

		String RESET = "\u001B[0m";
		String RED = "\u001B[31m";
		String GREEN = "\u001B[32m";
		String YELLOW = "\u001B[33m";
		String BLUE = "\u001B[34m";

		Scanner scan = new Scanner(System.in);

		System.out.println("+---------------------------------------+");
		System.out.println("+      学校の探偵ゲーム EASY MODE       +");
		System.out.println("+       消えたトロフィーのなぞ          +");
		System.out.println("+---------------------------------------+\n");

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String story = "今日は学校のお祭りの日です。\n"
				+ "でも、大切なラッキートロフィーがなくなりました。\n\n"
				+ "あなたは学校の探偵です。\n"
				+ "トロフィーを見つけてください！";

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

			System.out.println("\n+---------------------------------------+");
			System.out.println("|               ACTION MENU             |");
			System.out.println("+---------------------------------------+");
			System.out.println("+           1. 図書館をしらべる         +");
			System.out.println("+           2. 教室をしらべる           +");
			System.out.println("+           3. 体育館をしらべる         +");
			System.out.println("+           4. 見つけたもの             +");
			System.out.println("+           5. トロフィーを見つける     +");
			System.out.println("+           6. 終了                     +");
			System.out.println("+---------------------------------------+");
			int choice = scan.nextInt();

			switch (choice) {

			case 1:

				if (!memoFound) {
					System.out.println("🔍 図書館をしらべています...");
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

						System.out.println(YELLOW + "暗号を解いてください！" + RESET);
						System.out.println();

						System.out.println("20 18 15 16 8 25");
						System.out.println("Hint:O=15");
						System.out.print("答え: ");

						String answer = scan.next();

						if (answer.equalsIgnoreCase("TROPHY")) {

							System.out.println();

							victorysong1();
							System.out.println(GREEN + "🎉 正解！" + RESET);
							System.out.println("📝 メモを見つけました！");
							//System.out.println("『トロフィーは特別な場所にある』");

							String memo = "『トロフィーは特別な場所にある』";
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

							System.err.println("❌ 不正解！");
						}

					}
				} else {
					System.out.println("何もありません。");
				}
				break;

			case 2:

				if (!keyFound) {
					System.out.println("🔒 かぎを見つけました！");
					System.out.println("でもロックされています...");
					System.out.println();
					while (true) {
						System.out.println(YELLOW + "パズルを解いてください！" + RESET);
						System.out.println();
						System.out.println("問題:");
						System.out.println("25 24 22 19 15 ?");
						System.out.print("答え: ");
						int answer = scan.nextInt();

						if (answer == 10) {

							System.out.println();

							victorysong1();
							System.out.println(GREEN + "🎉 正解！");
							System.out.println("🔑 かぎを手に入れました！" + RESET);
							keyFound = true;
							break;

						} else {

							System.out.println();

							failsong1();
							System.err.println("❌ 不正解！");

							System.out.println("もう一度チャレンジしてください。");
						}
					}
				} else {
					System.out.println("何もありません。");
				}

				break;

			case 3:

				if (!footprintFound) {
					System.out.println("足あとを見つけました。かぎがいります");
					footprintFound = true;
				} else {
					System.out.println("何もありません。");
				}
				break;

			case 4:

				System.out.println(GREEN + "[    見つけたもの    ]" + RESET);

				if (memoFound)
					System.out.println(GREEN + "✅メモ" + RESET);

				if (keyFound)
					System.out.println(GREEN + "✅かぎ" + RESET);

				if (footprintFound)
					System.out.println(GREEN + "✅足あと" + RESET);

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

					System.out.println("🏆🏆🏆 トロフィーを見つけました！");
					System.out.println();
					System.out.println("りょうさんはお祭りのサプライズのために");
					System.out.println("トロフィーをかくしていました。");
					System.out.println();
					System.out.println("だれも悪いことをしていません。");
					System.out.println("みんなで楽しいお祭りを始めました！");
					System.out.println();

					System.out.println("✨ HAPPY END ✨");
					System.out.println("ゲームクリア！");
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

					System.out.println("まだ見つけたものが足りません。");
					System.out.println("もっと調べてください。");
				}

				break;

			case 6:
				return;

			default:
				System.out.println("もう一度えらんでください。");
			}
		}
	}

	public static void hardMode() throws Exception {

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
		System.out.println("探偵ゲーム");
		System.out.println("=================================================");

		System.out.println(
				"IT企業の社長である山田氏が、6月1日午後10時31分に\n"
						+ "施錠されたオフィスで死亡しているのが発見された。\n"
						+ "警察は自殺と考えていたが、削除されたメールにより\n"
						+ "殺人の可能性が浮上した。\n\n"

						+ "容疑者は4人。\n\n"

						+ "山田由紀（妻）― 大きな秘密を隠している\n"
						+ "佐藤健（共同経営者）― 会社の所有権を巡って対立していた\n"
						+ "鈴木美香（秘書）― 最近経営陣と問題を抱えていた\n"
						+ "中村亮（プログラマ）― 自分の功績を奪われたと主張している\n\n"

						+ "削除されたメール、なくなったスペアキー、"
						+ "防犯カメラ映像、そして怪しい証言。\n"
						+ "全員が何かを隠している。しかし犯人は一人だけだ。");

		play2();
		scan.nextLine();

		while (true) {

			System.out.println("\n何をしますか？");
			System.out.println("1. 現場を調査する");
			System.out.println("2. 防犯カメラを確認する");
			System.out.println("3. 妻に話を聞く");
			System.out.println("4. 共同経営者に電話する");
			System.out.println("5. 秘書に話を聞く");
			System.out.println("6.プログラマに話を聞く");
			System.out.println("7. 手がかりを見る");
			System.out.println("8. 犯人を指名する");

			int choice = scan.nextInt();

			switch (choice) {

			case 1:

				if (!sceneInvestigated) {

					System.out.println("\n発見した証拠");
					System.out.println("- 妻からのメッセージ");
					System.out.println("『今夜決着をつけましょう』");
					System.out.println("- 削除された文書");
					System.out.println("- 亮からの怒りのメール");
					System.out.println("- なくなったスペアキー");

					clues.add("妻からのメッセージ");
					clues.add("削除された文書");
					clues.add("怒りのメール");
					clues.add("なくなったスペアキー");

					sceneInvestigated = true;

				} else {

					System.out.println("すでに現場を調査しました。");

				}

				break;

			case 2:

				if (!cameraInvestigated) {

					System.out.println("\n防犯カメラ映像");
					System.out.println("- 午後10時25分から10時40分までカメラ停止");
					System.out.println("- 停止操作は山田社長のオフィスから行われた");
					System.out.println("- 佐藤（共同経営者）が午後10時15分に入館");
					System.out.println("- 午後10時42分に謎の人物が退館");

					clues.add("カメラ停止");
					clues.add("共同経営者が入館");
					clues.add("謎の人物");

					cameraInvestigated = true;

				} else {

					System.out.println("すでに防犯カメラを確認しました。");

				}

				break;

			case 3:

				if (!wifeInterviewed) {

					System.out.println("\n妻:");
					System.out.println("私は一晩中家にいました。");

					clues.add("妻は家にいたと主張");

					wifeInterviewed = true;

				} else {

					System.out.println("すでに妻に話を聞きました。");

				}

				break;

			case 4:

				if (!partnerInterviewed) {

					System.out.println("\n共同経営者:");
					System.out.println("私は仕事を休んでいました。");

					clues.add("共同経営者は仕事を休んでいた");

					partnerInterviewed = true;

				} else {

					System.out.println("すでに共同経営者に話を聞きました。");

				}

				break;

			case 5:

				if (!secretaryInterviewed) {

					System.out.println("\n秘書:");
					System.out.println("午後9時に退社して、そのまま帰宅しました。");

					clues.add("秘書は午後9時に退社したと証言");

					secretaryInterviewed = true;

				} else {

					System.out.println("すでに秘書に話を聞きました。");

				}

				break;

			case 6:

				if (!developerInterviewed) {

					System.out.println("\nプログラマ:");
					System.out.println("午後10時頃まで会社にいました。");
					System.out.println("倉庫の近くで美香さんを見ました。");
					System.out.println("何かの鍵を探しているようでした。");

					clues.add("ミカは倉庫で目撃された");

					developerInterviewed = true;

				} else {

					System.out.println("すでにプログラマに話を聞きました。");

				}

				break;

			case 7:

				System.out.println("\n集めた手がかり:");

				if (clues.isEmpty()) {

					System.out.println("まだ手がかりはありません。");

				} else {

					for (String clue : clues) {
						System.out.println("- " + clue);
					}

				}

				break;

			case 8:

				System.out.println("\n犯人は誰ですか？");
				System.out.println("1. 山田由紀（妻）");
				System.out.println("2. 佐藤健（共同経営者）");
				System.out.println("3. 鈴木美香（秘書）");
				System.out.println("4. 中村亮（プログラマ）");

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
					System.out.println("無効な選択です。");
					continue;

				}

				System.out.println("\nあなたが指名した犯人: " + accused);

				if (accused.equals(murderer)) {

					play3();

					System.out.println("\n🎉事件解決！");
					System.out.println("犯人は鈴木美香（秘書）だった！");
					System.out.println("彼女は解雇される予定だった。");

					play1();

				} else {

					play3();

					System.out.println("\n❌推理失敗");
					System.out.println("真犯人は逃亡してしまった...");

					play1();
				}

				return;

			default:
				System.out.println("無効な選択です。");
				continue;
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
