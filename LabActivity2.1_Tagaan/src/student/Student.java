package student;

public class Student {
    
    private String firstName, lastName;
    private int age;
    private boolean isMinor;
    
    public Student(){  
    }
  
  
    public Student(String firstName, String lastName, int age) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.isMinor = (age<18);
    }
    
    public void increaseAge()
    {
        age++;
        isMinor = (age<18);
    }
    
    public void setfirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public void setlastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public void setage(int age)
    {
        this.age = age;
    }
    
    public String getfirstName()
    {
        return firstName;
    }
    
    public String getlastName()
    {
        return lastName;
    }
     
    public int getage()
    {
        return age;
    }
      
    public String getName()
    {
        return lastName + ", " + firstName;
    }
    
    public String isMinorStatus(boolean isMinor)
    {
        if(isMinor == true){
            return "minor"; 
        } else {
            return "adult";
        }
    }
    
    @Override
    
    public String toString()
    {
        return getName() + " - " + age + " - " + isMinorStatus(isMinor); 
    }
}
