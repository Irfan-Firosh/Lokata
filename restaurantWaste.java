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

public class restaurantWaste extends JFrame {
    private JMenuBar menuBar;
    private JButton display;
    private JButton exit;
    private JLabel iBought;
    private JLabel iUsed;
    private JLabel iWaste;
    private JButton input;
    private JLabel label1;
    private JLabel label10;
    private JLabel label2;
    private JLabel label3;
    private JLabel label7;
    private JLabel label9;
    private JPanel panel1;
    private JPanel panel2;
    private JButton printGraph;
    private JButton printReport;
    private JButton reset;

    //Constructor 
    public restaurantWaste(){

        this.setTitle("restaurantWaste");
        this.setSize(660,400);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(660,400));
        contentPane.setBackground(new Color(204,204,204));

        display = new JButton();
        display.setBounds(119,263,90,35);
        display.setBackground(new Color(214,217,223));
        display.setForeground(new Color(0,0,0));
        display.setEnabled(true);
        display.setFont(new Font("SansSerif",0,13));
        display.setText("Display");
        display.setVisible(true);
        //Set action for button click
        //Call defined method
        display.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    displayVal(evt);
                }
            });

        exit = new JButton();
        exit.setBounds(577,16,60,35);
        exit.setBackground(new Color(214,217,223));
        exit.setForeground(new Color(255,51,0));
        exit.setEnabled(true);
        exit.setFont(new Font("SansSerif",0,20));
        exit.setText("X");
        exit.setVisible(true);
        //Set action for button click
        //Call defined method
        exit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    exitMenu(evt);
                }
            });

        iBought = new JLabel();
        iBought.setBounds(225,63,90,35);
        iBought.setBackground(new Color(214,217,223));
        iBought.setForeground(new Color(0,0,0));
        iBought.setEnabled(true);
        iBought.setFont(new Font("SansSerif",0,16));
        iBought.setText("");
        iBought.setVisible(true);

        iUsed = new JLabel();
        iUsed.setBounds(225,133,90,35);
        iUsed.setBackground(new Color(214,217,223));
        iUsed.setForeground(new Color(0,0,0));
        iUsed.setEnabled(true);
        iUsed.setFont(new Font("SansSerif",0,16));
        iUsed.setText("");
        iUsed.setVisible(true);

        iWaste = new JLabel();
        iWaste.setBounds(225,203,90,35);
        iWaste.setBackground(new Color(214,217,223));
        iWaste.setForeground(new Color(0,0,0));
        iWaste.setEnabled(true);
        iWaste.setFont(new Font("SansSerif",0,16));
        iWaste.setText("");
        iWaste.setVisible(true);

        input = new JButton();
        input.setBounds(16,263,90,35);
        input.setBackground(new Color(214,217,223));
        input.setForeground(new Color(0,0,0));
        input.setEnabled(true);
        input.setFont(new Font("SansSerif",0,13));
        input.setText("Input");
        input.setVisible(true);
        //Set action for button click
        //Call defined method
        input.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    inputVal(evt);
                }
            });

        label1 = new JLabel();
        label1.setBounds(15,63,200,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("SansSerif",0,16));
        label1.setText("Ingredients Bought (kg):");
        label1.setVisible(true);

        label10 = new JLabel();
        label10.setBounds(231,15,220,35);
        label10.setBackground(new Color(214,217,223));
        label10.setForeground(new Color(0,0,0));
        label10.setEnabled(true);
        label10.setFont(new Font("SansSerif",0,24));
        label10.setText("Restaurant Waste");
        label10.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(15,133,200,35);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("SansSerif",0,16));
        label2.setText("Ingredients Used  (kg):");
        label2.setVisible(true);

        label3 = new JLabel();
        label3.setBounds(15,203,200,35);
        label3.setBackground(new Color(214,217,223));
        label3.setForeground(new Color(0,0,0));
        label3.setEnabled(true);
        label3.setFont(new Font("SansSerif",0,16));
        label3.setText("Ingredients Wasted  (kg):");
        label3.setVisible(true);

        label7 = new JLabel();
        label7.setBounds(110,11,120,35);
        label7.setBackground(new Color(214,217,223));
        label7.setForeground(new Color(0,0,0));
        label7.setEnabled(true);
        label7.setFont(new Font("SansSerif",0,20));
        label7.setText("Information");
        label7.setVisible(true);

        label9 = new JLabel();
        label9.setBounds(106,14,120,35);
        label9.setBackground(new Color(214,217,223));
        label9.setForeground(new Color(0,0,0));
        label9.setEnabled(true);
        label9.setFont(new Font("SansSerif",0,20));
        label9.setText("Commands");
        label9.setVisible(true);

        panel1 = new JPanel(null);
        panel1.setBorder(BorderFactory.createEtchedBorder(1));
        panel1.setBounds(5,75,330,320);
        panel1.setBackground(new Color(214,217,223));
        panel1.setForeground(new Color(0,0,0));
        panel1.setEnabled(true);
        panel1.setFont(new Font("sansserif",0,12));
        panel1.setVisible(true);

        panel2 = new JPanel(null);
        panel2.setBorder(BorderFactory.createEtchedBorder(1));
        panel2.setBounds(336,75,330,320);
        panel2.setBackground(new Color(204,204,204));
        panel2.setForeground(new Color(0,0,0));
        panel2.setEnabled(true);
        panel2.setFont(new Font("sansserif",0,12));
        panel2.setVisible(true);

        printGraph = new JButton();
        printGraph.setBounds(65,175,200,50);
        printGraph.setBackground(new Color(214,217,223));
        printGraph.setForeground(new Color(0,0,0));
        printGraph.setEnabled(true);
        printGraph.setFont(new Font("SansSerif",0,16));
        printGraph.setText("Print Visual Report");
        printGraph.setVisible(true);
        //Set action for button click
        //Call defined method
        printGraph.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    printGraph(evt);
                }
            });

        printReport = new JButton();
        printReport.setBounds(65,83,200,50);
        printReport.setBackground(new Color(214,217,223));
        printReport.setForeground(new Color(0,0,0));
        printReport.setEnabled(true);
        printReport.setFont(new Font("SansSerif",0,16));
        printReport.setText("Print Text Report");
        printReport.setVisible(true);
        //Set action for button click
        //Call defined method
        printReport.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    printText(evt);
                }
            });

        reset = new JButton();
        reset.setBounds(222,263,90,35);
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
                    resetVal(evt);
                }
            });

        //adding components to contentPane panel
        panel1.add(display);
        contentPane.add(exit);
        panel1.add(iBought);
        panel1.add(iUsed);
        panel1.add(iWaste);
        panel1.add(input);
        panel1.add(label1);
        contentPane.add(label10);
        panel1.add(label2);
        panel1.add(label3);
        panel1.add(label7);
        panel2.add(label9);
        contentPane.add(panel1);
        contentPane.add(panel2);
        panel2.add(printGraph);
        panel2.add(printReport);
        panel1.add(reset);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //Method actionPerformed for display
    private void displayVal (ActionEvent evt) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\irfanfirosh\\Desktop\\COMPIADBMS\\login2.accdb");
            String query = "select bought,wasted,used from restaurantWaste";
            pst = con.prepareStatement(query); 
            pst.setMaxRows(1); 
            rs = pst.executeQuery();
            if(rs.next() == false)
            {
                JOptionPane.showMessageDialog(null, "RECORD NOT FOUND","ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            }
            else{
                iBought.setText(rs.getString("bought"));
                iUsed.setText(rs.getString("used"));
                iWaste.setText(rs.getString("wasted"));
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
        new foodWaste().setVisible(true);
    }

    //Method actionPerformed for input
    private void inputVal (ActionEvent evt) {
        new inputRestaurantWaste().setVisible(true);
    }

    //Method actionPerformed for printGraph
    private void printGraph (ActionEvent evt) {
        this.setVisible(false);
        new restaurantGraph().setVisible(true);
    }

    //Method actionPerformed for printReport
    private void printText (ActionEvent evt) {
        this.setVisible(false);
        new restaurantReport().setVisible(true);
    }

    //Method actionPerformed for reset
    private void resetVal (ActionEvent evt) {
        iBought.setText("");
        iUsed.setText("");
        iWaste.setText("");
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
                    new restaurantWaste();
                }
            });
    }

}