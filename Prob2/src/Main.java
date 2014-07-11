import java.io.*; 
public class Main  
{  
 public static void main (String[] args) throws java.lang.Exception 
    { 
    
   //use the following code to fetch input from console 
   String line; 
      DataInputStream in = new DataInputStream(System.in);
      int cont = 0, jumps[], results[], contJumps;
      String sentences[] = new String[3];
      while((line=in.readLine())!=null && cont < 3)    
      {
    	  sentences[cont++] = line;
      }
      
      for(int i=0; i<3; i++){
    	  String splitString[] = sentences[i].split(" ");
    	  for(int k=0; k<splitString.length; k++){
    		  if(Character.isUpperCase(splitString[k].charAt(0))){
    			  System.out.println(splitString[k]);
    		  }
    	  }
      }
    }
 
 	
}