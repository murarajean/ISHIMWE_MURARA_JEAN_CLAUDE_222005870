import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class job extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField jobidtxf;
    private JTextField locationtxf;
    private JTextField skillstxf;
    private JTextField employeridtxf;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    job frame = new job();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public job() {
        getContentPane().setForeground(new Color(255, 0, 128));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 523, 426);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("job id");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(56, 50, 121, 33);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("location");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_1.setBounds(54, 110, 105, 33);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("employer id");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_2.setBounds(54, 244, 110, 33);
        getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("job details");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 21));
        lblNewLabel_3.setBounds(333, 0, 144, 44);
        getContentPane().add(lblNewLabel_3);

        JButton btnNewButton = new JButton("submit");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/workers_for_constraction_recruitment", "root", "");
                    String sql = "INSERT INTO job VALUES(?,?,?,?)";
                    PreparedStatement st = con.prepareStatement(sql);
                    st.setInt(1, Integer.parseInt(jobidtxf.getText()));
                    st.setString(2, locationtxf.getText());
                    st.setString(3, skillstxf.getText());
                    st.setString(4, employeridtxf.getText());
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(btnNewButton, "data saved!!");

                    st.close();
                    con.close();

                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
