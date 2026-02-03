package daos;

import daos.i_daos.I_CarDAO;
import models.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDAO implements I_CarDAO {

    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public CarDAO() {
        this.cars = new ArrayList<>();
    }

    public CarDAO(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean addCar(Car car) {
        if(!cars.contains(car)) {
            cars.add(car);
            return true;
        }
        return false;
    }

    @Override
    public boolean addListCars(List<Car> cars) {
        return false;
    }

    @Override
    public List<Car> getListCars() {
        return cars;
    }

    @Override
    public Car findCarByCarID(Long carID) {
        for(Car car: cars) {
            if(car.getCarID().equals(carID)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public boolean deleteCar(Long carID) {
        Car carFound = findCarByCarID(carID);
        if(carFound != null) {
            cars.remove(carFound);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCar(Car car) {
        if(car.getCarID() == null){
            return false;
        } else {
            Car carFound = findCarByCarID(car.getCarID());
            if(carFound != null) {
                if(car.getCarName() != null) {
                    carFound.setCarName(car.getCarName());
                    System.out.println("Update car name successfully.");
                }
                if(car.getNumberOfSeats() != 0) {
                    carFound.setNumberOfSeats(car.getNumberOfSeats());
                    System.out.println("Update car seat successfully.");
                }
                if(car.getYearOfManufacture() != null) {
                    carFound.setYearOfManufacture(car.getYearOfManufacture());
                    System.out.println("Update car year of manufacture successfully.");
                }
                if(car.getCarCompany() != null) {
                    carFound.setCarCompany(car.getCarCompany());
                    System.out.println("Update car company successfully.");
                }
                return true;
            }
        }
        return false;
    }
}
