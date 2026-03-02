package com.askie01.springsecuritytutorial.mapper;

import com.askie01.springsecuritytutorial.dto.LoanResponseBody;
import com.askie01.springsecuritytutorial.model.Loan;

import java.time.LocalDateTime;

public class DefaultLoanToLoanResponseBodyMapper implements LoanToLoanResponseBodyMapper {

    @Override
    public LoanResponseBody mapToDTO(Loan loan) {
        final LoanResponseBody loanResponseBody = new LoanResponseBody();
        map(loan, loanResponseBody);
        return loanResponseBody;
    }

    @Override
    public void map(Loan source, LoanResponseBody target) {
        mapNumber(source, target);
        mapType(source, target);
        mapTotal(source, target);
        mapPaid(source, target);
        mapRemaining(source, target);
        mapDate(source, target);
    }

    private void mapNumber(Loan source, LoanResponseBody target) {
        final Long number = source.getLoanNumber();
        target.setNumber(number);
    }

    private void mapType(Loan source, LoanResponseBody target) {
        final String type = source.getLoanType();
        target.setType(type);
    }

    private void mapTotal(Loan source, LoanResponseBody target) {
        final Double total = source.getTotalLoan();
        target.setTotal(total);
    }

    private void mapPaid(Loan source, LoanResponseBody target) {
        final Double paid = source.getAmountPaid();
        target.setPaid(paid);
    }

    private void mapRemaining(Loan source, LoanResponseBody target) {
        final Double remaining = source.getRemainingAmount();
        target.setRemaining(remaining);
    }

    private void mapDate(Loan source, LoanResponseBody target) {
        final LocalDateTime date = source.getCreatedAt();
        target.setDate(date);
    }
}
