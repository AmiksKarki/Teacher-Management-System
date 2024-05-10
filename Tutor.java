/**
 * Tutor is a subclass of the class Teacher.
 *
 * @author Amiks Karki
 * @version 15th January 2024 Java Coursework
 */
public class Tutor extends Teacher 
{
    //instance variables
    private double salary;
    private String specialization;
    private String academicQualification;
    private int performanceIndex;
    private boolean isCertified;
    //constructor; initializing the instance variables
    public Tutor(int teacherID, String teacherName, String address, String workingType,String employmentStatus,int workingHours, 
    double salary,String specialization,String academicQualification, int performanceIndex)
    {
        super(teacherID,teacherName,address,workingType,employmentStatus);//super keyword is used to access the superclass constructor
        super.setWorkingHours(workingHours);
        this.salary=salary;
        this.specialization=specialization;
        this.academicQualification=academicQualification;
        this.performanceIndex=performanceIndex;
        this.isCertified=false;
    }
    public double getSalary()//getter method(used to return the values; here it is used to return salary)
    {
        return this.salary;
    }
    public String getSpecialization() 
    {
        return this.specialization;
    }

    public String getAcademicQualification() 
    {
        return this.academicQualification;
    }

    public int getPerformanceIndex() 
    {
        return this.performanceIndex;
    }

    public boolean getIsCertified() 
    {
        return this.isCertified;
    }
    //setter method(used to update the values of instance variables)
    public void setSalary(double newSalary, int newPerformanceIndex)/*Here I could have named the parameters salary and performance index
                                                                    without using new keyword however used it and replaced the old values with 
                                                                    the new ones*/
    {
        this.performanceIndex=newPerformanceIndex;
        this.salary=newSalary;
        if(this.getPerformanceIndex()>=5 && this.getWorkingHours()>20)
        {
            double appraisal=0.0;//by default, among float and double java accepts double if we add decimal point. 
                                //if it was float we should have written 0.0f at the end
            if(this.getPerformanceIndex()>=5 && this.getPerformanceIndex()<=7)
            {
                appraisal=((double)5/100);//explicit Typecasting-manually converting the data type integer(5) to double
            }
            if(this.getPerformanceIndex()>=8 && this.getPerformanceIndex()<=9)
            {
                appraisal=((double)10/100);//explicit Typecasting-manually converting the data type integer(10) to double
            }
            if(this.getPerformanceIndex()==10)
            {
                appraisal=((double)20/100);//explicit Typecasting-manually converting the data type integer(20) to double
            }
            this.salary=this.getSalary()+((appraisal)*this.getSalary());//new salary calculated after adding the appraisal amount
            this.isCertified=true;
        }
        else
        { 
            System.out.println("The Salary couldn't be approved because the tutor is not certified!!!");
        }
    }
    public void removeTutor()//method to set the value of the instance variables back to null
        {
            if(!this.getIsCertified())
            {
                this.salary=0;
                this.specialization="";
                this.academicQualification="";
                this.performanceIndex=0;
                this.isCertified=false;
                System.out.println("The values of Tutor were removed successfully");
            }
            else 
            {
                System.out.println("The Tutor Could not be removed");
            }
            
        }
    public void display()//method overriding
    {   super.display();
        if(this.getIsCertified())//if is certified is true then this condition will be true and output will be displayed
        {  
            System.out.println("Salary of tutor after adding appraisal is: " +this.getSalary());
            System.out.println("Specialization of tutor is: " +this.getSpecialization());
            System.out.println("Academic Qualifications of tutor is: " +this.getAcademicQualification());
            System.out.println("Performance Index of tutor is: " +this.getPerformanceIndex());
        }  
    }
    
}
