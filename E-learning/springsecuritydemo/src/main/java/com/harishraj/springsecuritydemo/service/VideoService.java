package com.harishraj.springsecuritydemo.service;

import com.harishraj.springsecuritydemo.model.Video;
import com.harishraj.springsecuritydemo.repo.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public Optional<Video> getVideoById(Long id) {
        return videoRepository.findById(id);
    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Video saveVideo(Video video) {
        videoRepository.save(video);
        return video;
    }

    public void updateVideo(Long id, Video videoDetails) {
        Video video = videoRepository.findById(id).orElseThrow();
        video.setName(videoDetails.getName());
        video.setDescription(videoDetails.getDescription());
        video.setContent(videoDetails.getContent());
        videoRepository.save(video);
    }

    public void deleteVideo(Long id) {
        videoRepository.deleteById(id);
    }
}
