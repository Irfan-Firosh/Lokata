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

public class addInventory extends JFrame {
    private JMenuBar menuBar;
    private JTextField itemName;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField quantity;
    private JButton submit;

    //Constructor 
    public addInventory(){

        this.setTitle("addInventory");
        this.setSize(400,400);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(400,400));
        contentPane.setBackground(new Color(192,192,192));

        itemName = new JTextField();
        itemName.setBounds(129,132,250,40);
        itemName.setBackground(new Color(255,255,255));
        itemName.setForeground(new Color(0,0,0));
        itemName.setEnabled(true);
        itemName.setFont(new Font("SansSerif",0,14));
        itemName.setText("");
        itemName.setVisible(true);

        label1 = new JLabel();
        label1.setBounds(152,24,210,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("SansSerif",0,20));
        label1.setText("ADD ITEM");
        label1.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(0,59,500,35);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("sansserif",0,12));
        label2.setText("--------------------------------------------------------------------------------------------------------------------------------------------");
        label2.setVisible(true);

        label3 = new JLabel();
        label3.setBounds(28,204,150,35);
        label3.setBackground(new Color(214,217,223));
        label3.setForeground(new Color(0,0,0));
        label3.setEnabled(true);
        label3.setFont(new Font("SansSerif",0,18));
        label3.setText("Quantiy :");
        label3.setVisible(true);

        label4 = new JLabel();
        label4.setBounds(29,132,90,35);
        label4.setBackground(new Color(214,217,223));
        label4.setForeground(new Color(0,0,0));
        label4.setEnabled(true);
        label4.setFont(new Font("SansSerif",0,18));
        label4.setText("Name :");
        label4.setVisible(true);

        label5 = new JLabel();
        label5.setBounds(0,268,500,35);
        label5.setBackground(new Color(214,217,223));
        label5.setForeground(new Color(0,0,0));
        label5.setEnabled(true);
        label5.setFont(new Font("sansserif",0,12));
        label5.setText("------------------------------------------------------------------------------------------------------------------------");
        label5.setVisible(true);

        quantity = new JTextField();
        quantity.setBounds(130,204,250,40);
        quantity.setBackground(new Color(255,255,255));
        quantity.setForeground(new Color(0,0,0));
        quantity.setEnabled(true);
        quantity.setFont(new Font("SansSerif",0,14));
        quantity.setText("");
        quantity.setVisible(true);

        submit = new JButton();
        submit.setBounds(83,317,250,35);
        submit.setBackground(new Color(214,217,223));
        submit.setForeground(new Color(0,0,0));
        submit.setEnabled(true);
        submit.setFont(new Font("SansSerif",0,16));
        submit.setText("Submit");
        submit.setVisible(true);
        submit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    addItem(evt);
                }
            });

        //adding components to contentPane panel
        contentPane.add(itemName);
        contentPane.add(label1);
        contentPane.add(label2);
        contentPane.add(label3);
        contentPane.add(label4);
        contentPane.add(label5);
        contentPane.add(quantity);
        contentPane.add(submit);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    private void addItem (ActionEvent evt) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "insert into inventoryManager" + "(Name, Quantity)" + "values (?, ?)";
        String name = itemName.getText().toLowerCase();
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\irfanfirosh\\Desktop\\COMPIADBMS\\login2.accdb");
            pst = con.prepareStatement(query);

            pst.setString(1, name);
            pst.setString(2, quantity.getText());

            pst.executeUpdate();

            pst.close();
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
                    new addInventory();
                }
            });
    }

}