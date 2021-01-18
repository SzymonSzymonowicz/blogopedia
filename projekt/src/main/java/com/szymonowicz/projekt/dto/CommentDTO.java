package com.szymonowicz.projekt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

    @NotEmpty(message = "Comment content can't be empty!")
    @Size(min = 16, max = 300, message = "Comment content must be longer than 16 characters and shorter than 300")
    private String commentContent;
}
