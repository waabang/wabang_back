package gdg.backya.wabang.repositories;

import gdg.backya.wabang.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Integer> {
}
