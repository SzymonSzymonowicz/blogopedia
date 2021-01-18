package com.szymonowicz.projekt.dto;

import com.szymonowicz.projekt.enums.PrivacyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    @NotEmpty(message = "Post Content can't be empty!")
    @Size(min = 10, max = 500, message = "Post content must be longer than 10 characters and shorter than 500")
    private String postContent;

    @NotEmpty(message = "Post tags can't be empty!")
    @Size(min = 3, max = 100, message = "Post tags must be longer than 3 characters and shorter than 100")
    private String tags;

    private PrivacyType privacyType;
}
