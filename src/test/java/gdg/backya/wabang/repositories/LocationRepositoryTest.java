package gdg.backya.wabang.repositories;

import gdg.backya.wabang.DataSourceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LocationRepositoryTest {

  @Autowired
  private LocationRepository locationRepository;

  @Test
  void findWhereNearby() {
    // given
    float latitude = 37.5665f;
    float longitude = 126.9780f;
    float distance = 5000f;
    int page = 0;
    int size = 10;

    // when
    var locations = locationRepository.findWhereNearby(latitude, longitude, distance, PageRequest.of(page, size));

    // then
    assertNotNull(locations);
  }
}