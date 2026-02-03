import daos.EmployeeDAO;
import models.Company;
import models.Employee;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // public Employee(String employeeFirstName, String employeeLastName,
        // boolean gender, String email, String positon)
        Employee employee1 = new Employee("Khang", "Nguyen", true, "khang@gmail.com", "intern");
        employee1.setEmployeeID(1L);

        Employee employee2 = new Employee("An", "Nguyen", true, "ang@gmail.com", "intern");
        employee2.setEmployeeID(2L);

        Employee employee3 = new Employee("Minh", "Nguyen", true, "minh@gmail.com", "intern");
        employee3.setEmployeeID(3L);

        //  public Company(String companyName, int yearEstablished)
        Company company1 = new Company("FPT", 1990);
        company1.setCompanyID(1L);

        company1.getEmployees().add(employee1);
        company1.getEmployees().add(employee2);
        company1.getEmployees().add(employee3);

        employee1.setCompany(company1);
        employee2.setCompany(company1);
        employee3.setCompany(company1);

        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.addEmployee(employee1);
        employeeDAO.addEmployee(employee2);
        employeeDAO.addEmployee(employee3);

        for(Employee e: employeeDAO.getAllEmployee()) {
            System.out.println(e);
            System.out.println(e.getCompany());
        }
    }
}