public class Employee {
    private String firstName;
    private String LastName;
    private int entreeDate;
    private int DepartureDate;
    private int birthDate;
    private String department;
    private float salary;

    private Employee(String firstName, String LastName, int entreeDate, int departureDate, int birthDate, String department, float salary) {
        this.firstName = firstName;
        this.LastName = LastName;
        this.entreeDate = entreeDate;
        DepartureDate = departureDate;
        this.birthDate = birthDate;
        this.department = department;
        this.salary = salary;
    }

    public static class Builder{
       private String firstName;
       private String LastName;
       private int entreeDate;
       private int DepartureDate;
       private int birthDate;
       private String department;
       private float salary;
   }
   public Builder firstName(String firstName){
        this.firstName=firstName;
        return this;
   }
    public Builder LastName(String LastName){
        this.LastName=LastName;
        return this;
    }
    public Builder entreeDate(int entreeDate){
        this.entreeDate=entreeDate;
        return this;
    }
    public Builder DepartureDate(int DepartureDate){
        this.DepartureDate=DepartureDate;
        return this;
    }
    public Builder birthDate(int birthDate){
        this.birthDate=birthDate;
        return this;
    }
    public Builder department(String department){
        this.department=department;
        return this;
    }
    public Builder salary(float salary){
        this.salary=salary;
        return this;
    }
    public Employee build(){
        return new Employee(this.firstName,this.LastName,this.entreeDate,this.DepartureDate,this.birthDate,this.department,this.salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", entreeDate=" + entreeDate +
                ", DepartureDate=" + DepartureDate +
                ", birthDate=" + birthDate +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
