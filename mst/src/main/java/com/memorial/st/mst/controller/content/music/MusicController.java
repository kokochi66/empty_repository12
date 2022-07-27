package com.memorial.st.mst.controller.content.music;

import com.memorial.st.mst.domain.file.FileDTO;
import com.memorial.st.mst.domain.music.Music;
import com.memorial.st.mst.service.file.FileService;
import com.memorial.st.mst.service.file.repository.ContentFileRepository;
import com.memorial.st.mst.service.music.MusicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping(value = "/music")
public class MusicController {

    @Autowired
    private FileService fileService;
    @Autowired
    private MusicService musicService;


    @PostMapping("/insert")
    public String addNewMusic(Music music) throws IOException {
        log.info("/music/insert - " + music);

        music.setPoint(0L);
        music.setRegDate(LocalDateTime.now());
        music.setVolume(0.5F);
        musicService.upsertMusic(music);

//        if (!music.getMusicFile().isEmpty()) {
//            fileService.save(music.getMusicFile());
//        }
        return "redirect:/";
    }
}
