package com.memorial.st.mst.service.file;

import com.memorial.st.mst.domain.file.ContentFile;
import com.memorial.st.mst.service.file.repository.ContentFileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ContentFileService {

    @Autowired
    private ContentFileRepository contentFileRepository;
    @Autowired
    private FileService fileService;


    public List<ContentFile> getContentFileList() {
        return contentFileRepository.findAll();
    }

    public List<ContentFile> getContentFileListByContentId(Long contentId) {
        return contentFileRepository.findAllByContentId(contentId);
    }

    @Transactional
    public void upsertContentFile(ContentFile contentFile) {
        if (contentFile.getSaveFile() != null) {
            String fileName = fileService.save(contentFile.getSaveFile());
            contentFile.setFileSrc(fileName);
        }
        contentFile.setModDate(LocalDateTime.now());
        contentFileRepository.save(contentFile);
    }

    public void deleteContentFile(ContentFile contentFile) {
        fileService.deleteByFileName(contentFile.getFileSrc());
        contentFileRepository.delete(contentFile);
    }


}
