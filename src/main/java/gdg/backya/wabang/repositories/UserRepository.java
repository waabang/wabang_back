package gdg.backya.wabang.repositories;

import gdg.backya.wabang.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
