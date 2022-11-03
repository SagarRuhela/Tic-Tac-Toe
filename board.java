package TicTactoeGame;

public class board {
   private char board[][];
   private  int boardSize=3;
   private char p1Symbol, p2Symbol;
   private int count;// for counting the number of moves or cells
   public final static int Player1_win=1;
   public final static int Player2_win=2;
   public final static int Drow=3;
   public final static int Incomplete=4;
   public final static int Invalid_value=5;
   
   public board(char p1Symbol, char p2Symbol) {
	   board=new char[boardSize][boardSize];
	   for(int i=0;i<boardSize;i++) {
		   for(int j=0;j<boardSize;j++) {
			   board[i][j]=' ';// initially it is empty.
		   }
	   }
	   this.p1Symbol=p1Symbol;
	   this.p2Symbol=p2Symbol;
   }
   
   public  int move(char symbol, int x, int y) {
	   // checking invalid values
	   if(x<0 || x>=boardSize || y<0 || y>=boardSize || board[x][y]!=' ') {
		   return Invalid_value;
	   }
	   board[x][y] =symbol;
	   count++;
	   // checking row
	   if(board[x][0]== board[x][1] && board[x][0]== board[x][2]) {
		   if(symbol== p1Symbol) {
			   return Player1_win;
		   }
		   else {
			   return Player2_win;
		   }
	   }
	   // checking column
	   if(board[0][y]== board[1][y] && board[0][y]== board[2][y]) {
		   if(symbol== p1Symbol) {
			   return Player1_win;
		   }
		   else {
			   return Player2_win;
		   }
	   }
	   // checking one diagonal
	   if(board[0][0]!=' ' && board[0][0]== board[1][1] && board[0][0]== board[2][2]) {
		   if(symbol== p1Symbol) {
			   return Player1_win;
		   }
		   else {
			   return Player2_win;
		   }
	   }
	   // checking second diagonal
	   if(board[0][2]!=' ' && board[0][2]== board[1][1] && board[0][2]== board[2][0]) {
		   if(symbol== p1Symbol) {
			   return Player1_win;
		   }
		   else {
			   return Player2_win;
		   }
	   }
	   if(count== boardSize*boardSize) {
		   return Drow;
	   }
	   return Incomplete;
   }
   
   // for printing the board
   public void print() {
	   System.out.println("Board Size =3X3");
	   System.out.println("____________________");
	   System.out.println();
	   for(int i=0;i<boardSize;i++) {
		   for(int j=0;j<boardSize;j++) {
			   System.out.print("| "+ board[i][j]+" |");
		   }
		   System.out.println();
	   }
	   System.out.println();
	   System.out.println("_____________________");
   }
}

