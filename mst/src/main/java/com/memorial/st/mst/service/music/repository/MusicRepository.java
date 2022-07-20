package com.memorial.st.mst.service.music.repository;

import com.memorial.st.mst.domain.music.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {
}
