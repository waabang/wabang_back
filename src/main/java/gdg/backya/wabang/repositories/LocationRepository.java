package gdg.backya.wabang.repositories;

import gdg.backya.wabang.domain.Location;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LocationRepository extends JpaRepository<Location, Integer> {

//  @Query(
//      "select Location from Location l " + "where l.latitude = :latitude and l.longitude = :longitude"
//  )
  //Slice<Location> findWhereNearby(Float latitude, Float longitude, PageRequest pageRequest);
}
