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

public class inputRestaurantWaste extends JFrame {
    private JMenuBar menuBar;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField orderedFood;
    private JButton resetVal;
    private JButton submitVal;
    private JTextField wasted;

    //Constructor 
    public inputRestaurantWaste(){

        this.setTitle("inputRestaurantWaste");
        this.setSize(320,330);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(320,330));
        contentPane.setBackground(new Color(192,192,192));

        label1 = new JLabel();
        label1.setBounds(98,16,200,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("SansSerif",0,22));
        label1.setText("Input Values");
        label1.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(28,89,150,35);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("SansSerif",0,16));
        label2.setText("Ordered Food (kg):");
        label2.setVisible(true);

        label3 = new JLabel();
        label3.setBounds(28,163,150,35);
        label3.setBackground(new Color(214,217,223));
        label3.setForeground(new Color(0,0,0));
        label3.setEnabled(true);
        label3.setFont(new Font("SansSerif",0,16));
        label3.setText("Wasted Food (kg):");
        label3.setVisible(true);

        orderedFood = new JTextField();
        orderedFood.setBounds(188,89,120,35);
        orderedFood.setBackground(new Color(255,255,255));
        orderedFood.setForeground(new Color(0,0,0));
        orderedFood.setEnabled(true);
        orderedFood.setFont(new Font("SansSerif",0,14));
        orderedFood.setText("");
        orderedFood.setVisible(true);

        resetVal = new JButton();
        resetVal.setBounds(176,269,120,35);
        resetVal.setBackground(new Color(214,217,223));
        resetVal.setForeground(new Color(0,0,0));
        resetVal.setEnabled(true);
        resetVal.setFont(new Font("SansSerif",0,14));
        resetVal.setText("Reset");
        resetVal.setVisible(true);
        //Set action for button click
        //Call defined method
        resetVal.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    resetValues(evt);
                }
            });

        submitVal = new JButton();
        submitVal.setBounds(22,269,120,35);
        submitVal.setBackground(new Color(214,217,223));
        submitVal.setForeground(new Color(0,0,0));
        submitVal.setEnabled(true);
        submitVal.setFont(new Font("SansSerif",0,14));
        submitVal.setText("Submit");
        submitVal.setVisible(true);
        //Set action for button click
        //Call defined method
        submitVal.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    submitVales(evt);
                }
            });

        wasted = new JTextField();
        wasted.setBounds(185,163,120,35);
        wasted.setBackground(new Color(255,255,255));
        wasted.setForeground(new Color(0,0,0));
        wasted.setEnabled(true);
        wasted.setFont(new Font("SansSerif",0,14));
        wasted.setText("");
        wasted.setVisible(true);

        //adding components to contentPane panel
        contentPane.add(label1);
        contentPane.add(label2);
        contentPane.add(label3);
        contentPane.add(orderedFood);
        contentPane.add(resetVal);
        contentPane.add(submitVal);
        contentPane.add(wasted);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //Method actionPerformed for resetVal
    private void resetValues (ActionEvent evt) {
        orderedFood.setText("");
        wasted.setText("");
    }

    //Method actionPerformed for submitVal
    private void submitVales (ActionEvent evt) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        String query = "delete FROM restaurantWaste";
        String yquery = "insert into restaurantWaste" + "(bought,wasted,used)" + "values (?, ?, ?)";

        String eatenFood = Integer.toString((Integer.parseInt(orderedFood.getText())) - (Integer.parseInt(wasted.getText())));

        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\irfanfirosh\\Desktop\\COMPIADBMS\\login2.accdb");
            pst = con.prepareStatement(query);
            pst.executeUpdate();
            pst.close();

            pst2 = con.prepareStatement(yquery);
            pst2.setString(1, orderedFood.getText());
            pst2.setString(2, wasted.getText());
            pst2.setString(3, eatenFood);

            pst2.executeUpdate();

            pst2.close();
            con.close();

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
                    new inputRestaurantWaste();
                }
            });
    }

}