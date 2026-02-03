package models;

import java.io.Serializable;
import java.util.*;

public class Company implements Serializable {
    private Long companyID;

    private String companyName;

    private int yearEstablished;

    private List<Employee> employees;

    public Long getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Long companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getYearEstablished() {
        return yearEstablished;
    }

    public void setYearEstablished(int yearEstablished) {
        this.yearEstablished = yearEstablished;
    }

    public List<Employee> getEmployees() {
        employees = new ArrayList<>();
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Company() {
        this.companyID = null;
        this.companyName = null;
        this.yearEstablished = 0;
        this.employees = new ArrayList<>();
    }

    public Company(String companyName, int yearEstablished) {
        this.companyName = companyName;
        this.yearEstablished = yearEstablished;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyID=" + companyID +
                ", companyName='" + companyName + '\'' +
                ", yearEstablished=" + yearEstablished +
                '}';
    }
}
