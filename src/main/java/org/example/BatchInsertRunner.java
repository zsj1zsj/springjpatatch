package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BatchInsertRunner implements CommandLineRunner {

    private final UserBatchService batchService;

    public BatchInsertRunner(UserBatchService batchService) {
        this.batchService = batchService;
    }

    @Override
    public void run(String... args) {
        batchService.insertUsers(1000); // 插入 1000 条
        System.out.println("批量插入完成 ✅");
    }
}
