package com.memorial.st.mst.domain.music;

import com.memorial.st.mst.domain.file.ContentFile;
import com.memorial.st.mst.domain.music.model.MusicType;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;


@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mst_music")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long musicId;
    private Long point;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

    private String title;
    private String vocal;
    private String composition;
    private Float volume;
    private MusicType musicType;

    @Transient
    private List<ContentFile> contentFileList;
    @Transient
    private MultipartFile musicFile;
    @Transient
    private MultipartFile musicMainImg;
    @Transient
    private Integer highlight;
}
