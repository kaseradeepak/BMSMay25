package com.scaler.bmsmay25.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseModel {
    private int amount;
    private String referenceId;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
}
