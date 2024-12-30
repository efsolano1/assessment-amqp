package ec.com.sofka.gateway;

import ec.com.sofka.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionRepository {
    Mono<Transaction> findTransactionById(String id);
    Flux<Transaction> findAllTransactions();
    Mono<Transaction> saveTransaction(Transaction transaction);

}