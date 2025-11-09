package org.denizugurgenc02.clubweb_backend.services;

import jakarta.transaction.Transactional;
import org.denizugurgenc02.clubweb_backend.dto.ActivityDTO;
import org.denizugurgenc02.clubweb_backend.entities.Activity;
import org.denizugurgenc02.clubweb_backend.repository.ActivityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Transactional
    public ActivityDTO addActivity(ActivityDTO activityDTO) {
        Activity activity = new Activity();
        BeanUtils.copyProperties(activityDTO, activity);

        activityRepository.create(activity);
        return activityDTO;
    }

    public List<ActivityDTO> getActivitiyList() {
        List<Activity> activityList = activityRepository.readAll();
        List<ActivityDTO> activityDTOList = new ArrayList<>();
        for (Activity activity : activityList){
            ActivityDTO activityDTO = new ActivityDTO();
            BeanUtils.copyProperties(activity, activityDTO);
            activityDTOList.add(activityDTO);
        }
        return activityDTOList;
    }

    public ActivityDTO getActivity(Integer id) {
        Activity activity = activityRepository.read(id);
        ActivityDTO activityDTO = new ActivityDTO();
        BeanUtils.copyProperties(activity, activityDTO);
        return activityDTO;
    }

    @Transactional
    public ActivityDTO putActivity(Integer id, ActivityDTO activityDTO) {
        Activity existingActivity = activityRepository.read(id);
        if (existingActivity != null) {
            existingActivity.setDescription(activityDTO.getDescription());
            existingActivity.setTitle(activityDTO.getTitle());
            activityRepository.update(existingActivity);
        }

        return activityDTO;
    }

    @Transactional
    public ActivityDTO deleteActivity(Integer id) {
        Activity activity = activityRepository.read(id);
        activityRepository.delete(id);
        ActivityDTO activityDTO = new ActivityDTO();

        BeanUtils.copyProperties(activity, activityDTO);
        return activityDTO;
    }
}
