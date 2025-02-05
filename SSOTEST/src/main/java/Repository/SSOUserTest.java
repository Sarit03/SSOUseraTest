package Repository;

import dev.danvega.SSOTEST.entity.SSOUserTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SSOUserTestRepository extends JpaRepository<SSOUserTest, LocalDateTime> {
}
