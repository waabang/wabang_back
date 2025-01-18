package gdg.backya.wabang.domain;

import gdg.backya.wabang.domain.enums.MissionType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Mission extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Integer id;

    @Column(name="created_at", nullable = false)
    private Integer locationId;

    private String title;

    private String quiz;

    private String headImageUrl;

    @Column(name="reward", nullable = false)
    @ColumnDefault("0")
    private Integer rewardPoint;

    @Enumerated(EnumType.STRING)
    private MissionType type;


}
