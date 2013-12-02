package file.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import deploy.appdata.directory;

public class ContentReader {
	private static boolean flag=false;
	static StringBuilder tempName;
	public static StringBuilder getToFromContents(String Start){ 
	try{
	    FileInputStream fstream = new FileInputStream(directory.titanNebulaContentPath+"/TitanWatchContent.txt");
	    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
	    String strLine;
	    tempName=new StringBuilder();
	    //Loop through and check if a header or footer line, if not
	    //equate a substring to a temp variable and print it....
	    while ((strLine = br.readLine()) != null)   {
	      
	      if(flag==true){
	      if(strLine.contains(";")){
	    	flag=false;
	    	tempName.append(strLine.split(";")[0]);
	      } 
	      else
	      {
	    	  tempName.append(strLine);
	      }
	      }
	      if (strLine.contains(Start)){
	    	  flag=true;
	    	  tempName.append("\n"+strLine.split("=")[1]);
	      }
	    }
	    //Close the input stream
	    fstream.close();
	  } catch (Exception e) {
	      e.printStackTrace();
	    }
	return tempName;
	  }
}
