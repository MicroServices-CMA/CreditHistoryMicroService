package org.microservice.model;

import java.util.ArrayList;
import java.util.List;

public class RepaymentList
{
    List<Repayment> repaymentList;

    public RepaymentList() {
        this.repaymentList = new ArrayList<Repayment>();
    }

    public List<Repayment> getRepaymentList() {
        return repaymentList;
    }

    public void setRepaymentList(List<Repayment> repaymentList) {
        this.repaymentList = repaymentList;
    }
}
