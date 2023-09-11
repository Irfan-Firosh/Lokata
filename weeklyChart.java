import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class weeklyChart extends ApplicationFrame {

    public weeklyChart( String applicationTitle , String chartTitle, int w[], int factor) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Days","Amount of Sales",
                createDataset(w, factor),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 700 , 500 ) );
        setContentPane( chartPanel );
    }

    private DefaultCategoryDataset createDataset( int w1[], int f) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        int w[] = new int[7];
        for(int i = 0 ; i < 7 ; i ++){
            w[i] = w1[i]+(w1[i]*f)+(w1[i]*f*f);
        }


        dataset.addValue( w[0] , "Sales" , "Monday" );
        dataset.addValue( w[1] , "Sales" , "Tuesday" );
        dataset.addValue( w[2] , "Sales" ,  "Wednesday" );
        dataset.addValue( w[3] , "Sales" , "Thursday" );
        dataset.addValue( w[4] , "Sales" , "Friday" );
        dataset.addValue( w[5] , "Sales" , "Saturday" );
        dataset.addValue( w[6] , "Sales" , "Sunday" );

        return dataset;
    }

}
