package form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class experience extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField experienceidtxf;
	private JTextField jobtitletxf;
	private JTextField durationtxf;
	private JTextField referencetxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					experience frame = new experience();
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
	public experience() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 512);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("experience id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(25, 79, 137, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("job title");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(25, 166, 114, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("duration");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(25, 244, 114, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("reference");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(25, 310, 124, 43);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("experience details");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(293, 24, 220, 41);
		contentPane.add(lblNewLabel_4);
		
		experienceidtxf = new JTextField();
		experienceidtxf.setBounds(372, 76, 124, 43);
		contentPane.add(experienceidtxf);
		experienceidtxf.setColumns(10);
		
		jobtitletxf = new JTextField();
		jobtitletxf.setBounds(372, 160, 124, 36);
		contentPane.add(jobtitletxf);
		jobtitletxf.setColumns(10);
		
		durationtxf = new JTextField();
		durationtxf.setBounds(372, 225, 124, 36);
		contentPane.add(durationtxf);
		durationtxf.setColumns(10);
		
		referencetxf = new JTextField();
		referencetxf.setBounds(372, 297, 124, 36);
		contentPane.add(referencetxf);
		referencetxf.setColumns(10);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/workers_for_constraction_recruitment","root","");
		String sql="INSERT INTO experience VALUES(?,?,?,?)";
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1, Integer.parseInt(experienceidtxf.getText()));
		st.setString(2,jobtitletxf.getText());
		st.setString(3, durationtxf.getText());
		st.setString(4, referencetxf.getText());
		st.executeUpdate();
		JOptionPane.showMessageDialog(btnNewButton, "data saved!!");
		
		st.close();
		con.close();
				
				
				
				
				
				
				
				
				
			} catch (Exception e2) {
				
			}
				
			
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(21, 408, 118, 56);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("view");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(389, 408, 124, 56);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("cancel");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				experienceidtxf.setText(null);
				jobtitletxf.setText(null);
				durationtxf.setText(null);
				referencetxf.setText(null);
			}
			
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(217, 408, 124, 56);
		contentPane.add(btnNewButton_2);
	}

}
