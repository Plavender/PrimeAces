package poker;
import javax.swing.ImageIcon;


public class Suit {

	String check = new String();
	
	public Suit(Card l)
	{
		check = l.getSuit().substring(0,1);
	}
	public ImageIcon getImage()
	{
		ImageIcon s = new ImageIcon("s.jpg");
		ImageIcon h = new ImageIcon("h.jpg");
		ImageIcon c = new ImageIcon("c.jpg");
		ImageIcon d = new ImageIcon("d.jpg");
		
		if(check.equals("s"))
			return s;
		else if(check.equals("h"))
			return h;
		else if (check.equals("c"))
			return c;
		else
			return d;
	}
}