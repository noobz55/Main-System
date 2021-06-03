import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class dmenu extends JFrame implements ActionListener{

	JButton delbut = new JButton("Delete");
	JButton searchbut = new JButton("Search");
	JTextField cn = new JTextField();
	JLabel label1 = new JLabel("Input Retailer Number");
	
	
	
	
	//From menu.java
	
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
	
	//end frm menu
	
	
	dmenu(){
		
		
		
		//Frrom menu java
		
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
		
		
		
		//End
		delbut.setBounds(250,345,100,20);
		delbut.setBackground(Color.red);
		searchbut.setBounds(370,345,100,20);
		searchbut.addActionListener(this);
		cn.setBounds(250,300,150,40);
		label1.setBounds(75,300,200,40);
		delbut.addActionListener(this);
		
		
		this.setSize(500,500);
		this.setLayout(null);
		this.setVisible(true);
		this.setResizable(false);
		this.add(delbut);
		this.add(cn);
		this.add(label1);
		this.add(searchbut);
		
		//from menu java
		this.add(Age);
		this.add(fname);
		this.add(lname);
		this.add(save);
		this.add(RetailerNumber);
		this.add(Address);
		this.add(status);
		this.add(telcom);
		this.add(back);
		//end

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==delbut) {
			
		}
		
		String customer = cn.getText();
		try {
			Connection del = DriverManager.getConnection("jdbc:mysql://localhost:3306/retailer","root","password");
			String delete = "delete from users where rn ="+"'"+customer+"'";
			Statement sta = del.createStatement();
			int x = sta.executeUpdate(delete);
			if(x==0) {
				JOptionPane.showMessageDialog(delbut,"LOL");
			}
			else {
			JOptionPane.showMessageDialog(delbut,"Customer Has Been Deleted");
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		if(e.getSource()==searchbut) {
			
			String search = cn.getText();
			try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/retailer", "root", "password");
				PreparedStatement pstmt = (PreparedStatement)con.prepareStatement("Select * from user where rn=?");
				pstmt.setString(1, search);
				
				//executing query
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					String fn = rs.getString(1);
					String ln = rs.getString(2);
					String Agesql = rs.getString(3);
					String rn = rs.getString(4);
					String ad = rs.getString(5);
					String tc = rs.getString(6);
					
					//asigning the values in th db in their respective textfield
					
					fname.setText(fn);
					lname.setText(ln);
					Age.setText(Agesql);
					RetailerNumber.setText(rn);
					Address.setText(ad);
					telcom.setText(tc);
					
				}else {
					System.out.print("Notfound");
				}
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			
		}
		
		if(e.getSource()==back) 
		{
			this.dispose();
			new MainMenu();
		}
	}
	
	
	
	
	
}
