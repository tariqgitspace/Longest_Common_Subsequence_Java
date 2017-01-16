
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.IOException;
 
public class  LCS_Tariq_Siddiqui_tariqsid
{    
	
	static int length_input1;
	static String String_input1;
	static String LCS_String;
	static int length_input2;
	static int final_length;
	static String String_input2; 
	static Writer output;
	static BufferedReader input;
	static int[][] LCS;

    public static int bigger(int a, int b)
    {
    	if(a>b)
    	{
    		return a;
    	}
    	else
    	{
    		return b;
    	}
    }

    
    public static void Longest_Common_SubSequence() throws IOException
    {
 
        LCS = new int[length_input1 + 1][length_input2 + 1];
 
        /*
         From Algorithm:
        for j = 0 to m do
        	2 opt[0, j] = 0
        	3 for i = 1 to n
        	4 	opt[i, 0] = 0
        	5 	for j = 1 to m
        	6 		if A[i] = B[j]
        	7 			opt[i, j] = opt[i − 1; j − 1] + 1
        	8 		elseif opt[i, j − 1] ≥ opt[i − 1; j]
        	9 			opt[i, j] = opt[i, j − 1]
        	10 		else
        	11 			opt[i, j] opt[i − 1; j]
        */		
     
        for (int i=0; i<=length_input1; i++)
        {
          for (int j=0; j<=length_input2; j++)
          {
            if (i == 0 || j == 0)
            {
              LCS[i][j] = 0;
            }
            else if (String_input1.charAt(i-1) == String_input2.charAt(j-1))
            {
              LCS[i][j] = LCS[i-1][j-1] + 1;
            }
            else if (LCS[i-1][j] >= LCS[i][j-1])
            {
            	LCS[i][j] = LCS[i-1][j];
            }
            else
            {
            	LCS[i][j] = LCS[i][j-1];
            }
            	
          }
        }
        
        
        final_length = LCS[length_input1][length_input2];
        

    }
    
    public static void Print_Longest_Common_SubSequence() throws IOException
    {
    	
        int i = length_input1, j = length_input2;
        //String output_answer="";
        int position=final_length;
        char[] answer = new char[final_length];
        
        while (i > 0 && j > 0) 
        {
            if (String_input1.charAt(i-1) == String_input2.charAt(j-1)) 
            {
            	position--;
            	answer[position]=String_input1.charAt(i-1);
            	//output_answer+=String_input1.charAt(i-1);
                i--;
                j--;
                
            }
            else if (LCS[i - 1][j] > LCS[i][j - 1]) 
            {
                i--;            	
            }

            else
            {
                j--;
            }
        }
        
        String text = String.valueOf(answer);
        //String x = new StringBuilder(output_answer).reverse().toString();
        output.write(Integer.toString(text.length()));
        output.write("\n");
        System.out.println(text.length()+"\n"+text);
        output.write(text);
    }

    
    public static void main(String[] args) throws IOException
    {    
		 String x= "D://1st Semester//Analysis-Of-Algorithm//Project2\\input.txt";
		 String y= "D://1st Semester//Analysis-Of-Algorithm//Project2\\output.txt";

		 input = new BufferedReader(new InputStreamReader(new FileInputStream(x)));
		  output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(y,false)));  //append=false(new file) 
		 String_input1 = "bbbb";
		 String_input2 = "ababab";
 

		  if(String_input1!=null && String_input2!=null)
		  {
			  length_input1 = String_input1.length();
			  length_input2 = String_input2.length();
		      Longest_Common_SubSequence();
			   Print_Longest_Common_SubSequence();
		  }
		  else
		   {
			//System.out.println("dsfd");
		    output.write("0");
	        output.write("\n");
		   }

		   
        input.close();
        output.close();
 
        
    }
}