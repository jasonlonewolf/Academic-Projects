import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;

public class Libraries {

	public Library[] libraries;        // a collection of libraries of type array
	public int numberOfLibraries;      // number of libraries in collection



	public Library buildLibraryFromFile(String libraryName, String fileName) {

		Library library = new Library(libraryName);

		String path = System.getProperty("user.dir");
		Book book = null;
		String s;

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			// try (BufferedReader br = new BufferedReader(new FileReader("./Root/" + fileName))) {
			// if you run locally on your environment use: new FileReader(path + "/src/" + fileName)
			library.libraryName = libraryName;
			//System.out.println(library.libraryName);

			while ((s = br.readLine()) != null) {

				try{
					String[] tok = s.split(",");
					book = new Book(tok[0],Integer.valueOf(tok[1]));
					book.library = library;
					library.books.add(book);


				}catch(Exception e){
					System.out.println("[01]"+e.getMessage());

				}

			}
		} catch (IOException e) {
			System.out.println("[02]"+e.getMessage());
		}
		return library;
	}

	public Library isThereBookInLibraries(Book book) {

		//System.out.println(this.numberOfLibraries);
		for(int i=0; i < this.numberOfLibraries;i++){
			try{  

				for (Book o : this.libraries[i].books) {
					if(book.equals(o)){

						return this.libraries[i];
					}
				}

			}catch(Exception e){
				System.out.println("e" + e.getMessage());
			}
		}


		return null;	
	}


	public Library rentBookAvailable(Book book, String requestDate, String dueDate) {

		Library foundLibrary = null;

		for(int i=0; i < this.numberOfLibraries;i++){

			for(Book o : libraries[i].books)
			{
				if(book.equals(o) 
						&& !(libraries[i].books.elementAt(libraries[i].books.indexOf(o)).isRented(libraries[i])) )
				{

					return libraries[i];
				}
			}

		}

		return foundLibrary;

	}


	@Override
	public boolean equals(Object o) {

		if (o == this){
			return true;
		}

		if (o == null){
			return false;
		}

		if (o instanceof Libraries){
			Libraries other = (Libraries)o;			
			return  (other.libraries.equals(this.libraries))&&(this.numberOfLibraries == other.numberOfLibraries);
		}else{
			return false;
		}
	}

	@Override
	public int hashCode() {
		return this.numberOfLibraries;
	}
	

	@Override
	public String toString() {
		
		String s = "";
		if(this.libraries!= null){
			Library lib[] = this.libraries.clone();
			for(int i= 0;i<this.numberOfLibraries;i++){
				if(lib[i]!=null){
					s = s + "Library = "+lib[i]; 
							
				}
			} 

		}
		return s;
	}






}



