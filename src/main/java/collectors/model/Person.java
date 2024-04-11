package collectors.model;

import collectors.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter@AllArgsConstructor
public class Person {
    private Optional<Car> car;
    public Optional<Car> getCar() { return car; }
}
