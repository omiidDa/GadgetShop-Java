// this class represents a general gadget
public class Gadget
{
    // basic details of the gadget
    private String model;
    private double price;
    private int weight;
    private String size;

    // constructor to set all gadget values when object is created
    public Gadget(String model, double price, int weight, String size)
    {
        this.model = model;
        this.price = price;
        this.weight = weight;
        this.size = size;
    }

    // returns the model of the gadget
    public String getModel()
    {
        return model;
    }

    // returns the price of the gadget
    public double getPrice()
    {
        return price;
    }

    // returns the weight of the gadget
    public int getWeight()
    {
        return weight;
    }

    // returns the size of the gadget
    public String getSize()
    {
        return size;
    }

    // displays all gadget details in the console
    public void display()
    {
        System.out.println("Model: " + model);
        System.out.println("Price: £" + price);
        System.out.println("Weight: " + weight + "g");
        System.out.println("Size: " + size);
    }
}