package finalizer;

import java.util.List;

interface CustomerRepository {
    List<CustomerEntity> findAllCustomers();
}