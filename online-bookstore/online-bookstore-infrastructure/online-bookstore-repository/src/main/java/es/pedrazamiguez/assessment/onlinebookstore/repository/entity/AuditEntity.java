package es.pedrazamiguez.assessment.onlinebookstore.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Data;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Audited
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class AuditEntity {

  @CreatedBy
  @Column(name = "created_by", updatable = false, nullable = false)
  private String createdBy;

  @CreatedDate
  @Column(name = "created_at", updatable = false, nullable = false)
  private LocalDateTime createdAt;

  @LastModifiedBy
  @Column(name = "updated_by", nullable = false)
  private String updatedBy;

  @LastModifiedDate
  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;
}
