package uz.xtreme.stadio.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "image")
@EntityListeners(AuditingEntityListener.class)
public class Image {
    @Id private UUID id;
    @CreatedDate private LocalDateTime created;
    @Column(name = "extension") private String ext;
    @Column(name = "position") private Integer position;
    @Column(name = "address_id") private Long addressId;
}
