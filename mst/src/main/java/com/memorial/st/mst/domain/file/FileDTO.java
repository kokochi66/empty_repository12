package com.memorial.st.mst.domain.file;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {
    private String uuid;
    private String fildName;
    private String contentType;
}
