package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserBatchService {

    @PersistenceContext
    private EntityManager em;

    private static final int BATCH_SIZE = 50;

    @Transactional
    public void insertUsers(int total) {
        for (int i = 1; i <= total; i++) {
            UserEntity user = new UserEntity();
            user.setUsername("User-" + i);
            em.persist(user);

            if (i % BATCH_SIZE == 0) {
                em.flush();
                em.clear();
            }
        }
    }
}
