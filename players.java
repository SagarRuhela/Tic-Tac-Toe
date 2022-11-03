package TicTactoeGame;

public class players {
   private  String name;
     private char symbol;
     
    public  players(String name, char symbol){
    	 setName(name);
    	 setSymbol(symbol);
     }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(!name.isEmpty()) {
		this.name = name;
		}		
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
}
