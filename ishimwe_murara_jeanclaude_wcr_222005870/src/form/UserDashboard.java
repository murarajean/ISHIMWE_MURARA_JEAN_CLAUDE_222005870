
package form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserDashboard extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserDashboard frame = new UserDashboard();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UserDashboard() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("User Dashboard");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(135, 11, 180, 25);
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton("View Profile");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to display user profile
            }
        });
        btnNewButton.setBounds(135, 73, 180, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Edit Profile");
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to edit user profile
            }
        });
        btnNewButton_1.setBounds(135, 118, 180, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Logout");
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to logout the user
            }
        });
        btnNewButton_2.setBounds(135, 163, 180, 23);
        contentPane.add(btnNewButton_2);
    }
}
