package com.memorial.st.mst.service.music;

import com.memorial.st.mst.domain.file.ContentFile;
import com.memorial.st.mst.domain.file.model.FileType;
import com.memorial.st.mst.domain.music.Music;
import com.memorial.st.mst.service.file.ContentFileService;
import com.memorial.st.mst.service.music.repository.MusicRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;
    @Autowired
    private ContentFileService contentFileService;

    public List<Music> getMusicList() {
        return musicRepository.findAll();
    }

    public Music getMusicByMusicId(Long musicId) {
        return musicRepository.getById(musicId);
    }

    @Transactional
    public void upsertMusic(Music music) {
        music.setModDate(LocalDateTime.now());
        Music save = musicRepository.save(music);
        if(music.getMusicFile() != null) {
            contentFileService.upsertContentFile(ContentFile.builder()
                            .contentId(save.getMusicId())
                            .fileType(FileType.SONG)
                            .regDate(LocalDateTime.now())
                            .saveFile(music.getMusicFile())
                            .highlight(music.getHighlight())
                    .build());
        }
    }

    public void deleteMusicByMusicId(Long musicId) {
        musicRepository.deleteById(musicId);
    }
}
