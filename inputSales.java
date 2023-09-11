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

public class inputSales extends JFrame {

    private JMenuBar menuBar;
    private JTextField fr1;
    private JTextField fr2;
    private JLabel label1;
    private JLabel label10;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JTextField mo1;
    private JTextField mo2;
    private JButton reset;
    private JTextField sa1;
    private JTextField su1;
    private JTextField su2;
    private JButton submit;
    private JTextField tu1;
    private JTextField sa2;
    private JTextField th1;
    private JTextField th2;
    private JTextField tu2;
    private JTextField we1;
    private JTextField we2;

    //Constructor 
    public inputSales(){

        this.setTitle("inputSales");
        this.setSize(1300,400);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(1300,400));
        contentPane.setBackground(new Color(192,192,192));

        fr1 = new JTextField();
        fr1.setBounds(850,129,110,35);
        fr1.setBackground(new Color(255,255,255));
        fr1.setForeground(new Color(0,0,0));
        fr1.setEnabled(true);
        fr1.setFont(new Font("sansserif",0,12));
        fr1.setText("");
        fr1.setVisible(true);

        fr2 = new JTextField();
        fr2.setBounds(850,225,110,35);
        fr2.setBackground(new Color(255,255,255));
        fr2.setForeground(new Color(0,0,0));
        fr2.setEnabled(true);
        fr2.setFont(new Font("sansserif",0,12));
        fr2.setText("");
        fr2.setVisible(true);

        label1 = new JLabel();
        label1.setBounds(170,24,90,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("SansSerif",0,20));
        label1.setText("Monday");
        label1.setVisible(true);

        label10 = new JLabel();
        label10.setBounds(24,225,90,35);
        label10.setBackground(new Color(214,217,223));
        label10.setForeground(new Color(0,0,0));
        label10.setEnabled(true);
        label10.setFont(new Font("SansSerif",0,20));
        label10.setText("Week 2 :");
        label10.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(340,24,129,35);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("SansSerif",0,20));
        label2.setText("Tuesday");
        label2.setVisible(true);

        label3 = new JLabel();
        label3.setBounds(510,24,120,35);
        label3.setBackground(new Color(214,217,223));
        label3.setForeground(new Color(0,0,0));
        label3.setEnabled(true);
        label3.setFont(new Font("SansSerif",0,20));
        label3.setText("Wednesday");
        label3.setVisible(true);

        label4 = new JLabel();
        label4.setBounds(680,24,90,35);
        label4.setBackground(new Color(214,217,223));
        label4.setForeground(new Color(0,0,0));
        label4.setEnabled(true);
        label4.setFont(new Font("SansSerif",0,20));
        label4.setText("Thursday");
        label4.setVisible(true);

        label5 = new JLabel();
        label5.setBounds(850,24,90,35);
        label5.setBackground(new Color(214,217,223));
        label5.setForeground(new Color(0,0,0));
        label5.setEnabled(true);
        label5.setFont(new Font("SansSerif",0,20));
        label5.setText("Friday");
        label5.setVisible(true);

        label6 = new JLabel();
        label6.setBounds(997,24,90,35);
        label6.setBackground(new Color(214,217,223));
        label6.setForeground(new Color(0,0,0));
        label6.setEnabled(true);
        label6.setFont(new Font("SansSerif",0,20));
        label6.setText("Saturday");
        label6.setVisible(true);

        label7 = new JLabel();
        label7.setBounds(1155,24,90,35);
        label7.setBackground(new Color(214,217,223));
        label7.setForeground(new Color(0,0,0));
        label7.setEnabled(true);
        label7.setFont(new Font("SansSerif",0,20));
        label7.setText("Sunday");
        label7.setVisible(true);

        label8 = new JLabel();
        label8.setBounds(24,129,90,35);
        label8.setBackground(new Color(214,217,223));
        label8.setForeground(new Color(0,0,0));
        label8.setEnabled(true);
        label8.setFont(new Font("SansSerif",0,20));
        label8.setText("Week 1 :");
        label8.setVisible(true);

        label9 = new JLabel();
        label9.setBounds(1145,325,150,70);
        label9.setBackground(new Color(214,217,223));
        label9.setForeground(new Color(255,51,51));
        label9.setEnabled(true);
        label9.setFont(new Font("SansSerif",0,16));
        label9.setText("Enter Sales in AED");
        label9.setVisible(true);

        mo1 = new JTextField();
        mo1.setBounds(170,131,110,35);
        mo1.setBackground(new Color(255,255,255));
        mo1.setForeground(new Color(0,0,0));
        mo1.setEnabled(true);
        mo1.setFont(new Font("sansserif",0,12));
        mo1.setText("");
        mo1.setVisible(true);

        mo2 = new JTextField();
        mo2.setBounds(170,225,110,35);
        mo2.setBackground(new Color(255,255,255));
        mo2.setForeground(new Color(0,0,0));
        mo2.setEnabled(true);
        mo2.setFont(new Font("sansserif",0,12));
        mo2.setText("");
        mo2.setVisible(true);

        reset = new JButton();
        reset.setBounds(1008,347,120,35);
        reset.setBackground(new Color(214,217,223));
        reset.setForeground(new Color(0,0,0));
        reset.setEnabled(true);
        reset.setFont(new Font("sansserif",0,12));
        reset.setText("Reset");
        reset.setVisible(true);
        //Set action for button click
        //Call defined method
        reset.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    resetValues(evt);
                }
            });

        sa1 = new JTextField();
        sa1.setBounds(997,129,110,35);
        sa1.setBackground(new Color(255,255,255));
        sa1.setForeground(new Color(0,0,0));
        sa1.setEnabled(true);
        sa1.setFont(new Font("sansserif",0,12));
        sa1.setText("");
        sa1.setVisible(true);

        su1 = new JTextField();
        su1.setBounds(1155,129,110,35);
        su1.setBackground(new Color(255,255,255));
        su1.setForeground(new Color(0,0,0));
        su1.setEnabled(true);
        su1.setFont(new Font("sansserif",0,12));
        su1.setText("");
        su1.setVisible(true);

        su2 = new JTextField();
        su2.setBounds(1155,225,110,35);
        su2.setBackground(new Color(255,255,255));
        su2.setForeground(new Color(0,0,0));
        su2.setEnabled(true);
        su2.setFont(new Font("sansserif",0,12));
        su2.setText("");
        su2.setVisible(true);

        submit = new JButton();
        submit.setBounds(863,347,120,35);
        submit.setBackground(new Color(214,217,223));
        submit.setForeground(new Color(0,0,0));
        submit.setEnabled(true);
        submit.setFont(new Font("SansSerif",0,14));
        submit.setText("Submit");
        submit.setVisible(true);
        //Set action for button click
        //Call defined method
        submit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    submitValues(evt);
                }
            });

        tu1 = new JTextField();
        tu1.setBounds(340,129,110,35);
        tu1.setBackground(new Color(255,255,255));
        tu1.setForeground(new Color(0,0,0));
        tu1.setEnabled(true);
        tu1.setFont(new Font("sansserif",0,12));
        tu1.setText("");
        tu1.setVisible(true);

        sa2 = new JTextField();
        sa2.setBounds(997,225,110,35);
        sa2.setBackground(new Color(255,255,255));
        sa2.setForeground(new Color(0,0,0));
        sa2.setEnabled(true);
        sa2.setFont(new Font("sansserif",0,12));
        sa2.setText("");
        sa2.setVisible(true);

        th1 = new JTextField();
        th1.setBounds(680,129,110,35);
        th1.setBackground(new Color(255,255,255));
        th1.setForeground(new Color(0,0,0));
        th1.setEnabled(true);
        th1.setFont(new Font("sansserif",0,12));
        th1.setText("");
        th1.setVisible(true);

        th2 = new JTextField();
        th2.setBounds(680,225,110,35);
        th2.setBackground(new Color(255,255,255));
        th2.setForeground(new Color(0,0,0));
        th2.setEnabled(true);
        th2.setFont(new Font("sansserif",0,12));
        th2.setText("");
        th2.setVisible(true);

        tu2 = new JTextField();
        tu2.setBounds(340,225,110,35);
        tu2.setBackground(new Color(255,255,255));
        tu2.setForeground(new Color(0,0,0));
        tu2.setEnabled(true);
        tu2.setFont(new Font("sansserif",0,12));
        tu2.setText("");
        tu2.setVisible(true);

        we1 = new JTextField();
        we1.setBounds(510,129,110,35);
        we1.setBackground(new Color(255,255,255));
        we1.setForeground(new Color(0,0,0));
        we1.setEnabled(true);
        we1.setFont(new Font("sansserif",0,12));
        we1.setText("");
        we1.setVisible(true);

        we2 = new JTextField();
        we2.setBounds(510,225,110,35);
        we2.setBackground(new Color(255,255,255));
        we2.setForeground(new Color(0,0,0));
        we2.setEnabled(true);
        we2.setFont(new Font("sansserif",0,12));
        we2.setText("");
        we2.setVisible(true);

        //adding components to contentPane panel
        contentPane.add(fr1);
        contentPane.add(fr2);
        contentPane.add(label1);
        contentPane.add(label10);
        contentPane.add(label2);
        contentPane.add(label3);
        contentPane.add(label4);
        contentPane.add(label5);
        contentPane.add(label6);
        contentPane.add(label7);
        contentPane.add(label8);
        contentPane.add(label9);
        contentPane.add(mo1);
        contentPane.add(mo2);
        contentPane.add(reset);
        contentPane.add(sa1);
        contentPane.add(su1);
        contentPane.add(su2);
        contentPane.add(submit);
        contentPane.add(tu1);
        contentPane.add(sa2);
        contentPane.add(th1);
        contentPane.add(th2);
        contentPane.add(tu2);
        contentPane.add(we1);
        contentPane.add(we2);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //Method actionPerformed for reset
    private void resetValues (ActionEvent evt) {
        mo1.setText("");
        tu1.setText("");
        we1.setText("");
        th1.setText("");
        fr1.setText("");
        sa1.setText("");
        su1.setText("");

        mo2.setText("");
        tu2.setText("");
        we2.setText("");
        th2.setText("");
        fr2.setText("");
        sa2.setText("");
        su2.setText("");
    }

    //Method actionPerformed for submit
    private void submitValues (ActionEvent evt) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        String query = "delete FROM sales";
        String query1 = "insert into sales" + "(Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday,Total,Factor)" + "values (?,?,?,?,?,?,?,?,?)";
        String query2 = "insert into sales" + "(Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday,Total, Factor)" + "values (?,?,?,?,?,?,?,?,?)";
        String total1 = Integer.toString((Integer.parseInt(mo1.getText())) + (Integer.parseInt(tu1.getText()))+ (Integer.parseInt(we1.getText()))+ (Integer.parseInt(th1.getText()))+ (Integer.parseInt(fr1.getText())+ (Integer.parseInt(sa1.getText())+ (Integer.parseInt(su1.getText())))));
        String total2 = Integer.toString((Integer.parseInt(mo2.getText())) + (Integer.parseInt(tu2.getText()))+ (Integer.parseInt(we2.getText()))+ (Integer.parseInt(th2.getText()))+ (Integer.parseInt(fr2.getText())+ (Integer.parseInt(sa2.getText())+ (Integer.parseInt(su2.getText())))));
        String growth = Integer.toString(((Integer.parseInt(total2)) - (Integer.parseInt(total1)))/(Integer.parseInt(total1)));
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\irfanfirosh\\Desktop\\COMPIADBMS\\login2.accdb");
            pst = con.prepareStatement(query);
            pst.executeUpdate();
            pst.close();

            pst1 = con.prepareStatement(query1);
            
            
            pst1.setString(1, mo1.getText());
            pst1.setString(2, tu1.getText());
            pst1.setString(3, we1.getText());
            pst1.setString(4, th1.getText());
            pst1.setString(5, fr1.getText());
            pst1.setString(6, sa1.getText());
            pst1.setString(7, su1.getText());
            pst1.setString(8, total1);
            pst1.setString(9, growth);
            pst1.executeUpdate();
            pst1.close();
            
            pst2 = con.prepareStatement(query2);
            
            
            pst2.setString(1, mo2.getText());
            pst2.setString(2, tu2.getText());
            pst2.setString(3, we2.getText());
            pst2.setString(4, th2.getText());
            pst2.setString(5, fr2.getText());
            pst2.setString(6, sa2.getText());
            pst2.setString(7, su2.getText());
            pst2.setString(8, total2);
            pst2.setString(9, growth);
            pst2.executeUpdate();
            pst2.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Input Succesful");
            this.setVisible(false);

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
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
                    new inputSales();
                }
            });
    }

}