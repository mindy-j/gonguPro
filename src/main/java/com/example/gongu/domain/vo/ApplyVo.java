package com.example.gongu.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ApplyVo {
    private Long applyNumber;
    private String applyEducation; //학력
    private String applyGraduate; //졸업 여부
    private String applyCareer; //경력
    private String applyCerti; //자격증
    private Long userNumber;
    private String userId; //필요한가?
    private String fileName;
    private String fileUploadPath;
    private String fileUuid;

}
