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

public class invManager extends JFrame {
    private JMenuBar menuBar;
    private JLabel randomLabel;
    private JButton add;
    private JButton clear;
    private JButton del;
    private JButton exit;
    private JLabel label1;
    private JLabel label10;
    private JLabel label12;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JTextField name;
    private JLabel nameDisplay;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel quDisplay;
    private JButton search;

    //Constructor 
    public invManager(){

        this.setTitle("invManager");
        this.setSize(777,529);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(777,529));
        contentPane.setBackground(new Color(192,192,192));

        randomLabel = new JLabel();
        randomLabel.setBounds(245,26,250,35);
        randomLabel.setBackground(new Color(214,217,223));
        randomLabel.setForeground(new Color(0,0,0));
        randomLabel.setEnabled(true);
        randomLabel.setFont(new Font("SansSerif",0,22));
        randomLabel.setText("INVENTORY MANAGER");
        randomLabel.setVisible(true);

        add = new JButton();
        add.setBounds(31,258,250,35);
        add.setBackground(new Color(214,217,223));
        add.setForeground(new Color(0,0,0));
        add.setEnabled(true);
        add.setFont(new Font("SansSerif",0,15));
        add.setText("Add Item");
        add.setVisible(true);
        //Set action for button click
        //Call defined method
        add.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    addItem(evt);
                }
            });

        clear = new JButton();
        clear.setBounds(89,258,250,35);
        clear.setBackground(new Color(214,217,223));
        clear.setForeground(new Color(0,0,0));
        clear.setEnabled(true);
        clear.setFont(new Font("SansSerif",0,15));
        clear.setText("Clear");
        clear.setVisible(true);
        //Set action for button click
        //Call defined method
        clear.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    clearDisplau(evt);
                }
            });

        del = new JButton();
        del.setBounds(31,307,250,35);
        del.setBackground(new Color(214,217,223));
        del.setForeground(new Color(0,0,0));
        del.setEnabled(true);
        del.setFont(new Font("SansSerif",0,15));
        del.setText("Delete Item");
        del.setVisible(true);
        //Set action for button click
        //Call defined method
        del.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    deleteItem(evt);
                }
            });

        exit = new JButton();
        exit.setBounds(89,307,250,35);
        exit.setBackground(new Color(214,217,223));
        exit.setForeground(new Color(204,51,0));
        exit.setEnabled(true);
        exit.setFont(new Font("SansSerif",0,15));
        exit.setText("Exit Menu");
        exit.setVisible(true);
        //Set action for button click
        //Call defined method
        exit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    exitMenu(evt);
                }
            });

        label1 = new JLabel();
        label1.setBounds(0,69,2000,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("sansserif",0,12));
        label1.setText("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        label1.setVisible(true);

        label10 = new JLabel();
        label10.setBounds(37,98,90,35);
        label10.setBackground(new Color(214,217,223));
        label10.setForeground(new Color(0,0,0));
        label10.setEnabled(true);
        label10.setFont(new Font("SansSerif",0,18));
        label10.setText("Item :");
        label10.setVisible(true);

        label12 = new JLabel();
        label12.setBounds(37,157,90,35);
        label12.setBackground(new Color(214,217,223));
        label12.setForeground(new Color(0,0,0));
        label12.setEnabled(true);
        label12.setFont(new Font("SansSerif",0,18));
        label12.setText("Quantity :");
        label12.setVisible(true);

        label4 = new JLabel();
        label4.setBounds(0,44,1000,35);
        label4.setBackground(new Color(214,217,223));
        label4.setForeground(new Color(0,0,0));
        label4.setEnabled(true);
        label4.setFont(new Font("sansserif",0,12));
        label4.setText("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        label4.setVisible(true);

        label5 = new JLabel();
        label5.setBounds(0,44,800,35);
        label5.setBackground(new Color(214,217,223));
        label5.setForeground(new Color(0,0,0));
        label5.setEnabled(true);
        label5.setFont(new Font("sansserif",0,12));
        label5.setText("---------------------------------------------------------------------------------------------------------");
        label5.setVisible(true);

        label6 = new JLabel();
        label6.setBounds(0,221,800,35);
        label6.setBackground(new Color(214,217,223));
        label6.setForeground(new Color(0,0,0));
        label6.setEnabled(true);
        label6.setFont(new Font("sansserif",0,12));
        label6.setText("---------------------------------------------------------------------------------------------------------");
        label6.setVisible(true);

        label7 = new JLabel();
        label7.setBounds(0,221,900,35);
        label7.setBackground(new Color(214,217,223));
        label7.setForeground(new Color(0,0,0));
        label7.setEnabled(true);
        label7.setFont(new Font("sansserif",0,12));
        label7.setText("---------------------------------------------------------------------------------------------------------");
        label7.setVisible(true);

        label8 = new JLabel();
        label8.setBounds(79,12,200,35);
        label8.setBackground(new Color(214,217,223));
        label8.setForeground(new Color(0,0,0));
        label8.setEnabled(true);
        label8.setFont(new Font("SansSerif",0,19));
        label8.setText("Check Availability");
        label8.setVisible(true);

        label9 = new JLabel();
        label9.setBounds(174,13,90,35);
        label9.setBackground(new Color(214,217,223));
        label9.setForeground(new Color(0,0,0));
        label9.setEnabled(true);
        label9.setFont(new Font("SansSerif",0,19));
        label9.setText("Display");
        label9.setVisible(true);

        name = new JTextField();
        name.setBounds(31,98,250,40);
        name.setBackground(new Color(255,255,255));
        name.setForeground(new Color(0,0,0));
        name.setEnabled(true);
        name.setFont(new Font("sansserif",0,12));
        name.setText("");
        name.setVisible(true);

        nameDisplay = new JLabel();
        nameDisplay.setBounds(128,98,270,35);
        nameDisplay.setBackground(new Color(214,217,223));
        nameDisplay.setForeground(new Color(0,0,0));
        nameDisplay.setEnabled(true);
        nameDisplay.setFont(new Font("SansSerif",0,16));
        nameDisplay.setText("");
        nameDisplay.setVisible(true);

        panel1 = new JPanel(null);
        panel1.setBorder(BorderFactory.createEtchedBorder(1));
        panel1.setBounds(14,120,308,372);
        panel1.setBackground(new Color(214,217,223));
        panel1.setForeground(new Color(0,0,0));
        panel1.setEnabled(true);
        panel1.setFont(new Font("sansserif",0,12));
        panel1.setVisible(true);

        panel2 = new JPanel(null);
        panel2.setBorder(BorderFactory.createEtchedBorder(1));
        panel2.setBounds(335,119,418,374);
        panel2.setBackground(new Color(214,217,223));
        panel2.setForeground(new Color(0,0,0));
        panel2.setEnabled(true);
        panel2.setFont(new Font("sansserif",0,12));
        panel2.setVisible(true);

        quDisplay = new JLabel();
        quDisplay.setBounds(128,157,280,35);
        quDisplay.setBackground(new Color(214,217,223));
        quDisplay.setForeground(new Color(0,0,0));
        quDisplay.setEnabled(true);
        quDisplay.setFont(new Font("SansSerif",0,16));
        quDisplay.setText("");
        quDisplay.setVisible(true);

        search = new JButton();
        search.setBounds(31,157,250,35);
        search.setBackground(new Color(214,217,223));
        search.setForeground(new Color(0,0,0));
        search.setEnabled(true);
        search.setFont(new Font("SansSerif",0,15));
        search.setText("Search");
        search.setVisible(true);
        //Set action for button click
        //Call defined method
        search.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    searchItem(evt);
                }
            });

        //adding components to contentPane panel
        contentPane.add(randomLabel);
        panel1.add(add);
        panel2.add(clear);
        panel1.add(del);
        panel2.add(exit);
        contentPane.add(label1);
        panel2.add(label10);
        panel2.add(label12);
        panel2.add(label4);
        panel1.add(label5);
        panel1.add(label6);
        panel2.add(label7);
        panel1.add(label8);
        panel2.add(label9);
        panel1.add(name);
        panel2.add(nameDisplay);
        contentPane.add(panel1);
        contentPane.add(panel2);
        panel2.add(quDisplay);
        panel1.add(search);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //Method actionPerformed for add
    private void addItem (ActionEvent evt) {
        new addInventory().setVisible(true);
    }

    //Method actionPerformed for clear
    private void clearDisplau (ActionEvent evt) {
        nameDisplay.setText("");
        quDisplay.setText("");
    }

    //Method actionPerformed for del
    private void deleteItem (ActionEvent evt) {
        new deleteInventory().setVisible(true);
    }

    //Method actionPerformed for exit
    private void exitMenu (ActionEvent evt) {
        this.setVisible(false);
        new Menu().setVisible(true);
    }

    //Method actionPerformed for search
    private void searchItem (ActionEvent evt) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\irfanfirosh\\Desktop\\COMPIADBMS\\login2.accdb");
            pst = con.prepareStatement("select Name,Quantity from inventoryManager where Name=?");
            String id = name.getText().toLowerCase();
            pst.setString(1, id);
            rs = pst.executeQuery();
            if(rs.next() == false)
            {
                JOptionPane.showMessageDialog(null, "RECORD NOT FOUND","ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
                nameDisplay.setText("");
                quDisplay.setText("");
                name.setText(""); 
            }
            else{
                nameDisplay.setText(rs.getString("Name"));
                quDisplay.setText(rs.getString("Quantity"));
                name.setText(""); 
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
                    new invManager();
                }
            });
    }

}