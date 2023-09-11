import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class perMonth extends ApplicationFrame {

    public perMonth( String applicationTitle , String chartTitle, String people, String waste ) {
        super( applicationTitle );        
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,           
                "Category",            
                "Score",            
                createDataset(people, waste),          
                PlotOrientation.VERTICAL,           
                true, true, false);

        ChartPanel chartPanel = new ChartPanel( barChart );        
        chartPanel.setPreferredSize(new java.awt.Dimension( 1000 , 367 ) );        
        setContentPane( chartPanel ); 
    }

    private CategoryDataset createDataset(String people, String waste ) {

        int ppl = (Integer.parseInt(people))*4; //customer per month
        int was = Integer.parseInt(waste);//waste 

        final String cus = "WASTE";  //customer   
        final String wa = "CUSTOMERS";
               
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
        p[0] = ppl;
	p[1] = 0.992*ppl;
	p[2] = 0.734*ppl;
	p[3] =0.521*ppl;
        p[4] = 0.638*ppl;
        p[5] = 0.819*ppl;
        p[6] =0.831*ppl;
        p[7] =0.856*ppl;
        p[8] =0.878*ppl;
        p[9] =0.856*ppl;
        p[10] =0.842*ppl;
        p[11] =0.986*ppl;
        
        double w[] = new double [12];
        for (int i = 0; i < 12; i++)
        {
            w[i] = was*p[i];
        }
        
        dataset.addValue( w[0] , cus , jan );        
        dataset.addValue( w[1] , cus , feb );        
        dataset.addValue( w[2] , cus , mar );        
        dataset.addValue( w[3] , cus , apr ); 
        dataset.addValue( w[4] , cus , may );        
        dataset.addValue( w[5] , cus , jun );        
        dataset.addValue( w[6] , cus , jul );        
        dataset.addValue( w[7] , cus , aug ); 
        dataset.addValue( w[8] , cus , sep );        
        dataset.addValue( w[9] , cus , oct );        
        dataset.addValue( w[10] , cus , nov );        
        dataset.addValue( w[11] , cus , dec ); 
        
        
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