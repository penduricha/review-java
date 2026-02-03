package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Car implements Serializable {
    private Long carID;

    private String carName;

    private Integer yearOfManufacture;

    private Integer numberOfSeats;

    private String carCompany;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carID, car.carID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(carID);
    }

    public Long getCarID() {
        return carID;
    }

    public void setCarID(Long carID) {
        this.carID = carID;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Integer getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Integer yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    public Car() {
        this.carID = null;
        this.carName = null;
        this.yearOfManufacture = null;
        this.numberOfSeats = 0;
        this.carCompany = null;
    }

    public Car(String carName, Integer yearOfManufacture, Integer numberOfSeats, String carCompany) {
        this.carName = carName;
        this.yearOfManufacture = yearOfManufacture;
        this.numberOfSeats = numberOfSeats;
        this.carCompany = carCompany;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carID=" + carID +
                ", carName='" + carName + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", numberOfSeats=" + numberOfSeats +
                ", carCompany='" + carCompany + '\'' +
                '}';
    }
}
