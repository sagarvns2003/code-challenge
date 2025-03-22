package vidya.code.chalenge.study;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AverageSalary {
  private FormatDecimalNumber formatDecimalNumber = new FormatDecimalNumber();

  public void findAverageSalary(List<Employee> employees) {

    Map<String, Map<String, Double>> averageSalaries =
        employees.parallelStream()
            .collect(
                Collectors.groupingBy(
                    Employee::getOfficeLocation,
                    Collectors.groupingBy(
                        Employee::getDesignation,
                        Collectors.averagingDouble(Employee::getSalary))));
    averageSalaries.forEach(
        (location, designations) -> {
          System.out.println("Location: " + location);
          designations.forEach(
              (designation, avgSalary) -> {
                System.out.println(
                    "Designation: "
                        + designation
                        + ", Average Salary: "
                        + formatDecimalNumber.formatNow(avgSalary));
              });
          System.out.println();
        });
  }

  public static void main(String[] args) {

    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee("Ashish", "A", "IT", "Pune", "Software Engineer", 10000d));
    employees.add(new Employee("Amit", "R", "HR", "Pune", "Recruiter", 12000d));
    employees.add(new Employee("Ramesh", "D", "HR", "Pune", "Senior Recruiter", 14000d));
    employees.add(new Employee("Jaya", "S", "IT", "Pune", "Tech Lead", 15000d));
    employees.add(new Employee("Smita", "M", "IT", "Bangalore", "Recruiter", 16000d));
    employees.add(new Employee("Umesh", "A", "IT", "Bangalore", "Software Engineer", 12000d));
    employees.add(new Employee("Pooja", "R", "HR", "Bangalore", "Software Engineer", 12000d));
    employees.add(new Employee("Ramesh", "D", "HR", "Pune", "Recruiter", 16000d));
    employees.add(new Employee("Bobby", "S", "IT", "Bangalore", "Tech Lead", 20000d));
    employees.add(new Employee("Vipul", "M", "IT", "Bangalore", "Software Engineer", 14000d));

    AverageSalary app = new AverageSalary();
    app.findAverageSalary(employees);
  }
}

class FormatDecimalNumber {
  private NumberFormat nf = NumberFormat.getNumberInstance();

  public FormatDecimalNumber() {
    nf.setMaximumFractionDigits(2);
    nf.setRoundingMode(RoundingMode.UP);
    nf.setGroupingUsed(false);
  }

  public String formatNow(double value) {
    return nf.format(value);
  }
}

@Getter
@AllArgsConstructor
class Employee {
  private String firstName;
  private String lastName;
  private String department;
  private String officeLocation;
  private String designation;
  private Double salary;
}
