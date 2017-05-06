import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	private static String[][] board;

	private static void generateBoard() {

		board = new String[][] { { ".", ".", "." }, { ".", ".", "." }, { ".", ".", "." } };
	}

	private static void placeX(int locationRow, int locationCol) {

		if (locationCol >= 3 || locationRow >= 3 || locationCol < 0 || locationRow < 0) {
			System.out.println("Bad Location");
		} else if (board[locationRow][locationCol].equals(".")) {
			board[locationRow][locationCol] = "X";
		} else if (!board[locationRow][locationCol].equals(".")) {
			System.out.println("Location already in use!");
		}

	}

	private static void placeO(int locationRow, int locationCol) {

		if (locationCol >= 3 || locationRow >= 3 || locationCol < 0 || locationRow < 0) {
			System.out.println("Bad Location");
		} else if (board[locationRow][locationCol].equals(".")) {
			board[locationRow][locationCol] = "O";
		} else if (!board[locationRow][locationCol].equals(".")) {
			System.out.println("Location already in use!");
		}

	}

	private static void printBoard() {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}

	}

	private static boolean isValidLocation(int locationRow, int locationCol) {
		if (board[locationRow][locationCol].equals(".")) {
			return true;
		}
		return false;
	}

	private static boolean playGame() {

		printBoard();

		String message = "Enter row location to place";
		System.out.println(message);
		Scanner reader = new Scanner(System.in);
		int rowEntry = Integer.parseInt(reader.nextLine());

		message = "Enter col location to place";
		System.out.println(message);
		int colEntry = Integer.parseInt(reader.nextLine());
		placeX(rowEntry, colEntry);

		Random rand = new Random();

		int cpRow = rand.nextInt(3);
		int cpCol = rand.nextInt(3);

		while (!isValidLocation(cpRow, cpCol)) {
			cpRow = rand.nextInt(3);
			cpCol = rand.nextInt(3);
		}

		placeO(cpRow, cpCol);

		printBoard();

		boolean gameEnd = determineIfWin();
		if (gameEnd) {
			reader.close();
		}

		return gameEnd;

	}

	private static boolean determineIfWin() {
		boolean win = false;

		if (board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2]) && board[0][0].equals("X")) {
			win = true;
		} else if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && board[0][0].equals("X")) {
			win = true;
		} else if (board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0]) && board[0][0].equals("X")) {
			win = true;
		} else if (board[0][1].equals(board[1][1]) && board[0][1].equals(board[2][1]) && board[0][1].equals("X")) {
			win = true;
		} else if (board[0][2].equals(board[1][2]) && board[0][2].equals(board[2][2]) && board[0][2].equals("X")) {
			win = true;
		} else if (board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2]) && board[1][0].equals("X")) {
			win = true;
		} else if (board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2]) && board[2][0].equals("X")) {
			win = true;
		} else if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && board[0][2].equals("X")) {
			win = true;
		} else if (board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2]) && board[0][0].equals("O")) {
			win = true;
		} else if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && board[0][0].equals("O")) {
			win = true;
		} else if (board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0]) && board[0][0].equals("O")) {
			win = true;
		} else if (board[0][1].equals(board[1][1]) && board[0][1].equals(board[2][1]) && board[0][1].equals("O")) {
			win = true;
		} else if (board[0][2].equals(board[1][2]) && board[0][2].equals(board[2][2]) && board[0][2].equals("O")) {
			win = true;
		} else if (board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2]) && board[1][0].equals("O")) {
			win = true;
		} else if (board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2]) && board[2][0].equals("O")) {
			win = true;
		} else if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && board[0][2].equals("O")) {
			win = true;
		}

		return win;

	}

	public static void main(String args[]) {

		generateBoard();

		System.out.println("Welcome to tic-tac-toe");
		System.out.println("You are X's");

		while (!playGame()) {
			System.out.println("Choose Location");
		}

		determineWinner();

	}

	private static void determineWinner() {
		// TODO Auto-generated method stub
		if (board[0][0].equals(board[0][1]) && board[0][0].equals(board[0][2]) && board[0][0].equals("X")) {
			System.out.println("Congratulations you won!");
		} else if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && board[0][0].equals("X")) {
			System.out.println("Congratulations you won!");
		} else if (board[0][0].equals(board[1][0]) && board[0][0].equals(board[2][0]) && board[0][0].equals("X")) {
			System.out.println("Congratulations you won!");
		} else if (board[0][1].equals(board[1][1]) && board[0][1].equals(board[2][1]) && board[0][0].equals("X")) {
			System.out.println("Congratulations you won!");
		} else if (board[0][2].equals(board[1][2]) && board[0][2].equals(board[2][2]) && board[0][0].equals("X")) {
			System.out.println("Congratulations you won!");
		} else if (board[1][0].equals(board[1][1]) && board[1][0].equals(board[1][2]) && board[0][0].equals("X")) {
			System.out.println("Congratulations you won!");
		} else if (board[2][0].equals(board[2][1]) && board[2][0].equals(board[2][2]) && board[0][0].equals("X")) {
			System.out.println("Congratulations you won!");
		} else if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && board[0][0].equals("X")) {
			System.out.println("Congratulations you won!");
		} else {
			System.out.println("BOO you lost!");
		}
	}

}
