package TicTactoeGame;

import java.util.Scanner;

public class TicTacToe {
	private players player1, player2;
	private board Board;

	public void Startgame() {
		
	   Scanner s= new Scanner(System.in);
	   //player input
	   player1=takeplayerInput(1);
	   player2=takeplayerInput(2);
	   while(player1.getSymbol()==player2.getSymbol()) {
		   System.out.println("symbol is alreafy taken take another symbol");
		   char symbol= s.next().charAt(0);
		   player2.setSymbol(symbol);
	   }
	   // create board
	   Board =new board(player1.getSymbol(),player2.getSymbol());
	   // start the game
	   boolean Player1turn=true;
	   int status=board.Incomplete;
	   while(status==board.Incomplete || status==board.Invalid_value) {
		   if(Player1turn) {
			   System.out.println("Player 1 "+player1.getName()+"'s turn");
			   System.out.println("enter X:");
			   int x=s.nextInt();
			   System.out.println("enter Y:");
			   int y=s.nextInt();
			   status= Board.move(player1.getSymbol(),x,y);
			  if(status==board.Invalid_value) {
				  System.out.println("Invalid move || try again ||");
			  }
			  else {
				  Player1turn =false;
				  Board.print();// for printing the board
			  }
		   }
		   else {
			   System.out.println("Player 2 "+player2.getName()+"'s turn");
			   System.out.println("enter X:");
			   int x=s.nextInt();
			   System.out.println("enter Y:");
			   int y=s.nextInt();
			    status= Board.move(player2.getSymbol(),x,y);
               if(status==board.Invalid_value) {
            	   System.out.println("Invalid move || try again ||");
			  }
			  else {
				  Player1turn =true;
				  Board.print();
			  }
		   }
		   }
	   if(status==board.Player1_win) {
		    System.out.println("player 1"+ player1.getName()+" wins the Game");
	   }
	   else if(status==board.Player2_win) {
		   System.out.println("player 2"+ player2.getName()+" wins the Game");
	   }
	   else {
		   System.out.println("Its  Drow ");
	   }
	   }

	

	// for taking the input from player
	private players takeplayerInput(int num) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter player" + num + " name");
		String name = s.nextLine();
		System.out.println("enter player " + num + " symbol");
		char symbol = s.next().charAt(0);
		players p = new players(name, symbol);
		return p;
	}
}
