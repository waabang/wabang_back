package gdg.backya.wabang.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RecordRepository extends JpaRepository<Record, Integer> {

  @Query("SELECT r FROM Record r WHERE r.userId = :userId AND r.missionId = :missionId")
  Optional<Record> findByUserIdAndRecordId(@Param("userId") Integer userId, @Param("missionId") Integer missionId);
}