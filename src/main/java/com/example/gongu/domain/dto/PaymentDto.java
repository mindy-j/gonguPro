package com.example.gongu.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PaymentDto {
   private Long paymentNumber;
   private int paymentAmount;
   private String paymentMerchantUid;
   private Long userNumber;
   private Long classNumber;
}
