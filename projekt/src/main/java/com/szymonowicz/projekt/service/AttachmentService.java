package com.szymonowicz.projekt.service;

import com.szymonowicz.projekt.model.Attachment;
import com.szymonowicz.projekt.repository.AttachmentRepository;
import org.springframework.stereotype.Service;

@Service
public class AttachmentService {
    private final AttachmentRepository attachmentRepository;

    public AttachmentService(AttachmentRepository attachmentRepository){
        this.attachmentRepository = attachmentRepository;
    }

    public void saveAttachment(Attachment attachment){
        attachmentRepository.save(attachment);
    }



}
