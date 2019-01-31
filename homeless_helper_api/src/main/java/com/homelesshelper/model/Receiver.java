package com.homelesshelper.model;

import org.hibernate.annotations.Type;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Entity
public class Receiver {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Long dateOfBirth;

//    @Lob
//    private Byte[] photo;

    @Type(type="text")
    private String summary;

    @NotNull
    private Float balance;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    private List<Donation> donations;

    public Receiver() {
        transactions = new ArrayList<>();
        donations = new ArrayList<>();
    }

    public Receiver(@NotNull String name, @NotNull Long dateOfBirth, String summary) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.summary = summary;
        this.balance = 0.0f;
    }

    public Receiver(@NotNull String name, @NotNull Long dateOfBirth, String summary, @NotNull Float balance, List<Transaction> transactions, List<Donation> donations) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.summary = summary;
        this.balance = balance;
        this.transactions = transactions;
        this.donations = donations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPrettyDateOfBirth() {
        Date date = new Date(dateOfBirth * 1000);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.UK);
        return format.format(date);
    }

    public void setDateOfBirth(Long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public void incrementBalance(Float amount) {
        balance += amount;
    }

    public void decrementBalance(Float amount) {
        balance -= amount;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

    public void addDonation(Donation donation) {
        donations.add(donation);
    }
}