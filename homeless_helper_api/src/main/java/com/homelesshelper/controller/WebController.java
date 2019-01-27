package com.homelesshelper.controller;

import com.homelesshelper.model.*;
import com.homelesshelper.service.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
public class WebController {

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

    @RequestMapping(value="/registerReceiver", method=RequestMethod.POST, consumes="application/json")
    @ResponseBody
    public ResponseEntity registerReceiver(@RequestBody String json) {
        JSONObject object = new JSONObject(json);
        String name = object.getString("name");
        Long dobEpoch = object.getLong("dob");
        String summary = object.getString("summary");

        Receiver newReceiver = new Receiver(name, dobEpoch, summary);
        receiverService.save(newReceiver);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/updateReceiver", method=RequestMethod.POST, consumes="application/json")
    @ResponseBody
    public ResponseEntity updateReceiver(@RequestBody String json) {
        JSONObject object = new JSONObject(json);
        Long id = object.getLong("receiver_id");
        String summary = object.getString("summary");

        Boolean success = receiverService.update(id, summary);
        if (!success) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/searchForReceiver", method=RequestMethod.POST, consumes="application/json")
    @ResponseBody
    public ResponseEntity searchForReceiver(@RequestBody String json) {
        JSONObject object = new JSONObject(json);
        String name = object.getString("name");
        Long dob = object.getLong("dob");

        List<Receiver> receivers = receiverService.findBy(name, dob);
        if (receivers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        JSONArray out = new JSONArray();
        for (int i = 0; i < receivers.size(); i++) {
            JSONObject obj = new JSONObject();
            obj.put("id", receivers.get(i).getId());
            obj.put("name", receivers.get(i).getName());
            obj.put("dob", receivers.get(i).getPrettyDateOfBirth());
            obj.put("summary", receivers.get(i).getSummary());
            out.put(obj);
        }

        return new ResponseEntity<>(out.toString(), HttpStatus.OK);
    }

    @RequestMapping(value="/getFullReceiverInfoAndHistory/{id}", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getFullReceiverInfoAndHistory(@PathVariable(value = "id") Long id) {

        Receiver receiver = receiverService.findBy(id);
        if (receiver == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

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

        return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
    }

    @RequestMapping(value="/getCashierReceiverInfo/{id}", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getCashierReceiverInfo(@PathVariable(value = "id") Long id) {

        Receiver receiver = receiverService.findBy(id);
        if (receiver == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        JSONObject obj = new JSONObject();
        obj.put("name", receiver.getName());
        obj.put("dob", receiver.getPrettyDateOfBirth());
        obj.put("balance", receiver.getBalance());

        return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
    }

    @RequestMapping(value="/getBasicReceiverInfo/{id}", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getBasicReceiverInfo(@PathVariable(value = "id") Long id) {

        Receiver receiver = receiverService.findBy(id);
        if (receiver == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        JSONObject obj = new JSONObject();
        obj.put("name", receiver.getName());
        obj.put("summary", receiver.getSummary());

        return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
    }

    @RequestMapping(value="/registerVendor", method=RequestMethod.POST, consumes="application/json")
    @ResponseBody
    public ResponseEntity registerVendor(@RequestBody String json) {
        JSONObject object = new JSONObject(json);
        String name = object.getString("name");
        String email = object.getString("email");
        String password = object.getString("password");

        Vendor vendor = new Vendor(name, email, password);
        vendorService.save(vendor);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/makeTransaction", method=RequestMethod.POST, consumes="application/json")
    @ResponseBody
    public ResponseEntity makeTransaction(@RequestBody String json) {
        JSONObject object = new JSONObject(json);
        Float amount = object.getFloat("amount");
        String description = object.getString("description");
        Long vendorId = object.getLong("vendor_id");
        Long receiverId = object.getLong("receiver_id");

        Vendor vendor = vendorService.findBy(vendorId);
        Receiver receiver = receiverService.findBy(receiverId);

        Transaction transaction = new Transaction(amount, description, vendor, receiver);
        vendor.addTransaction(transaction);
        receiver.addTransaction(transaction);

        transactionService.save(transaction);
        vendorService.save(vendor);
        receiverService.save(receiver);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/registerDonator", method=RequestMethod.POST, consumes="application/json")
    @ResponseBody
    public ResponseEntity registerDonator(@RequestBody String json) {
        JSONObject object = new JSONObject(json);
        String name = object.getString("name");
        String email = object.getString("email");
        String password = object.getString("password");

        Donator donator = new Donator(name, email, password);
        donatorService.save(donator);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/sendDonation", method=RequestMethod.POST, consumes="application/json")
    @ResponseBody
    public ResponseEntity sendDonation(@RequestBody String json) {
        JSONObject object = new JSONObject(json);

        Float amount = object.getFloat("amount");
        Long donatorId = object.getLong("donator_id");
        Long receiverId = object.getLong("receiver_id");

        Donator donator = donatorService.findBy(donatorId);
        Receiver receiver = receiverService.findBy(receiverId);

        Donation donation = new Donation(amount, donator, receiver);
        donator.addDonation(donation);
        receiver.addDonation(donation);

        donationService.save(donation);
        donatorService.save(donator);
        receiverService.save(receiver);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="/getDonatorStats/{id}", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getDonatorStats(@PathVariable(value = "id") Long donatorId) {

        Donator donator = donatorService.findBy(donatorId);
        List<Donation> donations = donator.getDonations();

        JSONObject out = new JSONObject();

        JSONArray donationsArr = new JSONArray();
        for (Donation donation : donations) {
            JSONObject obj = new JSONObject();
            obj.put("amount", donation.getAmount());
            obj.put("timestamp", donation.getPrettyTimeStamp());

            Receiver receiver = donation.getReceiver();
            JSONObject receiverObj = new JSONObject();
            receiverObj.put("id", receiver.getId());
            receiverObj.put("name", receiver.getName());
            obj.put("receiver", receiverObj);

            donationsArr.put(obj);
        }
        out.put("donations", donationsArr);

        return new ResponseEntity(out.toString(), HttpStatus.OK);
    }

}
