import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class StudentDetails extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDetails frame = new StudentDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection con=null;
	private JTextField tftype;
	private JTextField tfbreed;
	private JTextField Breed;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	public StudentDetails() throws SQLException {
		con = (Connection)DriverManager.getConnection("JDBC:mysql://localhost:3306/student","root","ganapathi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 444);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("file");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmNew_1 = new JMenuItem("new");
		mnFile.add(mntmNew_1);
		
		JMenuItem mntmSave = new JMenuItem("save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("exit");
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmUpdate = new JMenuItem("update");
		mnEdit.add(mntmUpdate);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("save", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblType = new JLabel("NAME:");
		lblType.setBounds(90, 51, 46, 14);
		panel.add(lblType);
		
		JLabel lblBreed = new JLabel("ENROLLMENT NUMBER:");
		lblBreed.setBounds(90, 108, 141, 14);
		panel.add(lblBreed);
		
		JLabel lblHealthyprecautions = new JLabel("DESCRIPTION ");
		lblHealthyprecautions.setBounds(90, 187, 122, 14);
		panel.add(lblHealthyprecautions);
		
		tftype = new JTextField();
		tftype.setBounds(282, 48, 86, 20);
		panel.add(tftype);
		tftype.setColumns(10);
		
		tfbreed = new JTextField();
		tfbreed.setBounds(282, 105, 86, 20);
		panel.add(tfbreed);
		tfbreed.setColumns(10);
		
		JTextArea tAhp = new JTextArea();
		tAhp.setBounds(282, 182, 378, 104);
		panel.add(tAhp);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  
				String type=tftype.getText();
				String breed=tfbreed.getText();
				String hp=tAhp.getText();
				
				try {
					
					/*q=query*/
					String q="insert into student.studentdata(NAME,studentid,description)"+"values('"+type+"','"+breed+"','"+hp+"')";
					
					Statement st =(Statement)con.createStatement();
					
					st.executeUpdate(q);
					
					JOptionPane.showMessageDialog(null,"saved data successfully");
		
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Some error has occured");
				}
		
			}
		});
		btnSave.setBounds(245, 297, 89, 23);
		panel.add(btnSave);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Delete", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel tfbr = new JLabel("ENROLLMENT NO:");
		tfbr.setBounds(98, 76, 178, 42);
		panel_1.add(tfbr);
		
		Breed = new JTextField();
		Breed.setBounds(237, 87, 169, 20);
		panel_1.add(Breed);
		Breed.setColumns(10);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				String bd=Breed.getText();
				try {
					
					/*q=query*/
					String q1="DELETE FROM student.studentdata Where studentid='"+bd+"' ";
					
					Statement st1 =(Statement)con.createStatement();
					
					st1.executeUpdate(q1);
					
					JOptionPane.showMessageDialog(null,"DELETED data successfully");
		
				}
				catch(Exception ex1)
				{
					JOptionPane.showMessageDialog(null,"Some error has occured while loading");
				}

			
			}
		});
		btnDelete.setBounds(243, 177, 89, 23);
		panel_1.add(btnDelete);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Update", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setBounds(29, 28, 46, 14);
		panel_2.add(lblName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(221, 25, 86, 20);
		panel_2.add(textField);
		
		JLabel lblEnrollmentNumber = new JLabel("ENROLLMENT NUMBER:");
		lblEnrollmentNumber.setBounds(29, 85, 135, 14);
		panel_2.add(lblEnrollmentNumber);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(221, 82, 86, 20);
		panel_2.add(textField_1);
		
		JLabel lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setBounds(29, 164, 122, 14);
		panel_2.add(lblDescription);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(221, 159, 379, 54);
		panel_2.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 241, 728, 106);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent arg0) {
			
				int row = table.getSelectedRow();
			String type1=(table.getModel().getValueAt(row,0)).toString();
				
				
				try
				{
				String q3="select * from student.studentdata Where NAME='"+type1+"'";
				Statement st3=(Statement)con.createStatement();
				ResultSet rs1=st3.executeQuery(q3);
				while (rs1.next())
				{
					textField.setText(rs1.getString(1));
					textField_1.setText(rs1.getString(2));
					textArea.setText(rs1.getString(3));
				}
				}
				catch(Exception ex3)
				{
					ex3.printStackTrace();
				}
			
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ty=textField.getText();
				String br=textField_1.getText();
				String hpf=textArea.getText();
				try {
					String q4="update student.studentdata set NAME='"+ty+"' , studentid='"+br +"' , description='"+hpf +"' where studentid='"+br+"'";
					Statement st4=(Statement)con.createStatement();
					st4.executeUpdate(q4);
					JOptionPane.showMessageDialog(null,"DATA UPDATED SUCCESSFULLY");		
				
			} catch (Exception ex4) {
				// TODO: handle exception
				ex4.printStackTrace();
			}
						}
		});
		btnNewButton.setBounds(468, 24, 89, 75);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SHOW ALL INFO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try
				{
				String q2="select * from student.studentdata";
				Statement st2=(Statement)con.createStatement();
				ResultSet rs=st2.executeQuery(q2);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception ex2)
				{
					ex2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(603, 24, 135, 75);
		panel_2.add(btnNewButton_1);
		
		JList list = new JList();
		list.setBounds(515, 346, 1, 1);
		panel_2.add(list);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("SEARCH", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblEnterTheBreed = new JLabel("ENTER THE ENROLLMENT NUMBER");
		lblEnterTheBreed.setForeground(Color.BLACK);
		lblEnterTheBreed.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterTheBreed.setBounds(46, 80, 305, 42);
		panel_3.add(lblEnterTheBreed);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setBounds(393, 94, 259, 20);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("SEARCH");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String q5="select * from studentdata where studentid='"+textField_2.getText()+"'";
				try {
					Statement st5=(Statement)con.createStatement();
					ResultSet rs5=st5.executeQuery(q5);
					while (rs5.next())
					{
						String type1 = rs5.getString("NAME");
						String Breed1 = rs5.getString("studentid");
						String HealthyPrecautions1=rs5.getString("description");
						JOptionPane.showMessageDialog(null,"you searched for"+"\n"+"ENROLLMENT NUMBER:"+"\t"+Breed1+"\n"+"and details are:"+"\n"+"NAME:"+"\t"+type1+"\n"+"ENROLLMENT NUMBER:"+"\t"+Breed1+"\n"+"DESCRIPTION :"+"\t"+HealthyPrecautions1);
					}
				} catch (SQLException ex5) {
					// TODO Auto-generated catch block
					ex5.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(301, 186, 146, 59);
		panel_3.add(btnNewButton_2);
	}
}
