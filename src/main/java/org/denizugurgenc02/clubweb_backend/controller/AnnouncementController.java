package org.denizugurgenc02.clubweb_backend.controller;

import org.denizugurgenc02.clubweb_backend.dto.AnnouncementDTO;
import org.denizugurgenc02.clubweb_backend.services.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @PostMapping("/add")
    public AnnouncementDTO addAnnouncement(@RequestBody AnnouncementDTO announcementDTO) {
        return announcementService.addAnnouncement(announcementDTO);
    }

    @GetMapping("/list")
    public List<AnnouncementDTO> getAllAnnouncement() {
        return announcementService.getAllAnnouncement();
    }

    @GetMapping("/{id}")
    public AnnouncementDTO getAnnouncement(@PathVariable Integer id) {
        return announcementService.getAnnouncement(id);
    }

    @PutMapping("/{id}")
    public AnnouncementDTO putAnnouncement(@PathVariable Integer id, @RequestBody AnnouncementDTO announcementDTO) {
        return announcementService.putAnnouncement(id, announcementDTO);
    }


    @DeleteMapping("/{id}")
    public AnnouncementDTO deleteAnnouncement(@PathVariable Integer id) {
        return announcementService.deleteAnnouncement(id);
    }
}
