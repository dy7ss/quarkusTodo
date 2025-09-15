package poc.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import poc.controller.assets.api.CustomerApi;
import poc.controller.assets.model.Account;
import poc.controller.assets.model.AccountBaseInfo;
import poc.controller.assets.model.Customer;

public class PocResource implements CustomerApi {

    @Override
    public Customer customerGet() {
        System.out.println("customerGet called");
        return Customer.builder()
                .customerId("12345")
                .account(Account.builder()
                        .accountId("acc-123")
                        .baseInfo(AccountBaseInfo.builder()
                        .accountCustomerName("John Doe")
                                .build())
                        .build())
                .build();

    }

    @Override
    public void customerPost(@Valid @NotNull Customer customer) {
        System.out.println("customerPost called with customerId: " + customer.getCustomerId());
    }

    // 他のメソッドの実装...
    
}
