package com.homelesshelper.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Entity
public class Donation {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Float amount;

    @NotNull
    private Long timeStamp;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "donator_id")
    private Donator donator;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Receiver receiver;

    public Donation() {}

    public Donation(@NotNull Float amount, @NotNull Long timeStamp, @NotNull Donator donator, @NotNull Receiver receiver) {
        this.amount = amount;
        this.timeStamp = timeStamp;
        this.donator = donator;
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

    public Donator getDonator() {
        return donator;
    }

    public void setDonator(Donator donator) {
        this.donator = donator;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }
}