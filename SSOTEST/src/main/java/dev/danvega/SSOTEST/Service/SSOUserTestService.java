package dev.danvega.SSOTEST.Service;

import dev.danvega.SSOTEST.Entity.SSOUserTestEntity;
import dev.danvega.SSOTEST.Repository.SSOUserTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SSOUserTestService {

    private final SSOUserTestRepository ssoUserTestRepository;

    @Autowired
    public SSOUserTestService(SSOUserTestRepository ssoUserTestRepository) {
        this.ssoUserTestRepository = ssoUserTestRepository;
    }

    // ฟังก์ชันเพื่อบันทึกข้อมูล
    public SSOUserTestEntity saveUser(SSOUserTestEntity user) {
        return ssoUserTestRepository.save(user);
    }

}
