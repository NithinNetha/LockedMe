package locked.me;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Home {

	public static void main(String[] args) throws IOException {
		String line="******Welcome to LockedMe.com*****"+
					"\n***Developed by Nithin Palarapu***";
		System.out.print(line);
		Home menu=new Home();
		menu.mainMenu();
	}
	public void mainMenu() throws IOException{
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		int ch=0;
		do {
			try {
				//Display option to user for choosing.
				System.out.println("\nSelect the following from options");
				System.out.println("\t1.Display list of Files\n\t2.Operations\n\t3.Exit");
				ch=Integer.parseInt(reader.readLine()); //Takes input for option.
				//prints when wrong option selected.
				if(ch>3)
					System.out.println("***Entered option is invalid***\n"); 
				switch(ch) {
				case 1: 
					break;
				case 2:{
					SubMenu();
					break;}
				case 3:
					System.out.println("Thank you");
					System.exit(0);
				}
			}catch(NumberFormatException e) {
				System.out.println("\nWrong entry..Enter correct choice");}
		}while(ch!=3);
		System.out.println("Thank you");
	}
	public void SubMenu(){
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		int option = 0;
		do{
			System.out.println("Choose from below option");
			System.out.println("\ta.Add file\n\tb.Delete File\n\tc.Search File\n\td.Return to Main Menu");
			try {
			option=Integer.parseInt(reader.readLine()); //Takes input for option.
	          switch(option) {
	          case 1:{
	        	  System.out.print("Enter file name to create: "); //ask for file name.
				String filecreate=reader.readLine(); //reads file name.
				AddFile(filecreate); //AddFile() method is called.  
	          }
	          case 2:
	            	break;
	          case 3:
	            	break;
	          case 4:
	        	  System.out.println("Going Back to MAIN menu");
	        	  mainMenu();
	        	  break;
	          }
		}catch (Exception e){
	            System.out.println("Please enter 1, 2, 3 or 4");}
		}while(option!=4);
	}
	public void AddFile(String name) {  //AddFile definition with name of file
		File aFile=new File(name); //initializing File class
		boolean result;
		if(name.matches("\\S+\\.(.*)")==true) //check if file name is in proper format
		{
			
		try
		{  
			result = aFile.createNewFile();  //creates a new file  
			if(result)      // test if successfully created a new file  
			{  
				System.out.print("file created at "); //returns the path string  
				String temp=aFile.getCanonicalPath();
				Path path=Paths.get(temp);
				path = path.getParent();
				System.out.println(path);
			}  
			else  
			{  
				System.out.println("File already exist at location: ");  
			}  
		}catch (IOException e){ e.printStackTrace();}
		}
		else
			System.out.println("Entered name is not a proper format");
		}
		
}