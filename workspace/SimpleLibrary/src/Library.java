import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class Library implements MaxTagValue {


	String       libraryName;
	Vector<Book> books;
	LinkedList<Book> lbooks;

	public Library(String libraryName) {
		this.libraryName = libraryName;
		books = new Vector<Book>();
		lbooks = new LinkedList<Book>();

	}

	public int findMaximumValueTag() {

		int maxElement = -100;
		for(Book o:this.books){
			if(o.valueTag > maxElement) maxElement = o.valueTag; 
		}
		return maxElement;
	}

	public boolean rentRequest(Book wanted, String requestDate, String dueDate) {

		try {
			Helper.checkDate(requestDate);
			Helper.checkDate(dueDate);
			for(Book book: this.books){
				if( (wanted.equals(book) && (books.elementAt(books.indexOf(book)).isRented(this))))
					return false;

			}
		} catch (DateFormatException e) {
			System.out.println(wanted + e.getMessage());
			return false;
		}
		return true;
	}


	@Override
	public boolean equals(Object o) {

		if (o == this){
			return true;
		}

		if (o == null){
			return false;
		}

		if (o instanceof Library){
			Library other = (Library)o;			
			return  (other.libraryName.equals(this.libraryName))&&(this.books == other.books);
		}else{
			return false;
		}
	}

	@Override
	public int hashCode() {
		return books.size();
	}

	@Override
	public String toString() {
		String s = this.libraryName;

		if(this.libraryName!= null){
	        s = s + "\n[\n";

			for(Book o : books){
				s = s + o + "\n"; 
			}

		}
          s = s +"]\n";
		return s;
	}

}
