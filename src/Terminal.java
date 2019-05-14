import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Vector;
import java.util.*;
public class Terminal {
	public static String Dic="";
	Parser p;
	public static Vector<String> files=new Vector<String>();
	public Terminal() {
	}
	public void Clear()
	{
		for(int i=0;i<100;i++)
		{
			System.out.print("\n");
		}
	}
	public void ls()
	{
		if(Dic=="")
        {
        	Dic=".";
        }
	        File curDir = new File(Dic);
	        getAllFiles(curDir);

	    }
	 private static void getAllFiles(File curDir) {
		 if(Dic=="")
		 {
			 Dic=".";
		 }
	        File[] filesList = curDir.listFiles();
	        for(File f : filesList){
	            if(f.isDirectory())
	                {System.out.println(f.getName());}
	            if(f.isFile()){
	                System.out.println(f.getName());
	                if(files.contains(f.getName())==false)
	                {
		                files.add(f.getName());
	                }}
	        }

	    }
	 public void getDic()
	 {
		 	pwd();
	 }
	 public void SetDic(String s)
	 {
	 	Dic=s; 
	 }
	 public static String readFileAsString(String fileName)throws Exception 
	  { 
	    String data = ""; 
	    data = new String(Files.readAllBytes(Paths.get(fileName))); 
	    return data; 
	  } 
	  static void more(String obj) throws Exception {
		  if(Dic=="")
			 {
				 Dic=".";
			 }
		 File curDir = new File(Dic);
		 File[] filesList = curDir.listFiles();
		 for(File f : filesList){
		 if(f.isFile()){
             if(files.contains(f.getName())==false)
             {
	                files.add(f.getName());
             }}
		 }
	        if(files.contains(obj))
	        {
	        	String data = readFileAsString(obj); 
	            System.out.println(data);
	        }
	        else
	        {	
	        	System.out.println("Bad Command");
	        }
	        files.removeAllElements();
	    }
	  public void cd(String path)
	  {
	  	System.setProperty("user.dir",path);
	  	String Cdirectory = System.getProperty("user.dir");
	  	System.out.println(Cdirectory);
	  }
public void help()
{
	System.out.println("To Use 'clear' Type it in that way *Without White spaces* > 'clear'");
	System.out.println("To Use 'cd' Type it in that way *With White spaces* > 'cd dir' *with full dir*\n if you want to back to base just type 'cd .'");
	System.out.println("To Use 'ls' Type it in that way *Without White spaces* > 'ls'");
	System.out.println("To Use 'cp' Type it in that way *With White spaces* > 'cp SourcePath DistinationPath'");
	System.out.println("To Use 'mv' Type it in that way *With White spaces* > 'mv SourcePath DistinationPath'");
	System.out.println("To Use 'rm' Type it in that way *With White spaces* > 'rm Source Path'");
	System.out.println("To Use 'mkdir' Type it in that way *With White spaces* > 'mkdir Source Path'");
	System.out.println("To Use 'rmdir' Type it in that way *With White spaces* > 'rmdir Source Path'");
	System.out.println("To Use 'cat' Type it in that way *With White spaces* > 'cat file1path file2path'");
	System.out.println("To Use 'more' Type it in that way *With White spaces* > 'more dir'");
	System.out.println("To Use 'pwd' Type it in that way *Without White spaces* > 'pwd'");
	System.out.println("To Use 'args' Type it in that way *Without White spaces* > 'args'");
	System.out.println("To Use 'date' Type it in that way *Without White spaces* > 'date'");
	System.out.println("To Use 'help' Type it in that way *Without White spaces* > 'help'");
	System.out.println("To Use 'exit' Type it in that way *Without White spaces* > 'exit'");

}
public void time_date()
{
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	System.out.println(dateFormat.format(date));
}
public void args()
{
	System.out.print(p.args);
}
void mkdir(String directory) {

	try { 
		if(Files.exists(Paths.get(directory)))
			System.out.println("The directory existed");

		else 
			Files.createDirectory(Paths.get(directory));
	}catch (Exception e) {
		System.out.println("this directory doesn't exist");
	}
}
void rmdir(String directory) throws Exception{

	if(Files.exists(Paths.get(directory))) {
		Files.delete(Paths.get(directory));
	}
	else System.out.println("This directory doesn't exist");
} 
public void exit()
{
	System.exit(0);
}
void cat (String file1path ,String file2path) throws Exception {
	String content= new String(); 	
	File file=new File(file1path);
	if(file.exists()) content = new Scanner(file).useDelimiter("\\Z").next();
	else System.out.println("File not found.");

	if(!file2path.equals(" "))
	{
		File file2 =new File(file2path);
		if(file.exists()) 
			content +=new Scanner(file2).useDelimiter("\\Z").next();
		else System.out.println("File not found.");
	}
	System.out.println(content);
}
public void cp(String source,String destination)throws Exception
{
	Files.copy(Paths.get(source), Paths.get(destination).resolve(Paths.get(source).getFileName()), StandardCopyOption.REPLACE_EXISTING);
}
public void mv(String source,String destination) throws Exception
{
	Files.move(Paths.get(source), Paths.get(destination).resolve(Paths.get(source).getFileName()), StandardCopyOption.REPLACE_EXISTING);
}
public void pwd()
{
	String directory = System.getProperty("user.dir");
	System.out.println("\n"+directory);

}
void rm(String source)
{
	try{if(Files.exists(Paths.get(source))) {
		Files.delete(Paths.get(source));
	}}
	catch(IOException e)
	{
		System.out.println("this Dircetory Doesn't Exist");
	}
}
}