package com.starlord0302.videoplaylist.repositories;

import com.starlord0302.videoplaylist.models.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<PlayList, Long> {
}
