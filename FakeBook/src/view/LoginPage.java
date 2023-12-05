package view;

import model.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class LoginPage implements ActionListener {
    private HashMap<String, String> loginInfo = new HashMap<>();
    private HashMap<String, Integer> loginId = new HashMap<>();
    private SocialMediaNetworkView socialMediaNetwork = new SocialMediaNetworkView(this);
    private JFrame jFrameLogin = new JFrame();
    private JButton loginButton = new JButton("Login");
    private JButton registerButton = new JButton("Register");
    private JButton okButton = new JButton("Ok");
    private JButton resetButton = new JButton("Reset");
    private JTextField userIdField = new JTextField();
    private JTextField passwordField = new JTextField();
    private JRadioButton maleRadioButton = new JRadioButton("Male");
    private JRadioButton femaleRadioButton = new JRadioButton("Female");
    private JTextField userDateOfBirthField = new JTextField();
    private JPasswordField userPasswordField = new JPasswordField();
    private JLabel userIdLabel = new JLabel("userID:");
    private JLabel userPasswordLabel = new JLabel("password:");
    private JLabel messageLabel = new JLabel();
    private int idUser = 0;
    private JLabel userDateOfBirthLabel = new JLabel("Date of birth");
    private JLabel userGenderLabel = new JLabel("Gender:");
    private ButtonGroup buttonGroup = new ButtonGroup();
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public LoginPage() {
        this.socialMediaNetwork.setVisible(false);

        this.userIdLabel.setBounds(50, 100, 75, 25);
        this.userPasswordLabel.setBounds(50, 150, 75, 25);
        this.userGenderLabel.setBounds(50, 200, 75, 25);
        this.userDateOfBirthLabel.setBounds(50, 250, 75, 25);

        this.messageLabel.setBounds(100, 300, 350, 35);
        this.messageLabel.setFont(new Font(null, Font.ITALIC, 20));

        this.userIdField.setBounds(125, 100, 200, 25);
        this.userPasswordField.setBounds(125, 150, 200, 25);
        this.passwordField.setBounds(125, 150, 200, 25);
        this.maleRadioButton.setBounds(125, 200, 100, 25);
        this.femaleRadioButton.setBounds(225, 200, 100, 25);
        this.userDateOfBirthField.setBounds(125, 250, 200, 25);

        this.buttonGroup.add(maleRadioButton);
        this.buttonGroup.add(femaleRadioButton);

        this.loginButton.setBounds(125, 350, 100, 25);
        this.loginButton.setFocusable(false);
        this.loginButton.addActionListener(this);

        this.registerButton.setBounds(225, 350, 100, 25);
        this.registerButton.setFocusable(false);
        this.registerButton.addActionListener(this);

        this.okButton.setBounds(125, 350, 100, 25);
        this.okButton.setFocusable(false);
        this.okButton.addActionListener(this);

        this.resetButton.setBounds(225, 350, 100, 25);
        this.resetButton.setFocusable(false);
        this.resetButton.addActionListener(this);

        this.jFrameLogin.add(this.userIdLabel);
        this.jFrameLogin.add(this.userPasswordLabel);
        this.jFrameLogin.add(messageLabel);
        this.jFrameLogin.add(this.userIdField);
        this.jFrameLogin.add(this.userPasswordField);
        this.jFrameLogin.add(loginButton);
        this.jFrameLogin.add(registerButton);

        this.jFrameLogin.setTitle("Login page");
        this.jFrameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jFrameLogin.setSize(520, 520);
        this.jFrameLogin.setLocationRelativeTo(null);
        this.jFrameLogin.setLayout(null);
        this.jFrameLogin.setVisible(true);
    }

    public void registerPage() {
        this.jFrameLogin.setTitle("Register page");
        this.jFrameLogin.remove(this.userPasswordField);
        this.jFrameLogin.remove(this.loginButton);
        this.jFrameLogin.remove(this.registerButton);

        this.jFrameLogin.add(this.userGenderLabel);
        this.jFrameLogin.add(this.userDateOfBirthLabel);

        this.jFrameLogin.add(this.passwordField);
        this.jFrameLogin.add(this.maleRadioButton);
        this.jFrameLogin.add(this.femaleRadioButton);
        this.jFrameLogin.add(this.userDateOfBirthField);
        this.jFrameLogin.add(this.okButton);
        this.jFrameLogin.add(this.resetButton);

        SwingUtilities.updateComponentTreeUI(jFrameLogin);
    }

    public void returnLogin() {
        this.jFrameLogin.setTitle("Login page");
        this.jFrameLogin.remove(this.passwordField);
        this.jFrameLogin.remove(this.okButton);
        this.jFrameLogin.remove(this.resetButton);
        this.jFrameLogin.remove(this.userDateOfBirthLabel);
        this.jFrameLogin.remove(this.userDateOfBirthField);
        this.jFrameLogin.remove(this.userGenderLabel);
        this.jFrameLogin.remove(maleRadioButton);
        this.jFrameLogin.remove(femaleRadioButton);


        this.jFrameLogin.add(this.userPasswordField);
        this.jFrameLogin.add(this.loginButton);
        this.jFrameLogin.add(this.registerButton);

        SwingUtilities.updateComponentTreeUI(jFrameLogin);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            this.registerPage();
        } else if (e.getSource() == loginButton) {
            String userId = this.userIdField.getText();
            String password = String.valueOf(this.userPasswordField.getPassword());

            if (this.loginInfo.containsKey(userId)) {
                if (this.loginInfo.get(userId).equals(password)) {
                    this.messageLabel.setForeground(Color.GREEN);
                    this.messageLabel.setText("Login successful");

                    this.jFrameLogin.setVisible(false);

                    int id = this.loginId.get(userId);
                    this.socialMediaNetwork.changeUser(id, userId);
                    this.socialMediaNetwork.setVisible(true);
                } else {
                    this.messageLabel.setForeground(Color.RED);
                    this.messageLabel.setText("Wrong password");
                }
            } else {
                this.messageLabel.setForeground(Color.RED);
                this.messageLabel.setText("Username not found");
            }
        } else if (e.getSource() == this.resetButton) {
            this.userIdField.setText("");
            this.passwordField.setText("");
            this.userDateOfBirthField.setText("");
            this.buttonGroup.clearSelection();
        } else if (e.getSource() == this.okButton) {
            String userId = this.userIdField.getText();
            String password = this.passwordField.getText();
            boolean userGender = this.maleRadioButton.isSelected() ? true : false;
            Date userDateOfBirth = null;

            boolean isDateVail = false;
            while (isDateVail == false) {
                try {
                    userDateOfBirth = this.dateFormat.parse(this.userDateOfBirthField.getText());
                    isDateVail = true;
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(this.jFrameLogin,
                            "Enter date in format dd/MM/yyyy");
                    throw new RuntimeException(ex);
                }
            }

            Node user = new Node(userId, userGender, userDateOfBirth);

            if (this.loginInfo.containsKey(userId)) {
                this.messageLabel.setForeground(Color.RED);
                this.messageLabel.setText("Username has already exist!");
            } else {
                this.loginInfo.put(userId, password);
                this.loginId.put(userId, idUser);
                this.idUser += 1;
                this.socialMediaNetwork.addUser(user);
                this.returnLogin();
            }
        }
    }

    public void setVisibleView(boolean status) {
        this.jFrameLogin.setVisible(status);
    }
}