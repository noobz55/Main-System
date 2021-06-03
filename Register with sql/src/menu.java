import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class menu extends JFrame implements ActionListener{

	
	JButton save = new JButton("SAVE");
	JTextField fname = new JTextField("First Name");
	JTextField lname = new JTextField("Last Name");
	JTextField Age = new JTextField("AGE");
	JTextField RetailerNumber = new JTextField("Retailer Number");
	JTextField Address = new JTextField("Address");
	JTextField telcom = new JTextField("TeleCom");
	JButton telcombut = new JButton("Smart");
	JButton telcombut2 = new JButton("GLOBE");
	JButton back = new JButton("Back");
	JTextField status = new JTextField();
	
	
	
	
	menu(){
		
		//Button
		save.setBounds(250,400,100,30);
		save.addActionListener(this);
		telcombut.setBounds(200,250,100,30);
		telcombut.addActionListener(this);
		telcombut2.setBounds(300,250,100,30);
		telcombut2.addActionListener(this);
		back.setBounds(150,400,100,30);
		back.addActionListener(this);
		
		//Fields
		fname.setBounds(50,50,150,30);
		lname.setBounds(50,90,150,30);
		Age.setBounds(50,130,150,30);
		RetailerNumber.setBounds(50,170,150,30);
		Address.setBounds(50,210,150,30);
		telcom.setBounds(50,250,150,30);
		telcom.setEditable(false);
		//Fields nga dakkel
		
		
		this.setSize(500,500);
		this.setLayout(null);
		this.add(Age);
		this.add(fname);
		this.add(lname);
		this.add(save);
		this.add(RetailerNumber);
		this.add(Address);
		this.add(status);
		this.add(telcom);
		this.add(telcombut);
		this.add(telcombut2);
		this.add(back);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==telcombut) {
			telcom.setText("");
			telcom.setText("Smart");
		}
		if(e.getSource()==telcombut2) {
			telcom.setText("");
			telcom.setText("Globe");
		}
		if(e.getSource()==save) {
			this.dispose();
			new MainMenu();	
		}
		if(e.getSource()==back) {
			this.dispose();
			new MainMenu();
		}
		
		//MYSQl from sir
		
		String fn = fname.getText();
		String ln = lname.getText();
		String Agesql = Age.getText();
		String rn = RetailerNumber.getText();
		String ad = Address.getText();
		String tc = telcom.getText();
		
		if(e.getSource()==save) {
			//if(rn!=10) detects if number is 12 digits 
			
			try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/retailer", "root","password");
				
				String query = "INSERT INTO users values("
						+ "'" + fn + "',"
						+ " '" +ln + "',"
						+ " '"+Agesql+"',"
						+ "'"+rn+"',"
						+ "'"+ad+"',"
						+ "'"+tc+"')";
				
				Statement sta = con.createStatement();
				int x = sta.executeUpdate(query);
				
				if(x==0) {
					 JOptionPane.showMessageDialog(save, "This is alredy exist");
				}else {
					JOptionPane.showMessageDialog(save, "Welcome, Your account is sucessfully created");
				}
				con.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			
		}
		//mysql from sir end
	}
}
