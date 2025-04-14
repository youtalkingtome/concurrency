package finalizer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
class Orders {
    String status;
    int amount;
    boolean isAvailable;
    String orderId;

}