import java.util.*;

public class Parser {
	 static Vector <String> args=new Vector();
	private String cmd;
	private String input;
	public Terminal obj=new Terminal();
	private Vector<String> Commands=new <String> Vector();
	private String RestOfCommand;
	public void Setinput(String s) throws Exception
	{
		input=s;
		Commands.add("clear");Commands.add("cd");Commands.add("ls");Commands.add("cp");
		Commands.add("mv");Commands.add("rm");Commands.add("mkdir");Commands.add("rmdir");
		Commands.add("cat");Commands.add("more");Commands.add("pwd");Commands.add("args");
		Commands.add("date");Commands.add("help");Commands.add("exit");
		parse(input);
	}
	public int Search (String s)
	{
		for(int i=0;i<Commands.size();i++)
		{
			if(s.equals(Commands.elementAt(i)))
				return i;
		}
		return -1;
	}
	public boolean parse(String input) throws Exception
	{
		String command="";
		String Rest="";
		String Source="";
		String Dis="";
		if(input.contains(" ")){
			command= input.substring(0, input.indexOf(" "));
			command.toLowerCase();
			 if(Search(command)==0||Search(command)==10||Search(command)==11||Search(command)==12||Search(command)==13||Search(command)==14||Search(command)==-1)
	        {
	        	System.out.print("Bad Command\n");
	        	return false;
	        }
	        command= input.substring(0, input.indexOf(" "));
	        cmd=command;
	        if(Search(command)==1||Search(command)==6||Search(command)==5||Search(command)==7||Search(command)==9)
	        {Rest+=input.substring(input.indexOf(" ")+1,input.length());
	        if(Rest.contains(" "))
	        {
	        	System.out.print("Bad Command\n");
	        	return false;
	        }
	        else if(Rest=="")
	        {
	        	System.out.print("Bad Command\n");
	        	return false;
	        }
	        args.add(Rest);
	        }
	        else
	        {
	        	int index = -1;
	        	int index2 = -1;
	        	for(int i=0;i<input.length();i++)
	        	{
	        		if(index>0&&input.charAt(i)==' ')
	        		{
	        			index2=i;
	        		}
	        		if(index<0&&input.charAt(i)==' ')
	        		{
	        			index=i;
	        		}
	        		
	        	}
	        	Source+=input.substring(index+1,index2);
		        args.add(Source);
	        	Dis+=input.substring(index2+1,input.length());
		        args.add(Dis);
	        }
	        
		}
		else if(input.isEmpty())
		{
			System.out.print("Bad Command\n");
        	return false;
		}
		else if(input.contains(" ")==false||input.contains("  ")==false)
		{
			command=input;
			 if(Search(command)==0||Search(command)==10||Search(command)==2||Search(command)==11||Search(command)==12||Search(command)==13||Search(command)==14)
			 {
				 cmd=command;
			 }
			 else
			 {
				 System.out.print("Bad Command\n");
		        	return false;
			 }

		}

		if(Search(cmd)==0)
		{
			obj.Clear();
		}
		if(Search(cmd)==1)
		{
			obj.cd(args.elementAt(args.size()-1));
		}
		if(Search(cmd)==2)
		{
			obj.ls();
		}
		if(Search(cmd)==3)
		{
			obj.cp(Source, Dis);
		}
		if(Search(cmd)==4)
		{
			obj.mv(Source,Dis);
		}
		if(Search(cmd)==5)
		{
			obj.rm(args.elementAt(args.size()-1));
		}
		if(Search(cmd)==6)
		{
			obj.mkdir(args.elementAt(args.size()-1));
		}
		if(Search(cmd)==7)
		{
			obj.rmdir(args.elementAt(args.size()-1));
		}
		if(Search(cmd)==8)
		{
			obj.cat(Source,Dis);
		}
		if(Search(cmd)==9)
		{
			obj.more(args.elementAt(args.size()-1));
		}
		if(Search(cmd)==10)
		{
			obj.getDic();
		}
		if(Search(cmd)==11)
		{
			obj.args();
		}
		if(Search(cmd)==12)
		{
			obj.time_date();
		}
		if(Search(cmd)==14)
		{
			obj.exit();
		}
		if(Search(cmd)==13)
		{
			obj.help();
		}
		return true;
	


	}
}
