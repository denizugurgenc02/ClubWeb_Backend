package org.denizugurgenc02.clubweb_backend.controller;


import org.denizugurgenc02.clubweb_backend.dto.ActivityDTO;
import org.denizugurgenc02.clubweb_backend.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping(path = "/add")
    public ActivityDTO addActivity(@RequestBody ActivityDTO activity) {
        return activityService.addActivity(activity);
    }

    @GetMapping(path = "/list")
    public List<ActivityDTO> getActivitiyList() {
        return activityService.getActivitiyList();
    }

    @GetMapping(path = "/{id}")
    public ActivityDTO getActivity(@PathVariable("id") Integer id) {
        return activityService.getActivity(id);
    }

    @PutMapping(path = "/{id}")
    public ActivityDTO putActivity(@PathVariable("id") Integer id, @RequestBody ActivityDTO activity) {
        return activityService.putActivity(id, activity);
    }

    @DeleteMapping(path = "/{id}")
    public ActivityDTO deleteActivity(@PathVariable("id") Integer id) {
        return activityService.deleteActivity(id);
    }


}
