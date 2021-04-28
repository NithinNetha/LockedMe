package locked.me;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
/*import java.nio.file.Path;
import java.nio.file.Paths;*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Home {
	static String dir; //to save user directory
    File folder_name; 		//To save folder name
    List<String> list =new ArrayList<String>(); //Creating a list to store file names
    
    
	public Home() { //constructor
        dir = System.getProperty("user.dir"); 	//Get User directory and store in variable
        folder_name = new File(dir+"/files"); 	//Create new folder in directory
        if (!folder_name.exists())				//checks if 'files' folder exists already
            folder_name.mkdirs();				//Create new folder in directory
        System.out.println("\nDirectory : "+ folder_name.getAbsolutePath());
    }
	
	
	public static void main(String[] args) throws IOException {
		String line="******Welcome to LockedMe.com*****"+  //welcome note
					"\n***Developed by Nithin Palarapu***";
		System.out.print(line); //print welcome note
		Home menu=new Home(); 	//object creation for class
		menu.mainMenu(); 		//Initialization of Main Menu
	}
	
	
	
	public void mainMenu() throws IOException{
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		list=makeList();  //Adding file names into list
		int ch=0; 
		do {				//loop initialization for main menu
			try {
				//Display option to user for choosing.
				System.out.println("\nSelect the following from options");
				System.out.println("\t1.Display list of Files\n\t2.Operations\n\t3.Exit");
				ch=Integer.parseInt(reader.readLine()); //Takes input for option.
				if(ch<1 || ch>3)  //prints when wrong option selected.
					System.out.println("\n***Wrong entry..Enter correct choice***"); 
				switch(ch) {
				case 1: {
					list=makeList();	 //called to make list 
					sortList(list); 	 //sort list using selection sort
					displayList(list);   //display list of files
					break;}
				case 2:{
					subMenu(); 			 //calls SubMenu(); function.
					break;}
				case 3:
					System.out.println("Thank you");
					System.exit(0);      //exit from application
				}
			}catch(NumberFormatException e) {
				System.out.println("\n***Entered option is invalid***");}
		}while(ch!=3);
		System.out.println("Thank you");
	} //closing of mainMenu();
	
	
	
	
	private void displayList(List<String> list) {
		if (list.isEmpty() == true)  //Checks if list is empty
            System.out.println("***There are no files to display***"); //prints if list is empty
		else {
			System.out.println("***Files currently in directory***"); //prints if list is not empty
			for(String i:list)
				System.out.println(" "+i);
		}
		
	}
	
	
	public void subMenu(){  //Start of Sub/Secondary menu
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		int option = 0; //Initialization of variable which stores user choice
		do{
			System.out.println("\nChoose from below option");
			System.out.println("\t1.Add file\n\t2.Delete File\n\t3.Search File\n\t4.Return to Main Menu");
			try {
			option=Integer.parseInt(reader.readLine()); //stores input for option.
	          switch(option) {
	          case 1:{
	        	  System.out.print("Enter file name to create: "); //ask for file name.
	        	  String filecreate=reader.readLine(); //reads file name.
	        	  addFile(filecreate); //AddFile() method is called. 
	        	  list=makeList(); //update list after creating file into folder
	          		break;
	          	}
	          case 2:{
	        	  System.out.print("Enter file name to Delete: "); //prompts for file name
	        	  String filedel=reader.readLine();  //read and store file name
	        	  deleteFile(filedel); 	//calling method for file deletion
	        	  list=makeList();      //update list after deleting file into folder
	        	  break;
	        	}
	          case 3:{
	            	fileSearch(list); //calling method for file deletion
	            	break;
	            }
	          case 4:
	        	  System.out.println("***Going Back to MAIN menu***");
	        	  mainMenu();
	        	  break;
	          }
		}catch (Exception e){
	            System.out.println("***Please enter 1, 2, 3 or 4***");}
		}while(option!=4);
	} //Closing of SubMenu(); Function.
	
	
	
	
	
	private void addFile(String name) {  //AddFile definition with name of file
		File aFile=new File(folder_name +"/"+name); //initializing File class
		boolean result;
		if(name.matches("\\S+\\.(.*)")==true) //check if file name is in proper format
		{
			
		try
		{  
			result = aFile.createNewFile();  //creates a new file  
			if(result)      // test if successfully created a new file  
			{  
				System.out.print(name+" file created at "+folder_name.getAbsolutePath()+"\n"); //returns the path string  
			}  
			else  
			{  
				System.out.println("***File already exist at location****");  //prints if file already exist
			}  
		}catch (IOException e){ e.printStackTrace();}
		}
		else
			System.out.println("****Entered name is not a proper format****"); 
	} //Closing of addfile() function.
	
	
	
	
	private void deleteFile(String filedel) { //method definition with file name
		String name=filedel; 
		File dFile =new File(folder_name +"/"+name); 
		if (dFile.delete()) { //checks if file deleted
		      System.out.println("Deleted the file: " + dFile.getName()); //prints if file is deleted
		    } else {
		      System.out.println("***File doesn't exist****"); //prints if file is not deleted
		    } 
	}
	
	public List<String> makeList() {  //method to make list which returns updated list
		File dir = new File(folder_name +"/"+"."); //giving folder directory
		List<String> names = Arrays.asList(dir.list( //copy files into list
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
		for (int i = 0; i < list.size(); i++) {// One by one move boundary of unsorted subarray
	        String smallest = list.get(i); // 
	     // Find the minimum element in unsorted array
	        int smallestIndex = i;
	        for (int j = i; j < list.size(); j++) {
	            String value = list.get(j);
	            if (value.compareTo(smallest) < 0) {
	                smallest = value;
	                smallestIndex = j;
	            }
	        }
	     // Swap the found minimum element with the first element
	        if (smallestIndex != i) { 
	            String head = list.get(i);
	            list.set(i, smallest);
	            list.set(smallestIndex, head);
	        }
	    }
	}
	
	/*Search using Naive Search Algorithm technique*/
	private void fileSearch(List<String> list) throws IOException { //Searching using Naive Pattern Searching
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		try { 
			System.out.print("Enter file name to search: "); //prompt for file name
			String ser=reader.readLine(); //read and store file name
			int flag=0;
			String name=ser.toUpperCase(); //convert file name to all uppercase 
			for(String str:list) //for each loop to retrieve each file name
				{
				String txt=str.toUpperCase(); //convert retrieved file name to uppercase
					int M=name.length(); //get and store length of user entered file name
					int N=txt.length();	 //get and store length of retrieved file name from list
					//A loop to slide pat one by one 
					for (int i = 0; i <= N - M; i++) {
						int j;	  
						// For current index i, check for pattern match 
						for (j = 0; j < M; j++)
							if (txt.charAt(i + j) != name.charAt(j)) //checks for character match
								break;
						// checks for is it only filename or fileName without extension 
						if ((j == M) && ((name.charAt(M-1)==txt.charAt(N-1)) || (txt.charAt(j)=='.'))) 
						{ 
							System.out.println("\tFound "+str); 
							flag++;
						}
					}
		
				}
			if(flag==0)
				System.out.println("***File not found***");
		}catch(NumberFormatException e) {System.out.println("***Enter options in integer format****");}
	}
	
		
}