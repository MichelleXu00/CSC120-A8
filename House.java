import java.util.ArrayList;

public class House extends Building implements HouseRequirements{
  
  //Attributes
  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElevator;

  private ArrayList<Student> newStudents; //a list of freshmen and trasfer students
  private int yearBuilt; //the year in which the house is built
  
    /**
     * Constructor
     * @param name the name of the house
     * @param address the location of the house
     * @param nFloors the number of floors in the house
     * @param hasDR whether the house has a dining room
     * @param hasE whether the house has an elevator
     */
    public House(String name, String address, int nFloors, boolean hasDR, boolean hasE) {
      super(name,address,nFloors);
      System.out.println("You have built a house: 🏠");
      this.residents = new ArrayList<>();
      this.hasDiningRoom = hasDR;
      this.hasElevator = hasE;
    }
  
    /**
     * overloaded constructor
     * @param name the name of the house
     * @param address the location of the house
     * @param nFloors the number of floors in the house
     * @param hasDR whether the house has a dining room
     * @param hasE whether the house has an elevator
     * @param yearB the year in which the house was built
     */
    public House(String name, String address, int nFloors, boolean hasDR, boolean hasE, int yearB) {
      super(name,address,nFloors);
      System.out.println("You have built a house: 🏠");
      this.residents = new ArrayList<>();
      this.hasDiningRoom = hasDR;
      this.hasElevator = hasE;
      this.yearBuilt = yearB;
  }

  /**
   * return whether the house has dining room
   * @return T/F
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * return the number of residents in the house
   * @return number of residents
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * add a student to the house
   * can be overload with collection (arraylist of student)
   * @param s student moving in
   */
  public void moveIn(Student s) {
    this.residents.add(s);
  }

  /**
   * overloaded method for move a list of new students into the house
   * @param newStudents a list of newcoming freshmen and transfer students to be moved into this house
   */
  public void moveIn() {
    this.residents.addAll(newStudents);
  }

  /**
   * remove a student from the house
   * @param s student needed to be moved out
   * @return the student who moved out
   */
  public Student moveOut(Student s) {// return the Student who moved out
    if (!residents.contains(s)) {
      throw new RuntimeException(s + "is not a resident here!");
    } this.residents.remove(s);
    return s;
  }

  /**
   * return whether the student is a resident of the house
   * @param s student who is asked about
   * @return T/F
   */
  public boolean isResident(Student s) {
    return this.residents.contains(s);
  }

  /**
   * show the options of methods of this subclass
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + moveIn() \n + moveOut() \n + isResidents()");
  }

  /**
   * move between non-adjacent floors in a single action via elevator
   * @param floorNum the floor to go to
   */
  public void goToFloor(int floorNum) {
    if (hasElevator == false) {
      throw new RuntimeException("This house does not have an elevator.");
    } super.goToFloor(floorNum);
  }

  public static void main(String[] args) {
    House washburn = new House("Washburn", "4 Seelye Drive", 3,false,false);
    washburn.showOptions();
    washburn.goToFloor(3);
  }
}