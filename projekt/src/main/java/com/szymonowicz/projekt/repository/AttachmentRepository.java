package com.szymonowicz.projekt.repository;

import com.szymonowicz.projekt.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

}
