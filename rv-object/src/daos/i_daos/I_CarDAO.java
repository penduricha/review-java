package daos.i_daos;

import models.Car;

import java.util.*;

public interface I_CarDAO {
    public boolean addCar(Car car);

    public boolean addListCars(List<Car> cars);

    public List<Car> getListCars();

    public Car findCarByCarID(Long carID);

    public boolean deleteCar(Long carID);

    public boolean updateCar(Car car);
}
