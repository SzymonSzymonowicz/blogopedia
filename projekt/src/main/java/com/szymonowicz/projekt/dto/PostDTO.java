package com.szymonowicz.projekt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    @NotEmpty(message = "Post Content can't be empty!")
    @Size(min = 10, max = 500, message = "Post content must be longer than 10 characters and shorter than 500")
    private String postContent;

    @NotEmpty(message = "Post tags can't be empty!")
    @Size(min = 3, max = 100, message = "Post tags must be longer than 3 characters and shorter than 100")
    private String tags;

    private long authorId;
}
