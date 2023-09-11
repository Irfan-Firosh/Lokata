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
import org.jfree.ui.RefineryUtilities;

public class customerGraph extends JFrame {
    private JMenuBar menuBar;
    private JButton exit;
    private JLabel label1;
    private JButton perDay;
    private JButton perMonth;
   

    //Constructor 
    public customerGraph(){

        this.setTitle("customerGraph");
        this.setSize(290,218);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(256,298));
        contentPane.setBackground(new Color(192,192,192));

        exit = new JButton();
        exit.setBounds(207,9,55,35);
        exit.setBackground(new Color(214,217,223));
        exit.setForeground(new Color(255,51,51));
        exit.setEnabled(true);
        exit.setFont(new Font("sansserif",0,14));
        exit.setText("X");
        exit.setVisible(true);
        //Set action for button click
        //Call defined method
        exit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    exitMenu(evt);
                }
            });

        label1 = new JLabel();
        label1.setBounds(50,11,150,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("SansSerif",0,20));
        label1.setText("Visual Analysis");
        label1.setVisible(true);

        perDay = new JButton();
        perDay.setBounds(50,76,150,50);
        perDay.setBackground(new Color(214,217,223));
        perDay.setForeground(new Color(0,0,0));
        perDay.setEnabled(true);
        perDay.setFont(new Font("SansSerif",0,16));
        perDay.setText("Daily");
        perDay.setVisible(true);
        //Set action for button click
        //Call defined method
        perDay.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    perDay(evt);
                }
            });

        perMonth = new JButton();
        perMonth.setBounds(49,149,150,50);
        perMonth.setBackground(new Color(214,217,223));
        perMonth.setForeground(new Color(0,0,0));
        perMonth.setEnabled(true);
        perMonth.setFont(new Font("SansSerif",0,16));
        perMonth.setText("Monthly");
        perMonth.setVisible(true);
        //Set action for button click
        //Call defined method
        perMonth.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    perMonth(evt);
                }
            });

       
        

        //adding components to contentPane panel
        contentPane.add(exit);
        contentPane.add(label1);
        contentPane.add(perDay);
        contentPane.add(perMonth);
        
        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //Method actionPerformed for exit
    private void exitMenu (ActionEvent evt) {
        this.setVisible(false);
        new customerWaste().setVisible(true);
    }

    //Method actionPerformed for perDay
    private void perDay (ActionEvent evt) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String people;
        String waste;
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\irfanfirosh\\Desktop\\COMPIADBMS\\login2.accdb");
            String query = "select numPeople,orderedFood,wastedFood from customerWaste";
            pst = con.prepareStatement(query); 
            pst.setMaxRows(1); 
            rs = pst.executeQuery();
            if(rs.next() == true)
            {
                people = rs.getString("numPeople");
                waste = rs.getString("wastedFood");
                perWeek chart = new perWeek("Daily Customer Food Waste" , "Days Vs Waste", people, waste);
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

    //Method actionPerformed for perMonth
    private void perMonth (ActionEvent evt) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String people;
        String waste;
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\irfanfirosh\\Desktop\\COMPIADBMS\\login2.accdb");
            String query = "select numPeople,orderedFood,wastedFood from customerWaste";
            pst = con.prepareStatement(query); 
            pst.setMaxRows(1); 
            rs = pst.executeQuery();
            if(rs.next() == true)
            {
                people = rs.getString("numPeople");
                waste = rs.getString("wastedFood");
                perMonth chart = new perMonth("Monthly Customer Food Waste", "Month VS Waste", people, waste);
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
                    new customerGraph();
                }
            });
    }

}