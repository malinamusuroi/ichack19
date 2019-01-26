package com.homelesshelper.controller;

import com.google.gson.Gson;
import com.homelesshelper.model.Receiver;
import com.homelesshelper.model.Vendor;
import com.homelesshelper.service.ReceiverService;
import com.homelesshelper.service.VendorService;
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

    @RequestMapping(value="/getReceivers", method=RequestMethod.GET)
    @ResponseBody
    public String getReceivers() {
        List<Receiver> receivers = receiverService.getAll();
        String json = new Gson().toJson(receivers);
        return json;
    }

    @RequestMapping(value="/getVendors", method=RequestMethod.GET)
    @ResponseBody
    public String getVendors() {
        List<Vendor> vendors = vendorService.getAll();
        String json = new Gson().toJson(vendors);
        return json;
    }
}
