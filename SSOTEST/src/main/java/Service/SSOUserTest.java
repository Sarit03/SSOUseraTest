package Service;

import dev.danvega.SSOTEST.entity.SSOUserTest;
import dev.danvega.SSOTEST.repository.SSOUserTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SSOUserTestService {

    @Autowired
    private SSOUserTestRepository repository;

    public SSOUserTest saveSSOUserTest(SSOUserTest ssoUserTest) {
        return repository.save(ssoUserTest);
    }
}
