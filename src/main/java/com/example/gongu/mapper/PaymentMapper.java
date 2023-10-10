package com.example.gongu.mapper;

import com.example.gongu.domain.dto.PaymentDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {
    public void insertPay(PaymentDto paymentDto);
}
