package com.memorial.st.mst.controller.content.game;

import com.memorial.st.mst.domain.file.ContentFile;
import com.memorial.st.mst.domain.music.Music;
import com.memorial.st.mst.service.file.ContentFileService;
import com.memorial.st.mst.service.music.MusicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequestMapping(value = "/game")
public class GameController {

    @Autowired
    private MusicService musicService;
    @Autowired
    private ContentFileService contentFileService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String gamePage(HttpServletResponse response, HttpServletRequest request) throws IOException {
        log.info("/game - gamePage");

        return "game";
    }

    @GetMapping(value = "/getData")
    @ResponseBody
    public List<Music> getMusicList() {
        Map<Long, List<ContentFile>> fileMap = contentFileService.getContentFileList().stream().collect(Collectors.groupingBy(ContentFile::getContentId));
        List<Music> musicList = musicService.getMusicList();
        musicList.forEach(music -> music.setContentFileList(fileMap.get(music.getMusicId())));
        return musicList;
    }
}
