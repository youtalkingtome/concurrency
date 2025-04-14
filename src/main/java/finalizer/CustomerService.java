package finalizer;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {
    private final CustomerRepository customerRepository;
    private final MailService mailService;

    public CustomerService(CustomerRepository customerRepository, MailService mailService) {
        this.customerRepository = customerRepository;
        this.mailService = mailService;
    }

    public void processAndSendMails() {
        List<CustomerEntity> customerEntities = customerRepository.findAllCustomers();

        // Transform entity to domain object
        List<CustomerDomain> customerDomains = customerEntities.stream()
                .map(this::transformToDomain)
                .collect(Collectors.toList());

        // Send emails to transformed domain objects
        for (CustomerDomain customer : customerDomains) {
            try {
                mailService.sendMail(customer);
            } catch (Exception e) {
                System.out.println("Failed to send mail to customer: " + customer.getId() + ", continuing...");
            }
        }
    }

    private CustomerDomain transformToDomain(CustomerEntity entity) {
        return new CustomerDomain(entity.getId(), entity.getEmail(), entity.getName());
    }
}