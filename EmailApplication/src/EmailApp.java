import java.util.Scanner;

import static java.lang.System.in;

public class EmailApp {
    //variable declaration for intake
        private String firstName;
        private String lastName;
        private String password;
        private String Department;
        private int defaultPasswordLength = 8;
        private int mailboxCapacity;
        private String alternateEmail;
        private String companySuffix;

        //Constructor to receive the firstName and lastname;
        public EmailApp(String firstName, String lastName)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.Department = setDepartment();
            this.password = randomPassword(defaultPasswordLength);
            this.companySuffix = CompanyName();
//            System.out.println("Email Name: "+this.firstName+this.lastName+"@"+this.Department);
            String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + Department + "." + companySuffix.toLowerCase();
            System.out.println("Employee Email-ID: "+email);
            System.out.println("Generated Password: "+this.password);

        }
        //Ask for the department;
        private String setDepartment()
        {
            System.out.print("Enter the department:\n1--->Sales\n2--->Development\n3--->Accounting\n0--->None\n");
            Scanner in = new Scanner(System.in);
            int deptChoice = in.nextInt();
            if (deptChoice == 1)
            {
                return "sales";
            }
            else if (deptChoice == 2)
            {
                return "dev";
            }
            else if (deptChoice == 3)
            {
                return  "acc";
            }
            else
            {
                return "temp";
            }
        }


        //Generate a random password;
        private String randomPassword(int length)
        {
            String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#$%&abcdefghijklmnopqrstuvwxyz";
            char[] password = new char[length];
            for (int i = 0; i<length;i++)
            {
              int rand = (int) (Math.random() * passwordSet.length());
              password[i] = passwordSet.charAt(rand);
            }
            return String.valueOf(password);
        }
    //Set the mailbox capacity;
    public void setMailboxCapacity(int capacity)
    {
        this.mailboxCapacity = capacity;
    }
        //Set alternative email;
    public  void setAlternateEmail(String altEmail)
    {
        this.alternateEmail = altEmail;
    }
        //Change the password;
    public void changePassword(String password)
    {
        this.password = password;
    }
    //Info on company name
    private String CompanyName()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Company Name: ");
        String suffix = in.nextLine();
        suffix = suffix+"."+"com";
        in.close();
        return suffix;
    }

    //get method to retrieve mailbox capacity
    public int getMailboxCapacity() {
            return mailboxCapacity;
    }

    public String getAlternateEmail()
    {
        return alternateEmail;
    }

    public String getPassword()
    {
        return password;
    }
}
