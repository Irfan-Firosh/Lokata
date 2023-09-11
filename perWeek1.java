import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class perWeek1 extends ApplicationFrame {

    public perWeek1( String applicationTitle , String chartTitle, String waste) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Days","Amount of Waste",
                createDataset(waste),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 700 , 500 ) );
        setContentPane( chartPanel );
    }

    private DefaultCategoryDataset createDataset(String waste) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        double w = Integer.parseInt(waste);
        double Mon = ((11.5*w)/100);
        double Tue = ((13.9*w)/100);
        double Wed = ((14.3*w)/100);
        double Thu = ((12.7*w)/100);
        double Fri = ((14.8*w)/100);
        double Sat = ((17.6*w)/100);
        double Sun = ((15.2*w)/100);

        dataset.addValue( Mon , "waste" , "Monday" );
        dataset.addValue( Tue , "waste" , "Tuesday" );
        dataset.addValue( Wed , "waste" ,  "Wednesday" );
        dataset.addValue( Thu , "waste" , "Thursday" );
        dataset.addValue( Fri , "waste" , "Friday" );
        dataset.addValue( Sat , "waste" , "Saturday" );
        dataset.addValue( Sun , "waste" , "Sunday" );

        return dataset;
    }

}
