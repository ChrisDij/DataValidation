import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Login2 implements ActionListener {
    private static JLabel title;
    private static JLabel userlabel;
    private static JTextField userText;
    private static JPanel userpanel;
    private static JPanel datepanel;
    private static JPanel agepanel;
    private static JLabel ageLabel;
    private static JTextField ageText;
    private static JLabel dobLabel;
    private static JPanel genderpanel;
    private static JLabel genderLabel;
    private static JRadioButton maleButton;
    private static JRadioButton femaleButton;
    private static JLabel maleLabel;
    private static JLabel femaleLabel;
    private static JButton button;
    private static JLabel messageLabel;
    private static ButtonGroup bg = new ButtonGroup();
    private static Border border = BorderFactory.createLineBorder(Color.black);

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert){
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    public static void main (String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(430,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        userpanel = new JPanel();
        userpanel.setBounds(0,60,400,35);

        agepanel = new JPanel();
        agepanel.setBounds(0,100,400,35);

        genderpanel = new JPanel();
        genderpanel.setBounds(0,140,400,35);

        datepanel = new JPanel();
        datepanel.setBounds(0,180,400,35);
        datepanel.setBackground(Color.RED);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        title = new JLabel("Data Validation Task");
        title.setBounds(100,20,400,25);
        title.setFont(new Font("Arial",Font.BOLD,20));

        userlabel = new JLabel("Enter Username(Limit of 13 Characters)");
        userlabel.setBounds(10,60,300,25);

        userText = new JTextField();
        userText.setBounds(260,60,165,25);

        ageLabel = new JLabel("Enter Age(Between ages 0 and 120)");
        ageLabel.setBounds(10,100,300,25);

        ageText= new JTextField();
        ageText.setBounds(260,100,165,25);

        genderLabel = new JLabel("Choose your Gender");
        genderLabel.setBounds(10,140,150,25);
        genderLabel.setBackground(Color.RED);

        maleButton= new JRadioButton();
        maleButton.setBounds(260,140,40,25);
       // maleButton.addActionListener();
        bg.add(maleButton);

        maleLabel = new JLabel("Male");
        maleLabel.setBounds(290,140,40,25);

        femaleButton= new JRadioButton();
        femaleButton.setBounds(330,140,40,25);
       // femaleButton.addActionListener();
        bg.add(femaleButton);

        femaleLabel = new JLabel("Female");
        femaleLabel.setBounds(360,140,50,25);

        dobLabel = new JLabel("Choose Date of Birth");
        dobLabel.setBounds(10,180,150,25);

        button = new JButton("Login");
        button.setBounds(150,210,80,25);
        //button.addActionListener(new Login());

        messageLabel = new JLabel("");
        messageLabel.setBounds(10,240,410,125);
        messageLabel.setBorder(border);

        panel.add(title);
        panel.add(userlabel);
        panel.add(userText);
        panel.add(ageLabel);
        panel.add(ageText);
        panel.add(genderLabel);
        panel.add(maleButton);
        panel.add(maleLabel);
        panel.add(femaleButton);
        panel.add(femaleLabel);
        panel.add(dobLabel);
        panel.add(button);
        panel.add(messageLabel);
        panel.add(userpanel);
        panel.add(agepanel);
        panel.add(genderpanel);
        panel.add(datepanel);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        int age = Integer.parseInt(ageText.getText());

        String message = "";

        if (user.length() > 13){
            message += " - Must be 13 Characters long";
            userpanel.setBackground(Color.RED);
        }else if (user.length() <= 13){
            userpanel.setBackground(Color.WHITE);
        }

        if (age < 0 || age > 120){
            message += "\n - Must be between 0 or 120";
            agepanel.setBackground(Color.RED);
        }else if (age > 0 || age < 120){
            agepanel.setBackground(Color.WHITE);
        }

        if (e.getSource() != maleButton && e.getSource() != femaleButton){
            message += "\n - Your gender must be chosen";
            genderpanel.setBackground(Color.RED);
        }
        if(user.length() < 13 && (age > 0 || age < 120)){
            message = " - Data Validation Complete" + "\n" +"Data is Valid";
        }

        //messageLabel.setText(message);
        System.out.println(message);
    }
} 