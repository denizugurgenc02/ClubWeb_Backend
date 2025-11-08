package org.denizugurgenc02.clubweb_backend.services;

import org.denizugurgenc02.clubweb_backend.dto.AnnouncementDTO;
import org.denizugurgenc02.clubweb_backend.entities.Announcement;
import org.denizugurgenc02.clubweb_backend.repository.AnnouncementRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnouncementService {

    @Autowired
    AnnouncementRepository announcementRepository;


    public AnnouncementDTO add(AnnouncementDTO dto) {
        Announcement announcement = new Announcement();
        BeanUtils.copyProperties(dto, announcement);

        announcementRepository.create(announcement);
        return dto;
    }

    public List<AnnouncementDTO> getAll() {

    }

    public AnnouncementDTO getById(Integer id) {
        Announcement announcement = announcementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Announcement not found"));
        return toDTO(announcement);
    }

    public AnnouncementDTO update(Integer id, AnnouncementDTO dto) {
        Announcement announcement = announcementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Announcement not found"));

        announcement.setTitle(dto.getTitle());
        announcement.setDescription(dto.getDescription());

        Announcement updated = announcementRepository.save(announcement);
        return toDTO(updated);
    }

    public AnnouncementDTO delete(Integer id) {
        Announcement announcement = announcementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Announcement not found"));

        announcementRepository.delete(announcement);
        return toDTO(announcement);
    }

    private AnnouncementDTO toDTO(Announcement entity) {
        return new AnnouncementDTO(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription()
        );
    }
}
