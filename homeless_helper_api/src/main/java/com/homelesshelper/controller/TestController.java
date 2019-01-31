package com.homelesshelper.controller;

import com.homelesshelper.model.*;
import com.homelesshelper.service.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    ReceiverService receiverService;

    @Autowired
    VendorService vendorService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    DonatorService donatorService;

    @Autowired
    DonationService donationService;

    @RequestMapping(value="/getReceivers", method=RequestMethod.GET)
    @ResponseBody
    public String getReceivers() {
        List<Receiver> receivers = receiverService.getAll();

        JSONArray arr = new JSONArray();
        for (Receiver receiver: receivers) {
            JSONObject obj = new JSONObject();
            obj.put("id", receiver.getId());
            obj.put("name", receiver.getName());
            obj.put("dob", receiver.getPrettyDateOfBirth());
            obj.put("summary", receiver.getSummary());
            obj.put("balance", receiver.getBalance());

            JSONArray transactions = new JSONArray();
            receiver.getTransactions().forEach(t -> {
                JSONObject transaction = new JSONObject();
                transaction.put("amount", t.getAmount());
                transaction.put("description", t.getDescription());
                transaction.put("timestamp", t.getPrettyTimeStamp());
                transactions.put(transaction);
            });
            obj.put("transactions", transactions);

            JSONArray donations = new JSONArray();
            receiver.getDonations().forEach(d -> {
                JSONObject donation = new JSONObject();
                donation.put("amount", d.getAmount());
                donation.put("timestamp", d.getPrettyTimeStamp());
                donation.put("donator", d.getDonator().getName());
                donations.put(donation);
            });
            obj.put("donations", donations);

            arr.put(obj);
        }

        return arr.toString();
    }

    @RequestMapping(value="/getVendors", method=RequestMethod.GET)
    @ResponseBody
    public String getVendors() {
        List<Vendor> vendors = vendorService.getAll();

        JSONArray arr = new JSONArray();
        for (Vendor vendor: vendors) {
            JSONObject obj = new JSONObject();
            obj.put("id", vendor.getId());
            obj.put("name", vendor.getName());
            obj.put("email", vendor.getEmail());
            obj.put("password", vendor.getPassword());
            JSONArray transactions = new JSONArray();
            vendor.getTransactions().forEach(t -> {
                JSONObject transaction = new JSONObject();
                transaction.put("amount", t.getAmount());
                transaction.put("description", t.getDescription());
                transaction.put("timestamp", t.getPrettyTimeStamp());
                transaction.put("receiver", t.getReceiver().getName());
                transactions.put(transaction);
            });
            obj.put("transactions", transactions);
            arr.put(obj);
        }

        return arr.toString();
    }

    @RequestMapping(value="/getTransactions", method=RequestMethod.GET)
    @ResponseBody
    public String getTransactions() {
        List<Transaction> transactions = transactionService.getAll();

        JSONArray arr = new JSONArray();
        for (Transaction transaction: transactions) {
            JSONObject obj = new JSONObject();
            obj.put("id", transaction.getId());
            obj.put("amount", transaction.getAmount());
            obj.put("description", transaction.getDescription());
            obj.put("timestamp", transaction.getPrettyTimeStamp());

            Vendor vendor = transaction.getVendor();
            JSONObject vendorObj = new JSONObject();
            vendorObj.put("id", vendor.getId());
            vendorObj.put("name", vendor.getName());
            vendorObj.put("email", vendor.getEmail());
            vendorObj.put("password", vendor.getPassword());
            obj.put("vendor", vendorObj);

            Receiver receiver = transaction.getReceiver();
            JSONObject receiverObj = new JSONObject();
            receiverObj.put("id", receiver.getId());
            receiverObj.put("name", receiver.getName());
            receiverObj.put("dob", receiver.getPrettyDateOfBirth());
            receiverObj.put("summary", receiver.getSummary());
            receiverObj.put("balance", receiver.getBalance());
            obj.put("receiver", receiverObj);

            arr.put(obj);
        }

        return arr.toString();
    }

    @RequestMapping(value="/getDonators", method=RequestMethod.GET)
    @ResponseBody
    public String getDonators() {
        List<Donator> donators = donatorService.getAll();

        JSONArray arr = new JSONArray();
        for (Donator donator : donators) {
            JSONObject obj = new JSONObject();
            obj.put("id", donator.getId());
            obj.put("name", donator.getName());
            obj.put("email", donator.getEmail());
            obj.put("password", donator.getPassword());

            JSONArray donations = new JSONArray();
            donator.getDonations().forEach(d -> {
                JSONObject donation = new JSONObject();
                donation.put("amount", d.getAmount());
                donation.put("timestamp", d.getPrettyTimeStamp());
                donation.put("receiver", d.getReceiver().getName());
                donations.put(donation);
            });
            obj.put("donations", donations);
            arr.put(obj);
        }

        return arr.toString();
    }

    @RequestMapping(value="/getDonations", method=RequestMethod.GET)
    @ResponseBody
    public String getDonations() {
        List<Donation> donations = donationService.getAll();

        JSONArray arr = new JSONArray();
        for (Donation donation : donations) {
            JSONObject obj = new JSONObject();
            obj.put("id", donation.getId());
            obj.put("amount", donation.getAmount());
            obj.put("timestamp", donation.getPrettyTimeStamp());

            Donator donator = donation.getDonator();
            JSONObject donatorObj = new JSONObject();
            donatorObj.put("id", donator.getId());
            donatorObj.put("name", donator.getName());
            donatorObj.put("email", donator.getEmail());
            obj.put("donator", donatorObj);

            Receiver receiver = donation.getReceiver();
            JSONObject receiverObj = new JSONObject();
            receiverObj.put("id", receiver.getId());
            receiverObj.put("name", receiver.getName());
            receiverObj.put("dob", receiver.getPrettyDateOfBirth());
            receiverObj.put("summary", receiver.getSummary());
            receiverObj.put("balance", receiver.getBalance());
            obj.put("receiver", receiverObj);

            arr.put(obj);
        }

        return arr.toString();
    }
}
