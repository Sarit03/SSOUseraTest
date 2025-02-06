package dev.danvega.SSOTEST.Repository;

import dev.danvega.SSOTEST.Entity.SSOUserTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SSOUserTestRepository extends JpaRepository<SSOUserTestEntity, Long> {
}
