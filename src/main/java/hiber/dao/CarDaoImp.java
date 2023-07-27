package hiber.dao;

import org.springframework.stereotype.Repository;
import hiber.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    private final List<Car> carList;

    public CarDaoImp() {
        this.carList = new ArrayList<>(Arrays.asList());
    }

    @Override
    public List<Car> getCars() {
        return carList;
    }

    @Override
    public void addCar(Car car) {
        carList.add(car);
    }
}