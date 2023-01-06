import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View implements ActionListener {

    private String userName;
    private char nw;
    private int age;
    private boolean male;
    private boolean female;

    class JTextFieldLimit extends PlainDocument {
        private int limit;
        JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null)
                return;
            if ((getLength() + str.length()) <= limit) {
                super.insertString(offset, str, attr);
            }
        }
    }

    private JLabel title;
    private JLabel userlabel;
    private JTextField userText;
    private JLabel messageUser;
    private JPanel userpanel;
    private JPanel nwpanel;
    private JTextField nwText;
    private JLabel messageAge;
    private JPanel agepanel;
    private JLabel ageLabel;
    private JTextField ageText;
    private JLabel messageGender;
    private JLabel nwLabel;
    private JPanel genderpanel;
    private JLabel genderLabel;
    private JLabel messageNw;
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    private JLabel maleLabel;
    private JLabel femaleLabel;
    private JLabel messageLabel;
    private static JButton button;
    private ButtonGroup bg = new ButtonGroup();
    private Border border = BorderFactory.createLineBorder(Color.black);

    View(){
        JFrame frame = new JFrame();
        frame.setSize(630,300);
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        userpanel = new JPanel();
        userpanel.setBounds(0,60,430,35);

        agepanel = new JPanel();
        agepanel.setBounds(0,100,430,35);

        genderpanel = new JPanel();
        genderpanel.setBounds(0,140,430,35);

        nwpanel = new JPanel();
        nwpanel.setBounds(0,180,430,35);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        title = new JLabel("Data Validation Task");
        title.setBounds(100,20,400,25);
        title.setFont(new Font("Arial",Font.BOLD,20));

        userlabel = new JLabel("Enter Username(Limit of 13 Characters)");
        userlabel.setBounds(10,60,300,25);

        userText = new JTextField();
        userText.setBounds(260,60,165,25);

        messageUser = new JLabel();
        messageUser.setBounds(440,60,300,25);

        ageLabel = new JLabel("Enter Age(Between ages 0 and 120)");
        ageLabel.setBounds(10,100,300,25);

        ageText= new JTextField();
        ageText.setBounds(260,100,165,25);

        messageAge = new JLabel();
        messageAge.setBounds(440,100,300,25);

        genderLabel = new JLabel("Choose your Gender");
        genderLabel.setBounds(10,140,150,25);
        genderLabel.setBackground(Color.RED);

        maleButton= new JRadioButton();
        maleButton.setBounds(260,140,40,25);

        maleLabel = new JLabel("Male");
        maleLabel.setBounds(290,140,40,25);

        femaleButton= new JRadioButton();
        femaleButton.setBounds(330,140,40,25);

        bg.add(maleButton);
        bg.add(femaleButton);

        femaleLabel = new JLabel("Female");
        femaleLabel.setBounds(360,140,50,25);

        messageGender = new JLabel();
        messageGender.setBounds(440,140,300,25);

        nwLabel = new JLabel("Do you have an existing account?('Y' or 'N')");
        nwLabel.setBounds(10,180,270,25);

        nwText = new JTextField();
        nwText.setDocument(new JTextFieldLimit(1));
        nwText.setBounds(300,180,22,25);

        messageNw = new JLabel();
        messageNw.setBounds(440,180,300,25);

        messageLabel = new JLabel("");
        messageLabel.setBounds(10,240,410,125);
        messageLabel.setBorder(border);

        button = new JButton("Login");
        button.setBounds(150,210,80,25);

        frame.add(panel);
        panel.add(userpanel);
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
        panel.add(nwLabel);
        panel.add(nwText);
        panel.add(messageUser);
        panel.add(messageAge);
        panel.add(messageGender);
        panel.add(messageNw);
        panel.add(button);

        panel.add(userpanel);
        panel.add(agepanel);
        panel.add(genderpanel);
        panel.add(nwpanel);
        frame.setVisible(true);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public char getNw() {
        return nw;
    }

    public void setNw(char nw) {
        this.nw = nw;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public boolean isFemale() {
        return female;
    }

    public void setFemale(boolean female) {
        this.female = female;
    }



    public JTextField getUserText(){
        return this.userText;
    }

    public JTextField getAgeText(){
        return this.ageText;
    }

    public JRadioButton getMaleButton(){
        return this.maleButton;
    }

    public JRadioButton getFemaleButton(){
        return this.femaleButton;
    }

    public JTextField getNwText(){
        return this.nwText;
    }

    public JButton getButton(){
        return this.button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if (userText == e.getSource()) {
                this.setUserName(userText.getText());

                if (this.getUserName().length() > 13) {
                    userpanel.setBackground(Color.RED);
                    messageUser.setText(" - Must be 13 Characters long");
                } else if (this.getUserName().length() <= 13) {
                    userpanel.setBackground(Color.WHITE);
                    messageUser.setText(" - Data is Valid");
                }
            }else if(userText == null) {
                userpanel.setBackground(Color.RED);
                messageUser.setText(" - Please insert the required information");
            }
/////////
            if (e.getSource() == ageText) {
                this.setAge(Integer.parseInt(ageText.getText()));
                if (this.getAge() < 0 || this.getAge() > 120) {
                    messageAge.setText(" - Must be between 0 or 120");
                    agepanel.setBackground(Color.RED);
                } else if (this.getAge() > 0 || this.getAge() < 120) {
                    agepanel.setBackground(Color.WHITE);
                    messageAge.setText(" - Data is Valid");
                }
            }else if(ageText == null) {
                agepanel.setBackground(Color.RED);
                messageAge.setText(" - Please insert the required information");
            }
///////////
            if (e.getSource() == maleButton || e.getSource() == femaleButton) {
                if (e.getSource() == maleButton) {
                    this.setMale(true);
                    this.setFemale(false);
                } else if (e.getSource() == femaleButton) {
                    this.setMale(false);
                    this.setFemale(true);
                }
                if (this.isMale() == false && this.isFemale() == false) {
                    messageGender.setText(" - Your gender must be chosen");
                    genderpanel.setBackground(Color.RED);
                } else if (this.isMale() == true || this.isFemale() == true) {
                    genderpanel.setBackground(Color.WHITE);
                    messageGender.setText(" - Data is Valid");
                }
            }else if(maleButton == null || femaleButton == null) {
                genderpanel.setBackground(Color.RED);
                messageGender.setText(" - Please insert the required information");
            }
//////////
            if (e.getSource() == nwText) {
                this.setNw(nwText.getText().charAt(0));
                if (this.getNw() == 'Y' || this.getNw() == 'N' || this.getNw() == 'y' || this.getNw() == 'n') {
                    nwpanel.setBackground(Color.WHITE);
                    messageNw.setText(" - Data is Valid");
                } else if (this.getNw() != 'Y' || this.getNw() != 'N' || this.getNw() != 'y' || this.getNw() != 'n') {
                    messageNw.setText(" - Incorrect letter used");
                    nwpanel.setBackground(Color.RED);
                }
            }else if(nwText == null){
                nwpanel.setBackground(Color.RED);
                messageNw.setText(" - Please insert the required information");
            }
        System.out.println(userText);

        }
    }

