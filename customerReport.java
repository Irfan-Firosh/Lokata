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

public class customerReport extends JFrame {
    private JMenuBar menuBar;
    private JLabel blah;
    private JLabel cAvg;
    private JLabel cMonth;
    private JLabel cYear;
    private JLabel eAvg;
    private JLabel eMonth;
    private JLabel eYear;
    private JButton exit;
    private JLabel hah;
    private JLabel haha;
    private JLabel label1;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label16;
    private JLabel label17;
    private JLabel label18;
    private JLabel label19;
    private JLabel label2;
    private JLabel label20;
    private JLabel label24;
    private JLabel label25;
    private JLabel label26;
    private JLabel label27;
    private JLabel label28;
    private JLabel label3;
    private JLabel label33;
    private JLabel label7;
    private JLabel label8;
    private JLabel oAvg;
    private JLabel oMonth;
    private JLabel oYear;
    private JButton print;
    private JLabel wAvg;
    private JLabel wMonth;
    private JLabel wYear;

    //Constructor 
    public customerReport(){

        this.setTitle("customerReport");
        this.setSize(493,870);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(493,870));
        contentPane.setBackground(new Color(255,255,255));

        blah = new JLabel();
        blah.setBounds(196,730,120,35);
        blah.setBackground(new Color(214,217,223));
        blah.setForeground(new Color(0,0,0));
        blah.setEnabled(true);
        blah.setFont(new Font("sansserif",0,12));
        blah.setText("Per year");
        blah.setVisible(true);

        cAvg = new JLabel();
        cAvg.setBounds(360,699,90,35);
        cAvg.setBackground(new Color(214,217,223));
        cAvg.setForeground(new Color(0,0,0));
        cAvg.setEnabled(true);
        cAvg.setFont(new Font("SansSerif",0,16));
        cAvg.setText("");
        cAvg.setVisible(true);

        cMonth = new JLabel();
        cMonth.setBounds(27,699,90,35);
        cMonth.setBackground(new Color(214,217,223));
        cMonth.setForeground(new Color(0,0,0));
        cMonth.setEnabled(true);
        cMonth.setFont(new Font("SansSerif",0,16));
        cMonth.setText("");
        cMonth.setVisible(true);

        cYear = new JLabel();
        cYear.setBounds(196,699,90,35);
        cYear.setBackground(new Color(214,217,223));
        cYear.setForeground(new Color(0,0,0));
        cYear.setEnabled(true);
        cYear.setFont(new Font("SansSerif",0,16));
        cYear.setText("");
        cYear.setVisible(true);

        eAvg = new JLabel();
        eAvg.setBounds(360,497,90,35);
        eAvg.setBackground(new Color(214,217,223));
        eAvg.setForeground(new Color(0,0,0));
        eAvg.setEnabled(true);
        eAvg.setFont(new Font("SansSerif",0,16));
        eAvg.setText("");
        eAvg.setVisible(true);

        eMonth = new JLabel();
        eMonth.setBounds(27,497,90,35);
        eMonth.setBackground(new Color(214,217,223));
        eMonth.setForeground(new Color(0,0,0));
        eMonth.setEnabled(true);
        eMonth.setFont(new Font("SansSerif",0,16));
        eMonth.setText("");
        eMonth.setVisible(true);

        eYear = new JLabel();
        eYear.setBounds(197,496,90,35);
        eYear.setBackground(new Color(214,217,223));
        eYear.setForeground(new Color(0,0,0));
        eYear.setEnabled(true);
        eYear.setFont(new Font("SansSerif",0,16));
        eYear.setText("");
        eYear.setVisible(true);

        exit = new JButton();
        exit.setBounds(414,16,60,35);
        exit.setBackground(new Color(255,255,255));
        exit.setForeground(new Color(255,51,0));
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

        hah = new JLabel();
        hah.setBounds(360,730,120,35);
        hah.setBackground(new Color(214,217,223));
        hah.setForeground(new Color(0,0,0));
        hah.setEnabled(true);
        hah.setFont(new Font("sansserif",0,12));
        hah.setText("per week");
        hah.setVisible(true);

        haha = new JLabel();
        haha.setBounds(360,178,120,35);
        haha.setBackground(new Color(214,217,223));
        haha.setForeground(new Color(0,0,0));
        haha.setEnabled(true);
        haha.setFont(new Font("sansserif",0,12));
        haha.setText("Kgs per week");
        haha.setVisible(true);

        label1 = new JLabel();
        label1.setBounds(-50,54,600,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("SansSerif",0,14));
        label1.setText("------------------------------------------------------------------------------------------------------------------------");
        label1.setVisible(true);

        label10 = new JLabel();
        label10.setBounds(-52,230,600,35);
        label10.setBackground(new Color(214,217,223));
        label10.setForeground(new Color(0,0,0));
        label10.setEnabled(true);
        label10.setFont(new Font("sansserif",0,12));
        label10.setText("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        label10.setVisible(true);

        label11 = new JLabel();
        label11.setBounds(21,282,90,35);
        label11.setBackground(new Color(214,217,223));
        label11.setForeground(new Color(0,0,0));
        label11.setEnabled(true);
        label11.setFont(new Font("SansSerif",0,20));
        label11.setText("Food Ordered");
        label11.setVisible(false);

        label12 = new JLabel();
        label12.setBounds(20,282,200,35);
        label12.setBackground(new Color(214,217,223));
        label12.setForeground(new Color(0,0,0));
        label12.setEnabled(true);
        label12.setFont(new Font("SansSerif",0,20));
        label12.setText("Food Ordered");
        label12.setVisible(true);

        label16 = new JLabel();
        label16.setBounds(26,353,120,35);
        label16.setBackground(new Color(214,217,223));
        label16.setForeground(new Color(0,0,0));
        label16.setEnabled(true);
        label16.setFont(new Font("sansserif",0,12));
        label16.setText("Kgs per month");
        label16.setVisible(true);

        label17 = new JLabel();
        label17.setBounds(195,353,120,35);
        label17.setBackground(new Color(214,217,223));
        label17.setForeground(new Color(0,0,0));
        label17.setEnabled(true);
        label17.setFont(new Font("sansserif",0,12));
        label17.setText("Kgs per year");
        label17.setVisible(true);

        label18 = new JLabel();
        label18.setBounds(360,353,120,35);
        label18.setBackground(new Color(214,217,223));
        label18.setForeground(new Color(0,0,0));
        label18.setEnabled(true);
        label18.setFont(new Font("sansserif",0,12));
        label18.setText("Kgs per week");
        label18.setVisible(true);

        label19 = new JLabel();
        label19.setBounds(-50,405,600,35);
        label19.setBackground(new Color(214,217,223));
        label19.setForeground(new Color(0,0,0));
        label19.setEnabled(true);
        label19.setFont(new Font("sansserif",0,12));
        label19.setText("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        label19.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(147,19,201,35);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("SansSerif",0,24));
        label2.setText("WASTE REPORT");
        label2.setVisible(true);

        label20 = new JLabel();
        label20.setBounds(20,457,120,35);
        label20.setBackground(new Color(214,217,223));
        label20.setForeground(new Color(0,0,0));
        label20.setEnabled(true);
        label20.setFont(new Font("SansSerif",0,20));
        label20.setText("Food Eaten");
        label20.setVisible(true);

        label24 = new JLabel();
        label24.setBounds(27,528,120,35);
        label24.setBackground(new Color(214,217,223));
        label24.setForeground(new Color(0,0,0));
        label24.setEnabled(true);
        label24.setFont(new Font("sansserif",0,12));
        label24.setText("Kgs per month");
        label24.setVisible(true);

        label25 = new JLabel();
        label25.setBounds(196,528,120,35);
        label25.setBackground(new Color(214,217,223));
        label25.setForeground(new Color(0,0,0));
        label25.setEnabled(true);
        label25.setFont(new Font("sansserif",0,12));
        label25.setText("Kgs per year");
        label25.setVisible(true);

        label26 = new JLabel();
        label26.setBounds(360,528,120,35);
        label26.setBackground(new Color(214,217,223));
        label26.setForeground(new Color(0,0,0));
        label26.setEnabled(true);
        label26.setFont(new Font("sansserif",0,12));
        label26.setText("Kgs per week");
        label26.setVisible(true);

        label27 = new JLabel();
        label27.setBounds(-50,607,600,35);
        label27.setBackground(new Color(214,217,223));
        label27.setForeground(new Color(0,0,0));
        label27.setEnabled(true);
        label27.setFont(new Font("sansserif",0,12));
        label27.setText("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        label27.setVisible(true);

        label28 = new JLabel();
        label28.setBounds(20,659,200,35);
        label28.setBackground(new Color(214,217,223));
        label28.setForeground(new Color(0,0,0));
        label28.setEnabled(true);
        label28.setFont(new Font("SansSerif",0,20));
        label28.setText("Customer Flow");
        label28.setVisible(true);

        label3 = new JLabel();
        label3.setBounds(21,106,120,35);
        label3.setBackground(new Color(214,217,223));
        label3.setForeground(new Color(0,0,0));
        label3.setEnabled(true);
        label3.setFont(new Font("SansSerif",0,20));
        label3.setText("Food Waste");
        label3.setVisible(true);

        label33 = new JLabel();
        label33.setBounds(27,730,120,35);
        label33.setBackground(new Color(214,217,223));
        label33.setForeground(new Color(0,0,0));
        label33.setEnabled(true);
        label33.setFont(new Font("sansserif",0,12));
        label33.setText("Per month");
        label33.setVisible(true);

        label7 = new JLabel();
        label7.setBounds(27,178,120,35);
        label7.setBackground(new Color(214,217,223));
        label7.setForeground(new Color(0,0,0));
        label7.setEnabled(true);
        label7.setFont(new Font("SansSerif",0,12));
        label7.setText("Kgs per month");
        label7.setVisible(true);

        label8 = new JLabel();
        label8.setBounds(196,178,120,35);
        label8.setBackground(new Color(214,217,223));
        label8.setForeground(new Color(0,0,0));
        label8.setEnabled(true);
        label8.setFont(new Font("sansserif",0,12));
        label8.setText("Kgs per year");
        label8.setVisible(true);

        oAvg = new JLabel();
        oAvg.setBounds(360,322,90,35);
        oAvg.setBackground(new Color(214,217,223));
        oAvg.setForeground(new Color(0,0,0));
        oAvg.setEnabled(true);
        oAvg.setFont(new Font("SansSerif",0,16));
        oAvg.setText("");
        oAvg.setVisible(true);

        oMonth = new JLabel();
        oMonth.setBounds(27,322,90,35);
        oMonth.setBackground(new Color(214,217,223));
        oMonth.setForeground(new Color(0,0,0));
        oMonth.setEnabled(true);
        oMonth.setFont(new Font("SansSerif",0,16));
        oMonth.setText("");
        oMonth.setVisible(true);

        oYear = new JLabel();
        oYear.setBounds(196,322,90,35);
        oYear.setBackground(new Color(214,217,223));
        oYear.setForeground(new Color(0,0,0));
        oYear.setEnabled(true);
        oYear.setFont(new Font("SansSerif",0,16));
        oYear.setText("");
        oYear.setVisible(true);

        print = new JButton();
        print.setBounds(144,803,180,50);
        print.setBackground(new Color(214,217,223));
        print.setForeground(new Color(0,0,0));
        print.setEnabled(true);
        print.setFont(new Font("SansSerif",0,18));
        print.setText("Print Report");
        print.setVisible(true);
        //Set action for button click
        //Call defined method
        print.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    printReport(evt);
                }
            });

        wAvg = new JLabel();
        wAvg.setBounds(360,147,90,35);
        wAvg.setBackground(new Color(214,217,223));
        wAvg.setForeground(new Color(0,0,0));
        wAvg.setEnabled(true);
        wAvg.setFont(new Font("SansSerif",0,16));
        wAvg.setText("");
        wAvg.setVisible(true);

        wMonth = new JLabel();
        wMonth.setBounds(27,147,90,35);
        wMonth.setBackground(new Color(214,217,223));
        wMonth.setForeground(new Color(0,0,0));
        wMonth.setEnabled(true);
        wMonth.setFont(new Font("SansSerif",0,16));
        wMonth.setText("");
        wMonth.setVisible(true);

        wYear = new JLabel();
        wYear.setBounds(196,147,90,35);
        wYear.setBackground(new Color(214,217,223));
        wYear.setForeground(new Color(0,0,0));
        wYear.setEnabled(true);
        wYear.setFont(new Font("SansSerif",0,16));
        wYear.setText("");
        wYear.setVisible(true);

        //adding components to contentPane panel
        contentPane.add(blah);
        contentPane.add(cAvg);
        contentPane.add(cMonth);
        contentPane.add(cYear);
        contentPane.add(eAvg);
        contentPane.add(eMonth);
        contentPane.add(eYear);
        contentPane.add(exit);
        contentPane.add(hah);
        contentPane.add(haha);
        contentPane.add(label1);
        contentPane.add(label10);
        contentPane.add(label11);
        contentPane.add(label12);
        contentPane.add(label16);
        contentPane.add(label17);
        contentPane.add(label18);
        contentPane.add(label19);
        contentPane.add(label2);
        contentPane.add(label20);
        contentPane.add(label24);
        contentPane.add(label25);
        contentPane.add(label26);
        contentPane.add(label27);
        contentPane.add(label28);
        contentPane.add(label3);
        contentPane.add(label33);
        contentPane.add(label7);
        contentPane.add(label8);
        contentPane.add(oAvg);
        contentPane.add(oMonth);
        contentPane.add(oYear);
        contentPane.add(print);
        contentPane.add(wAvg);
        contentPane.add(wMonth);
        contentPane.add(wYear);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //Method actionPerformed for exit
    private void exitMenu (ActionEvent evt) {
        this.setVisible(false);
        new customerWaste().setVisible(true);
    }

    //Method actionPerformed for print
    private void printReport (ActionEvent evt) {
        int wmonth = 0;
        int wyear = 0;
        int emonth = 0;
        int eyear = 0;
        int omonth = 0;
        int oyear = 0;
        int cmonth = 0;
        int cyear = 0;
        
        
        int p = 0;
        int w = 0;
        int ea = 0;
        int o = 0;
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\irfanfirosh\\Desktop\\COMPIADBMS\\login2.accdb");
            String query = "select numPeople,orderedFood,wastedFood, eatenFood from customerWaste";
            pst = con.prepareStatement(query); 
            pst.setMaxRows(1); 
            rs = pst.executeQuery();
            if(rs.next() == false)
            {
                JOptionPane.showMessageDialog(null, "RECORD NOT FOUND","ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
            }
            else{
                p = Integer.parseInt(rs.getString("numPeople"));
                o = Integer.parseInt(rs.getString("orderedFood"));
                w = Integer.parseInt(rs.getString("wastedFood"));
                ea = Integer.parseInt(rs.getString("eatenFood"));
                
                cmonth = p * 4;
                cyear = p * 52;
                wmonth = w * cmonth;
                wyear = w * cyear;
                emonth = ea * cmonth;
                eyear = ea * cyear;
                omonth = o * cmonth;
                oyear = o * cyear;
                
                
                
                cMonth.setText(Integer.toString(cmonth));
                cYear.setText(Integer.toString(cyear));
                cAvg.setText(Integer.toString(p));
                
                oMonth.setText(Integer.toString(omonth));
                oYear.setText(Integer.toString(oyear));
                oAvg.setText(Integer.toString(o* p));
                
                eMonth.setText(Integer.toString(emonth));
                eYear.setText(Integer.toString(eyear));
                eAvg.setText(Integer.toString(ea * p));
                
                wMonth.setText(Integer.toString(wmonth));
                wYear.setText(Integer.toString(wyear));
                wAvg.setText(Integer.toString(w* p));
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
                    new customerReport();
                }
            });
    }

}