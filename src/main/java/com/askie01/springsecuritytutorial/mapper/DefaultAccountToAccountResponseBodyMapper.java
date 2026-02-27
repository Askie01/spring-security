package com.askie01.springsecuritytutorial.mapper;

import com.askie01.springsecuritytutorial.dto.AccountResponseBody;
import com.askie01.springsecuritytutorial.dto.CustomerResponseBody;
import com.askie01.springsecuritytutorial.model.Account;
import com.askie01.springsecuritytutorial.model.Customer;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultAccountToAccountResponseBodyMapper implements AccountToAccountResponseBodyMapper {

    private final CustomerToCustomerResponseBodyMapper customerMapper;

    @Override
    public AccountResponseBody mapToDTO(Account account) {
        final AccountResponseBody accountResponseBody = AccountResponseBody.builder()
                .owner(new CustomerResponseBody())
                .build();
        map(account, accountResponseBody);
        return accountResponseBody;
    }

    @Override
    public void map(Account account, AccountResponseBody accountResponseBody) {
        mapAccountNumber(account, accountResponseBody);
        mapAccountType(account, accountResponseBody);
        mapBranchAddress(account, accountResponseBody);
        mapOwner(account, accountResponseBody);
    }

    private void mapAccountNumber(Account account, AccountResponseBody accountResponseBody) {
        final Long accountNumber = account.getAccountNumber();
        accountResponseBody.setAccountNumber(accountNumber);
    }

    private void mapAccountType(Account account, AccountResponseBody accountResponseBody) {
        final String accountType = account.getAccountType();
        accountResponseBody.setAccountType(accountType);
    }

    private void mapBranchAddress(Account account, AccountResponseBody accountResponseBody) {
        final String branchAddress = account.getBranchAddress();
        accountResponseBody.setBranchAddress(branchAddress);
    }

    private void mapOwner(Account account, AccountResponseBody accountResponseBody) {
        final Customer customer = account.getCustomer();
        final CustomerResponseBody customerResponseBody = accountResponseBody.getOwner();
        customerMapper.map(customer, customerResponseBody);
    }
}
