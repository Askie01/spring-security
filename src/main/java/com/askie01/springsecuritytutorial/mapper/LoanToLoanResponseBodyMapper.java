package com.askie01.springsecuritytutorial.mapper;

import com.askie01.springsecuritytutorial.dto.LoanResponseBody;
import com.askie01.springsecuritytutorial.model.Loan;

public interface LoanToLoanResponseBodyMapper
        extends Mapper<Loan, LoanResponseBody>,
        ToDTOMapper<Loan, LoanResponseBody> {
}
