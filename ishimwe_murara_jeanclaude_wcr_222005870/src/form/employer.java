package form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class employer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField employeridtxf;
	private JTextField namextxf;
	private JTextField identitynumbertxf;
	private JTextField emailtxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employer frame = new employer();
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
	public employer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 427);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("manager id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(29, 45, 122, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("names");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(29, 95, 103, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("identity number");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(24, 164, 145, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(" MANAGER DETAIL");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(275, 14, 257, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel addresstxf = new JLabel("email");
		addresstxf.setFont(new Font("Tahoma", Font.BOLD, 15));
		addresstxf.setBounds(24, 235, 108, 33);
		contentPane.add(addresstxf);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");

					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/workers_for_constraction_recruitment","root","");
			String sql="INSERT INTO employer VALUES(?,?,?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(employeridtxf.getText()));
			st.setString(2,namextxf.getText());
			st.setString(3, identitynumbertxf.getText());
			st.setString(4, emailtxf.getText());
			st.executeUpdate();
			JOptionPane.showMessageDialog(btnNewButton, "data saved!!");
			
			st.close();
			con.close();
					
					
					
					
					
					
					
					
					
				} catch (Exception e2) {
					
				}	
					
			}
					
				
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(41, 321, 159, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(245, 321, 150, 40);
		contentPane.add(btnNewButton_1);
		
		employeridtxf = new JTextField();
		employeridtxf.setBounds(330, 43, 176, 33);
		contentPane.add(employeridtxf);
		employeridtxf.setColumns(10);
		
		namextxf = new JTextField();
		namextxf.setBounds(330, 103, 176, 33);
		contentPane.add(namextxf);
		namextxf.setColumns(10);
		
		identitynumbertxf = new JTextField();
		identitynumbertxf.setBounds(330, 172, 176, 40);
		contentPane.add(identitynumbertxf);
		identitynumbertxf.setColumns(10);
		
		emailtxf = new JTextField();
		emailtxf.setBounds(330, 243, 176, 41);
		contentPane.add(emailtxf);
		emailtxf.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("update ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/workers_for_construction_recruitment","root","");
					String sql="UPDATE  manager=?,names=?,identity_number=?,email=? WHERE manager=?";					
					PreparedStatement st=con.prepareStatement(sql);

					st.setString(1,employeridtxf.getText());
					st.setString(2, namextxf.getText());
					st.setString(3, identitynumbertxf.getText());
					st.setString(4, emailtxf.getText());				
										
										
					JOptionPane.showMessageDialog(btnNewButton_2, "data changed!!!");
					st.executeUpdate();
					st.close();
					con.close();
										
										
										
										
									} catch (Exception e2) {
										// TODO: handle exception
									}
									
									
									
									
								}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(486, 325, 145, 33);
		contentPane.add(btnNewButton_2);
	}
	}

