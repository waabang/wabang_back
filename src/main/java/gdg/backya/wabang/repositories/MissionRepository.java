package gdg.backya.wabang.repositories;

import gdg.backya.wabang.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MissionRepository extends JpaRepository<Mission, Integer> {
  @Query(
      value = "SELECT Mission FROM Mission m "
          + "WHERE m.locationId = :missionId"
  )
  Optional<Mission> findByLocationId(Integer missionId);
}
