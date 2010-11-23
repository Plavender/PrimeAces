
public abstract class Player {
	
	public int chips; 
	
	int hNum;
	
	public Player(int m)
	{
		m = chips;
	}
	public int getChips()
	{
		return chips;
	}
	
	public void addChips(int x)	
	{
		chips += x;
	}
	
	public void takeChips(int y)
	{
		chips -= y;
	}
	

	
}



