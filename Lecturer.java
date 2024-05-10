/**
 * Lecturer is a subclass of the class Teacher.
 *
 * @author Amiks Karki
 * @version 15th January 2024 Java Coursework
 */
public class Lecturer extends Teacher
{   //instance variables
    private String department;
    private int yearsOfExperience;
    private int gradedScore;
    private boolean hasGraded;
    //constructor; initializing the instance variables
    public Lecturer(int teacherID, String teacherName, String address,String workingType,String employmentStatus,int workingHours,String department,int yearsOfExperience)
    {
        super(teacherID, teacherName, address, workingType, employmentStatus);//super keyword is used to access the superclass constructor
        super.setWorkingHours(workingHours);
        this.department=department;
        this.yearsOfExperience=yearsOfExperience;
        this.gradedScore=0;
        this.hasGraded=false;
    }
    public String getDepartment() //getter method(used to return the values; here it is used to return department)
    {
        return this.department;
    }
    public int getYearsOfExperience()
    {
        return this.yearsOfExperience;
    }
    public int getGradedScore()
    {
        return this.gradedScore;
    }
    public boolean getHasGraded()
    {
        return this.hasGraded;
    }
    //mutator method or setter method
    public void setGradedScore(int gradedScore)
    {
        this.gradedScore=gradedScore;
    }
    public void gradeAssignment(int gradedScore, String department,int yearsOfExperience)
    {
        this.yearsOfExperience=yearsOfExperience;/*we have to display the years of experience at display method 
        that's why we are  updating the parameter value of years of experience to the instance variable so that we can display the new value */
        if(this.getYearsOfExperience()>=5 && this.getDepartment().equals(department))
        //The equals() method compares two strings, and returns true if the strings are equal, and false if not.
        {
            this.gradedScore=gradedScore;/*score is only updated if the lecturer grades the assignment. i.e the if condition is true
                                       Here, the value of instance variable is changed from 0 to the user inputted value from gradeAssignment method*/
            if(this.getGradedScore()>=70)
            {
                System.out.println("The student got the grade A");
            }
            else if(this.getGradedScore()>=60 )
            {
                System.out.println("The student got the grade B");
            }
            else if(this.getGradedScore()>=50 )
            {
                System.out.println("The student got the grade C");
            }
            else if(this.getGradedScore()>=40 )
            {
                System.out.println("The student got the grade D");
            }
            else
            {
                System.out.println("The student got the grade E");
            }
            this.hasGraded=true;
        }
        else
        {
            System.out.println("The Lecturer's qualifications does not meet to grade the Students");
        }
    }
    public void display()//overriding- parent class method and child class method has same method name
    {
        if(!this.getHasGraded())//when has graded is false if condition is true and then the output is displayed
        {
            System.out.println("The Lecturer has not Graded the Student!!!");
        }
        
        else
        {   super.display();//calls the parent class method

            System.out.println("The Lecturer's Department is: "+this.getDepartment());
            System.out.println("The Lecturer's Experience is "+this.getYearsOfExperience());//displaying the same experience the user passed through gradeAssignment method
            System.out.println("The Graded Score is: "+this.getGradedScore());//displaying the same score the user passed through gradeAssignment method
        }
        
    };
    
    
    
}
