package locked.me;

import java.io.IOException;
import java.util.Scanner;

public class Home {

	public static void main(String[] args) throws IOException {
		String line="******Welcome to LockedMe.com*****"+
					"\n***Developed by Nithin Palarapu***";
		System.out.print(line);
		Home menu=new Home();
		menu.mainMenu();
	}
	public void mainMenu(){
		Scanner s=new Scanner(System.in);
		int ch=0;
		do {
			try {
				//Display option to user for choosing.
				System.out.println("\nSelect the following from options");
				System.out.println("\t1.Display list of Files\n\t2.Operations\n\t3.Exit");
				ch=s.nextInt(); //Takes input for option.
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
		Scanner s=new Scanner(System.in);
		System.out.println("Choose from below option");
		System.out.println("\ta.Add file\n\tb.Delete File\n\tc.Search File\n\td.Return to Main Menu");
		char option = 0;
		do{
			try {
			char[] input = s.nextLine().toLowerCase().trim().toCharArray();
	          option = input[0];
	          switch(option) {
	          case 'a':
	        	  break;
	          case 'b':
	            	break;
	          case 'c':
	            	break;
	          case 'd':
	        	  System.out.println("Going Back to MAIN menu");
	        	  mainMenu();
	        	  break;
	          default:{
	            	System.out.println("Please enter a, b, c or d def");
	            	SubMenu();}
	          }
		}catch (Exception e){
	            System.out.println("Please enter a, b, c or d");}
		}while(option!='d');
	}
		
}