package org.denizugurgenc02.clubweb_backend.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementDTO {

    private Integer id;

    private String title;

    private String description;
}
