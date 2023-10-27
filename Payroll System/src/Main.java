import java.util.ArrayList;

abstract class Employee
{
    private final String name;
    private final int id;

    public Employee(String name, int id)
    {
        this.name = name;
        this.id =id;
    }

    public String getName()
    {
        return name;
    }
    public int getId()
    {
        return id;
    }

    public abstract double calculateSalary();

    public String toString()
    {
        return "Employee[name="+name+" , id="+id+" , salary="+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee
{
    private final double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary)
    {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee
{
    private final int WorkingHours;
    private final double HourlyRate;

    public PartTimeEmployee(String name, int id, int workingHours, double HourlyRate)
    {
        super(name, id);
        this.WorkingHours = workingHours;
        this.HourlyRate=HourlyRate;
    }
    @Override
    public double calculateSalary() {
        return (WorkingHours*HourlyRate);
    }
}

class PayrollSystem
{
    private ArrayList<Employee> employeeList;

    public PayrollSystem()
    {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee)
    {
        employeeList.add(employee);
    }
    public void removeEmployee(int id)
    {
        Employee employeeToRemove = null;
        for(Employee employee : employeeList)
        {
            if (employee.getId() == id)
            {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null)
        {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee()
    {
        for(Employee employee: employeeList)
        {
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee fe1 = new FullTimeEmployee("Harsha",27,70000);
        PartTimeEmployee pe1 = new PartTimeEmployee("Siddarth",19,40,1000);

        payrollSystem.addEmployee(fe1);
        payrollSystem.addEmployee(pe1);

        System.out.println("Employee details: ");
        payrollSystem.displayEmployee();

        System.out.println("Removing Employee Record");
        payrollSystem.removeEmployee(19);
        System.out.println("After Record Deletion:");
        payrollSystem.displayEmployee();


    }
}