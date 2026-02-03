import daos.CarDAO;
import models.Car;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //public Car(String carName, Integer yearOfManufacture, Integer numberOfSeats, String carCompany)
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Car car1 = new Car("Mercedes", 2000, 4, "Mercedes Benz");
        car1.setCarID(1L);

        Car car2 = new Car("Audi", 2000, 4, "Audi");
        car2.setCarID(2L);

        Car car3 = new Car("Toyota", 2010, 4, "Toyota");
        car3.setCarID(3L);

        Car car4 = new Car("KIA", 2009, 4, "KIA");
        car4.setCarID(4L);

        CarDAO carDao = new CarDAO();

        carDao.addCar(car1);
        carDao.addCar(car2);
        carDao.addCar(car3);
        carDao.addCar(car4);

        for(Car car: carDao.getListCars()) {
            System.out.println(car);
        }

        //Delete car4
        boolean deleteCar = carDao.deleteCar(4L);
        if(deleteCar) {
            System.out.println();
            System.out.println("Car deleted successfully");
            for(Car car: carDao.getListCars()) {
                System.out.println(car);
            }
        }

        Car carToUpdate = new Car();
        carToUpdate.setCarID(1L);
        carToUpdate.setCarName("Mercedes Benz 1050");
        carToUpdate.setYearOfManufacture(2002);

        boolean updateCar = carDao.updateCar(carToUpdate);
        if(updateCar) {
            System.out.println();
            for(Car car: carDao.getListCars()) {
                System.out.println(car);
            }
        }
    }
}