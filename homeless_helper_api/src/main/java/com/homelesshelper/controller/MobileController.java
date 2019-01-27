package com.homelesshelper.controller;

import com.homelesshelper.model.Receiver;
import com.homelesshelper.service.ReceiverService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MobileController {

    @Autowired
    ReceiverService receiverService;

    @RequestMapping(value="/receiver/{id}", method= RequestMethod.GET)
    public ResponseEntity getReceiver(@PathVariable(value = "id") Long id) {

        Receiver receiver = receiverService.findBy(id);
        if (receiver == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        JSONObject obj = new JSONObject();
        obj.put("id", receiver.getId());
        obj.put("name", receiver.getName());
        obj.put("info", receiver.getSummary());
        obj.put("balance", receiver.getBalance());

        return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
    }

    @RequestMapping(value="/balance/{id}", method= RequestMethod.GET)
    public ResponseEntity getBalance(@PathVariable(value = "id") Long id) {

        Receiver receiver = receiverService.findBy(id);
        if (receiver == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        JSONObject obj = new JSONObject();
        obj.put("id", receiver.getId());
        obj.put("balance", receiver.getBalance());

        return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
    }
}
