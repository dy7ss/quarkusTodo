package org.openapitools.model;

import org.openapitools.model.AccountBaseInfo;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("Account")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class Account   {
  private @Valid String accountId;
  private @Valid AccountBaseInfo baseInfo;

  protected Account(AccountBuilder<?, ?> b) {
    this.accountId = b.accountId;
    this.baseInfo = b.baseInfo;
  }

  public Account() {
  }

  /**
   **/
  public Account accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  
  @JsonProperty("accountId")
  @NotNull
  public String getAccountId() {
    return accountId;
  }

  @JsonProperty("accountId")
  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  /**
   **/
  public Account baseInfo(AccountBaseInfo baseInfo) {
    this.baseInfo = baseInfo;
    return this;
  }

  
  @JsonProperty("baseInfo")
  @NotNull
  public AccountBaseInfo getBaseInfo() {
    return baseInfo;
  }

  @JsonProperty("baseInfo")
  public void setBaseInfo(AccountBaseInfo baseInfo) {
    this.baseInfo = baseInfo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Account account = (Account) o;
    return Objects.equals(this.accountId, account.accountId) &&
        Objects.equals(this.baseInfo, account.baseInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, baseInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Account {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    baseInfo: ").append(toIndentedString(baseInfo)).append("\n");
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


  public static AccountBuilder<?, ?> builder() {
    return new AccountBuilderImpl();
  }

  private static final class AccountBuilderImpl extends AccountBuilder<Account, AccountBuilderImpl> {

    @Override
    protected AccountBuilderImpl self() {
      return this;
    }

    @Override
    public Account build() {
      return new Account(this);
    }
  }

  public static abstract class AccountBuilder<C extends Account, B extends AccountBuilder<C, B>>  {
    private String accountId;
    private AccountBaseInfo baseInfo;
    protected abstract B self();

    public abstract C build();

    public B accountId(String accountId) {
      this.accountId = accountId;
      return self();
    }
    public B baseInfo(AccountBaseInfo baseInfo) {
      this.baseInfo = baseInfo;
      return self();
    }
  }
}

