package org.fasttrackit.onlineshopapi;

import org.fasttrackit.onlineshopapi.domain.Customer;
import org.fasttrackit.onlineshopapi.service.CustomerService;
import org.fasttrackit.onlineshopapi.transfer.customer.CreateCustomerRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceIntegrationTests {

    @Autowired
    private CustomerService customerService;

    @Test
    public void testCreateCustomer_whenValidRequest_thenReturnCustomerWithId() {
        Customer customer = createCustomer();

        assertThat(customer, notNullValue());
        assertThat(customer.getId(), greaterThan(0L));

    }

    private Customer createCustomer() {
        CreateCustomerRequest request = new CreateCustomerRequest();
        request.setFirstName("Gheorghe");
        request.setLastName("Gheorghiu");
        request.setAddress("str. Strazilor nr. 33");
        request.setEmail("Gheorge.gheorghiu@yahoo.com");
        request.setUsername("Gheorghe");
        request.setPassword("Gheorghiu");

        return customerService.createCustomer(request);
    }


}
