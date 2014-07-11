import java.io.*; 
public class Main  
{  
 public static void main (String[] args) throws java.lang.Exception 
    { 
    
   //use the following code to fetch input from console 
   String line; 
      DataInputStream in = new DataInputStream(System.in);
      int cont = 0, jumps[], results[], contJumps;
      jumps = new int[4];
      results = new int[4];
      while((line=in.readLine())!=null && cont <= 3)    
      {
      	jumps[cont++] = Integer.parseInt(line);
      }
      
      for(int i=0; i<4; i++){
   		contJumps=1;
    	for(int j=0; j<jumps[i]; j++){
   			if(contJumps==1){
   				results[i] += 20;
   				contJumps++;
   			}else if(contJumps==2){
   				results[i] += 10;
   				contJumps++;
   			}else{
   				results[i] += 5;
   				contJumps=1;
   			}
   		}
   		System.out.println(Integer.toString(results[i]));
   	  }
    }
 
 	
}