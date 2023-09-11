/**
*Text genereted by Simple GUI Extension for BlueJ
*/
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


public class Menu extends JFrame {

    private JMenuBar menuBar;
    private JButton foodWastage;
    private JButton inventoryTracker;
    private JLabel label1;
    private JButton recipies;
    private JButton sales;

    //Constructor 
    public Menu(){

        this.setTitle("Menu");
        this.setSize(400,270);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(400,270));
        contentPane.setBackground(new Color(192,192,192));


        foodWastage = new JButton();
        foodWastage.setBounds(5,70,390,35);
        foodWastage.setBackground(new Color(214,217,223));
        foodWastage.setForeground(new Color(0,0,0));
        foodWastage.setEnabled(true);
        foodWastage.setFont(new Font("SansSerif",0,15));
        foodWastage.setText("Food Waste");
        foodWastage.setVisible(true);
        //Set action for button click
        //Call defined method
        foodWastage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                foodWaste(evt);
            }
        });


        inventoryTracker = new JButton();
        inventoryTracker.setBounds(5,210,390,35);
        inventoryTracker.setBackground(new Color(214,217,223));
        inventoryTracker.setForeground(new Color(0,0,0));
        inventoryTracker.setEnabled(true);
        inventoryTracker.setFont(new Font("SansSerif",0,15));
        inventoryTracker.setText("Inventory Tracker");
        inventoryTracker.setVisible(true);
        //Set action for button click
        //Call defined method
        inventoryTracker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                inventoryTracker(evt);
            }
        });


        label1 = new JLabel();
        label1.setBounds(176,19,90,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("SansSerif",0,20));
        label1.setText("MENU");
        label1.setVisible(true);

        recipies = new JButton();
        recipies.setBounds(5,163,390,35);
        recipies.setBackground(new Color(214,217,223));
        recipies.setForeground(new Color(0,0,0));
        recipies.setEnabled(true);
        recipies.setFont(new Font("SansSerif",0,15));
        recipies.setText("Recipies");
        recipies.setVisible(true);
        //Set action for button click
        //Call defined method
        recipies.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                recipies(evt);
            }
        });


        sales = new JButton();
        sales.setBounds(5,118,390,35);
        sales.setBackground(new Color(214,217,223));
        sales.setForeground(new Color(0,0,0));
        sales.setEnabled(true);
        sales.setFont(new Font("SansSerif",0,15));
        sales.setText("Sales");
        sales.setVisible(true);
        //Set action for button click
        //Call defined method
        sales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dynamicSales(evt);
            }
        });


        //adding components to contentPane panel
        contentPane.add(foodWastage);
        contentPane.add(inventoryTracker);
        contentPane.add(label1);
        contentPane.add(recipies);
        contentPane.add(sales);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //Method actionPerformed for foodWastage
    private void foodWaste (ActionEvent evt) {
        this.setVisible(false);
        new foodWaste().setVisible(true);
    }

    //Method actionPerformed for inventoryTracker
    private void inventoryTracker (ActionEvent evt) {
        this.setVisible(false);
        new invManager().setVisible(true);
    }

    //Method actionPerformed for recipies
    private void recipies (ActionEvent evt) {
        this.setVisible(false);
        new recipieTracker().setVisible(true);
    }

    //Method actionPerformed for sales
    private void dynamicSales (ActionEvent evt) {
        this.setVisible(false);
        new salesForecast().setVisible(true);
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
                new Menu();
            }
        });
    }

}