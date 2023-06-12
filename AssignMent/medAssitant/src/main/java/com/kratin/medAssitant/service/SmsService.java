package com.kratin.medAssitant.service;

import com.kratin.medAssitant.configuration.TwilioConfig;
import com.kratin.medAssitant.sms.SmsMessage;
import com.twilio.Twilio;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    private final TwilioConfig twilioConfig;

    @Autowired
    public SmsService(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }

//    public void sendSms(String toPhoneNumber, String message) {
//        PhoneNumber fromPhoneNumber = new PhoneNumber("+15074193668");
//        PhoneNumber to = new PhoneNumber(toPhoneNumber);
//
//        Message.creator(to, fromPhoneNumber, message).create(new TwilioRestClient.Builder(twilioConfig.getAccountSid(), twilioConfig.getAuthToken()).build());
//    }
    
    public void sendSms(SmsMessage smsMessage) {
        // Check if the current time matches the desired send time
        LocalTime currentTime = LocalTime.now();
        if (currentTime.isAfter(smsMessage.getSendTime())) {
            // Send the SMS immediately
            doSendSms(smsMessage);
        } else {
            // Schedule the SMS to be sent at the specified time
            scheduleSms(smsMessage);
        }
    }

    
    private void doSendSms(SmsMessage smsMessage) {
        // Initialize the Twilio REST client with your account SID and auth token
        Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());

        // Create the necessary Twilio objects for sending the SMS
        PhoneNumber fromPhoneNumber = new PhoneNumber("+15074193668");
        PhoneNumber toPhoneNumber = new PhoneNumber(smsMessage.getToPhoneNumber());

        // Build the message
        Message message = Message.creator(toPhoneNumber, fromPhoneNumber, smsMessage.getMessage()).create();

        // Handle the response from Twilio
        if (message.getStatus() == Message.Status.FAILED) {
            // SMS sending failed
            System.out.println("Failed to send SMS: " + message.getErrorMessage());
        } else {
            // SMS sent successfully
            System.out.println("SMS sent successfully! SID: " + message.getSid());
        }
    }
    
    private void scheduleSms(SmsMessage smsMessage) {
        long delay = Duration.between(LocalTime.now(), smsMessage.getSendTime()).toMillis();

        TimerTask task = new TimerTask() {
            public void run() {
                doSendSms(smsMessage);
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, delay);
    }


}

