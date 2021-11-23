package events;

import java.util.ArrayList;

import model.Piece;
import utilitaires.Utilitaires;

public class Verifications {
	public static boolean verif_Choice(String position) {
		if (position.length() == 2) {
			if (((position.charAt(0) >= 'A') && (position.charAt(0) <= 'H'))
					&& ((position.charAt(1) >= '1') && (position.charAt(1) <= '8'))) {
				return true;
			}

		}
		return false;
	}

	public static void verif_Movement(Piece P, ArrayList<String> alMoves, String[][] board, int sign) {
		if (board[P.getY() + 1 * sign][P.getX() + 1].length() == 2) {
			alMoves.add(Utilitaires.get_Position(board, P.getX() + 1, P.getY() + 1 * sign));
		}
		if (board[P.getY() + 1 * sign][P.getX() - 1].length() == 2) {
			alMoves.add(Utilitaires.get_Position(board, P.getX() - 1, P.getY() + 1 * sign));
		}
	}

	/*
	 * public static void verif_Ascend(Piece P,ArrayList<String> alMoves,String[][]
	 * board,int sign) { if(board[P.getY()+1*sign][P.getX()+1].length()==2) {
	 * alMoves.add(Utilitaires.get_Position(board, P.getX()+1, P.getY()+1*sign)); }
	 * if(board[P.getY()+1*sign][P.getX()-1].length()==2) {
	 * alMoves.add(Utilitaires.get_Position(board, P.getX()-1, P.getY()+1*sign)); }
	 * }
	 */
	/*
	 * public static void verif_Descend(Piece P,ArrayList<String> alMoves,String[][]
	 * board) { if(board[P.getY()+1][P.getX()+1].length()==2) {
	 * alMoves.add(Utilitaires.get_Position(board, P.getX()+1, P.getY()+1)); }
	 * if(board[P.getY()+1][P.getX()-1].length()==2) {
	 * alMoves.add(Utilitaires.get_Position(board, P.getX()-1, P.getY()+1)); } }
	 */
	// afficher les mouvement possibles
	public static boolean possible_Moves(Piece P, String[][] board) {
		// possible moves
		ArrayList<String> alMoves = new ArrayList<String>();
		if (P.isQueen()) {
			verif_Movement(P, alMoves, board, -1);
			verif_Movement(P, alMoves, board, 1);
			// verif_Descend(P,alMoves,board);
		} else if (P.getColour() == "Blanc") {
			verif_Movement(P, alMoves, board, -1);
		} else if (P.getColour() == "Noir") {
			verif_Movement(P, alMoves, board, 1);
		}
		if (alMoves.isEmpty()) {
			System.out.println("aucun mouvement a été detecté pour le pion " + P.getName());
			return false;
		} else {
			Utilitaires.display_List(alMoves);
			return true;
		}

	}
}
