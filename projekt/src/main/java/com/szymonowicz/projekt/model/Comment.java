package com.szymonowicz.projekt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @NotEmpty(message = "Comment content can't be empty!")
    @Size(min = 2, max = 300, message = "Comment content must be longer than 2 characters and shorter than 300")
    private String commentContent;
}
