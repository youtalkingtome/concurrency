package collectors;

import collectors.model.Insurance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Setter
@Getter@AllArgsConstructor
public class Car {
    private Optional<Insurance> insurance;

}
