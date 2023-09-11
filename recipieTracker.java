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

public class recipieTracker extends JFrame {
    private JMenuBar menuBar;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTextField idText;
    private JLabel ingredientsDisplay;
    private JLabel instructionsDisplay;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label5;
    private JLabel label7;
    private JLabel nameDisplay;
    private JPanel panel1;
    private JPanel panel2;

    //Constructor 
    public recipieTracker(){

        this.setTitle("recipieTracker");
        this.setSize(1052,542);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(1052,542));
        contentPane.setBackground(new Color(192,192,192));

        button1 = new JButton();
        button1.setBounds(91,151,121,83);
        button1.setBackground(new Color(214,217,223));
        button1.setForeground(new Color(0,0,0));
        button1.setEnabled(true);
        button1.setFont(new Font("SansSerif",0,16));
        button1.setText("Search");
        button1.setVisible(true);
        //Set action for button click
        //Call defined method
        button1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    searchRecipie(evt);
                }
            });

        button2 = new JButton();
        button2.setBounds(421,410,110,40);
        button2.setBackground(new Color(214,217,223));
        button2.setForeground(new Color(0,0,0));
        button2.setEnabled(true);
        button2.setFont(new Font("sansserif",0,12));
        button2.setText("Add Recipie");
        button2.setVisible(true);
        //Set action for button click
        //Call defined method
        button2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    addRecipie(evt);
                }
            });

        button3 = new JButton();
        button3.setBounds(561,410,130,40);
        button3.setBackground(new Color(214,217,223));
        button3.setForeground(new Color(0,0,0));
        button3.setEnabled(true);
        button3.setFont(new Font("sansserif",0,12));
        button3.setText("Delete Recipie");
        button3.setVisible(true);
        //Set action for button click
        //Call defined method
        button3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    deleteRecipie(evt);
                }
            });

        button4 = new JButton();
        button4.setBounds(1001,6,50,34);
        button4.setBackground(new Color(214,217,223));
        button4.setForeground(new Color(204,0,0));
        button4.setEnabled(true);
        button4.setFont(new Font("SansSerif",0,20));
        button4.setText("X");
        button4.setVisible(true);
        //Set action for button click
        //Call defined method
        button4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    exitMenu(evt);
                }
            });

        idText = new JTextField();
        idText.setBounds(146,41,102,42);
        idText.setBackground(new Color(255,255,255));
        idText.setForeground(new Color(0,0,0));
        idText.setEnabled(true);
        idText.setFont(new Font("SansSerif",0,12));
        idText.setText("");
        idText.setVisible(true);

        ingredientsDisplay = new JLabel();
        ingredientsDisplay.setBounds(182,159,500,35);
        ingredientsDisplay.setBackground(new Color(214,217,223));
        ingredientsDisplay.setForeground(new Color(0,0,0));
        ingredientsDisplay.setEnabled(true);
        ingredientsDisplay.setFont(new Font("SansSerif",0,16));
        ingredientsDisplay.setText("");
        ingredientsDisplay.setVisible(true);

        instructionsDisplay = new JLabel();
        instructionsDisplay.setBounds(182,283,500,35);
        instructionsDisplay.setBackground(new Color(214,217,223));
        instructionsDisplay.setForeground(new Color(0,0,0));
        instructionsDisplay.setEnabled(true);
        instructionsDisplay.setFont(new Font("SansSerif",0,16));
        instructionsDisplay.setText("");
        instructionsDisplay.setVisible(true);

        label1 = new JLabel();
        label1.setBounds(447,26,200,28);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("SansSerif",0,20));
        label1.setText("RECIPIE LIST");
        label1.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(25,44,120,35);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("SansSerif",0,16));
        label2.setText("Recipie Name:");
        label2.setVisible(true);

        label3 = new JLabel();
        label3.setBounds(57,44,90,35);
        label3.setBackground(new Color(214,217,223));
        label3.setForeground(new Color(0,0,0));
        label3.setEnabled(true);
        label3.setFont(new Font("SansSerif",0,18));
        label3.setText("Recipie: ");
        label3.setVisible(true);

        label5 = new JLabel();
        label5.setBounds(57,159,100,35);
        label5.setBackground(new Color(214,217,223));
        label5.setForeground(new Color(0,0,0));
        label5.setEnabled(true);
        label5.setFont(new Font("SansSerif",0,18));
        label5.setText("Ingredients:");
        label5.setVisible(true);

        label7 = new JLabel();
        label7.setBounds(57,283,100,35);
        label7.setBackground(new Color(214,217,223));
        label7.setForeground(new Color(0,0,0));
        label7.setEnabled(true);
        label7.setFont(new Font("SansSerif",0,18));
        label7.setText("Instructions:");
        label7.setVisible(true);

        nameDisplay = new JLabel();
        nameDisplay.setBounds(182,44,500,35);
        nameDisplay.setBackground(new Color(0,153,153));
        nameDisplay.setForeground(new Color(0,0,0));
        nameDisplay.setEnabled(true);
        nameDisplay.setFont(new Font("SansSerif",0,16));
        nameDisplay.setText("");
        nameDisplay.setVisible(true);

        panel1 = new JPanel(null);
        panel1.setBorder(BorderFactory.createEtchedBorder(1));
        panel1.setBounds(338,74,711,467);
        panel1.setBackground(new Color(51,255,204));
        panel1.setForeground(new Color(0,0,0));
        panel1.setEnabled(true);
        panel1.setFont(new Font("sansserif",0,12));
        panel1.setVisible(true);

        panel2 = new JPanel(null);
        panel2.setBorder(BorderFactory.createEtchedBorder(1));
        panel2.setBounds(5,77,333,463);
        panel2.setBackground(new Color(204,204,255));
        panel2.setForeground(new Color(0,0,0));
        panel2.setEnabled(true);
        panel2.setFont(new Font("sansserif",0,12));
        panel2.setVisible(true);

        //adding components to contentPane panel
        panel2.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        contentPane.add(button4);
        panel2.add(idText);
        panel1.add(ingredientsDisplay);
        panel1.add(instructionsDisplay);
        contentPane.add(label1);
        panel2.add(label2);
        panel1.add(label3);
        panel1.add(label5);
        panel1.add(label7);
        panel1.add(nameDisplay);
        contentPane.add(panel1);
        contentPane.add(panel2);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //Method actionPerformed for button1
    private void searchRecipie (ActionEvent evt) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\irfanfirosh\\Desktop\\COMPIADBMS\\login2.accdb");
            pst = con.prepareStatement("select Name,Ingredients,Instructions from recipieManager where Name=?");
            String name = idText.getText().toLowerCase();
            pst.setString(1, name);
            rs = pst.executeQuery();
            if(rs.next() == false)
            {
                JOptionPane.showMessageDialog(null, "RECORD NOT FOUND","ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
                nameDisplay.setText("");
                ingredientsDisplay.setText("");
                instructionsDisplay.setText("");
                idText.setText(""); 
            }
            else{
                nameDisplay.setText(rs.getString("Name"));
                ingredientsDisplay.setText(rs.getString("Ingredients"));
                instructionsDisplay.setText(rs.getString("Instructions"));
            }
            con.close();
            pst.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Method actionPerformed for button2
    private void addRecipie (ActionEvent evt) {
        new recipieAdd().setVisible(true);
    }

    //Method actionPerformed for button3
    private void deleteRecipie (ActionEvent evt) {
        new deleteRecipie().setVisible(true);
    }

    //Method actionPerformed for button4
    private void exitMenu (ActionEvent evt) {
        this.setVisible(false);
        new Menu().setVisible(true);
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
                    new recipieTracker();
                }
            });
    }

}