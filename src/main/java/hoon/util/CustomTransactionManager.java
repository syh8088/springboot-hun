package hoon.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
@Scope("prototype") // NOTE #8 이 외의 다양한 스코프도 확인할 것!
@Slf4j
public class CustomTransactionManager {
    private static ThreadLocal<TransactionStatus> status = new ThreadLocal<>();
    private final PlatformTransactionManager transactionManager;

    @Autowired
    public CustomTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void start() {
        int isolationLevel = TransactionDefinition.ISOLATION_DEFAULT; // NOTE #8 트랜잭션 생성 시 고려해야할 것 1
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("CustomTransaction");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW); // NOTE #8 트랜잭션 생성 시 고려해야할 것 2
        def.setIsolationLevel(isolationLevel);
        status.set(transactionManager.getTransaction(def));
    }

    public void rollback() {
        transactionManager.rollback(status.get());
        status.remove();
    }

    public void commit() {
        transactionManager.commit(status.get());
        status.remove();
    }
}
