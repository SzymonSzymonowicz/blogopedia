package com.szymonowicz.projekt.model;

import com.szymonowicz.projekt.enums.PrivacyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String postContent;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinTable(name = "post_tag",
            joinColumns = { @JoinColumn(name = "post_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id")}
    )
    private Set<Tag> tags = new HashSet<>();

    @ToString.Exclude
    @OneToMany(targetEntity = Attachment.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private List<Attachment> attachments = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private List<Comment> comments = new ArrayList<>();

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST
    })
    @JoinTable(name = "post_author",
            joinColumns = { @JoinColumn(name = "post_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id")}
    )
    private Set<Author> authors = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private PrivacyType privacyType;
}
