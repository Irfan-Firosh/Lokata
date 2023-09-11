import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class perWeek extends ApplicationFrame {

    public perWeek( String applicationTitle , String chartTitle, String people, String waste) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Days","Amount of waste",
                createDataset(people, waste),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 700 , 500 ) );
        setContentPane( chartPanel );
    }

    private DefaultCategoryDataset createDataset( String people, String waste) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        int ppl = Integer.parseInt(people);
        int w = Integer.parseInt(waste);
        int Mon = ((12*ppl)/100)*w;
        int Tue = ((14*ppl)/100)*w;
        int Wed = ((14*ppl)/100)*w;
        int Thu = ((13*ppl)/100)*w;
        int Fri = ((15*ppl)/100)*w;
        int Sat = ((17*ppl)/100)*w;
        int Sun = ((15*ppl)/100)*w;

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