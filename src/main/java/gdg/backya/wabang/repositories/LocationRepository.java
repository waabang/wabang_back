package gdg.backya.wabang.repositories;

import gdg.backya.wabang.domain.Location;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LocationRepository extends JpaRepository<Location, Integer> {

  @Query(
      value = "SELECT * FROM locations l "
          + "WHERE ST_Distance_Sphere(Point(:longitude, :latitude), l.coordinate) < :distance",
      nativeQuery = true
  )
  Slice<Location> findWhereNearby(@Param("latitude") float latitude, @Param("longitude") float longitude, @Param("distance") float distance, PageRequest pageRequest);

}
