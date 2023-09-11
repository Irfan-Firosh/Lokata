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

public class deleteInventory extends JFrame {
    private JMenuBar menuBar;
    private JButton delete;
    private JTextField itemName;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;

    //Constructor 
    public deleteInventory(){

        this.setTitle("deleteInventory");
        this.setSize(300,300);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(300,300));
        contentPane.setBackground(new Color(192,192,192));

        delete = new JButton();
        delete.setBounds(64,197,180,40);
        delete.setBackground(new Color(214,217,223));
        delete.setForeground(new Color(0,0,0));
        delete.setEnabled(true);
        delete.setFont(new Font("SansSerif",0,16));
        delete.setText("Delete");
        delete.setVisible(true);
        //Set action for button click
        //Call defined method
        delete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    deleteItem(evt);
                }
            });

        itemName = new JTextField();
        itemName.setBounds(84,113,200,40);
        itemName.setBackground(new Color(255,255,255));
        itemName.setForeground(new Color(0,0,0));
        itemName.setEnabled(true);
        itemName.setFont(new Font("SansSerif",0,14));
        itemName.setText("");
        itemName.setVisible(true);

        label1 = new JLabel();
        label1.setBounds(0,45,400,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("sansserif",0,12));
        label1.setText("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        label1.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(84,16,200,35);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("SansSerif",0,20));
        label2.setText("DELETE ITEM");
        label2.setVisible(true);

        label3 = new JLabel();
        label3.setBounds(14,114,90,35);
        label3.setBackground(new Color(214,217,223));
        label3.setForeground(new Color(0,0,0));
        label3.setEnabled(true);
        label3.setFont(new Font("SansSerif",0,18));
        label3.setText("Name :");
        label3.setVisible(true);

        //adding components to contentPane panel
        contentPane.add(delete);
        contentPane.add(itemName);
        contentPane.add(label1);
        contentPane.add(label2);
        contentPane.add(label3);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //Method actionPerformed for delete
    private void deleteItem (ActionEvent evt) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "delete inventoryManager " + "where Name = ?";
        String st = itemName.getText();
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
            JOptionPane.showMessageDialog(null, "Data has already been deleted","ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
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
                    new deleteInventory();
                }
            });
    }

}