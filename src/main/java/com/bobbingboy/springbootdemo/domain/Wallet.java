package com.bobbingboy.springbootdemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
public class Wallet {

    @Id
    @GeneratedValue
    private long id;

    private BigDecimal balance;

    @OneToOne(mappedBy = "wallet")
    private Author author;

    public Wallet() {
    }

    public Wallet(BigDecimal balance) {
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
