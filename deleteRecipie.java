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

public class deleteRecipie extends JFrame {
    private JMenuBar menuBar;
    private JButton delID;
    private JButton delName;
    private JTextField input;
    private JLabel label1;
    private JLabel label2;
    private JPanel panel1;

    //Constructor 
    public deleteRecipie(){

        this.setTitle("deleteRecipie");
        this.setSize(493,370);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(493,370));
        contentPane.setBackground(new Color(192,192,192));

        delID = new JButton();
        delID.setBounds(268,149,200,35);
        delID.setBackground(new Color(214,217,223));
        delID.setForeground(new Color(0,0,0));
        delID.setEnabled(true);
        delID.setFont(new Font("sansserif",0,12));
        delID.setText("Delete By ID");
        delID.setVisible(true);
        //Set action for button click
        //Call defined method
        delID.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    deleteID(evt);
                }
            });

        delName = new JButton();
        delName.setBounds(14,149,200,35);
        delName.setBackground(new Color(214,217,223));
        delName.setForeground(new Color(0,0,0));
        delName.setEnabled(true);
        delName.setFont(new Font("sansserif",0,12));
        delName.setText("Delete By Name");
        delName.setVisible(true);
        //Set action for button click
        //Call defined method
        delName.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    deleteName(evt);
                }
            });

        input = new JTextField();
        input.setBounds(173,56,200,40);
        input.setBackground(new Color(255,255,255));
        input.setForeground(new Color(0,0,0));
        input.setEnabled(true);
        input.setFont(new Font("SansSerif",0,14));
        input.setText("");
        input.setVisible(true);

        label1 = new JLabel();
        label1.setBounds(180,20,200,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("SansSerif",0,20));
        label1.setText("Delete Recipie");
        label1.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(112,56,90,35);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("SansSerif",0,16));
        label2.setText("Enter:");
        label2.setVisible(true);

        panel1 = new JPanel(null);
        panel1.setBorder(BorderFactory.createEtchedBorder(1));
        panel1.setBounds(5,68,488,306);
        panel1.setBackground(new Color(51,255,204));
        panel1.setForeground(new Color(0,0,0));
        panel1.setEnabled(true);
        panel1.setFont(new Font("sansserif",0,12));
        panel1.setVisible(true);

        //adding components to contentPane panel
        panel1.add(delID);
        panel1.add(delName);
        panel1.add(input);
        contentPane.add(label1);
        panel1.add(label2);
        contentPane.add(panel1);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //Method actionPerformed for delID
    private void deleteID (ActionEvent evt) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "delete recipieManager " + "where ID = ?";
        int id = Integer.parseInt(input.getText());

        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\irfanfirosh\\Desktop\\COMPIADBMS\\login2.accdb");
            pst = con.prepareStatement(query);
            pst.setInt(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Succesfully Deleted");
            pst.close();
            con.close();
            this.setVisible(false);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    //Method actionPerformed for delName
    private void deleteName (ActionEvent evt) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "delete recipieManager " + "where Name = ?";
        String st = input.getText();
        if ( st instanceof String){
            try
            {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\irfanfirosh\\Desktop\\COMPIADBMS\\login2.accdb");
                pst = con.prepareStatement(query);
                pst.setString(1, st);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Succesfully Deleted");
                pst.close();
                con.close();
                this.setVisible(false);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Incorrect Button","ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
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
                    new deleteRecipie();
                }
            });
    }

}