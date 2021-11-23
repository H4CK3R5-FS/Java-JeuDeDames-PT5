package events;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.text.Utilities;

import game.Texts;
import model.Joueur;
import model.Piece;
import utilitaires.Utilitaires;

public class Round {

//round sert à gerer un tour pour un joueur
	public static void round(HashMap<String, Piece> hmP, String[][] board) {
		while (true) {
			Utilitaires.read_Board(board);
			System.out.println(Texts.piece_Choice);
			String choix = Utilitaires.saisieString().toUpperCase();
			// prev_pos est la position precedente de Pion avant de le bouger
			String prev_pos = Utilitaires.get_Position(board, hmP.get(choix).getX(), hmP.get(choix).getY());
			// Verifications.possible_Moves(hmP.get(choix),board);
			if (Verifications.possible_Moves(hmP.get(choix), board)) {
				Events.eat_Condition(hmP, hmP.get(choix), board);
				//Events.eat_Event(hmP.get(choix), hmP.get("PN5"), board, hmP);
				System.out.println("choisis ta position : ");
				String choix_pos = Utilitaires.saisieString().toUpperCase();
				System.out.print(Verifications.verif_Choice(choix_pos));
				while (!Verifications.verif_Choice(choix_pos)) {
					choix_pos = Utilitaires.saisieString().toUpperCase();
				}
				int x = choix_pos.charAt(0);
				x = x - 64;
				int y = choix_pos.charAt(1);
				y = y - 48;
				Events.move(hmP.get(choix), board, x, y);
				System.out.println("Player moved " + hmP.get(choix).getName() + " from " + prev_pos + " to "
						+ Utilitaires.get_Position(board, x, y));
			}

		}

	}
}
