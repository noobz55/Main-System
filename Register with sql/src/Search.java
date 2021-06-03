import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JFrame frame = new JFrame();
        JPanel panelbot = new JPanel();
        JButton Back = new JButton("Back");
		JButton Search = new JButton("Search");
		JTextField field1 = new JTextField();
		
		panelbot.setBackground(Color.DARK_GRAY);
		panelbot.setLayout(null);
		panelbot.setBounds(0,0,500,500);
		panelbot.add(Back);
		panelbot.add(Search);
		panelbot.add(field1);
		
		//Buttons and label
		Back.setBounds(30,100,70,50);
		Search.setBounds(120,0,100,30);
		field1.setBounds(250,0,100,30);
		
		
		//Adding
		
		frame.add(panelbot);
		frame.setResizable(false);
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Showing Database");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
