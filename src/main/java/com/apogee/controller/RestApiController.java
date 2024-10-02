/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apogee.controller;

import com.apogee.request.TestOne;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author saini
 */
@RestController
public class RestApiController {

    @GetMapping("/getReq")
    public String getReq() {
        return "This is GET Response!";
    }

    @PostMapping("/postReq")
    public String postReq() {
        return "This is POST Response!";
    }

//    @PostMapping("/postReqData")
    @PostMapping(value = "/postReqData", consumes = "application/json", produces = "application/json")
    public Map<String, Object> postData(@RequestBody Map<String, Object> obj) {
        String result = "";
        Map<String, Object> jobj = new HashMap<>();
        try {
            result = obj.get("msg").toString();
            jobj.put("1", "hhhhh");
            jobj.put("2", "hi");
        } catch (Exception e) {
            System.out.println("com.apogee.controller.RestApiController.postData(): " + e);
        }
        return jobj;
    }

    @PostMapping("/postJSONReq")
    public ResponseEntity postJSONReq(@RequestBody TestOne req) {
        JSONObject jobj = new JSONObject();
        Map<String, String> data = new HashMap<>();
        try {
            jobj.put("1", "1");
            System.out.println("data: " + req.getMsg());            
            data.put("key1", "value1");
            data.put("key2", "value2");
        } catch (Exception e) {
            System.out.println("com.apogee.controller.RestApiController.postJSONReq(): " + e);
        }

        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
