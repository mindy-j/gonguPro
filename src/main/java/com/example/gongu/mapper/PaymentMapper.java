package com.example.gongu.mapper;

import com.example.gongu.domain.dto.PaymentDto;
import com.example.gongu.domain.vo.PaymentCriteria;
import com.example.gongu.domain.vo.admin.AdminClassVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentMapper {
    public void insertPay(PaymentDto paymentDto);

//    결제 목록 조회
    public List<AdminClassVo> selectPay(PaymentCriteria paymentCriteria);

//    결제 목록 수
    public int selectPayTotal(@Param("userNumber") Long userNumber);

//    클래스 레벨 수정
    public void updateClass(Long classNumber);
}
