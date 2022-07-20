package com.memorial.st.mst.service.music;

import com.memorial.st.mst.domain.music.Music;
import com.memorial.st.mst.service.music.repository.MusicRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public List<Music> getMusicList() {
        return musicRepository.findAll();
    }

    public Music getMusicByMusicId(Long musicId) {
        return musicRepository.getById(musicId);
    }

    public void upsertMusic(Music music) {
        music.setModDate(LocalDateTime.now());
        musicRepository.save(music);
    }

    public void deleteMusicByMusicId(Long musicId) {
        musicRepository.deleteById(musicId);
    }
}
