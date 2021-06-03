import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;


public class showtTablewithDb extends JFrame{
	//model
	DefaultTableModel model = new DefaultTableModel() ;
	//container
	Container cont = this.getContentPane();
	//create Table
	JTable table = new JTable(model);
	
	public showtTablewithDb() {
		cont.setLayout(new FlowLayout(FlowLayout.CENTER));
	//headers


model.addColumn("First Name");
model.addColumn("Last Name");
model.addColumn("Age");
model.addColumn("Retailer Number");
model.addColumn("Address");
model.addColumn("Telcom");
		
	
	//accessing the database
	try {
		//Class.forName("com.mysql.jdbc.driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/retailer", "root", "password");
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			model.addRow(new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
		}
	}catch (Exception e) {
		System.out.print(e.getMessage());
	}
	
	JScrollPane sp = new JScrollPane(table);
	cont.add(sp);

	table.setEnabled(false);
	
	//add table to the frame

}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JFrame frame = new showtTablewithDb();
        JPanel panelbot = new JPanel();
        JButton Back = new JButton("Back");
		JButton Search = new JButton("Search");
		JTextField field1 = new JTextField();
		
		panelbot.setBackground(Color.green);
		panelbot.setBounds(0,0,500,500);
		panelbot.add(Back);
		panelbot.add(Search);
		panelbot.add(field1);
		
		//Buttons and label
		Back.setBounds(0,400,70,50);
		Search.setBounds(0,400,70,50);
		field1.setBounds(0,0,100,200);
		
		
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
