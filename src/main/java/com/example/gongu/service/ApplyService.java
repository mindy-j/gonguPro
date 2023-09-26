package com.example.gongu.service;

import com.example.gongu.domain.dto.MentoApplyDto;
import com.example.gongu.mapper.ApplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ApplyService {
    private final ApplyMapper applyMapper;
    private final FileService fileService;

    public void register(MentoApplyDto mentoApplyDto){
        applyMapper.insert(mentoApplyDto);
    }

    public void registerAndFileProc(MentoApplyDto mentoApplyDto, List<MultipartFile> files){
        register(mentoApplyDto);

        if(files.isEmpty()) { return; }

        try {
            fileService.registerAndSaveFile(files, mentoApplyDto.getApplyNumber());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
