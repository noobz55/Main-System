import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenu extends JFrame implements ActionListener{

	JButton createcustomer = new JButton("Create Retailer");
	JButton viewcustomer = new JButton("View Retailers / Search Retailers");
	JButton  deletecustomer = new JButton("Delete Retailers");
	JButton exit = new JButton("Exit");
	
	MainMenu(){
		
		createcustomer.setBounds(50,100,150,30);
		createcustomer.addActionListener(this);
		viewcustomer.setBounds(50,200,150,30);
		viewcustomer.addActionListener(this);
		deletecustomer.setBounds(50,300,150,30);
		deletecustomer.addActionListener(this);
		exit.setBounds(50,400,150,30);
		exit.addActionListener(this);
		
		this.setSize(500,500);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		this.add(createcustomer);
		this.add(deletecustomer);
		this.add(exit);
		this.add(viewcustomer);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==exit) {
			this.dispose();
		}
		if(e.getSource()==createcustomer) {
			new menu();
			this.dispose();
		}
		if(e.getSource()==viewcustomer) {
			
		
			JFrame frame = new showtTablewithDb();
			
			
			
	        frame.setSize(700,700);
	        frame.setLocationRelativeTo(null);
	        frame.setTitle("Showing Database");
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}
		if(e.getSource()==deletecustomer) {
			new dmenu();
			this.dispose();
		}
		
	}
	
}
