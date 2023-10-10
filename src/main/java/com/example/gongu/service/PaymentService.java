package com.example.gongu.service;

import com.example.gongu.domain.dto.PaymentDto;
import com.example.gongu.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PaymentService {
    private final PaymentMapper paymentMapper;

    public void registerPay(PaymentDto paymentDto){
        paymentMapper.insertPay(paymentDto);
    }
}