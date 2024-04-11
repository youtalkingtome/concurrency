package collectors.model;

import collectors.Car;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;


public class PersonCarInsurance {


    public Set<String> getCarInsuranceNames(List<Person> persons) {
        return persons.stream()
                .map(Person::getCar)
                .map(optCar -> optCar.flatMap(Car::getInsurance))
                .map(optIns -> optIns.map(Insurance::getName))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(toSet());

    }
}
