package com.memorial.st.mst.domain.file;

import com.memorial.st.mst.domain.file.model.FileType;
import com.memorial.st.mst.domain.music.model.MusicType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ContentFilePK implements Serializable {
    private static final long serialVersionUID = -3527741493770935982L;
    private Long contentId;
    private FileType fileType;
}
