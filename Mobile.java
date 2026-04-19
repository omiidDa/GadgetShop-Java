// this class represents a mobile phone and extends the Gadget class
public class Mobile extends Gadget
{
    // stores the available calling credit (in minutes)
    private int credit;

    // constructor to set all mobile details including credit
    public Mobile(String model, double price, int weight, String size, int credit)
    {
        // call the constructor of the parent class (Gadget)
        super(model, price, weight, size);
        this.credit = credit;
    }

    // returns the current calling credit
    public int getCredit()
    {
        return credit;
    }

    // this method is used to add more credit
    public void addCredit(int amount)
    {
        // check that the amount is a positive number
        if(amount > 0)
        {
            credit = credit + amount;
        }
        else
        {
            // show message if user enters invalid amount
            System.out.println("Please enter a positive amount of credit.");
        }
    }

    // this method simulates making a phone call
    public void makeCall(String phoneNumber, int duration)
    {
        // check that the duration is a valid positive number
        if(duration > 0)
        {
            // check if there is enough credit to make the call
            if(credit >= duration)
            {
                System.out.println("Calling " + phoneNumber + " for " + duration + " minutes.");
                // reduce credit after the call
                credit = credit - duration;
            }
            else
            {
                // show message if there is not enough credit
                System.out.println("Insufficient credit to make the call.");
            }
        }
        else
        {
            // show message if duration is invalid
            System.out.println("Please enter a valid call duration.");
        }
    }

    // display all mobile details including credit
    @Override
    public void display()
    {
        // call display from Gadget class first
        super.display();
        System.out.println("Calling credit: " + credit + " minutes");
    }
}