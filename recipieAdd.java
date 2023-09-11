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


public class recipieAdd extends JFrame {

    private JMenuBar menuBar;
    private JButton button2;
    private JTextField ingredients;
    private JTextField instructions;
    private JLabel label1;
    private JLabel label3;
    private JLabel label5;
    private JLabel label7;
    private JPanel panel1;
    private JTextField recipieName;

    //Constructor 
    public recipieAdd(){

        this.setTitle("recipieAdd");
        this.setSize(730,551);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(730,551));
        contentPane.setBackground(new Color(192,192,192));


        button2 = new JButton();
        button2.setBounds(575,409,110,40);
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


        ingredients = new JTextField();
        ingredients.setBounds(182,159,500,60);
        ingredients.setBackground(new Color(255,255,255));
        ingredients.setForeground(new Color(0,0,0));
        ingredients.setEnabled(true);
        ingredients.setFont(new Font("SansSerif",0,14));
        ingredients.setText("");
        ingredients.setVisible(true);

        instructions = new JTextField();
        instructions.setBounds(182,283,500,60);
        instructions.setBackground(new Color(255,255,255));
        instructions.setForeground(new Color(0,0,0));
        instructions.setEnabled(true);
        instructions.setFont(new Font("SansSerif",0,14));
        instructions.setText("");
        instructions.setVisible(true);

        label1 = new JLabel();
        label1.setBounds(280,26,200,28);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("SansSerif",0,20));
        label1.setText("ENTER RECIPIE");
        label1.setVisible(true);

        label3 = new JLabel();
        label3.setBounds(57,44,90,35);
        label3.setBackground(new Color(214,217,223));
        label3.setForeground(new Color(0,0,0));
        label3.setEnabled(true);
        label3.setFont(new Font("SansSerif",0,18));
        label3.setText("Name: ");
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

        panel1 = new JPanel(null);
        panel1.setBorder(BorderFactory.createEtchedBorder(1));
        panel1.setBounds(5,80,723,466);
        panel1.setBackground(new Color(51,255,204));
        panel1.setForeground(new Color(0,0,0));
        panel1.setEnabled(true);
        panel1.setFont(new Font("sansserif",0,12));
        panel1.setVisible(true);

        recipieName = new JTextField();
        recipieName.setBounds(182,44,500,60);
        recipieName.setBackground(new Color(255,255,255));
        recipieName.setForeground(new Color(0,0,0));
        recipieName.setEnabled(true);
        recipieName.setFont(new Font("SansSerif",0,14));
        recipieName.setText("");
        recipieName.setVisible(true);

        //adding components to contentPane panel
        panel1.add(button2);
        panel1.add(ingredients);
        panel1.add(instructions);
        contentPane.add(label1);
        panel1.add(label3);
        panel1.add(label5);
        panel1.add(label7);
        contentPane.add(panel1);
        panel1.add(recipieName);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //Method actionPerformed for button2
    private void addRecipie (ActionEvent evt) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        String query = "insert into recipieManager" + "(Name, Ingredients, Instructions)" + "values (?, ?, ?)";
        String name = recipieName.getText().toLowerCase();
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\irfanfirosh\\Desktop\\COMPIADBMS\\login2.accdb");
            pst = con.prepareStatement(query);
            
            pst.setString(1, name);
            pst.setString(2, ingredients.getText());
            pst.setString(3, instructions.getText());
            
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
                new recipieAdd();
            }
        });
    }

}