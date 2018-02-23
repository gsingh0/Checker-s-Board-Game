import javax.swing.JFrame;

public class Client {
	public static void main(String [] args)
	{
		JFrame frame = new JFrame("Checker's Board Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Checkers checkers = new Checkers();
		
		frame.getContentPane().add(checkers);
		
		frame.pack();
		frame.setVisible(true);
	}

}
