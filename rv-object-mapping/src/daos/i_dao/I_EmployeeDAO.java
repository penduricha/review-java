package daos.i_dao;

import models.Employee;

import java.util.List;

public interface I_EmployeeDAO {
    public boolean addEmployee(Employee e);

    public List<Employee> getAllEmployee();
}
