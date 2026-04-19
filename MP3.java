// this class represents an MP3 player and extends the Gadget class
public class MP3 extends Gadget
{
    // stores the available memory of the MP3 player
    private int memory;

    // constructor that sets all values including memory
    public MP3(String model, double price, int weight, String size, int memory)
    {
        // call the constructor of the parent class (Gadget)
        super(model, price, weight, size);
        this.memory = memory;
    }

    // returns the current available memory
    public int getMemory()
    {
        return memory;
    }

    // this method is used to download music to the MP3 player
    public void downloadMusic(int amount)
    {
        // check that the amount entered is a positive number
        if(amount > 0)
        {
            // check if there is enough memory available
            if(amount <= memory)
            {
                // reduce memory after downloading
                memory = memory - amount;
                System.out.println("Music downloaded.");
            }
            else
            {
                // show message if there is not enough memory
                System.out.println("Insufficient memory available.");
            }
        }
        else
        {
            // show message if user enters invalid value
            System.out.println("Please enter a valid download size.");
        }
    }

    // this method deletes music and increases available memory
    public void deleteMusic(int amount)
    {
        memory = memory + amount;
    }

    // display all details including memory
    @Override
    public void display()
    {
        // call display from Gadget class first
        super.display();
        System.out.println("Available memory: " + memory);
    }
}