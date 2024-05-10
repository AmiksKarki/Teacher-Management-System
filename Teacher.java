/**
 * Teacher is a superclass.
 *
 * @author Amiks Karki
 * @version 15th January 2024 Java Coursework
 */
public class Teacher
{   //instance variable
    //An instance variable is a variable which is declared in a class but outside of constructors, methods
    private int teacherID;
    private String teacherName;
    private String address;
    private String workingType;
    private String employmentStatus;
    private int workingHours;
    //Constructor; it is also a method used to initialize the instance variables
    public Teacher( int teacherID, String teacherName, String address,String workingType,String employmentStatus)
    //variables inside the constructor i.e Teacher() are called local variables
    {
        /*  The attribute teacher name is initialized with the parameter value 
            and teacher Id, address,working type, and employment status are also assigned with the parameter values.*/
        this.teacherID=teacherID; 
        this.teacherName=teacherName;
        this.address=address;//if this keyword is not used then the variable is declared as local variable
        this.workingType=workingType;/*A variable declared inside the body of the method is called local variable. 
                                        scope of local variable is limited to that method only*/
        this.employmentStatus=employmentStatus;
    }
    public int getID()//getter method(used to return the values; here it is used to return Teacher's ID)
    {
        return this.teacherID;
    }
    public String getName()
    {
        return this.teacherName;
    }
    public String getAddress()
    {
        return this.address;
    }
    public String getWorkingType()
    {
        return this.workingType;
    }
    public String getEmploymentStatus()
    {
        return this.employmentStatus;
    }
    public int getWorkingHours()
    {
        return this.workingHours;
    }
    public void setWorkingHours(int workingHours)//setter method(used to update the values of instance variables)
    {
        this.workingHours=workingHours;
    }
    public void display()//instance method(methods that can only be called after creating an object)
    {
        if(this.getWorkingHours()==0)
        {
            System.out.println("The teacher's Working Hours is not assigned please assign the value of working hours!: ");
        }
         else if(this.getWorkingHours()>0)
        {
            System.out.println("The teacher ID is: "+this.getID());
            System.out.println("The teacher Name is: "+this.getName());
            System.out.println("The teacher Address is: "+this.getAddress());
            System.out.println("The teacher Working Type is: "+this.getWorkingType());
            System.out.println("The teacher Employment status is: "+this.getEmploymentStatus());
            System.out.println("The teacher's Working Hours is "+this.getWorkingHours());
        }
        else
        {
            System.out.println("The teacher's Working Hours is invalid!! Please enter the positive working value");
        }
        
    }
    
    
}
