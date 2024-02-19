package form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class worker extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField workeridtxf;
	private JTextField namestxf;
	private JTextField emailtxf;
	private JTextField phonenumbertxf;
	private JTextField experiencetxf;
	private JTextField certificatetxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					worker frame = new worker();
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
	public worker() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("worker id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(23, 110, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("names");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(23, 163, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("email");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(23, 215, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("worker details");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_3.setBounds(292, 27, 185, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("phone number");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(22, 251, 118, 31);
		contentPane.add(lblNewLabel_4);
		
		workeridtxf = new JTextField();
		workeridtxf.setBounds(266, 92, 211, 32);
		contentPane.add(workeridtxf);
		workeridtxf.setColumns(10);
		
		namestxf = new JTextField();
		namestxf.setBounds(266, 135, 211, 42);
		contentPane.add(namestxf);
		namestxf.setColumns(10);
		
		emailtxf = new JTextField();
		emailtxf.setBounds(266, 203, 211, 31);
		contentPane.add(emailtxf);
		emailtxf.setColumns(10);
		
		phonenumbertxf = new JTextField();
		phonenumbertxf.setBounds(266, 258, 211, 24);
		contentPane.add(phonenumbertxf);
		phonenumbertxf.setColumns(10);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");

					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/workers_for_constraction_recruitment","root","");
			String sql="INSERT INTO worker VALUES(?,?,?,?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(workeridtxf.getText()));
			st.setString(2,namestxf.getText());
			st.setString(3, emailtxf.getText());
			st.setString(4, phonenumbertxf.getText());
			st.setString(5, experiencetxf.getText());
			st.setString(6, certificatetxf.getText());
			st.executeUpdate();
			JOptionPane.showMessageDialog(btnNewButton, "data saved!!");
			
			st.close();
			con.close();
					
					
					
					
					
					
					
					
					
				} catch (Exception e2) {
					
				}	
					
					
					
					
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(10, 404, 118, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				namestxf.setText(null);
				emailtxf.setText(null);
				phonenumbertxf.setText(null);
				 experiencetxf.setText(null);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(159, 402, 118, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("view");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/workers_for_construction_recruitment","root","");
					java.sql.Statement st=con.createStatement();
					String query="SELECT * FROM worker";
					ResultSet rs=st.executeQuery(query);
					java.sql.ResultSetMetaData rsdm=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel)btnNewButton_2.getModel();
					int cols=rsdm.getColumnCount();
					String[]colName=new String[cols];
					for(int i=0;i<cols;i++)
					colName[i]=rsdm.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					String workerid,names,email,phonenumber,experience,certificate;
					while(rs.next()) {
						workerid=rs.getString(1);
						names=rs.getString(2);
						email=rs.getString(3);
						phonenumber=rs.getString(4);
						experience=rs.getString(5);
						certificate =rs.getString(6);
						String[]row= {workerid,names,email,phonenumber,experience,certificate};	
						model.addRow(row);
						
								
					}
					
					
				}catch (Exception e2) {
					// TODO: handle exception
				}
					
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(476, 402, 89, 41);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			private Component deletebtn;

			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/workers_for_construction_recruitment","root","");	
					String sql="DELETE FROM account WHERE  workerid=?";
					int idtxf=Integer.parseInt(JOptionPane.showInputDialog("Enter  to delete ")); 
					PreparedStatement st=con.prepareStatement(sql);
					st.setInt(1, idtxf);
					final Component Delete;
					JOptionPane.showMessageDialog(deletebtn, "recored out!!");
					st.executeUpdate();
					st.close();
					con.close();
					
					
					
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}	
					
				}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_3.setBounds(308, 404, 118, 41);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_5 = new JLabel("experience");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(23, 299, 105, 31);
		contentPane.add(lblNewLabel_5);
		
		experiencetxf = new JTextField();
		experiencetxf.setBounds(266, 299, 211, 31);
		contentPane.add(experiencetxf);
		experiencetxf.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("certificate");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(22, 350, 118, 31);
		contentPane.add(lblNewLabel_6);
		
		certificatetxf = new JTextField();
		certificatetxf.setBounds(266, 352, 211, 31);
		contentPane.add(certificatetxf);
		certificatetxf.setColumns(10);
	}
}
