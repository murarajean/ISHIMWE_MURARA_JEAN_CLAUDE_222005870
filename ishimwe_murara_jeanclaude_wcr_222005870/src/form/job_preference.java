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

public class job_preference extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jobtxtf;
	private JTextField jobttxtf;
	private JTextField mobtxtf;
	private JTextField workeridtxtf;
	private JTextField workerstxtf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					job_preference frame = new job_preference();
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
	public job_preference() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 504);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 0));
		contentPane.setForeground(new Color(128, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("job type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(35, 135, 87, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("worker schedule");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(35, 298, 152, 37);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("job_preference detail");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(308, 11, 246, 37);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("mobility");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(35, 204, 110, 37);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("worker id");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(35, 252, 87, 37);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/workers_for_constraction_recruitment","root","");
		String sql="INSERT INTO job_preference VALUES(?,?,?,?,?)";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1, Integer.parseInt(jobtxtf.getText()));
		st.setString(2,jobttxtf.getText());
		st.setString(3, mobtxtf.getText());
		st.setString(4, workeridtxtf.getText());
		st.setString(5, workerstxtf.getText());
		st.executeUpdate();
		JOptionPane.showMessageDialog(btnNewButton, "data saved!!");
		
		st.close();
		con.close();
				
				
				
				
				
				
				
				
				
			} catch (Exception e2) {
				
			}	
				
				
				
				
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(20, 398, 165, 58);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jobttxtf.setText(null);
				mobtxtf.setText(null);
				 workeridtxtf.setText(null);
				 workerstxtf.setText(null);
			}
			
			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(310, 398, 171, 58);
		contentPane.add(btnNewButton_1);
		
		jobtxtf = new JTextField();
		jobtxtf.setBounds(303, 75, 178, 34);
		contentPane.add(jobtxtf);
		jobtxtf.setColumns(10);
		
		jobttxtf = new JTextField();
		jobttxtf.setBounds(304, 132, 177, 37);
		contentPane.add(jobttxtf);
		jobttxtf.setColumns(10);
		
		mobtxtf = new JTextField();
		mobtxtf.setBounds(307, 209, 174, 30);
		contentPane.add(mobtxtf);
		mobtxtf.setColumns(10);
		
		workeridtxtf = new JTextField();
		workeridtxtf.setBounds(304, 254, 177, 37);
		contentPane.add(workeridtxtf);
		workeridtxtf.setColumns(10);
		
		workerstxtf = new JTextField();
		workerstxtf.setBounds(308, 300, 178, 37);
		contentPane.add(workerstxtf);
		workerstxtf.setColumns(10);
	}

}
