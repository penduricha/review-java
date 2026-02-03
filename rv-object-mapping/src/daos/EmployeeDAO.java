package daos;

import daos.i_dao.I_EmployeeDAO;
import models.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements I_EmployeeDAO {

    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public EmployeeDAO() {
        this.employees = new ArrayList<>();
    }

    @Override
    public boolean addEmployee(Employee e) {
        if(!employees.contains(e)) {
            employees.add(e);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return this.employees;
    }
}
