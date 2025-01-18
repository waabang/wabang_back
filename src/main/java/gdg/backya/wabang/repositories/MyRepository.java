package gdg.backya.wabang.repositories;

import gdg.backya.wabang.services.dtos.JoinedInfo;
import gdg.backya.wabang.domain.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepository extends JpaRepository<User, Long> {

  @Query(
      "select new gdg.backya.wabang.services.dtos.JoinedInfo(l.name, m.headImageUrl, l.streetAddress, r.success) "
      + "from Mission m "
      + "join Location l on m.locationId = l.id "
      + "join Record r on m.id = r.missionId "
          + "where r.userId = 1"
  )
  Slice<JoinedInfo> findAllJoinedMissionsInfo(PageRequest pageRequest);
}
