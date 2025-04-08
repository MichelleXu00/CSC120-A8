/* This is a stub for the Library class */
import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements{

  //Attributes
  private Hashtable<String, Boolean> collection;
  
  //Constructor
  public Library(String name, String address, int nFloors) {
    super(name,address,nFloors);
    System.out.println("You have built a library: 📖");
    this.collection = new Hashtable<>();
  }
  
  /**
   * add a book to the collection
   * @param title title of the book
   */
  public void addTitle(String title) {
    this.collection.put(title,true);
  }

  /**
   * remove a book from the collection
   * @param title title of the book
   * @return title of the book being removed
   */
  public String removeTitle(String title) {
    this.collection.remove(title,false);
    return title;
  }

  /**
   * check out a book if it is available
   * @param title title of the book needed to be checked out
   */
  public void checkOut(String title) {
    if (this.collection.containsKey(title) && this.collection.get(title)== true) {
      removeTitle(title);
    }
  }

  /**
   * return a book if it is not available
   * @param title title of the book needed to be returned
   */
  public void returnBook(String title) {
    if (this.collection.containsKey(title) && this.collection.get(title) == false) {
      addTitle(title);
    }
  }

  /**
   * returns true if the title appears as a key in the Libary's collection, false otherwise
   * @param title title of the book
   * @return T/F
   */
  public boolean containsTitle(String title) {
    if (this.collection.containsKey(title)) {
      return true;
    }
    return false;
  }  
  
  /**
   * returns true if the title is currently available, false otherwise
   * @param title title of the book
   * @return T/F
   */
  public boolean isAvailable(String title) {
    if (this.collection.get(title) == true) {
      return true;
    }
    return false;
  }
  
  /**
   * prints out the entire collection in an easy-to-read way (including checkout status)
   */
  public void printCollection() {
    System.out.println(this.collection);
  }

  /**
   * show the options of methods of this subclass
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook \n + containsTitle() \n + isAvailable \n + printCollection()");
  }

  /**
   * move between non-adjacent floors in a single action via elevator
   * @param floorNum the floor to go to
   */
  public void goToFloor(int floorNum) {
    super.goToFloor(floorNum);
  }

  public static void main(String[] args) {
    Library Neilson = new Library("Neilson", "7 Neilson Drive",5);
    Neilson.showOptions();
    Neilson.enter();
    Neilson.goToFloor(4);
    }
  }