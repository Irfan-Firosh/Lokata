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
import java.sql.ResultSet; 
import org.jfree.ui.RefineryUtilities;

public class weeklySales extends JFrame {
    private JMenuBar menuBar;
    private JButton button1;
    private JButton display;
    private JLabel label1;
    private JLabel label2;
    private JButton report;
    private JLabel wTotal;

    //Constructor 
    public weeklySales(){

        this.setTitle("weeklySales");
        this.setSize(350,390);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(350,390));
        contentPane.setBackground(new Color(192,192,192));

        button1 = new JButton();
        button1.setBounds(275,15,60,35);
        button1.setBackground(new Color(214,217,223));
        button1.setForeground(new Color(255,51,51));
        button1.setEnabled(true);
        button1.setFont(new Font("SansSerif",0,20));
        button1.setText("X");
        button1.setVisible(true);
        //Set action for button click
        //Call defined method
        button1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    exitMenu(evt);
                }
            });

        display = new JButton();
        display.setBounds(16,135,90,35);
        display.setBackground(new Color(214,217,223));
        display.setForeground(new Color(0,0,0));
        display.setEnabled(true);
        display.setFont(new Font("sansserif",0,12));
        display.setText("Calculate");
        display.setVisible(true);
        //Set action for button click
        //Call defined method
        display.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    display(evt);
                }
            });

        label1 = new JLabel();
        label1.setBounds(124,18,120,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("SansSerif",0,20));
        label1.setText("Next Week");
        label1.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(16,103,220,35);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("SansSerif",0,16));
        label2.setText("Total Sales Next Week (AED):");
        label2.setVisible(true);

        report = new JButton();
        report.setBounds(73,303,200,50);
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
                    printReport(evt);
                }
            });

        wTotal = new JLabel();
        wTotal.setBounds(246,103,90,35);
        wTotal.setBackground(new Color(214,217,223));
        wTotal.setForeground(new Color(0,0,0));
        wTotal.setEnabled(true);
        wTotal.setFont(new Font("SansSerif",0,16));
        wTotal.setText("");
        wTotal.setVisible(true);

        //adding components to contentPane panel
        contentPane.add(button1);
        contentPane.add(display);
        contentPane.add(label1);
        contentPane.add(label2);
        contentPane.add(report);
        contentPane.add(wTotal);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //Method actionPerformed for button1
    private void exitMenu (ActionEvent evt) {
        this.setVisible(false);
        new salesForecast().setVisible(true);
    }

    //Method actionPerformed for display
    private void display (ActionEvent evt) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        int t = 0;
        int f = 0;
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\irfanfirosh\\Desktop\\COMPIADBMS\\login2.accdb");
            String query = "SELECT Total,Factor FROM sales";
            pst = con.prepareStatement(query); 
            pst.setMaxRows(1); 
            rs = pst.executeQuery();
            if(rs.next() == false)
            {
                JOptionPane.showMessageDialog(null, "RECORD NOT FOUND","ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            }
            else{
                t = Integer.parseInt(rs.getString("Total"));
                f = Integer.parseInt(rs.getString("Factor"));
                wTotal.setText(Integer.toString(t+(t*f)+(t*f*f)));
            }
            con.close();
            pst.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Method actionPerformed for report
    private void printReport (ActionEvent evt) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        int t = 0;
        int f = 0;
        int w[] = new int[7];
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\irfanfirosh\\Desktop\\COMPIADBMS\\login2.accdb");
            String query = "SELECT Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday,Factor FROM sales";
            pst = con.prepareStatement(query); 
            pst.setMaxRows(1); 
            rs = pst.executeQuery();
            if(rs.next() == false)
            {
                JOptionPane.showMessageDialog(null, "RECORD NOT FOUND","ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            }
            else{
                w[0] = Integer.parseInt(rs.getString("Monday"));
                w[1] = Integer.parseInt(rs.getString("Tuesday"));
                w[2] = Integer.parseInt(rs.getString("Wednesday"));
                w[3] = Integer.parseInt(rs.getString("Thursday"));
                w[4] = Integer.parseInt(rs.getString("Friday"));
                w[5] = Integer.parseInt(rs.getString("Saturday"));
                w[6] = Integer.parseInt(rs.getString("Sunday"));
                f = Integer.parseInt(rs.getString("Factor"));
                weeklyChart chart = new weeklyChart("Next Week Sales Forecast" , "Days Vs Sales", w, f);
                chart.pack( );
                RefineryUtilities.centerFrameOnScreen( chart );
                chart.setVisible( true );
            }
            con.close();
            pst.close();
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
                    new weeklySales();
                }
            });
    }

}