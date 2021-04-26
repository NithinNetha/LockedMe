package locked.me;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Home {
	static String DIRECTORY;
    File folder_name;
    List<String> list =new ArrayList<String>(); //Creating a list to store file names
    
    
	public Home() { //constructor
        DIRECTORY = System.getProperty("user.dir");
        folder_name = new File(DIRECTORY+"/files");
        if (!folder_name.exists())
            folder_name.mkdirs();
        System.out.println("DIRECTORY : "+ folder_name.getAbsolutePath());
    }
	
	
	public static void main(String[] args) throws IOException {
		String line="******Welcome to LockedMe.com*****"+  //welcome note
					"\n***Developed by Nithin Palarapu***";
		System.out.print(line);
		Home menu=new Home(); //object creation for class
		menu.mainMenu(); //Initialization of Main Menu
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
				case 1: {
					list=makeList(); //called to make list 
					sortList(list); //sort list using selection sort
					displayList(list); //display list of files
					break;}
				case 2:{
					subMenu(); //calls SubMenu(); function.
					break;}
				case 3:
					System.out.println("Thank you");
					System.exit(0);//exit from application
				}
			}catch(NumberFormatException e) {
				System.out.println("\nWrong entry..Enter correct choice");}
		}while(ch!=3);
		System.out.println("Thank you");
	} //closing of mainMenu();
	private void displayList(List<String> list) {
		if (list.isEmpty() == true)
            System.out.println("***There are no files to display***");
		else {
			System.out.println("Files currently in directory");
			for(String i:list)
				System.out.println(" "+i);
		}
		
	}
	public void subMenu(){
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		int option = 0;
		do{
			System.out.println("Choose from below option");
			System.out.println("\t1.Add file\n\t2.Delete File\n\t3.Search File\n\t4.Return to Main Menu");
			try {
			option=Integer.parseInt(reader.readLine()); //Takes input for option.
	          switch(option) {
	          case 1:{
	        	  System.out.print("Enter file name to create: "); //ask for file name.
				String filecreate=reader.readLine(); //reads file name.
				addFile(filecreate); //AddFile() method is called. 
				list=makeList();
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
	} //Closing of SubMenu(); Function.
	
	public void addFile(String name) {  //AddFile definition with name of file
		File aFile=new File(folder_name +"/"+name); //initializing File class
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
	} //Closing of addfile() function.
	
	public List<String> makeList() {
		File dir = new File(folder_name +"/"+"."); //giving folder directory
		List<String> names = Arrays.asList(dir.list(
		   new FilenameFilter() {
		      @Override public boolean accept(File dir, String name) {		         	        	 
		    	  return name.matches("\\S+\\.(.*)"); //checking only for files not folders
		    	 }
		   }
		));
		return names;
	}//closing of makeList();
	
	//demonstrating Selection sort
	public void sortList(List<String> list) { 
		for (int i = 0; i < list.size(); i++) {
	        String smallest = list.get(i);
	        int smallestIndex = i;
	        for (int j = i; j < list.size(); j++) {
	            String value = list.get(j);
	            if (value.compareTo(smallest) < 0) {
	                smallest = value;
	                smallestIndex = j;
	            }
	        }

	        if (smallestIndex != i) {
	            String head = list.get(i);
	            list.set(i, smallest);
	            list.set(smallestIndex, head);
	        }
	    }
	}
		
}