import java.util.*;

class Student{
	String StId;
	String StName;
	int PRFMarks;
	int DBMSMarks;
	int TotalMarks;
	double AvgMarks;
	
	public boolean SearchID(Student[] ar, String STID){
		boolean b=false;
		for (int i = 0; i < ar.length; i++){
			if(STID.equalsIgnoreCase(ar[i].StId)){
				b=true;
				break;
			}
		}
		return b;
		
	}
	
	public void CalMarks(){
		TotalMarks=PRFMarks+DBMSMarks;
		AvgMarks=(double)TotalMarks/2;
	}
	
	public int GetIndex(Student[] ar,String STID){
		int index=0;
		for (int i = 0; i <ar.length ; i++){
			if(STID.equalsIgnoreCase(ar[i].StId)){
				index=i;
				break;
			}
		}
		return index;
	}
	
	public boolean SearchMarksAdded(){
		if(this.PRFMarks==-1){
			return false;
		}
		return true;
		
	}
	
	
	public void PrintStudentName(){
		System.out.print("Student Name     	: "+StName);
	}
	
	public void PrintStudentDetails(){
		System.out.println("Student ID   	: "+StId);
		System.out.println("Student Name 	: "+StName);
	}
	
	public void PrintStudentMarks(){
		System.out.println("PRF Marks    	: "+PRFMarks);
		System.out.println("DBMS Marks  	: "+DBMSMarks);
	}
	
	public void PrintStudentSUBMarks(){
		System.out.println("Total Marks    	: "+TotalMarks);
		System.out.println("Average Marks   : "+AvgMarks);
	}
	
	public void UpdateStudentName(String temp){
		this.StName=temp;
	}
	
	
	public void AddStudent(String StId, String StName){
		this.StId=StId;
		this.StName=StName;
		PRFMarks=-1;
		DBMSMarks=-1;
	}
	public void AddStudentWithMarks(String StId, String StName, int PRFMarks, int DBMSMarks){
		this.StId=StId;
		this.StName=StName;
		this.PRFMarks=PRFMarks;
		this.DBMSMarks=DBMSMarks;
		
	}
	public Student GetAddress(){
		return this;
	}
	
	public static void SortMarks(Student[] ar){
		for (int i = 0; i < ar.length; i++){
			ar[i].CalMarks();
		}
		
		for (int i = ar.length-1; i >=0 ; i--){
			for (int j = 0; j < i; j++){
				if(ar[j].TotalMarks>ar[j+1].TotalMarks){
					Student temp=ar[j+1];
					ar[j+1]=ar[j];
					ar[j]=temp;
				}
			}
			
		}
		
	}
	
	
	public static void SortMarksPRF(Student[] ar){
		for (int i = 0; i < ar.length; i++){
			ar[i].CalMarks();
		}
		
		for (int i = ar.length-1; i >=0 ; i--){
			for (int j = 0; j < i; j++){
				if(ar[j].PRFMarks>ar[j+1].PRFMarks){
					Student temp=ar[j+1];
					ar[j+1]=ar[j];
					ar[j]=temp;
				}
			}
			
		}
		
	}
	
	public static void SortMarksDBMS(Student[] ar){
		for (int i = 0; i < ar.length; i++){
			ar[i].CalMarks();
		}
		
		for (int i = ar.length-1; i >=0 ; i--){
			for (int j = 0; j < i; j++){
				if(ar[j].DBMSMarks>ar[j+1].DBMSMarks){
					Student temp=ar[j+1];
					ar[j+1]=ar[j];
					ar[j]=temp;
				}
			}
			
		}
		
	}
	
	
	
}

//------------------Main Method-------------------------

class Demo{
	static Student[] Array=new Student[0];
	
	public static void main(String args[]){
		do{
			method();
		}while(true);
		
	}
	
	
//----------------------Select Method--------------------------	
	
	public static void method(){
		Scanner input=new Scanner(System.in);
		Startpage();
		String option=input.nextLine();
		switch(option){
			case "1" : AddStudent(); break;
			case "2" : AddnewStudentwithMarks(); break;
			case "3" : AddMarks(); break;
			case "4" : UpdateStudentDetails(); break;
			case "5" : UpdateMarks(); break;
			case "6" : DeleteStudent(); break;
			case "7" : PrintSTDetails(); break;
			case "8" : PrintSTRanks(); break;
			case "9" : BestinPRF(); break;
			case "10" : BestinDBMS(); break;
			default : System.out.println("Enter Correct Option : ");
		}
	}
	
	
	//-----------------------Startpage-------------------------------	
	
	public static void Startpage(){
		Scanner input=new Scanner(System.in);
		Print("WELCOME TO GDSE MANAGEMENT SYSTEM");
		
		System.out.println("\n");
		System.out.println("[1] Add New Student\t\t\t\t\t[2]  Add New Student with Marks");
		System.out.println("[3] Add Marks\t\t\t\t\t\t[4]  Update Student Details");
		System.out.println("[5] Update Marks\t\t\t\t\t[6]  Delete Student");
		System.out.println("[7] Print Student Details\t\t\t\t[8]  Print Student Ranks");
		System.out.println("[9] Best in Programming Fundementals\t\t\t[10] Best in Database Management System");
		System.out.print("\nEnter an option to Continue > ");
		
	}
	
//----------------------Method 1 AddStudent----------------------------------	
	
	public static void AddStudent(){
		Scanner input=new Scanner(System.in);
		Print("ADD NEW STUDENT");
		
		L1:do{	System.out.print("\n\nEnter Student ID : ");
			String STID=input.nextLine();  // get student id
			Student temp=new Student();
			
			if(temp.SearchID(Array,STID)){
				System.out.print("\nThe Student ID alrady exists\n");
				L2:do{	System.out.print("Do you want to add Student ( Y/N )  ");
					String op=input.nextLine();
					if(op.equalsIgnoreCase("Y")){
						continue L1;
					}else if(op.equalsIgnoreCase("N")){
						break L1;
						
					}else{
						System.out.print("Plese Enter Valid Option! ");
						continue L2;
					}
				}while(true);
				
			}else{
				System.out.print("Enter Student Name : ");
				String StName=input.nextLine(); // get Student name
				temp.AddStudent(STID,StName);
				
				Student[] tempAr=new Student[Array.length+1];
				for (int i = 0; i < Array.length; i++){
					tempAr[i]=Array[i];
				}
				tempAr[tempAr.length-1]=temp;
				Array=tempAr;
				
				System.out.print("\nStudent has been added successfully. Do you want to add a new student (Y/N) : ");
				L3:do{ String YN=input.nextLine();
					char option=YN.charAt(0);
					if (option=='Y'){
						continue L1;
					}else if(option=='y'){
						continue L1;
					}else if(option=='N'){
						break L1;
					}else if(option=='n'){
						break L1;
					}else{
						System.out.print("Enter Valid Option!  Do you want to add a new student (Y/N) :  ");
							continue L3;
					}
				}while(true);
				
			}
		}while(true);
	}
	
	
//----------------------Method 2 AddStudent with Marks----------------------------------		

	public static void AddnewStudentwithMarks(){
		Scanner input=new Scanner(System.in);
		Print("ADD STUDENT WITH MARKS");
		
		L1:do{	System.out.print("\n\nEnter Student ID : ");
			String STID=input.nextLine();  // get student id
			Student temp=new Student();
			
			if(temp.SearchID(Array,STID)){
				System.out.print("\nThe Student ID alrady exists\n");
				L2:do{	System.out.print("Do you want to add Student ( Y/N )  ");
					String op=input.nextLine();
					if(op.equalsIgnoreCase("Y")){
						continue L1;
					}else if(op.equalsIgnoreCase("N")){
						break L1;
						
					}else{
						System.out.print("Plese Enter Valid Option! ");
						continue L2;
					}
				}while(true);
				
			}else{
				System.out.print("Enter Student Name : ");
				String StName=input.nextLine(); // get Student name
				int PRF,DBMS;
				L2:do{	System.out.print("\nEnter PRF Marks : "); // get PRF marks
					PRF=input.nextInt();
					if(PRF>100 || PRF<0){
						System.out.print("\nInvalid Marks. Please Enter Correct Marks : ");
						continue L2;
					}
					L3:do{	System.out.print("Enter DBMS Marks : "); // get DBMS marks
						DBMS=input.nextInt();
						input.nextLine();
						if(DBMS>100 || DBMS<0){
							System.out.print("\nInvalid Marks. Please Enter Correct Marks : \n");
							continue L3;
						}
						break L2;
					}while(true);
				}while(true);
	
				temp.AddStudentWithMarks(STID,StName,PRF,DBMS);
				
				Student[] tempAr=new Student[Array.length+1];
				for (int i = 0; i < Array.length; i++){
					tempAr[i]=Array[i];
				}
				tempAr[tempAr.length-1]=temp;
				Array=tempAr;
				
				System.out.print("\nStudent has been added successfully. Do you want to add a new student (Y/N) : ");
				L3:do{ String YN=input.nextLine();
					char option=YN.charAt(0);
					if (option=='Y'){
						continue L1;
					}else if(option=='y'){
						continue L1;
					}else if(option=='N'){
						break L1;
					}else if(option=='n'){
						break L1;
					}else{
						System.out.print("Enter Valid Option!  Do you want to add a new student (Y/N) :  ");
							continue L3;
					}
				}while(true);
				
			}
		}while(true);
	}




//------------------------------Method 3 Add Marks--------------------

	public static void AddMarks(){
		Scanner input=new Scanner(System.in);
		Print("ADD MARKS");
		L1: do{	System.out.print("\nEnter Student ID : ");
			String STID = input.nextLine();
			Student temp=new Student();
			
			if(temp.SearchID(Array,STID)==false){
				System.out.print("Invalid Student ID. Do you want to Search agin ( Y/N )  ");
				L2:do{	String op1=input.nextLine();
					if(op1.equalsIgnoreCase("Y")){
						continue L1;
					}else if(op1.equalsIgnoreCase("N")){
						break L1;
					}else{
						System.out.print("Enter Valid Option. Do you want to Search agin ( Y/N )  ");
						continue L2;
					}
				}while(true);
			}else{
				int index=temp.GetIndex(Array,STID);
				temp=Array[index];
				System.out.print("Student Name : "+temp.StName);
				
				if(temp.PRFMarks!=-1){
					System.out.print("\n\nThis student marks already added.\nIf you want to update the marks. please use [5] Update marks option.\n\nDo you want to add marks for another student? (Y/N) ");
						L3:do{	String op2=input.nextLine();
						if(op2.equalsIgnoreCase("Y")){
							continue L1;
						}else if(op2.equalsIgnoreCase("N")){
							break L1;
						}else{
							System.out.print("Enter Valid Option. Do you want to Search agin ( Y/N )  ");
							continue L3;
						}
					}while(true);
				}else{
					L5:do{	System.out.print("\n\nEnter PRF marks : ");
						int PRF=input.nextInt();
						if(PRF>100 || PRF<0){
							System.out.print("Invalid Marks. Please enter correct Marks.\n");
							continue L5;
						}else{
							temp.PRFMarks=PRF;
							break L5;
						}
					}while(true);
					
					L6:do{	System.out.print("Enter DBMS marks : ");
						int DBMS=input.nextInt();
						if(DBMS>100 || DBMS<0){
							System.out.print("Invalid Marks. Please enter correct Marks.\n\n");
							continue L6;
						}else{
							temp.DBMSMarks=DBMS;
							break L6;
						}
					}while(true);
					
					
					input.nextLine();
					System.out.print("Marks have been Added. do you want to add marks for another Student ( Y/N )  ");
					L4:do{	String op4=input.nextLine();
						if(op4.equalsIgnoreCase("Y")){
							continue L1;
						}else if(op4.equalsIgnoreCase("N")){
							break L1;
						}else{
							System.out.print("Enter Valid Option. do you want to add marks for another Student ( Y/N )  ");
							continue L4;
						}
					}while(true);
				}
			}
						
		}while(true);
		
	}		
		
		
//--------------------------method 4 - Update student details-----------------

		public static void UpdateStudentDetails(){
			Scanner input=new Scanner(System.in);
			Print("UPDATE STUDENT DETAILS");
			
			L1: do{	
				System.out.print("\nEnter Student ID : ");
				String STID = input.nextLine();
				Student temp=new Student();
				
				if(temp.SearchID(Array,STID)==false){
					System.out.print("Invalid Student ID. Do you want to Search agin ( Y/N )  ");
					L2:do{	String op1=input.nextLine();
						if(op1.equalsIgnoreCase("Y")){
							continue L1;
						}else if(op1.equalsIgnoreCase("N")){
							break L1;
						}else{
							System.out.print("Enter Valid Option. Do you want to Search agin ( Y/N )  ");
							continue L2;
						}
					}while(true);
				}else{
					int index=temp.GetIndex(Array,STID);
					temp=Array[index].GetAddress();
					temp.PrintStudentName();
					System.out.print("\n\nEnter new Student Name : ");
					String NewStName=input.nextLine();
					temp.UpdateStudentName(NewStName);
					System.out.print("\nStudent details has been update sucessfully.\nDo you want to update another student details ( Y/N ) ");
					L3:do{	String op1=input.nextLine();
						if(op1.equalsIgnoreCase("Y")){
							continue L1;
						}else if(op1.equalsIgnoreCase("N")){
							break L1;
						}else{
							System.out.print("\nEnter Valid Option. Do you want to update another student details ( Y/N )  ");
							continue L3;
						}
					}while(true);
					
				}
			
		}while(true);
	}
		
//----------------------------------Method 5 - Update marks------------------

	public static void UpdateMarks(){
		Scanner input=new Scanner(System.in);
		Print("UPDATE MARKS");
		L1: do{	
				System.out.print("\nEnter Student ID : ");
				String STID = input.nextLine();
				Student temp=new Student();
				
				if(temp.SearchID(Array,STID)==false){
					System.out.print("Invalid Student ID. Do you want to Search agin ( Y/N )  ");
					L2:do{	String op1=input.nextLine();
						if(op1.equalsIgnoreCase("Y")){
							continue L1;
						}else if(op1.equalsIgnoreCase("N")){
							break L1;
						}else{
							System.out.print("Enter Valid Option. Do you want to Search agin ( Y/N )  ");
							continue L2;
						}
					}while(true);
				}else{
					int index=temp.GetIndex(Array,STID);
					temp=Array[index];
					if(temp.PRFMarks==-1){
						System.out.print("This Student Marks yet to be added.\nDo you want to update marks for another Student (Y/N) ");
						L3:do{
							String op1=input.nextLine();
							if(op1.equalsIgnoreCase("Y")){
								continue L1;
							}else if(op1.equalsIgnoreCase("N")){
								break L1;
							}else{
								System.out.print("Enter Valid Option. Do you want to Search agin ( Y/N )  ");
								continue L3;
							}
						}while(true);
					}else{
						temp.PrintStudentDetails();
						temp.PrintStudentMarks();
						L4:do{	
							System.out.print("\nEnter New PRF Marks : ");
							int PRF=input.nextInt();
							if(PRF>100 || PRF<0 ){
								System.out.print("\nInvalid Marks. Please Enter Correct Marks. \n");
								continue L4;
							}else{
								temp.PRFMarks=PRF;
								break L4;
							}
						}while(true);
						L5:do{	
							System.out.print("Enter New DBMS Marks : ");
							int DBMS=input.nextInt();
							input.nextLine();
							if(DBMS>100 || DBMS<0 ){
								System.out.print("\nInvalid Marks. Please Enter Correct Marks. \n");
								continue L5;
							}else{
								temp.DBMSMarks=DBMS;
								System.out.print("\nMarks have been updated Successfully.\nDo you want to update marks for another Student ( Y/N )  ");
								L6:do{
									String op1=input.nextLine();
									if(op1.equalsIgnoreCase("Y")){
										continue L6;
									}else if(op1.equalsIgnoreCase("N")){
										break L1;
									}else{
										System.out.print("Enter Valid Option. Do you want to update marks for another Student ( Y/N )  ");
										continue L6;
									}
								}while(true);
							}
						}while(true);
					}
					
				}
			}while(true);
		
	}
	
	
//--------------------------------------- Method 6 - Delete Student -------------------		
		
		public static void DeleteStudent(){
			Scanner input=new Scanner(System.in);
			Print("DELETE STUDENT");
			L1: do{	
				System.out.print("\nEnter Student ID : ");
				String STID = input.nextLine();
				Student temp=new Student();
				
				if(temp.SearchID(Array,STID)==false){
					System.out.print("Invalid Student ID. Do you want to Search agin ( Y/N )  ");
					L2:do{	String op1=input.nextLine();
						if(op1.equalsIgnoreCase("Y")){
							continue L1;
						}else if(op1.equalsIgnoreCase("N")){
							break L1;
						}else{
							System.out.print("Enter Valid Option. Do you want to Search agin ( Y/N )  ");
							continue L2;
						}
					}while(true);
				}else{
					int index=temp.GetIndex(Array,STID);
					temp=Array[index];
					System.out.println();
					temp.PrintStudentDetails();
					L3:do{
						System.out.print("\nDo you want to Delete this Student ( Y/N ) ");
						String op1=input.nextLine();
						if(op1.equalsIgnoreCase("Y")){
							Student[] tempAr=new Student[Array.length-1];
							for (int i = 0; i <index ; i++){
								tempAr[i]=Array[i];
							}
							for (int i = index; i <tempAr.length ; i++){
								tempAr[i]=Array[i+1];
							}
							Array=tempAr;
							
							System.out.print("\nStudent has been delete successfully.\nDo you want to delete another Student ( Y/N ) ");
							L4:do{	
								String op2=input.nextLine();
								if(op2.equalsIgnoreCase("Y")){
									continue L1;
								}else if(op2.equalsIgnoreCase("N")){
									break L1;
								}else{
									System.out.print("Enter Valid Option. Do you want to delete another Student ( Y/N ) ");
									continue L4;
								}
							}while(true);
							
						}else if(op1.equalsIgnoreCase("N")){
							break L1;
						}else{
							System.out.print("Enter Valid Option.\n");
							continue L3;
						}
					}while(true);
				}
			}while(true);
			
		}
		
	
//----------------------------Method 7 Print Student Details-----------------	

	public static void PrintSTDetails(){
		Scanner input=new Scanner(System.in);
			Print("PRINT STUDENT DETAILS");
			L1: do{	
				System.out.print("\nEnter Student ID : ");
				String STID = input.nextLine();
				Student temp=new Student();
				
				if(temp.SearchID(Array,STID)==false){
					System.out.print("Invalid Student ID. Do you want to Search agin ( Y/N )  ");
					L2:do{	String op1=input.nextLine();
						if(op1.equalsIgnoreCase("Y")){
							continue L1;
						}else if(op1.equalsIgnoreCase("N")){
							break L1;
						}else{
							System.out.print("Enter Valid Option. Do you want to Search agin ( Y/N )  ");
							continue L2;
						}
					}while(true);
				}else{
					int index=temp.GetIndex(Array,STID);
					temp=Array[index];
					System.out.println();
					temp.PrintStudentDetails();
					if(temp.SearchMarksAdded()==false){
						System.out.print("\n\nMarks yet to be added.\nDo you want to Search agin ( Y/N )  ");
						L3:do{	
							String op1=input.nextLine();
							if(op1.equalsIgnoreCase("Y")){
								continue L1;
							}else if(op1.equalsIgnoreCase("N")){
								break L1;
							}else{
								System.out.print("Enter Valid Option. Do you want to Search agin ( Y/N )  ");
								continue L3;
							}
						}while(true);
					}else{
						temp.PrintStudentMarks();
						temp.CalMarks();
						temp.PrintStudentSUBMarks();
						temp.SortMarks(Array);
						index=temp.GetIndex(Array,STID);
						System.out.print("Rank 		: "+(Array.length-index));
						System.out.print(Array.length-index==1? "  ( First )" : Array.length-index==2? "  ( Second )" : Array.length-index==3? "  ( Third )" : "");
						
						System.out.print("\n\nDo you want to Search agin ( Y/N )  ");
						L4:do{	String op1=input.nextLine();
							if(op1.equalsIgnoreCase("Y")){
								continue L1;
							}else if(op1.equalsIgnoreCase("N")){
								break L1;
							}else{
								System.out.print("Enter Valid Option. Do you want to Search agin ( Y/N )  ");
								continue L4;
							}
						}while(true);
					}
				}
			}while(true);
		
	}

//------------------------Method 8 - Print Student Ranks---------------

	public static void PrintSTRanks(){
		Scanner input=new Scanner(System.in);
		Print("PRINT STUEDNTS' RANK");
		Student temp=new Student();
		temp.SortMarks(Array);
		System.out.print("\n\n|Rank|\t\t"+"|ID|\t\t"+"|Name|\t\t"+"|Total Marks|\t\t"+"|Average Marks|\n");
		for (int i = Array.length-1,j=1; i >= 0; i--,j++){
			if(Array[i].PRFMarks==-1){
				break;
			}else{
				System.out.println(j+"\t\t"+Array[i].StId+"\t\t"+Array[i].StName+"\t\t\t"+Array[i].TotalMarks+"\t\t\t"+Array[i].AvgMarks);
			}	
		}
		do{
			System.out.print("\nDo you want to go back main menu ( Y/N ) ");
			String op=input.nextLine();
			if(op.equalsIgnoreCase("Y")){
				break;
			}else{
				continue;
			}
		}while(true);
		
	}
	
	
//-----------------------------	Method 9 - Best in Programming Fundemental-------------------

	public static void BestinPRF(){
		Scanner input=new Scanner(System.in);
		Print("BEST IN PROGRAMMING FUNDEMENTALS");
		Student temp=new Student();
		System.out.print("\n\n|ID|\t\t"+"|Name|\t\t"+"|PRF Marks|\t\t|"+"DBMS Marks|\n");
		temp.SortMarksPRF(Array);
		for (int i = Array.length-1; i >=0 ; i--){
			if(Array[i].PRFMarks==-1){
				break;
			}else{
				System.out.println(" "+Array[i].StId+"\t\t    "+Array[i].StName+"\t\t  "+Array[i].PRFMarks+"\t\t\t   "+Array[i].DBMSMarks);
			}
		}
		do{
			System.out.print("\nDo you want to go back main menu ( Y/N ) ");
			String op=input.nextLine();
			if(op.equalsIgnoreCase("Y")){
				break;
			}else{
				continue;
			}
		}while(true);
		
	}
	
	
//-----------------------------	Method 10 - Best in Database Managment System-------------------

	public static void BestinDBMS(){
		Scanner input=new Scanner(System.in);
		Print("BEST IN DATABASE MANAGEMENT SYSTEM");
		Student temp=new Student();
		System.out.print("\n\n|ID|\t\t"+"|Name|\t\t"+"|DBMS Marks|\t\t|"+"PRF Marks|\n");
		temp.SortMarksDBMS(Array);
		for (int i = Array.length-1; i >=0 ; i--){
			if(Array[i].DBMSMarks==-1){
				break;
			}else{
				System.out.println(" "+Array[i].StId+"\t\t    "+Array[i].StName+"\t\t  "+Array[i].DBMSMarks+"\t\t\t   "+Array[i].PRFMarks);
			}
		}
		do{
			System.out.print("\nDo you want to go back main menu ( Y/N ) ");
			String op=input.nextLine();
			if(op.equalsIgnoreCase("Y")){
				break;
			}else{
				continue;
			}
		}while(true);
		
	}	
		
	
//-------------------------Console Clear-----------------------------	
	
	public final static void clearConsole() { 
		try {
			final String os = System.getProperty("os.name"); 
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J"); 
				System.out.flush();
			}
		}catch (final Exception e) {
			e.printStackTrace();
		}
	}

	
	
//--------------------------PAGE VIEW-----------

		public static void Print(String text){
			clearConsole();
		Scanner input=new Scanner(System.in);
		for (int i = 0; i < 100; i++){
			System.out.print("-");
		}
		System.out.print("\n\t\t|\t\t"+text+"\t\t|\n");
		for (int i = 0; i < 100; i++){
			System.out.print("-");
		}
	}


	

}
