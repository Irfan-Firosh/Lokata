import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class perMonth1 extends ApplicationFrame {

    public perMonth1( String awasicationTitle , String chartTitle, String waste ) {
        super( awasicationTitle );        
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,           
                "Category",            
                "Waste",            
                createDataset(waste),          
                PlotOrientation.VERTICAL,           
                true, true, false);

        ChartPanel chartPanel = new ChartPanel( barChart );        
        chartPanel.setPreferredSize(new java.awt.Dimension( 1000 , 367 ) );        
        setContentPane( chartPanel ); 
    }

    private CategoryDataset createDataset(String waste ) {

        int was = (Integer.parseInt(waste))*4;//waste 

        final String wa = "WASTE";
               
        final String jan = "January";        
        final String feb = "February";        
        final String mar = "March";  
        final String apr = "April"; 
        final String may = "May"; 
        final String jun = "June"; 
        final String jul = "July"; 
        final String aug = "August"; 
        final String sep = "September"; 
        final String oct = "October"; 
        final String nov = "November"; 
        final String dec = "December"; 
        final DefaultCategoryDataset dataset = 
        new DefaultCategoryDataset( );  

        double p[] = new double [12];
        p[0] = was;
	p[1] = 0.912 * was;
	p[2] = 0.754 * was;
	p[3] =0.721 * was;
        p[4] = 0.438 * was;
        p[5] = 0.819* was;
        p[6] =0.831*was;
        p[7] =0.856*was;
        p[8] =0.808*was;
        p[9] =0.956*was;
        p[10] =0.842*was;
        p[11] =0.986*was;
        
        
        dataset.addValue( p[0] , wa , jan );
        dataset.addValue( p[1] , wa , feb );
        dataset.addValue( p[2] , wa , mar );
        dataset.addValue( p[3] , wa , apr );
        dataset.addValue( p[4] , wa , may );
        dataset.addValue( p[5] , wa , jun );
        dataset.addValue( p[6] , wa , jul);
        dataset.addValue( p[7] , wa , aug );
        dataset.addValue( p[8] , wa , sep );
        dataset.addValue( p[9] , wa , oct);
        dataset.addValue( p[10] , wa , nov );
        dataset.addValue( p[11] , wa , dec );
        return dataset; 

    }

}
