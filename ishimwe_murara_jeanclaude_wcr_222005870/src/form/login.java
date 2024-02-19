package form;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField passwartxf;
    private JTextField usernamestxf;
    private Connection connection;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    login frame = new login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public login() {
        connectToDatabase(); // Connect to the database when the form is created

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 357);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 255, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("user names");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(53, 80, 115, 43);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("passward");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel_1.setBounds(40, 159, 115, 36);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("log in for worker");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2.setBounds(222, 42, 175, 36);
        contentPane.add(lblNewLabel_2);

        JButton btnNewButton = new JButton("log in");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernamestxf.getText();
                String password = passwartxf.getText();

                // Validate the login credentials
                if (validateLogin(username, password)) {
                    System.out.println("Login successful");
                    // Add code to navigate to the next frame or perform other actions
                } else {
                    System.out.println("Invalid login");
                }
            }
        });
        btnNewButton.setBounds(40, 255, 130, 43);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("cancel");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                usernamestxf.setText(null);
                passwartxf.setText(null);
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton_1.setBounds(248, 255, 149, 43);
        contentPane.add(btnNewButton_1);

        passwartxf = new JTextField();
        passwartxf.setBounds(248, 169, 123, 49);
        contentPane.add(passwartxf);
        passwartxf.setColumns(10);

        usernamestxf = new JTextField();
        usernamestxf.setBounds(248, 103, 123, 36);
        contentPane.add(usernamestxf);
        usernamestxf.setColumns(10);
    }

    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/workers";
            String user = "your_username";
            String password = "your_password";
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean validateLogin(String username, String password) {
        try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // If a row is returned, the login is valid
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
