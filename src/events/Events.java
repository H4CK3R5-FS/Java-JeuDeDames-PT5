package events;

import java.util.HashMap;

import model.Joueur;
import model.Piece;
import utilitaires.Utilitaires;

public class Events {
	public static void isMovable(Piece P, Joueur J) {

	}
//only move if its your turn
//move only your colours

//mouvement event
//move(hmP.get("PB2"), board, 3, 5);
//{key,value}
//{PB2,Piece}

//move sert à bouger un pion(piece)
	public static void move(Piece P, String[][] board, int x, int y) {
		board[P.getY()][P.getX()] = Utilitaires.get_Position(board, P.getX(), P.getY());
		P.setX(x);
		P.setY(y);
		board[P.getY()][P.getX()] = P.getName();
	}

	public static void check_Moves() {

	}
	// eat event
	public static void eat_Event(Piece predator,Piece victim,String[][] board,HashMap<String, Piece> hmP) {
	System.out.println(predator.getName()+" ate "+victim.getName());
	board[victim.getY()][victim.getX()]=Utilitaires.get_Position(board, victim.getX(), victim.getY());
	hmP.remove(victim.getName());
	Utilitaires.read_Board(board);
	}
	public static boolean eat_Condition(HashMap<String,Piece> hmP,Piece P,String[][] board) {
		if(hmP.containsKey(board[P.getY()-1][P.getX()-1])) {
			if(hmP.get(board[P.getY()-1][P.getX()-1]).getColour()!=hmP.get(board[P.getY()][P.getX()]).getColour()) {
				if(!hmP.containsKey(board[P.getY()-2][P.getX()-2])) {
					System.out.println(P.getName()+" can eat ");
					return true;
				}
			}
		}
		System.out.print(P.getName()+" cannot eat ");
		return false;
	}
	// eat condtions
	// il ya un pion après
	// le pion est de couleur different
	// la case après est vide
	// change turns after each play
	// game over
	// if player is out of pieces
	// if player cant move anymore
}
