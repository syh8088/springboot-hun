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
@Scope("prototype")
@Slf4j
public class CustomTransactionManager {
    private static ThreadLocal<TransactionStatus> status = new ThreadLocal<>();
    private final PlatformTransactionManager transactionManager;

    @Autowired
    public CustomTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void start() {
        int isolationLevel = TransactionDefinition.ISOLATION_DEFAULT;
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("CustomTransaction");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        def.setIsolationLevel(isolationLevel);
        status.set(transactionManager.getTransaction(def));
        log.info("start transaction");
    }

    public void rollback() {
        transactionManager.rollback(status.get());
        status.remove();
        log.info("rollback transaction");
    }

    public void commit() {
        transactionManager.commit(status.get());
        status.remove();
        log.info("commit transaction");
    }
}
