package com.example.gongu.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ImageDto {
    Long fileNumber;
    String fileName;
    String fileUploadPath;
    String fileUuid;
    Long applyNumber;
}
