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
    public AnnouncementDTO add(@RequestBody AnnouncementDTO dto) {
        return announcementService.add(dto);
    }

    @GetMapping("/list")
    public List<AnnouncementDTO> getAll() {
        return announcementService.getAll();
    }

    @GetMapping("/{id}")
    public AnnouncementDTO getById(@PathVariable Integer id) {
        return announcementService.getById(id);
    }

    @PutMapping("/{id}")
    public AnnouncementDTO update(@PathVariable Integer id, @RequestBody AnnouncementDTO dto) {
        return announcementService.update(id, dto);
    }


    @DeleteMapping("/{id}")
    public AnnouncementDTO delete(@PathVariable Integer id) {
        return announcementService.delete(id);
    }
}
