import java.util.Random;

import javax.swing.JOptionPane;

public class TicTacToeGame {
	public static void main(String[] args) {
		loadGame();

	}

	private static void loadGame() {
		System.out.println("welcome");
		System.out.println(" Tic Tac Tao Game  ( X | O )");
		Game();
	}

	private static void Game() {

		String[][] matrix = new String[3][3];
		resetMatrix(matrix);
		String player1Sign = JOptionPane.showInputDialog("Player1 please enter your sign");

		String player2Sign;
		if (player1Sign.matches("x") || player1Sign.matches("X")) {
			if (player1Sign == "x") {
				player2Sign = "o";
			} else {
				player2Sign = "O";
			}
		} else if (player1Sign.matches("o") || player1Sign.matches("O")) {
			if (player1Sign == "o") {
				player2Sign = "x";
			} else {
				player2Sign = "X";
			}

		} else {
			System.out.println("Wrong input");
			return;
		}
		int start = whoStart();
		int counter = 0;
		
		System.out.println("Random Start");
		
		
		for (int index = 0; index < matrix.length * matrix[0].length; index++) {
			
			int turn = whosPlayNow(counter, start);
			
			System.out.println("player " + turn + "  Make a move");
			System.out.println("Choose (x,y)");
			
			String xSpot = JOptionPane.showInputDialog("Choose x");
			int spot1 = Integer.parseInt(xSpot);
			
			String ySpot = JOptionPane.showInputDialog("Choose y");
			int spot2 = Integer.parseInt(ySpot);
			
			
			if(isValidPosition(spot1,spot2,matrix)) {
				if (turn == 1) {
					matrix[spot1][spot2] = player1Sign;
				} else {
					matrix[spot1][spot2] = player2Sign;
				}
			}
			else {
				return;
			}
			counter++;
			
			showMatrix(matrix);
			
			if (counter > 4 && isPlayerWon(matrix)) {
				System.out.println("player" + turn + "  won");
				return;
			}

		}
		System.out.println("no one wins");

	}

	private static boolean isValidPosition(int spot1, int spot2, String[][] matrix) {
		if ((spot1 < 0 || spot1 >=3) || (spot2 < 0 ||spot2 >= 3)) {
			System.out.println("out of scope");
			return false;
		}
		if (matrix[spot1][spot2] != "_") {
			System.out.println("spot already taken");
			return false;
		}
		return true;
	}

	private static void resetMatrix(String[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				matrix[row][col] = "_";
			}
		}
	}

	private static void showMatrix(String[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				System.out.print(matrix[row][col] + "   ");
			}
			System.out.print("\n");

		}

	}

	private static boolean isPlayerWon(String[][] matrix) {
		if (matrix[0][0] != "_" && matrix[0][0] == matrix[0][1] && matrix[0][0] == matrix[0][2]) {
			return true;
		}
		if (matrix[0][0] != "_" && matrix[0][0] == matrix[1][1] && matrix[0][0] == matrix[2][2]) {
			return true;
		}
		if (matrix[0][0] != "_" && matrix[0][0] == matrix[1][0] && matrix[0][0] == matrix[2][0]) {
			return true;
		}
		if (matrix[0][2] != "_" && matrix[0][2] == matrix[1][1] && matrix[0][2] == matrix[2][0]) {
			return true;
		}
		if (matrix[0][2] != "_" && matrix[0][2] == matrix[1][2] && matrix[0][2] == matrix[2][2]) {
			return true;
		}
		if (matrix[1][1] != "_" && matrix[1][1] == matrix[1][0] && matrix[1][1] == matrix[1][2]) {
			return true;
		}
		if (matrix[1][1] != "_" && matrix[1][1] == matrix[0][1] && matrix[1][1] == matrix[2][1]) {
			return true;
		}
		if (matrix[2][0] != "_" && matrix[2][0] == matrix[2][1] && matrix[2][0] == matrix[2][2]) {
			return true;
		}
		return false;
	}

	private static int whosPlayNow(int counter, int turn) {
		if ((counter + turn) % 2 == 0) {
			return 2;

		}
		return 1;
	}

	private static int whoStart() {
		Random rand = new Random();
		int rand_int1 = rand.nextInt(2);
		return rand_int1 + 1;
	}
}
