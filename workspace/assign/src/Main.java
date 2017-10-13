import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

public class Main {

	static int howManyBooksInLibraries(Libraries libs,Book book) {
		int numberOfLibraries = 0;
		//System.out.println(this.numberOfLibraries);
		for(int i=0; i < libs.numberOfLibraries;i++){

			for (Book o : libs.libraries[i].books) {
				if(book.equals(o)){

					numberOfLibraries++;
				}
			}

		}
		return numberOfLibraries;
	}

	public static Libraries task1(Libraries pls){

		pls.numberOfLibraries = 2;
		pls.libraries = new Library[pls.numberOfLibraries];
		pls.libraries[0] = pls.buildLibraryFromFile("Seneca@York", "YorkLibrary.txt");
		pls.libraries[1] = pls.buildLibraryFromFile("Newham", "NewhamLibrary.txt");

		System.out.println(pls);
		//System.out.println(pls.libraries[0]);
		//System.out.println(pls.libraries[1]);
		

	//	for(int i=0;i<pls.numberOfLibraries;i++){
			
//			System.out.println("Library = " + pls.libraries[i]);
//			System.out.println("[");
//
//			for (Book o : pls.libraries[i].books) {
//				System.out.println(o);
//			}
//			System.out.println("]");

		//}

		return pls;	
	}


	public static void task2(Libraries pls){

		Book book = new Book("C++", 20);

		System.out.println("Trying to find the book, " + book);

		Library lib = pls.isThereBookInLibraries(book);

		if (lib == null)
			System.out.println(Helper.printNonexistent(book));
		
	}
	
	public static Libraries task3(Libraries pls){

		Book book;
		Library lib;
		book = new Book("Database System Concepts",45);
		//Library libNo = new Library("Seneca@York");
		//book.library = libNo;

		String requestDate = Helper.getCurrentDate();
		String dueDate = "04/15/2017";;

		// try to rent book
		System.out.println("Trying to rent the book, "+ book.bookName() + " from " +   requestDate + " to " + dueDate +" at any library");
		System.out.println();
		lib = pls.rentBookAvailable(book, requestDate, dueDate);

		if(lib != null)
		{
			// rent successful			
			System.out.println(book.bookName() + " exists at " + lib.libraryName);
			
			System.out.println("trying to rent the book, " + book.bookName() + " at "+ lib.libraryName);
			System.out.println();
			if(lib.rentRequest(book, requestDate, dueDate)){
				
				System.out.println(Helper.printAvailable(book, requestDate, lib));
				System.out.println("Renting the book, "+ book.bookName() +" at " + lib.libraryName);
				book.rentBook(requestDate, dueDate, lib);

				System.out.println(book.bookName() + " is rented at " + lib.libraryName);
				
			}else {
				System.out.println(Helper.printUnavailable(book, requestDate));        
				System.out.println("the book," + book.bookName() + "is already rented");
			}

			System.out.println();
			
			System.out.println("trying to rent the book, " + book.bookName() + " at "+ lib.libraryName);

			if(lib.rentRequest(book, requestDate, dueDate)){	

				System.out.println(Helper.printAvailable(book, requestDate, lib));
				System.out.println("Renting the book, "+ book +" at " + lib.libraryName);
				book.rentBook(requestDate, dueDate, lib);
				System.out.println(book.bookName() + " is rented at " + lib.libraryName);
				
			}else {
				System.out.println(Helper.printUnavailable(book, requestDate));        
				System.out.println("the book," + book.bookName() + " is already rented");
			}

			System.out.println();

			// return the book so it can be rented again
			System.out.println("Retunring the book," + book.bookName());
			book.returnBook(lib);
			System.out.println("the book, "+ book.bookName()+" returned");

			System.out.println();

			System.out.println("trying to rent the book, " + book.bookName() + " at "+ lib.libraryName);

			if(lib.rentRequest(book, requestDate, dueDate)){	

				System.out.println(Helper.printAvailable(book, requestDate, lib));
				System.out.println("Renting the book, "+ book +" at " + lib.libraryName);
				book.rentBook(requestDate, dueDate, lib);
				System.out.println(book.bookName() + " is rented at " + lib.libraryName);
				
			}else {
				System.out.println(Helper.printUnavailable(book, requestDate));        
				System.out.println("the book," + book.bookName() + " is already rented");
			}


			System.out.println();

		}
		else
			System.out.println(Helper.printUnavailable(book, requestDate));        

		return pls;
	}
	
	
	// tostring if you can find a library, rent the book at that library.
	//print library object througg tostring
	public static Libraries task4(Libraries pls){



		Book book = new Book("Database System Concepts",45);

		System.out.println("Finding a library found the book "+book.bookName());

		Library lib = pls.isThereBookInLibraries(book);

		if (lib == null){
			System.out.println(Helper.printNonexistent(book));

		}else{
			System.out.println(lib.libraryName + "is the first library the book, "+book.bookName()+" found");
		}
		
		System.out.println();
		
		lib = null;
		
		System.out.println("Checking availablity the book, "+book.bookName()+" any library");
		
		for(int i= 0;i<pls.numberOfLibraries;i++){

			int bookcnt = 0;
			
			for(Book o : pls.libraries[i].books){
			
				if(o.equals(book)){
					bookcnt ++;		
				}
					
			}
			
			if(bookcnt == 0){
				System.out.println("the book, "+book.bookName()+" do not exist at " + pls.libraries[i].libraryName);	
			}else {
				System.out.println("the book, "+book.bookName()+" exist at " + pls.libraries[i].libraryName);	
				
			}	
			
			
			bookcnt = 0;
		
			
			for(Book o : pls.libraries[i].books){
				
				if(o.equals(book)){		
				//the book exist in library	
					if(o.isRented(pls.libraries[i])){
						System.out.println(Helper.printUnavailable(book, Helper.getCurrentDate())
								+" at " + pls.libraries[i].libraryName);
					}else{
						System.out.println(Helper.printAvailable(book, Helper.getCurrentDate(), pls.libraries[i]));
					}
					
				}
					
			}
			
			
		}




		return pls;	
	}
	public static Libraries task5(Libraries pls){


		for(int i= 0;i<pls.numberOfLibraries;i++){
			System.out.println("Library : "+pls.libraries[i].libraryName + "  greatest value tag : "+pls.libraries[i].findMaximumValueTag());
		}

		return pls;	
	}
	
	public static Libraries task6(Libraries pls){

		Book book = new Book("Database System Concepts",45);

		for(int i= 0;i<pls.numberOfLibraries;i++){
			System.out.println("=========================");
			if(book.isRented(pls.libraries[i])){
				System.out.println("Library : "+pls.libraries[i].libraryName + " the book " + book + " is borrowed");	
				
			}else{
				System.out.println("Library : "+pls.libraries[i].libraryName + " the book " + book + " is available");			
			}

			
			
			for(Book o : pls.libraries[i].books){
				try{
					if(book.equals(o)){
						
						if(o.isBookOverdue())
						{
							System.out.println(book + " is overdue");
						}
						else{
							System.out.println(book + " is not overdue");

						}
					}
					
				}catch(Exception x){

				System.out.println("overdue exception:"+x.getMessage());

				}
			}

			System.out.println("=========================");		
		}	
		
		System.out.println();
		System.out.println("Insert overdue data to Newham libarary");
		String requestDate2 = "03/10/2017";
		String dueDate2 = "03/22/2017";
		Library lib2 = pls.libraries[1];
		Book book2 = new Book("Database System Concepts",45);
		book2.rentBook(requestDate2, dueDate2, lib2);
		System.out.println("Inserted data:"+ book2 + ", rent date " + requestDate2 + " return date: "+dueDate2);
		System.out.println();
		
		
		
		for(int i= 0;i<pls.numberOfLibraries;i++){
			System.out.println("=========================");
			if(book.isRented(pls.libraries[i])){
				System.out.println("Library : "+pls.libraries[i].libraryName + " the book " + book + " is borrowed");	
				
			}else{
				System.out.println("Library : "+pls.libraries[i].libraryName + " the book " + book + " is available");			
			}

			
			
			for(Book o : pls.libraries[i].books){
				try{
					if(book.equals(o)){
						
						if(o.isBookOverdue())
						{
							System.out.println(book + " is overdue");
						}
						else{
							System.out.println(book + " is not overdue");

						}
					}
					
				}catch(Exception x){

				System.out.println("overdue exception:"+x.getMessage());
				System.out.println("not overdue");


				}
			}

			System.out.println("=========================");		
		}	
		
		
		if(howManyBooksInLibraries(pls,book) > 1){
			System.out.println( "number of libraries book found: "+ howManyBooksInLibraries(pls,book));		
		} else System.out.println("libraries book found: "+ howManyBooksInLibraries(pls,book));


		return pls;	
	}
	
	public static Libraries task7(Libraries pls){



		return pls;	
	}
	
	
	
	

	public static void main(String[] args) {


		/* TASK 1 - build libraries from files - at least two libraries */

		System.out.println("\n\n *" + " TASK 1 " + "*");
		//Libraries ls = new Libraries(/* your number of libraries */);
		Libraries libs = new Libraries();
		libs = task1(libs);



		/* TASK 2 - ask for a book that is not in any library inventory */

		System.out.println("\n\n *" + " TASK 2 " + "*");
		

		task2(libs);
		

		/* TASK 3 - ask for a book that is in a library inventory
		 *  issue a rent request and print the bookEssentials of Database Management
		 *  issue the same rent request and print the book
		 *  return the book
		 *  issue the rent request with new dates and print the book
		 */
		System.out.println("\n\n *" + " TASK 3 " + "*");

		libs = task3(libs);



		/* TASK 4 - ask for the same book in all libraries
		 */
		System.out.println("\n\n *" + " TASK 4 " + "*");
		libs = task4(libs);
		
		/* TASK 5 - calculate maximum value tag for each library */
		System.out.println("\n\n *" + " TASK 5 " + "*");

		libs = task5(libs);

		/* TASK 6 - inquire about a book - it is available? when does it become available, etc.
		 * - inquire about a book: 
		 * is it borrowed?, is it overdue?, 
		 * could it be found in more than one library?, 
		 * when can it be borrowed? */
		System.out.println("\n\n *" + " TASK 6 " + "*");
		libs = task6(libs);


	}
}
