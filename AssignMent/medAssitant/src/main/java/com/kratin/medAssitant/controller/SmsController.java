package com.kratin.medAssitant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kratin.medAssitant.service.SmsService;
import com.kratin.medAssitant.sms.SmsMessage;

@CrossOrigin
@RestController
@RequestMapping
public class SmsController {
    private final SmsService smsSchedulerService;

    @Autowired
    public SmsController(SmsService smsSchedulerService) {
        this.smsSchedulerService = smsSchedulerService;
    }

    @PostMapping("/send-sms")
    public void sendSms(@RequestBody SmsMessage smsMessage) {
        smsSchedulerService.sendSms(smsMessage);
    }
}

