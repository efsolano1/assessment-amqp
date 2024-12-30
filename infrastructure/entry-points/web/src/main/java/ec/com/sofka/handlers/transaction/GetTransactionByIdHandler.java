package ec.com.sofka.handlers.transaction;

import ec.com.sofka.appservice.transaction.GetTransactionByIdUseCase;
import ec.com.sofka.data.dto.transactionDTO.TransactionResponseDTO;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class GetTransactionByIdHandler {
    private final GetTransactionByIdUseCase getTransactionByIdUseCase;

    public GetTransactionByIdHandler(GetTransactionByIdUseCase getTransactionByIdUseCase) {
        this.getTransactionByIdUseCase = getTransactionByIdUseCase;
    }

    public Mono<TransactionResponseDTO> getTransactionById(String id) {
        return getTransactionByIdUseCase.apply(id)
                .map(transaction -> new TransactionResponseDTO(
                        transaction.getId(),
                        transaction.getAmount(),
                        transaction.getType(),
                        transaction.getCost(),
                        transaction.getIdAccount()
                ))
                .switchIfEmpty(Mono.empty());
    }
}