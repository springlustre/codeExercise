package test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
public class wordtest {

	public static void main(String[] args) {
		 String fileName = "src/test/SentiWordNet.txt";
		 readFileByLines(fileName);
	}
	public static void readFileByLines(String fileName) {
		HashMap <String,List<String>> mtw = new HashMap<String,List<String>>();
        File file = new File(fileName);  
        BufferedReader reader = null;  
        try {
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  

			int line = 1;  

            while ((tempString = reader.readLine()) != null) 
            {
            	if(tempString.charAt(0)!='#')
            	{
	            	String[] thisline = tempString.split("\\t");
	                String[] meaning_words=thisline[4].replaceAll("#\\d+", "").split(" ");
	                ArrayList<String> list= new  ArrayList<String>();
	                for(String word:meaning_words)
	                {
	                	if(mtw.get(word)==null)
	                	{
		                	for(String a:meaning_words)
		                	{
		                		if(a!=word)
		                			list.add(a);
		                	}
		                	mtw.put(word, list);
	                	}
	                	else
	                	{
	                		List<String> list1=new ArrayList<String>();
	                		list1=mtw.get(word);
	                        for( String a:meaning_words)
	                        {
	                        	int flag=1;
			                	for(String b:list1)
			                	{
			                		if((a==b)||(a==word))
			                			flag=0;             	
			                	}
			                	if(flag==1){
			                		list1.add(a);
			                	}
			                }	    
	                        mtw.put(word,list1);
	                	}
	                	
	                		
	                }
            	}
            	line++;
            } 
            System.out.println(mtw);
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    }  
}
