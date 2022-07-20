package com.memorial.st.mst.controller.content.music;

import com.memorial.st.mst.domain.file.FileDTO;
import com.memorial.st.mst.domain.music.Music;
import com.memorial.st.mst.service.file.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping(value = "/music")
public class MusicController {

    @Autowired
    private FileService fileService;


    @PostMapping("/insert")
    public String addNewMusic(Music music) throws IOException {
        log.info("/music/insert - " + music);

        if (!music.getMusicFile().isEmpty()) {
            FileDTO dto = new FileDTO(UUID.randomUUID().toString(), music.getMusicFile().getOriginalFilename(), music.getMusicFile().getContentType());
            File newFileName = new File("uploads/" + dto.getUuid() + "_" + dto.getFildName());
            log.info("download path :: " + newFileName.getPath());
            fileService.save(music.getMusicFile());
        }
        return "redirect:/";
    }
}
