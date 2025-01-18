package gdg.backya.wabang.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Record extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="user_id", nullable = false)
    private Integer userId;

    @Column(name="mission_id", nullable = false)
    private Integer missionId;

    @Setter
    private boolean success;

    public Record(Integer userId, Integer missionId, boolean success) {
        this.userId = userId;
        this.missionId = missionId;
      this.success = success;
    }
}
