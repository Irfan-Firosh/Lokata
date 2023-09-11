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

public class customerWaste extends JFrame {

    private JMenuBar menuBar;
    private JLabel customerFlow;
    private JButton display;
    private JButton exitMenu;
    private JLabel foodOrdered;
    private JLabel foodWasted;
    private JButton graphReport;
    private JButton input;
    private JLabel label1;
    private JLabel label10;
    private JLabel label2;
    private JLabel label4;
    private JLabel label5;
    private JLabel label9;
    private JPanel panel1;
    private JPanel panel2;
    private JButton reset;
    private JButton textReport;

    //Constructor 
    public customerWaste(){

        this.setTitle("customerWaste");
        this.setSize(635,399);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(635,399));
        contentPane.setBackground(new Color(204,204,204));

        customerFlow = new JLabel();
        customerFlow.setBounds(216,61,90,35);
        customerFlow.setBackground(new Color(214,217,223));
        customerFlow.setForeground(new Color(0,0,0));
        customerFlow.setEnabled(true);
        customerFlow.setFont(new Font("SansSerif",0,14));
        customerFlow.setText("");
        customerFlow.setVisible(true);

        display = new JButton();
        display.setBounds(120,266,90,35);
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
                    displayInfo(evt);
                }
            });

        exitMenu = new JButton();
        exitMenu.setBounds(561,8,60,35);
        exitMenu.setBackground(new Color(204,204,204));
        exitMenu.setForeground(new Color(255,51,51));
        exitMenu.setEnabled(true);
        exitMenu.setFont(new Font("SansSerif",0,18));
        exitMenu.setText("X");
        exitMenu.setVisible(true);
        //Set action for button click
        //Call defined method
        exitMenu.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    exit(evt);
                }
            });

        foodOrdered = new JLabel();
        foodOrdered.setBounds(217,129,90,35);
        foodOrdered.setBackground(new Color(214,217,223));
        foodOrdered.setForeground(new Color(0,0,0));
        foodOrdered.setEnabled(true);
        foodOrdered.setFont(new Font("SansSerif",0,14));
        foodOrdered.setText("");
        foodOrdered.setVisible(true);

        foodWasted = new JLabel();
        foodWasted.setBounds(216,199,90,35);
        foodWasted.setBackground(new Color(214,217,223));
        foodWasted.setForeground(new Color(0,0,0));
        foodWasted.setEnabled(true);
        foodWasted.setFont(new Font("SansSerif",0,14));
        foodWasted.setText("");
        foodWasted.setVisible(true);

        graphReport = new JButton();
        graphReport.setBounds(45,159,200,50);
        graphReport.setBackground(new Color(214,217,223));
        graphReport.setForeground(new Color(0,0,0));
        graphReport.setEnabled(true);
        graphReport.setFont(new Font("SansSerif",0,15));
        graphReport.setText("Print Visual Report");
        graphReport.setVisible(true);
        //Set action for button click
        //Call defined method
        graphReport.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    printVisual(evt);
                }
            });

        input = new JButton();
        input.setBounds(13,266,90,35);
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
                    inputValue(evt);
                }
            });

        label1 = new JLabel();
        label1.setBounds(117,6,100,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("SansSerif",0,18));
        label1.setText("Information");
        label1.setVisible(true);

        label10 = new JLabel();
        label10.setBounds(201,15,300,35);
        label10.setBackground(new Color(214,217,223));
        label10.setForeground(new Color(0,0,0));
        label10.setEnabled(true);
        label10.setFont(new Font("SansSerif",0,30));
        label10.setText("Customer Waste");
        label10.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(15,59,200,35);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("SansSerif",0,14));
        label2.setText("Customer Flow (per week):");
        label2.setVisible(true);

        label4 = new JLabel();
        label4.setBounds(15,129,200,35);
        label4.setBackground(new Color(214,217,223));
        label4.setForeground(new Color(0,0,0));
        label4.setEnabled(true);
        label4.setFont(new Font("SansSerif",0,14));
        label4.setText("Avg. Food Ordered (Kg):");
        label4.setVisible(true);

        label5 = new JLabel();
        label5.setBounds(15,199,200,35);
        label5.setBackground(new Color(214,217,223));
        label5.setForeground(new Color(0,0,0));
        label5.setEnabled(true);
        label5.setFont(new Font("SansSerif",0,14));
        label5.setText("Avg. Food Wasted (Kg):");
        label5.setVisible(true);

        label9 = new JLabel();
        label9.setBounds(93,9,150,35);
        label9.setBackground(new Color(214,217,223));
        label9.setForeground(new Color(0,0,0));
        label9.setEnabled(true);
        label9.setFont(new Font("SansSerif",0,18));
        label9.setText("Commands");
        label9.setVisible(true);

        panel1 = new JPanel(null);
        panel1.setBorder(BorderFactory.createEtchedBorder(1));
        panel1.setBounds(5,78,342,320);
        panel1.setBackground(new Color(214,217,223));
        panel1.setForeground(new Color(0,0,0));
        panel1.setEnabled(true);
        panel1.setFont(new Font("sansserif",0,12));
        panel1.setVisible(true);

        panel2 = new JPanel(null);
        panel2.setBorder(BorderFactory.createEtchedBorder(1));
        panel2.setBounds(341,77,293,318);
        panel2.setBackground(new Color(204,204,204));
        panel2.setForeground(new Color(0,0,0));
        panel2.setEnabled(true);
        panel2.setFont(new Font("sansserif",0,12));
        panel2.setVisible(true);

        reset = new JButton();
        reset.setBounds(226,266,90,35);
        reset.setBackground(new Color(214,217,223));
        reset.setForeground(new Color(0,0,0));
        reset.setEnabled(true);
        reset.setFont(new Font("SansSerif",0,13));
        reset.setText("Reset");
        reset.setVisible(true);
        //Set action for button click
        //Call defined method
        reset.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    reset(evt);
                }
            });

        textReport = new JButton();
        textReport.setBounds(45,70,200,50);
        textReport.setBackground(new Color(214,217,223));
        textReport.setForeground(new Color(0,0,0));
        textReport.setEnabled(true);
        textReport.setFont(new Font("SansSerif",0,15));
        textReport.setText("Print Text Report");
        textReport.setVisible(true);
        //Set action for button click
        //Call defined method
        textReport.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    printText(evt);
                }
            });

        //adding components to contentPane panel
        panel1.add(customerFlow);
        panel1.add(display);
        contentPane.add(exitMenu);
        panel1.add(foodOrdered);
        panel1.add(foodWasted);
        panel2.add(graphReport);
        panel1.add(input);
        panel1.add(label1);
        contentPane.add(label10);
        panel1.add(label2);
        panel1.add(label4);
        panel1.add(label5);
        panel2.add(label9);
        contentPane.add(panel1);
        contentPane.add(panel2);
        panel1.add(reset);
        panel2.add(textReport);

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
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\irfanfirosh\\Desktop\\COMPIADBMS\\login2.accdb");
            String query = "select numPeople,orderedFood,wastedFood from customerWaste";
            pst = con.prepareStatement(query); 
            pst.setMaxRows(1); 
            rs = pst.executeQuery();
            if(rs.next() == false)
            {
                JOptionPane.showMessageDialog(null, "RECORD NOT FOUND","ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            }
            else{
                customerFlow.setText(rs.getString("numPeople"));
                foodOrdered.setText(rs.getString("orderedFood"));
                foodWasted.setText(rs.getString("wastedFood"));
            }
            con.close();
            pst.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Method actionPerformed for exitMenu
    private void exit (ActionEvent evt) {
        this.setVisible(false);
        new foodWaste().setVisible(true);
    }

    //Method actionPerformed for graphReport
    private void printVisual (ActionEvent evt) {
        this.setVisible(false);
        new customerGraph().setVisible(true);
    }

    //Method actionPerformed for input
    private void inputValue (ActionEvent evt) {
        new inputCustomerWaste().setVisible(true);
    }

    //Method actionPerformed for reset
    private void reset (ActionEvent evt) {
        customerFlow.setText("");
        foodOrdered.setText("");
        foodWasted.setText("");
    }

    //Method actionPerformed for textReport
    private void printText (ActionEvent evt) {
        this.setVisible(false);
        new customerReport().setVisible(true);
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
                    new customerWaste();
                }
            });
    }

}