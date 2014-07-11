import java.io.*; 
import java.util.Calendar;
public class Main  
{  
 public static void main (String[] args) throws java.lang.Exception 
    { 
    
   //use the following code to fetch input from console 
   String line; 
      DataInputStream in = new DataInputStream(System.in);
      int cont=0, year, month;
      String dates[] = new String[3];
      String day[] = new String[]{"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY","FRIDAY","SATURDAY"};
      Calendar cal = Calendar.getInstance();
      while((line=in.readLine())!=null && cont < 2)    
      {
    	  dates[cont++] = line;
      }
      
      for(int i=0; i<2; i++){
    	  String splitDate[] = dates[i].split("-");
    	  year = Integer.parseInt(splitDate[0]);
    	  month = Integer.parseInt(splitDate[1]);
    	  cal.set(year,month,28);
    	  System.out.println(day[cal.get(Calendar.DAY_OF_WEEK)-1]);
      }
    }
 
 	
}