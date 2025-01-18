package gdg.backya.wabang.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "locations")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Location extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Integer id;

    @Column(name = "latitude", nullable = false)
    private Float langtitude;

    @Column(name = "longitude", nullable = false)
    private Float longitude;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "street_address", nullable = false)
    private String streetAddress;

    @OneToMany(mappedBy = "location")
    private List<Tag> tags;
}
