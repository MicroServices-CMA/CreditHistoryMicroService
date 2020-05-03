package org.microservice.model;

import java.util.ArrayList;
import java.util.List;

public class BankList
{
    List<Bank> banks;

    public BankList() {
        this.banks = new ArrayList<Bank>();
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }
}
