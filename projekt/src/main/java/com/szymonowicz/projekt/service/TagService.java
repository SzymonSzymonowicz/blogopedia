package com.szymonowicz.projekt.service;

import com.szymonowicz.projekt.model.Tag;
import com.szymonowicz.projekt.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository){
        this.tagRepository = tagRepository;
    }

    public void saveTag(Tag tag){
        tagRepository.save(tag);
    }

    public Set<Tag> getTagsFromString(String tagsStr){
        HashSet<Tag> tags = new HashSet<>();

        Arrays.stream(tagsStr.split(" ")).forEach(tagStr -> {
            Optional<Tag> tagOptional = tagRepository.findByTagName(tagStr);

            if(tagOptional.isEmpty())
                tags.add(new Tag(){{setTagName(tagStr);}});
            else
                tags.add(tagOptional.get());
        });

        return tags;
    }

    public void deleteTag(long id) {
        Optional<Tag> tagOptional = tagRepository.findById(id);

        if(tagOptional.isEmpty())
            return;

        tagRepository.delete(tagOptional.get());
    }
}
