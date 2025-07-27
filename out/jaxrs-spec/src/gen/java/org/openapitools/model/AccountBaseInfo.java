package org.openapitools.model;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("AccountBaseInfo")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class AccountBaseInfo   {
  private @Valid String accountCustomerName;

  protected AccountBaseInfo(AccountBaseInfoBuilder<?, ?> b) {
    this.accountCustomerName = b.accountCustomerName;
  }

  public AccountBaseInfo() {
  }

  /**
   **/
  public AccountBaseInfo accountCustomerName(String accountCustomerName) {
    this.accountCustomerName = accountCustomerName;
    return this;
  }

  
  @JsonProperty("accountCustomerName")
  @NotNull
 @Pattern(regexp="^[A-Z][a-z]+$")  public String getAccountCustomerName() {
    return accountCustomerName;
  }

  @JsonProperty("accountCustomerName")
  public void setAccountCustomerName(String accountCustomerName) {
    this.accountCustomerName = accountCustomerName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountBaseInfo accountBaseInfo = (AccountBaseInfo) o;
    return Objects.equals(this.accountCustomerName, accountBaseInfo.accountCustomerName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountCustomerName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountBaseInfo {\n");
    
    sb.append("    accountCustomerName: ").append(toIndentedString(accountCustomerName)).append("\n");
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


  public static AccountBaseInfoBuilder<?, ?> builder() {
    return new AccountBaseInfoBuilderImpl();
  }

  private static final class AccountBaseInfoBuilderImpl extends AccountBaseInfoBuilder<AccountBaseInfo, AccountBaseInfoBuilderImpl> {

    @Override
    protected AccountBaseInfoBuilderImpl self() {
      return this;
    }

    @Override
    public AccountBaseInfo build() {
      return new AccountBaseInfo(this);
    }
  }

  public static abstract class AccountBaseInfoBuilder<C extends AccountBaseInfo, B extends AccountBaseInfoBuilder<C, B>>  {
    private String accountCustomerName;
    protected abstract B self();

    public abstract C build();

    public B accountCustomerName(String accountCustomerName) {
      this.accountCustomerName = accountCustomerName;
      return self();
    }
  }
}

