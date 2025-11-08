package org.denizugurgenc02.clubweb_backend.services;

import jakarta.transaction.Transactional;
import org.denizugurgenc02.clubweb_backend.dto.AnnouncementDTO;
import org.denizugurgenc02.clubweb_backend.entities.Announcement;
import org.denizugurgenc02.clubweb_backend.repository.AnnouncementRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnouncementService {

    @Autowired
    AnnouncementRepository announcementRepository;

    @Transactional
    public AnnouncementDTO addAnnouncement(@RequestBody AnnouncementDTO announcementDTO) {
        Announcement announcement = new Announcement();
        BeanUtils.copyProperties(announcementDTO, announcement);

        announcementRepository.create(announcement);
        return announcementDTO;
    }

    public List<AnnouncementDTO> getAllAnnouncement() {
        List<Announcement> announcementList = announcementRepository.readAll();
        List<AnnouncementDTO> announcementDTOList = new ArrayList<>();

        for (Announcement announcement : announcementList) {
            AnnouncementDTO announcementDTO = new AnnouncementDTO();
            BeanUtils.copyProperties(announcement, announcementDTO);

            announcementDTOList.add(announcementDTO);
        }
        return announcementDTOList;
    }

    public AnnouncementDTO getAnnouncement(@RequestBody Integer id) {
        Announcement announcement = announcementRepository.read(id);
        AnnouncementDTO announcementDTO = new AnnouncementDTO();

        BeanUtils.copyProperties(announcement, announcementDTO);
        return announcementDTO;
    }

    @Transactional
    public AnnouncementDTO putAnnouncement(@RequestBody Integer id, AnnouncementDTO announcementDTO) {
        Announcement existingAnnouncement = announcementRepository.read(id);

        if (existingAnnouncement != null) {
            existingAnnouncement.setTitle(announcementDTO.getTitle());
            existingAnnouncement.setDescription(announcementDTO.getDescription());

            announcementRepository.update(existingAnnouncement);
        }
        return announcementDTO;
    }

    @Transactional
    public AnnouncementDTO patchAnnouncement(@RequestBody Integer id, AnnouncementDTO announcementDTO) {
        Announcement existingAnnouncement = announcementRepository.read(id);

        if (existingAnnouncement != null) {
            existingAnnouncement.setTitle(announcementDTO.getTitle());
            existingAnnouncement.setDescription(announcementDTO.getDescription());

            announcementRepository.update(existingAnnouncement);
        }
        return announcementDTO;
    }

    @Transactional
    public AnnouncementDTO deleteAnnouncement(@RequestBody Integer id) {
        Announcement announcement = announcementRepository.read(id);
        AnnouncementDTO announcementDTO = new AnnouncementDTO();

        BeanUtils.copyProperties(announcement, announcementDTO);
        return announcementDTO;
    }
}
