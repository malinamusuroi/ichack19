package com.homelesshelper.controller;

import com.google.gson.Gson;
import com.homelesshelper.model.Receiver;
import com.homelesshelper.model.Vendor;
import com.homelesshelper.service.ReceiverService;
import com.homelesshelper.service.VendorService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    ReceiverService receiverService;

    @Autowired
    VendorService vendorService;

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
        Long id = object.getLong("id");
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

    @RequestMapping(value="/getFullReceiverInfoAndHistory", method=RequestMethod.POST, consumes="application/json")
    @ResponseBody
    public ResponseEntity getFullReceiverInfoAndHistory(@RequestBody String json) {
        JSONObject object = new JSONObject(json);
        Long id = object.getLong("id");

        Receiver receiver = receiverService.findBy(id);
        if (receiver == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        String receiversJson = new Gson().toJson(receiver);
        JSONObject obj = new JSONObject(receiversJson);
        obj.put("dob", receiver.getPrettyDateOfBirth());
        obj.remove("dateOfBirth");

        return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
    }

    @RequestMapping(value="/getCashierReceiverInfo", method=RequestMethod.POST, consumes="application/json")
    @ResponseBody
    public ResponseEntity getCashierReceiverInfo(@RequestBody String json) {
        JSONObject object = new JSONObject(json);
        Long id = object.getLong("id");

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
}
