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

public class inputCustomerWaste extends JFrame {
    private JMenuBar menuBar;
    private JLabel input_values;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField orderedFood;
    private JTextField people;
    private JButton reset;
    private JButton submit;
    private JTextField wastedFood;

    //Constructor 
    public inputCustomerWaste(){

        this.setTitle("inputCustomerWaste");
        this.setSize(400,383);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(400,383));
        contentPane.setBackground(new Color(192,192,192));

        input_values = new JLabel();
        input_values.setBounds(139,16,150,35);
        input_values.setBackground(new Color(214,217,223));
        input_values.setForeground(new Color(0,0,0));
        input_values.setEnabled(true);
        input_values.setFont(new Font("SansSerif",0,20));
        input_values.setText("Input Values");
        input_values.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(25,105,200,35);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("SansSerif",0,15));
        label2.setText("Customer Flow (per week):");
        label2.setVisible(true);

        label3 = new JLabel();
        label3.setBounds(25,180,200,35);
        label3.setBackground(new Color(214,217,223));
        label3.setForeground(new Color(0,0,0));
        label3.setEnabled(true);
        label3.setFont(new Font("SansSerif",0,15));
        label3.setText("Avg. Food Ordered (Kg):");
        label3.setVisible(true);

        label4 = new JLabel();
        label4.setBounds(26,255,200,35);
        label4.setBackground(new Color(214,217,223));
        label4.setForeground(new Color(0,0,0));
        label4.setEnabled(true);
        label4.setFont(new Font("SansSerif",0,15));
        label4.setText("Avg. Food Wasted (Kg):");
        label4.setVisible(true);

        orderedFood = new JTextField();
        orderedFood.setBounds(243,180,100,35);
        orderedFood.setBackground(new Color(255,255,255));
        orderedFood.setForeground(new Color(0,0,0));
        orderedFood.setEnabled(true);
        orderedFood.setFont(new Font("SansSerif",0,14));
        orderedFood.setText("");
        orderedFood.setVisible(true);

        people = new JTextField();
        people.setBounds(244,105,100,35);
        people.setBackground(new Color(255,255,255));
        people.setForeground(new Color(0,0,0));
        people.setEnabled(true);
        people.setFont(new Font("SansSerif",0,14));
        people.setText("");
        people.setVisible(true);

        reset = new JButton();
        reset.setBounds(233,325,120,35);
        reset.setBackground(new Color(214,217,223));
        reset.setForeground(new Color(0,0,0));
        reset.setEnabled(true);
        reset.setFont(new Font("SansSerif",0,14));
        reset.setText("Reset");
        reset.setVisible(true);
        //Set action for button click
        //Call defined method
        reset.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    resetValues(evt);
                }
            });

        submit = new JButton();
        submit.setBounds(45,325,120,35);
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

        wastedFood = new JTextField();
        wastedFood.setBounds(244,255,100,35);
        wastedFood.setBackground(new Color(255,255,255));
        wastedFood.setForeground(new Color(0,0,0));
        wastedFood.setEnabled(true);
        wastedFood.setFont(new Font("SansSerif",0,14));
        wastedFood.setText("");
        wastedFood.setVisible(true);

        //adding components to contentPane panel
        contentPane.add(input_values);
        contentPane.add(label2);
        contentPane.add(label3);
        contentPane.add(label4);
        contentPane.add(orderedFood);
        contentPane.add(people);
        contentPane.add(reset);
        contentPane.add(submit);
        contentPane.add(wastedFood);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //Method actionPerformed for reset
    private void resetValues (ActionEvent evt) {
        people.setText("");
        orderedFood.setText("");
        wastedFood.setText("");
    }

    //Method actionPerformed for submit
    private void submitValues (ActionEvent evt) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        String query = "delete FROM customerWaste";
        String yquery = "insert into customerWaste" + "(numPeople,orderedFood,wastedFood,eatenFood)" + "values (?, ?, ?,?)";
        
        String eatenFood = Integer.toString((Integer.parseInt(orderedFood.getText())) - (Integer.parseInt(wastedFood.getText())));
        
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\irfanfirosh\\Desktop\\COMPIADBMS\\login2.accdb");
            pst = con.prepareStatement(query);
            pst.executeUpdate();
            pst.close();
            
            pst2 = con.prepareStatement(yquery);
            pst2.setString(1, people.getText());
            pst2.setString(2, orderedFood.getText());
            pst2.setString(3, wastedFood.getText());
            pst2.setString(4, eatenFood);
            
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
                    new inputCustomerWaste();
                }
            });
    }

}