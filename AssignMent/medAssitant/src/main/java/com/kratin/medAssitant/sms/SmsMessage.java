package com.kratin.medAssitant.sms;

import java.time.LocalTime;

public class SmsMessage {
    private String toPhoneNumber;
    private String message;
    private LocalTime sendTime;



    public String getToPhoneNumber() {
        return toPhoneNumber;
    }

    public void setToPhoneNumber(String toPhoneNumber) {
        this.toPhoneNumber = toPhoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public LocalTime getSendTime() {
		return sendTime;
	}

	public void setSendTime(LocalTime sendTime) {
		this.sendTime = sendTime;
	}
    
    
}

