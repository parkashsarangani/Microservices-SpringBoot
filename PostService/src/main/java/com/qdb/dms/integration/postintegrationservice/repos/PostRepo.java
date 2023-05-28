package com.qdb.dms.integration.postintegrationservice.repos;

import com.qdb.dms.integration.postintegrationservice.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findAllByUserId(long userId);
}
