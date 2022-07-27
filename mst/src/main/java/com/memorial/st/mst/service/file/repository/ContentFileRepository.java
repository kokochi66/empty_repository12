package com.memorial.st.mst.service.file.repository;

import com.memorial.st.mst.domain.file.ContentFile;
import com.memorial.st.mst.domain.file.ContentFilePK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentFileRepository extends JpaRepository<ContentFile, ContentFilePK> {

    List<ContentFile> findAllByContentId(Long contentId);
}
