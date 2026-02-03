package models;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {
    private Long employeeID;

    private String employeeFirstName;

    private String employeeLastName;

    private boolean gender;

    private String email;

    private String positon;

    private Company company;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeID, employee.employeeID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(employeeID);
    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPositon() {
        return positon;
    }

    public void setPositon(String positon) {
        this.positon = positon;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Employee() {
        this.employeeID = null;
        this.employeeFirstName = null;
        this.employeeLastName = null;
        this.gender = true;
        this.email = null;
        this.positon = null;
        this.company = new Company();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", positon='" + positon + '\'' +
                '}';
    }

    public Employee(String employeeFirstName, String employeeLastName, boolean gender, String email, String positon) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.gender = gender;
        this.email = email;
        this.positon = positon;
    }
}
