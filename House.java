import java.util.ArrayList;

public class House extends Building implements HouseRequirements{
  
  //Attributes
  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElevator;

  //Constructor
  public House(String name, String address, int nFloors, boolean hasDR, boolean hasE) {
    super(name,address,nFloors);
    System.out.println("You have built a house: 🏠");
    this.residents = new ArrayList<>();
    this.hasDiningRoom = hasDR;
    this.hasElevator = hasE;
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
   */
  public void moveIn(Student s) {
    this.residents.add(s);
  }

  /**
   * remove a student from the house
   * @param s student needed to be moved out
   * @return the student who moved out
   */
  public Student moveOut(Student s) {// return the Student who moved out
    this.residents.remove(s);
    return s;
  }

  /**
   * return whether the student is a resident of the house
   * @param s student who is asked about
   * @return T/F
   */
  public boolean isResident(Student s) {
    if (this.residents.contains(s)) {
      return true;
    }
    return false;
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
    }
    super.goToFloor(floorNum);
  }

  public static void main(String[] args) {
    House Washburn = new House("Washburn", "4 Seelye Drive", 3,false,false);
    Washburn.showOptions();
    Washburn.goToFloor(3);
  }
}