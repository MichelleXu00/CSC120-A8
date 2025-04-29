/* This is a stub for the Cafe class */
public class Cafe extends Building{

    //Attributes
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    private double nCounces; // The number of ounces of coffee remaining in inventory
    private double sugar; // The number of ounces of sugar remaining in inventory

    /**
     * Constructor
     * @param name the name of the cafe
     * @param address the location of the cafe
     * @param nFloors the number of floors in the cafe
     */
    public Cafe(String name, String address, int nFloors) {
        super(name,address,nFloors);
        System.out.println("You have built a cafe: ☕");
        this.nCoffeeOunces = 300;
        this.nSugarPackets = 100;
        this.nCreams = 50;
        this.nCups = 60;
    }
    
    /**
     * sell a cup of coffee and the inventory should decrease in each category according to the given parameters
     * @param size The number of ounces of coffee used in the cup of coffe
     * @param nSugarPackets The number of sugar packets used in the cup of coffe
     * @param nCreams The number of "splashes" of cream used in the cup of coffe
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 0) {
            restock(300, 100, 50, 60);
        } this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }

    /**
     * overloaded method of sellCoffee()
     * @param size The number of ounces of coffee used in the cup of coffe
     * @param sugar The number of ounces of sugar used in the cup of coffe
     * @param nCreams The number of "splashes" of cream used in the cup of coffe
     */
    public void sellCoffee(double size, double sugar, int nCreams) {
        if (this.nCounces < size || this.sugar < sugar || this.nCreams < nCreams || this.nCups < 0) {
            restock(300, 100, 50, 60);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }

    /**
     * restock when the inventory is out of stock
     * @param nCoffeeOunces The number of ounces of coffee to restock
     * @param nSugarPackets The number of sugar packets to restock
     * @param nCreams The number of "splashes" of cream to restock
     * @param nCups The number of cups to restock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /**
     * overloaded method of restock()
     * @param nCounces The number of ounces of coffee to restock
     * @param sugar The number of ounces of sugar to restock
     * @param nCreams The number of "splashes" of cream to restock
     * @param nCups The number of cups to restock
     */
    private void restock(double nCounces, double sugar, int nCreams, int nCups) {
        this.nCounces = nCounces;
        this.sugar = sugar;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /**
    * show the options of methods of this subclass
    */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + sellCoffee() \n + restock()");
      }    
    
    /**
    * error message
    * @param floorNum the floor to go to
    */
    public void goToFloor(int floorNum) {
        throw new RuntimeException("There is only one floor in the cafe");
    }

    public static void main(String[] args) {
        Cafe campusCafe = new Cafe("Campus Center Cafe","1 Chapin Way",1);
        campusCafe.showOptions();
        campusCafe.sellCoffee(10.5, 1.5, 2);
        campusCafe.restock(30.5, 20.5, 50, 40);
        campusCafe.goToFloor(2);
    }
}
