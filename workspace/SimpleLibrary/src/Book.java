import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

/**
 * The Book class implements ...
 *
 * @author  ....
 */
class Book {

	String       bookName;    // the book name
	int          valueTag;    // an integer between -100 and 100
	Library      library;     // the library having this book it its inventory
	RentSettings rs;          // rent settings


	public Book(String bookName, int valueTag) {
		this.bookName = bookName;
		this.valueTag = valueTag;


	}


	// set the rent dates; if dates are not valid catch DateFormatException and return false,
	// if rentDate > dueDate catch RentPeriodException and return false
	// if one the exceptions occur there is no RentSettings object
	public boolean rentBook(String rentDate, String dueDate, Library library) {


		try
		{
			RentSettings rs = new RentSettings(rentDate, dueDate, library);

			for(Book b:library.books){
				if(b.equals(this)){
					library.books.elementAt(library.books.indexOf(b)).setRs(rs);
					return true;

				}
			}
			return false;

		}
		catch(DateFormatException exc)
		{
			System.out.println("DateFormatException when trying to rent book.");
			return false;
		}
		catch(RentPeriodException exc)
		{
			System.out.println("RentPriodException when trying to rent book.");
			return false;
		}
	}

	// destroy the RentSettings object for this book
	public void returnBook(Library library) {
		try{
			if(this.library.equals(library))
			{
				for(Book b:library.books)
					if(b.equals(this))
						library.books.elementAt(library.books.indexOf(b)).setRs(null);

			}
		}catch(Exception e){
			System.err.println("returnBook:" + e.getMessage());	
		}

	}

	// return the date when this book is available
	public String availableDate(Library library) {
		return "";
	}

	// returns true if the current date is greater than the due date
	public boolean isBookOverdue() throws DateFormatException  {

		String curDate = Helper.getCurrentDate();
		boolean overdue = false;

		try
		{
			overdue = (Helper.timeDifference(curDate, rs.dueDate) < 0);
		}
		catch(DateFormatException exc)
		{
			System.out.println("DateFormatException when checking for overdue the book.");
		}

		return overdue;	
	}

	public boolean isRented(Library lib) {

		if(lib!= null){

			for(Book b:lib.books)
				if(b.equals(this)){
					try{
						if(lib.books.elementAt(lib.books.indexOf(b)).rs.borrowed)
							return true;
					}catch(Exception e){
						return false;


					}
				}
		}

		return false;
	}

	public RentSettings getRs() {
		//RentSettings rs = null;
		return rs;
	}

	public void setRs(RentSettings rs) {

		this.rs = rs;


	}

	@Override
	public boolean equals(Object o) {

		if (o == this){
			return true;
		}

		if (o == null){
			return false;
		}

		if (o instanceof Book){
			Book other = (Book)o;			
			return  (other.bookName.equals(this.bookName))&&(this.valueTag == other.valueTag);
		}else{
			return false;
		}
	}

	@Override
	public int hashCode() {
		return this.valueTag;
	}

	@Override
	public String toString() {
		String s = this.bookName();

		if(this.library!= null){
			s= "("+ s + " => " + this.library.libraryName +")"; 
		} 
		else {
			s = "("+ s + ")";
					}
		return s;
	}

	public String bookName() {
		return bookName + "," + valueTag;
	}

	private class RentSettings {

		private String rentDate;          // date when the item is requested
		private String dueDate;           // date when the item must be returned
		private boolean borrowed = false; // true if the item is rented

		//default ctr
		private RentSettings() throws DateFormatException {



		}

		// private ctr must throw DateFormatException and RentPeriodException
		private RentSettings(String rentDate, String dueDate, Library library)
				throws DateFormatException, RentPeriodException {
			if(library != null){
				if(Helper.isValidDate(rentDate)&&Helper.isValidDate(dueDate)){
					if(Helper.timeDifference(rentDate, dueDate)> 0){
						if(!this.borrowed){

							this.rentDate =  rentDate;
							this.dueDate =  dueDate;
							Book.this.library = library;
							this.borrowed = true;
						}

					}else throw new RentPeriodException();



				}else throw new DateFormatException();




			}
		}
	}

}
