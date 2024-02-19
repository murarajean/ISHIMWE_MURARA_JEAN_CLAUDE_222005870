package form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class jobs extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField jobidTextField;
    private JTextField locationTextField;
    private JTextField skillsTextField;
    private JTextField employeridTextField;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    jobs frame = new jobs();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public jobs() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblJobId = new JLabel("Job ID:");
        lblJobId.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblJobId.setBounds(10, 20, 60, 14);
        contentPane.add(lblJobId);

        jobidTextField = new JTextField();
        jobidTextField.setBounds(190, 19, 86, 20);
        contentPane.add(jobidTextField);
        jobidTextField.setColumns(10);

        JLabel lblLocation = new JLabel("Location:");
        lblLocation.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblLocation.setBounds(10, 50, 89, 14);
        contentPane.add(lblLocation);

        locationTextField = new JTextField();
        locationTextField.setBounds(190, 49, 86, 20);
        contentPane.add(locationTextField);
        locationTextField.setColumns(10);

        JLabel lblSkills = new JLabel("Skills:");
        lblSkills.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblSkills.setBounds(10, 80, 60, 14);
        contentPane.add(lblSkills);

        skillsTextField = new JTextField();
        skillsTextField.setBounds(190, 80, 86, 20);
        contentPane.add(skillsTextField);
        skillsTextField.setColumns(10);

        JLabel lblEmployerId = new JLabel("Employer ID:");
        lblEmployerId.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblEmployerId.setBounds(10, 110, 107, 14);
        contentPane.add(lblEmployerId);

        employeridTextField = new JTextField();
        employeridTextField.setBounds(190, 109, 86, 20);
        contentPane.add(employeridTextField);
        employeridTextField.setColumns(10);

        JButton btnSave = new JButton("Save");
        btnSave.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to save job details to database
            }
        });
        btnSave.setBounds(10, 193, 107, 23);
        contentPane.add(btnSave);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to update job details in database
            }
        });
        btnUpdate.setBounds(163, 193, 128, 23);
        contentPane.add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add code to delete job from database
            }
        });
        btnDelete.setBounds(375, 197, 128, 23);
        contentPane.add(btnDelete);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 258, 614, 192);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null, null},
            },
            new String[] {
                "Job ID", "Location", "Skills", "Employer ID"
            }
        ));
        scrollPane.setViewportView(table);
    }
}
