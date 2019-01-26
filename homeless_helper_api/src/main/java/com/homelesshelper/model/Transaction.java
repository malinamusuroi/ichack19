package com.homelesshelper.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Float amount;

    @NotNull
    private String description;

    @NotNull
    private Long timeStamp;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Receiver receiver;

    public Transaction() {}

    public Transaction(@NotNull Float amount, @NotNull String description, @NotNull Long timeStamp, @NotNull Vendor vendor, @NotNull Receiver receiver) {
        this.amount = amount;
        this.description = description;
        this.timeStamp = timeStamp;
        this.vendor = vendor;
        this.receiver = receiver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPrettyTimeStamp() {
        Date date = new Date(timeStamp * 1000);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.UK);
        return format.format(date);
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }
}