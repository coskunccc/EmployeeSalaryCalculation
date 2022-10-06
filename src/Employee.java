public class Employee {
    /*
    In this class after private fields
    'Contructer, Setters, Getters and Methods' are created
     */
    private String name;
    private double salary;
    private int workHours;
    private int hireYear;

    //constructer
    public Employee(String name, double salary, int workHours, int hireYear) {
        setName(name);
        setSalary(salary);
        setWorkHours(workHours);
        setHireYear(hireYear);
    }

    // setters
    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Name is empty");
            return;
        }
        this.name = name;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            System.out.println("Salary cannot be less than zero");
            return;
        }
        this.salary = salary;
    }

    public void setWorkHours(int workHours) {
        if (workHours < 0) {
            System.out.println("Work hours cannot be negative");
            return;
        }
        this.workHours = workHours;
    }

    public void setHireYear(int hireYear) {
        if (hireYear < 1960 || hireYear > 2021) {
            // suppose that company founded at 1960 and this today's date is 2021
            return;
        }
        this.hireYear = hireYear;
    }

    // getters
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getWorkHours() {
        return workHours;
    }

    public int getHireYear() {
        return hireYear;
    }

    // ------------METHODS-------------

    public double tax() {
        if (salary < 1000) {
            return 0;
        } else {
            return salary * (0.03);
        }
    }

    public double bonus() {
        if (workHours > 40) {
            return (workHours - 40) * 30 * 4;
            //suppose that salary is paid monthly and there are 4 weeks in a month
        } else {
            return 0;
        }
    }

    // I suppoesed that raiseSalary method calculates only
    // the amount which will be added to first salary.
    // The net salary will be sum of salary, bonuses and raiseSalary minus tax

    public double raiseSalary() {
        int workYears = 2021 - hireYear;
        double raise=0;

        //salary after tax and bonus.
        double salaryAfterTaxAndBonus = salary-tax()+bonus();

        if (workYears<10){
            raise=salaryAfterTaxAndBonus*(0.05);
        } else if (workYears<20) {
            raise=salaryAfterTaxAndBonus*(0.10);
        } else{
            raise=salaryAfterTaxAndBonus*(0.15);
        }
        return raise;
    }

    // now it is to write toString method
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ",\n salary=" + salary +
                ",\n workHours=" + workHours +
                ",\n hireYear=" + hireYear +
                ",\n taxes=" + tax() +
                ",\n bonuses=" + bonus() +
                ",\n raise of salary=" + raiseSalary() +
                ",\n NET SALARY (salary+bonuses+raise-tax) = " + (salary +bonus()+raiseSalary()-tax())+
                '}';
    }
}
