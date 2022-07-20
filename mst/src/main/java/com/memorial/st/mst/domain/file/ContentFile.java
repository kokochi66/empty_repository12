package com.memorial.st.mst.domain.file;

import com.memorial.st.mst.domain.file.model.FileType;
import com.memorial.st.mst.domain.music.model.MusicType;
import lombok.*;

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

    private Long point;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

    private String fileSrc;
    private String vocal;
    private String composition;
    private MusicType musicType;
}
