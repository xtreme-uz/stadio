package uz.xtreme.stadio.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "image")
public class Image {
    @Id private UUID id;
    @Column(name = "position") private int position;
    @Column(name = "address_id") private Long addressId;
}
