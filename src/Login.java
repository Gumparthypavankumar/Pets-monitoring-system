import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tfusername;
	private JPasswordField tfpasswordField;
	Connection con=null;
	private JTextField tf_n;
	private JTextField tf_c;
	private JTextField tf_u;
	private JTextField tf_p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Login() throws SQLException {
		con =DriverManager.getConnection("JDBC:mysql://localhost:3306/student","root","ganapathi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(12, 53, 70, 38);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(12, 104, 87, 38);
		contentPane.add(lblPassword);
		
		tfusername = new JTextField();
		tfusername.setBackground(Color.WHITE);
		tfusername.setBounds(94, 62, 86, 20);
		contentPane.add(tfusername);
		tfusername.setColumns(10);
		
		tfpasswordField = new JPasswordField();
		tfpasswordField.setBackground(Color.WHITE);
		tfpasswordField.setBounds(94, 113, 86, 20);
		contentPane.add(tfpasswordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				String query ="select * from student.studentadmin";
				Statement st =con.createStatement();
			ResultSet rs  =	st.executeQuery(query);
				while (rs.next()) {
					String username = rs.getString(1);
					String password=  rs.getString(2);
					
					if (tfusername.getText().equals(username) && tfpasswordField.getText().equals(password))
					{
						JOptionPane.showMessageDialog(null,"Login Successfull");
						
						StudentDetails st1=new StudentDetails();
						st1.setVisible(true);
						dispose();	
					}
					/*else
					{
						JOptionPane.showMessageDialog(null,"INVALID INPUT");	
					}*/
					
				}
				
				
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null,"INVALID INPUT");
			}
				
				
				
				
				
				
			}
		});
		btnLogin.setBounds(76, 166, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(216, 65, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(216, 114, 56, 19);
		contentPane.add(lblCategory);
		
		JLabel lblUsername_1 = new JLabel("username");
		lblUsername_1.setBounds(216, 162, 63, 14);
		contentPane.add(lblUsername_1);
		
		JLabel lblPassword_1 = new JLabel("password");
		lblPassword_1.setBounds(216, 189, 56, 14);
		contentPane.add(lblPassword_1);
		
		tf_n = new JTextField();
		tf_n.setBackground(Color.WHITE);
		tf_n.setBounds(309, 62, 86, 20);
		contentPane.add(tf_n);
		tf_n.setColumns(10);
		
		tf_c = new JTextField();
		tf_c.setBackground(Color.WHITE);
		tf_c.setBounds(309, 111, 86, 20);
		contentPane.add(tf_c);
		tf_c.setColumns(10);
		
		tf_u = new JTextField();
		tf_u.setBackground(Color.WHITE);
		tf_u.setBounds(309, 159, 86, 20);
		contentPane.add(tf_u);
		tf_u.setColumns(10);
		
		tf_p = new JTextField();
		tf_p.setBackground(Color.WHITE);
		tf_p.setBounds(309, 186, 86, 20);
		contentPane.add(tf_p);
		tf_p.setColumns(10);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=tf_n.getText();
				String c=tf_c.getText();
				String us=tf_u.getText();
				String pa=tf_p.getText();
				try
				{
				con =DriverManager.getConnection("JDBC:mysql://localhost:3306/student","root","ganapathi");
				String quy="insert into student.studentadmin(username,password,NAME,CATEGORY)"+"values('"+us+"','"+pa+"','"+s+"','"+c+"')";
				Statement m=(Statement)con.createStatement();
				m.executeUpdate(quy);
				JOptionPane.showMessageDialog(null,"REGISTERED SUCSSESFULLY");
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(null,"some error has occured");
				}
				
			}
		});
		btnRegister.setBounds(263, 228, 89, 23);
		contentPane.add(btnRegister);
	}
}
