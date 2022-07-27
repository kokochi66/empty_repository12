package com.memorial.st.mst.domain.file;

import com.memorial.st.mst.domain.file.model.FileType;
import com.memorial.st.mst.domain.music.model.MusicType;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(ContentFilePK.class)
@Table(name = "mst_content_file")
public class ContentFile {
    @Id
    private Long contentId;
    @Id
    private FileType fileType;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private String fileSrc;

    private Integer highlight;

    @Transient
    private MultipartFile saveFile;
}
