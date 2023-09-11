import java.sql.SQLException;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet; 
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;
import javax.swing.JOptionPane;

public class Login extends JFrame {
    private JMenuBar menuBar;
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField userName;
    private JPasswordField userPass;

    //Constructor 
    public Login(){

        this.setTitle("Login");
        this.setSize(400,300);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(400,300));
        contentPane.setBackground(new Color(192,192,192));

        button1 = new JButton();
        button1.setBounds(72,216,90,35);
        button1.setBackground(new Color(214,217,223));
        button1.setForeground(new Color(0,0,0));
        button1.setEnabled(true);
        button1.setFont(new Font("sansserif",0,12));
        button1.setText("Login");
        button1.setVisible(true);
        //Set action for button click
        //Call defined method
        button1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    loginCheck(evt);
                }
            });

        button2 = new JButton();
        button2.setBounds(216,216,90,35);
        button2.setBackground(new Color(214,217,223));
        button2.setForeground(new Color(0,0,0));
        button2.setEnabled(true);
        button2.setFont(new Font("sansserif",0,12));
        button2.setText("Reset");
        button2.setVisible(true);
        //Set action for button click
        //Call defined method
        button2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    reset(evt);
                }
            });

        label1 = new JLabel();
        label1.setBounds(115,21,200,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("SansSerif",0,20));
        label1.setText("SIGN-IN PAGE");
        label1.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(33,91,90,35);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("SansSerif",0,16));
        label2.setText("User Name");
        label2.setVisible(true);

        label3 = new JLabel();
        label3.setBounds(34,145,90,35);
        label3.setBackground(new Color(214,217,223));
        label3.setForeground(new Color(0,0,0));
        label3.setEnabled(true);
        label3.setFont(new Font("SansSerif",0,16));
        label3.setText("Password");
        label3.setVisible(true);

        userName = new JTextField();
        userName.setBounds(166,91,200,35);
        userName.setBackground(new Color(255,255,255));
        userName.setForeground(new Color(0,0,0));
        userName.setEnabled(true);
        userName.setFont(new Font("sansserif",0,12));
        userName.setText("");
        userName.setVisible(true);

        userPass = new JPasswordField();
        userPass.setBounds(166,145,200,35);
        userPass.setBackground(new Color(214,217,223));
        userPass.setForeground(new Color(0,0,0));
        userPass.setEnabled(true);
        userPass.setFont(new Font("sansserif",0,12));
        userPass.setVisible(true);

        //adding components to contentPane panel
        contentPane.add(button1);
        contentPane.add(button2);
        contentPane.add(label1);
        contentPane.add(label2);
        contentPane.add(label3);
        contentPane.add(userName);
        contentPane.add(userPass);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //Method actionPerformed for button1
    private void loginCheck (ActionEvent evt) 
    {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\irfanfirosh\\Desktop\\COMPIADBMS\\login2.accdb");
            String sql = "Select * from userInfo where username=? and password=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, userName.getText());
            pst.setString(2, userPass.getText());
            rs = pst.executeQuery();
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null, "Username and Password Matched");
                new Menu().setVisible(true);
                this.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Username and Password Incorrect","ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
                userName.setText("");
                userPass.setText("");
            }
            con.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Method actionPerformed for button2
    private void reset (ActionEvent evt) {
        userName.setText("");
        userPass.setText("");
    }

    //method for generate menu
    public void generateMenu(){
        menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu tools = new JMenu("Tools");
        JMenu help = new JMenu("Help");

        JMenuItem open = new JMenuItem("Open   ");
        JMenuItem save = new JMenuItem("Save   ");
        JMenuItem exit = new JMenuItem("Exit   ");
        JMenuItem preferences = new JMenuItem("Preferences   ");
        JMenuItem about = new JMenuItem("About   ");

        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(exit);
        tools.add(preferences);
        help.add(about);

        menuBar.add(file);
        menuBar.add(tools);
        menuBar.add(help);
    }

    public static void main(String[] args){
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new Login();
                }
            });
    }

}