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

public class foodWaste extends JFrame {
    private JMenuBar menuBar;
    private JButton customer;
    private JButton exit;
    private JLabel label1;
    private JButton restaurant;

    //Constructor 
    public foodWaste(){

        this.setTitle("foodWaste");
        this.setSize(300,300);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(300,250));
        contentPane.setBackground(new Color(192,192,192));

        customer = new JButton();
        customer.setBounds(51,91,200,35);
        customer.setBackground(new Color(214,217,223));
        customer.setForeground(new Color(0,0,0));
        customer.setEnabled(true);
        customer.setFont(new Font("SansSerif",0,15));
        customer.setText("Customer Waste");
        customer.setVisible(true);
        //Set action for button click
        //Call defined method
        customer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    customerWaste(evt);
                }
            });

        exit = new JButton();
        exit.setBounds(234,8,60,35);
        exit.setBackground(new Color(214,217,223));
        exit.setForeground(new Color(255,51,51));
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

        label1 = new JLabel();
        label1.setBounds(84,13,150,33);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("SansSerif",0,20));
        label1.setText("Food Wastage");
        label1.setVisible(true);

        restaurant = new JButton();
        restaurant.setBounds(51,153,200,35);
        restaurant.setBackground(new Color(214,217,223));
        restaurant.setForeground(new Color(0,0,0));
        restaurant.setEnabled(true);
        restaurant.setFont(new Font("SansSerif",0,15));
        restaurant.setText("Restaurant Waste");
        restaurant.setVisible(true);
        //Set action for button click
        //Call defined method
        restaurant.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    restaurantWaste(evt);
                }
            });


        //adding components to contentPane panel
        contentPane.add(customer);
        contentPane.add(exit);
        contentPane.add(label1);
        contentPane.add(restaurant);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //Method actionPerformed for customer
    private void customerWaste (ActionEvent evt) {
        this.setVisible(false);
        new customerWaste().setVisible(true);
    }

    //Method actionPerformed for exit
    private void exitMenu (ActionEvent evt) {
        this.setVisible(false);
        new Menu().setVisible(true);
    }

    //Method actionPerformed for restaurant
    private void restaurantWaste (ActionEvent evt) {
        this.setVisible(false);
        new restaurantWaste().setVisible(true);
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
                    new foodWaste();
                }
            });
    }

}