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

public class salesForecast extends JFrame {
    private JMenuBar menuBar;
    private JButton display;
    private JButton exit;
    private JButton input;
    private JLabel label1;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel perDay;
    private JLabel perWeek;
    private JLabel perYear;
    private JButton report;
    private JButton reset;

    //Constructor 
    public salesForecast(){

        this.setTitle("salesForecast");
        this.setSize(700,450);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(700,450));
        contentPane.setBackground(new Color(192,192,192));

        display = new JButton();
        display.setBounds(101,298,90,35);
        display.setBackground(new Color(214,217,223));
        display.setForeground(new Color(0,0,0));
        display.setEnabled(true);
        display.setFont(new Font("sansserif",0,12));
        display.setText("Display");
        display.setVisible(true);
        //Set action for button click
        //Call defined method
        display.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    displayInfo(evt);
                }
            });

        exit = new JButton();
        exit.setBounds(49,149,200,50);
        exit.setBackground(new Color(214,217,223));
        exit.setForeground(new Color(0,0,0));
        exit.setEnabled(true);
        exit.setFont(new Font("SansSerif",0,18));
        exit.setText("Back To Menu");
        exit.setVisible(true);
        //Set action for button click
        //Call defined method
        exit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    exitMenu(evt);
                }
            });

        input = new JButton();
        input.setBounds(5,298,90,35);
        input.setBackground(new Color(214,217,223));
        input.setForeground(new Color(0,0,0));
        input.setEnabled(true);
        input.setFont(new Font("sansserif",0,12));
        input.setText("Input");
        input.setVisible(true);
        //Set action for button click
        //Call defined method
        input.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    inputInfo(evt);
                }
            });

        label1 = new JLabel();
        label1.setBounds(136,15,150,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("SansSerif",0,22));
        label1.setText("Information");
        label1.setVisible(true);

        label11 = new JLabel();
        label11.setBounds(108,15,90,35);
        label11.setBackground(new Color(214,217,223));
        label11.setForeground(new Color(0,0,0));
        label11.setEnabled(true);
        label11.setFont(new Font("SansSerif",0,22));
        label11.setText("Actions");
        label11.setVisible(true);

        label12 = new JLabel();
        label12.setBounds(0,232,320,35);
        label12.setBackground(new Color(214,217,223));
        label12.setForeground(new Color(0,0,0));
        label12.setEnabled(true);
        label12.setFont(new Font("sansserif",0,12));
        label12.setText("-----------------------------------------------------------------------------------------");
        label12.setVisible(true);

        label13 = new JLabel();
        label13.setBounds(234,10,300,50);
        label13.setBackground(new Color(214,217,223));
        label13.setForeground(new Color(0,0,0));
        label13.setEnabled(true);
        label13.setFont(new Font("SansSerif",0,28));
        label13.setText("SALES FORECAST");
        label13.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(17,87,250,35);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("SansSerif",0,16));
        label2.setText("Avg. Sales Per Day (this year): ");
        label2.setVisible(true);

        label3 = new JLabel();
        label3.setBounds(17,116,90,35);
        label3.setBackground(new Color(214,217,223));
        label3.setForeground(new Color(0,0,0));
        label3.setEnabled(true);
        label3.setFont(new Font("sansserif",0,12));
        label3.setText("AED");
        label3.setVisible(true);

        label4 = new JLabel();
        label4.setBounds(17,181,250,35);
        label4.setBackground(new Color(214,217,223));
        label4.setForeground(new Color(0,0,0));
        label4.setEnabled(true);
        label4.setFont(new Font("SansSerif",0,16));
        label4.setText("Avg. Sales Per Week (this year):");
        label4.setVisible(true);

        label5 = new JLabel();
        label5.setBounds(17,210,90,35);
        label5.setBackground(new Color(214,217,223));
        label5.setForeground(new Color(0,0,0));
        label5.setEnabled(true);
        label5.setFont(new Font("sansserif",0,12));
        label5.setText("AED");
        label5.setVisible(true);

        label6 = new JLabel();
        label6.setBounds(17,275,250,35);
        label6.setBackground(new Color(214,217,223));
        label6.setForeground(new Color(0,0,0));
        label6.setEnabled(true);
        label6.setFont(new Font("SansSerif",0,16));
        label6.setText("Total Sales Next Year:");
        label6.setVisible(true);

        label7 = new JLabel();
        label7.setBounds(17,304,90,35);
        label7.setBackground(new Color(214,217,223));
        label7.setForeground(new Color(0,0,0));
        label7.setEnabled(true);
        label7.setFont(new Font("sansserif",0,12));
        label7.setText("AED");
        label7.setVisible(true);

        panel1 = new JPanel(null);
        panel1.setBorder(BorderFactory.createEtchedBorder(1));
        panel1.setBounds(5,73,399,376);
        panel1.setBackground(new Color(214,217,223));
        panel1.setForeground(new Color(0,0,0));
        panel1.setEnabled(true);
        panel1.setFont(new Font("sansserif",0,12));
        panel1.setVisible(true);

        panel2 = new JPanel(null);
        panel2.setBorder(BorderFactory.createEtchedBorder(1));
        panel2.setBounds(406,73,291,376);
        panel2.setBackground(new Color(204,204,204));
        panel2.setForeground(new Color(0,0,0));
        panel2.setEnabled(true);
        panel2.setFont(new Font("sansserif",0,12));
        panel2.setVisible(true);

        perDay = new JLabel();
        perDay.setBounds(272,87,90,35);
        perDay.setBackground(new Color(214,217,223));
        perDay.setForeground(new Color(0,0,0));
        perDay.setEnabled(true);
        perDay.setFont(new Font("SansSerif",0,16));
        perDay.setText("");
        perDay.setVisible(true);

        perWeek = new JLabel();
        perWeek.setBounds(272,181,90,35);
        perWeek.setBackground(new Color(214,217,223));
        perWeek.setForeground(new Color(0,0,0));
        perWeek.setEnabled(true);
        perWeek.setFont(new Font("SansSerif",0,16));
        perWeek.setText("");
        perWeek.setVisible(true);

        perYear = new JLabel();
        perYear.setBounds(272,275,90,35);
        perYear.setBackground(new Color(214,217,223));
        perYear.setForeground(new Color(0,0,0));
        perYear.setEnabled(true);
        perYear.setFont(new Font("SansSerif",0,16));
        perYear.setText("");
        perYear.setVisible(true);

        report = new JButton();
        report.setBounds(49,79,200,50);
        report.setBackground(new Color(214,217,223));
        report.setForeground(new Color(0,0,0));
        report.setEnabled(true);
        report.setFont(new Font("SansSerif",0,18));
        report.setText("Visual Report");
        report.setVisible(true);
        //Set action for button click
        //Call defined method
        report.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    report(evt);
                }
            });

        reset = new JButton();
        reset.setBounds(196,298,90,35);
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
                    resetInfo(evt);
                }
            });

        //adding components to contentPane panel
        panel2.add(display);
        panel2.add(exit);
        panel2.add(input);
        panel1.add(label1);
        panel2.add(label11);
        panel2.add(label12);
        contentPane.add(label13);
        panel1.add(label2);
        panel1.add(label3);
        panel1.add(label4);
        panel1.add(label5);
        panel1.add(label6);
        panel1.add(label7);
        contentPane.add(panel1);
        contentPane.add(panel2);
        panel1.add(perDay);
        panel1.add(perWeek);
        panel1.add(perYear);
        panel2.add(report);
        panel2.add(reset);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //Method actionPerformed for display
    private void displayInfo (ActionEvent evt) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        int y = 0;
        int t = 0;
        int f = 0;
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\irfanfirosh\\Desktop\\COMPIADBMS\\login2.accdb");
            String query = "select Total,Factor from sales";
            pst = con.prepareStatement(query); 
            pst.setMaxRows(1); 
            rs = pst.executeQuery();
            if(rs.next() == false)
            {
                JOptionPane.showMessageDialog(null, "RECORD NOT FOUND","ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            }
            else{
                f = Integer.parseInt(rs.getString("Factor"));
                t = Integer.parseInt(rs.getString("Total"));

                y= t* ( (1+f)^52 );
                perYear.setText(Integer.toString(y));
                perDay.setText(Integer.toString(y/365));
                perWeek.setText(Integer.toString(y/52));
            }
            con.close();
            pst.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Method actionPerformed for exit
    private void exitMenu (ActionEvent evt) {
        this.setVisible(false);
        new Menu().setVisible(true);
    }

    //Method actionPerformed for input
    private void inputInfo (ActionEvent evt) {
        new inputSales().setVisible(true);
    }

    //Method actionPerformed for report
    private void report (ActionEvent evt) {
        new weeklySales().setVisible(true);
        this.setVisible(false);
    }

    //Method actionPerformed for reset
    private void resetInfo (ActionEvent evt) {
        perDay.setText("");
        perWeek.setText("");
        perYear.setText("");
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
                    new salesForecast();
                }
            });
    }

}