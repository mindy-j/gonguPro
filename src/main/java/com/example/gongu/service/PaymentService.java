package com.example.gongu.service;

import com.example.gongu.domain.dto.PaymentDto;
import com.example.gongu.domain.vo.PaymentCriteria;
import com.example.gongu.domain.vo.admin.AdminClassVo;
import com.example.gongu.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PaymentService {
    private final PaymentMapper paymentMapper;

    public void registerPay(PaymentDto paymentDto){
        paymentMapper.insertPay(paymentDto);
    }

//    결제 목록 조회
    public List<AdminClassVo> findPay(PaymentCriteria paymentCriteria){
        return paymentMapper.selectPay(paymentCriteria);
    }

//    결제 목록 수 조회
    public int findPayTotal(Long userNumber){
        return paymentMapper.selectPayTotal(userNumber);
    }

//    클래스 레벨 변경
    public void modifyClass(Long classNumber){
        paymentMapper.updateClass(classNumber);
    }
}