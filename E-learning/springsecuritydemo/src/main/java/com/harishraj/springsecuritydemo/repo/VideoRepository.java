package com.harishraj.springsecuritydemo.repo;
import com.harishraj.springsecuritydemo.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}

