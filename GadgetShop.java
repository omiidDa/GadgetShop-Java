import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// this class creates the main window for the gadget shop
public class GadgetShop extends JFrame
{
    // list to store all gadgets
    private ArrayList<Gadget> gadgets;

    // text fields for user input
    private JTextField modelField;
    private JTextField priceField;
    private JTextField weightField;
    private JTextField sizeField;
    private JTextField creditField;
    private JTextField memoryField;
    private JTextField phoneNumberField;
    private JTextField durationField;
    private JTextField downloadSizeField;
    private JTextField displayNumberField;

    // area to show results in the GUI
    private JTextArea outputArea;

    // constructor
    public GadgetShop()
    {
        gadgets = new ArrayList<Gadget>();
        makeFrame();
    }

    // this method builds the whole GUI
    private void makeFrame()
    {
        setTitle("Gadget Shop");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // panel for all input fields
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new GridLayout(10, 2));

        fieldsPanel.add(new JLabel("Model:"));
        modelField = new JTextField();
        fieldsPanel.add(modelField);

        fieldsPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        fieldsPanel.add(priceField);

        fieldsPanel.add(new JLabel("Weight:"));
        weightField = new JTextField();
        fieldsPanel.add(weightField);

        fieldsPanel.add(new JLabel("Size:"));
        sizeField = new JTextField();
        fieldsPanel.add(sizeField);

        fieldsPanel.add(new JLabel("Initial Credit:"));
        creditField = new JTextField();
        fieldsPanel.add(creditField);

        fieldsPanel.add(new JLabel("Initial Memory:"));
        memoryField = new JTextField();
        fieldsPanel.add(memoryField);

        fieldsPanel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        fieldsPanel.add(phoneNumberField);

        fieldsPanel.add(new JLabel("Duration:"));
        durationField = new JTextField();
        fieldsPanel.add(durationField);

        fieldsPanel.add(new JLabel("Download Size:"));
        downloadSizeField = new JTextField();
        fieldsPanel.add(downloadSizeField);

        fieldsPanel.add(new JLabel("Display Number:"));
        displayNumberField = new JTextField();
        fieldsPanel.add(displayNumberField);

        add(fieldsPanel, BorderLayout.NORTH);

        // panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3));

        JButton addMobileButton = new JButton("Add Mobile");
        JButton addMP3Button = new JButton("Add MP3");
        JButton clearButton = new JButton("Clear");
        JButton displayAllButton = new JButton("Display All");
        JButton makeCallButton = new JButton("Make A Call");
        JButton downloadMusicButton = new JButton("Download Music");

        buttonPanel.add(addMobileButton);
        buttonPanel.add(addMP3Button);
        buttonPanel.add(clearButton);
        buttonPanel.add(displayAllButton);
        buttonPanel.add(makeCallButton);
        buttonPanel.add(downloadMusicButton);

        add(buttonPanel, BorderLayout.CENTER);

        // output area at the bottom
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setPreferredSize(new Dimension(800, 250));
        add(scrollPane, BorderLayout.SOUTH);

        // connect buttons to methods
        addMobileButton.addActionListener(e -> addMobile());
        addMP3Button.addActionListener(e -> addMP3());
        clearButton.addActionListener(e -> clearFields());
        displayAllButton.addActionListener(e -> displayAll());
        makeCallButton.addActionListener(e -> makeCall());
        downloadMusicButton.addActionListener(e -> downloadMusic());

        setVisible(true);
    }

    // gets the model from the text field
    private String getModel()
    {
        return modelField.getText();
    }

    // gets the price and converts it to double
    private double getPrice()
    {
        return Double.parseDouble(priceField.getText());
    }

    // gets the weight and converts it to int
    private int getWeight()
    {
        return Integer.parseInt(weightField.getText());
    }

    // gets the size from the text field
    private String getSizeValue()
    {
        return sizeField.getText();
    }

    // gets the credit and converts it to int
    private int getCredit()
    {
        return Integer.parseInt(creditField.getText());
    }

    // gets the memory and converts it to int
    private int getMemory()
    {
        return Integer.parseInt(memoryField.getText());
    }

    // gets the phone number from the text field
    private String getPhoneNumber()
    {
        return phoneNumberField.getText();
    }

    // gets the duration and converts it to int
    private int getDuration()
    {
        return Integer.parseInt(durationField.getText());
    }

    // gets the download size and converts it to int
    private int getDownloadSize()
    {
        return Integer.parseInt(downloadSizeField.getText());
    }

    // this method checks if the display number is valid
    private int getDisplayNumber()
    {
        int displayNumber = -1;

        try
        {
            int enteredNumber = Integer.parseInt(displayNumberField.getText());

            if(enteredNumber >= 0 && enteredNumber < gadgets.size())
            {
                displayNumber = enteredNumber;
            }
            else
            {
                JOptionPane.showMessageDialog(this,
                    "Display number is out of range.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

                System.out.println("ERROR: Display number is out of range.");
            }
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,
                "Display number must be an integer.",
                "Error",
                JOptionPane.ERROR_MESSAGE);

            System.out.println("ERROR: Display number must be an integer.");
        }

        return displayNumber;
    }

    // this method creates a new mobile and adds it to the list
    private void addMobile()
    {
        try
        {
            String model = getModel();
            double price = getPrice();
            int weight = getWeight();
            String size = getSizeValue();
            int credit = getCredit();

            Mobile mobile = new Mobile(model, price, weight, size, credit);
            gadgets.add(mobile);

            outputArea.append("Mobile added.\n");
            System.out.println("Mobile added.");
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,
                "Please enter valid values for price, weight and credit.",
                "Error",
                JOptionPane.ERROR_MESSAGE);

            System.out.println("ERROR: Please enter valid values for price, weight and credit.");
        }
    }

    // this method creates a new MP3 player and adds it to the list
    private void addMP3()
    {
        try
        {
            String model = getModel();
            double price = getPrice();
            int weight = getWeight();
            String size = getSizeValue();
            int memory = getMemory();

            MP3 mp3 = new MP3(model, price, weight, size, memory);
            gadgets.add(mp3);

            outputArea.append("MP3 player added.\n");
            System.out.println("MP3 player added.");
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this,
                "Please enter valid values for price, weight and memory.",
                "Error",
                JOptionPane.ERROR_MESSAGE);

            System.out.println("ERROR: Please enter valid values for price, weight and memory.");
        }
    }

    // this method clears all text fields
    private void clearFields()
    {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        downloadSizeField.setText("");
        displayNumberField.setText("");
    }

    // this method displays all gadgets in the output area and CMD
    private void displayAll()
    {
        if(gadgets.size() == 0)
        {
            outputArea.append("No gadgets stored.\n");
            System.out.println("No gadgets stored.");
        }
        else
        {
            outputArea.append("All gadgets:\n");
            System.out.println("All gadgets:");

            for(int i = 0; i < gadgets.size(); i++)
            {
                Gadget gadget = gadgets.get(i);

                outputArea.append("Display Number: " + i + "\n");
                outputArea.append("Model: " + gadget.getModel() + "\n");
                outputArea.append("Price: £" + gadget.getPrice() + "\n");
                outputArea.append("Weight: " + gadget.getWeight() + "g\n");
                outputArea.append("Size: " + gadget.getSize() + "\n");

                System.out.println("Display Number: " + i);
                System.out.println("Model: " + gadget.getModel());
                System.out.println("Price: £" + gadget.getPrice());
                System.out.println("Weight: " + gadget.getWeight() + "g");
                System.out.println("Size: " + gadget.getSize());

                // check if the gadget is a mobile or MP3
                if(gadget instanceof Mobile)
                {
                    Mobile mobile = (Mobile) gadget;
                    outputArea.append("Calling credit: " + mobile.getCredit() + " minutes\n");
                    System.out.println("Calling credit: " + mobile.getCredit() + " minutes");
                }
                else if(gadget instanceof MP3)
                {
                    MP3 mp3 = (MP3) gadget;
                    outputArea.append("Available memory: " + mp3.getMemory() + "\n");
                    System.out.println("Available memory: " + mp3.getMemory());
                }

                outputArea.append("\n");
                System.out.println();
            }
        }
    }

    // this method makes a call using a selected mobile phone
    private void makeCall()
    {
        int displayNumber = getDisplayNumber();

        if(displayNumber != -1)
        {
            Gadget gadget = gadgets.get(displayNumber);

            if(gadget instanceof Mobile)
            {
                try
                {
                    Mobile mobile = (Mobile) gadget;
                    String phoneNumber = getPhoneNumber();
                    int duration = getDuration();

                    mobile.makeCall(phoneNumber, duration);
                    outputArea.append("Call made from gadget " + displayNumber + "\n");
                    System.out.println("Call made from gadget " + displayNumber);
                }
                catch(NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(this,
                        "Duration must be an integer.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

                    System.out.println("ERROR: Duration must be an integer.");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this,
                    "Selected gadget is not a mobile phone.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

                System.out.println("ERROR: Selected gadget is not a mobile phone.");
            }
        }
    }

    // this method downloads music to a selected MP3 player
    private void downloadMusic()
    {
        int displayNumber = getDisplayNumber();

        if(displayNumber != -1)
        {
            Gadget gadget = gadgets.get(displayNumber);

            if(gadget instanceof MP3)
            {
                try
                {
                    MP3 mp3 = (MP3) gadget;
                    int downloadSize = getDownloadSize();

                    mp3.downloadMusic(downloadSize);
                    outputArea.append("Music downloaded to gadget " + displayNumber + "\n");
                    System.out.println("Music downloaded to gadget " + displayNumber);
                }
                catch(NumberFormatException e)
                {
                    JOptionPane.showMessageDialog(this,
                        "Download size must be an integer.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);

                    System.out.println("ERROR: Download size must be an integer.");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this,
                    "Selected gadget is not an MP3 player.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

                System.out.println("ERROR: Selected gadget is not an MP3 player.");
            }
        }
    }

    // main method to run the program
    public static void main(String[] args)
    {
        new GadgetShop();
    }
}
