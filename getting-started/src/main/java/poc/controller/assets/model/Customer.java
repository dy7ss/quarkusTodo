package poc.controller.assets.model;

import poc.controller.assets.model.Account;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("Customer")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", comments = "Generator version: 7.11.0-SNAPSHOT")
public class Customer   {
  private String customerId;
  private Account account;

  protected Customer(CustomerBuilder<?, ?> b) {
    this.customerId = b.customerId;
    this.account = b.account;
  }

  public Customer() {
  }

  @JsonCreator
  public Customer(
    @JsonProperty(required = true, value = "customerId") String customerId,
    @JsonProperty(required = true, value = "account") Account account
  ) {
    this.customerId = customerId;
    this.account = account;
  }

  /**
   **/
  public Customer customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

  
  @JsonProperty(required = true, value = "customerId")
  @NotNull public String getCustomerId() {
    return customerId;
  }

  @JsonProperty(required = true, value = "customerId")
  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  /**
   **/
  public Customer account(Account account) {
    this.account = account;
    return this;
  }

  
  @JsonProperty(required = true, value = "account")
  @NotNull @Valid public Account getAccount() {
    return account;
  }

  @JsonProperty(required = true, value = "account")
  public void setAccount(Account account) {
    this.account = account;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(this.customerId, customer.customerId) &&
        Objects.equals(this.account, customer.account);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, account);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Customer {\n");
    
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static CustomerBuilder<?, ?> builder() {
    return new CustomerBuilderImpl();
  }

  private static class CustomerBuilderImpl extends CustomerBuilder<Customer, CustomerBuilderImpl> {

    @Override
    protected CustomerBuilderImpl self() {
      return this;
    }

    @Override
    public Customer build() {
      return new Customer(this);
    }
  }

  public static abstract class CustomerBuilder<C extends Customer, B extends CustomerBuilder<C, B>>  {
    private String customerId;
    private Account account;
    protected abstract B self();

    public abstract C build();

    public B customerId(String customerId) {
      this.customerId = customerId;
      return self();
    }
    public B account(Account account) {
      this.account = account;
      return self();
    }
  }
}

