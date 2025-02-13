package cityProject.cityBank.Service;

import cityProject.cityBank.Model.Transaction;
import cityProject.cityBank.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    public Transaction saveTransaction(Transaction dto) {
        Transaction transaction = new Transaction();
        transaction.setAmount(dto.getAmount());
        transaction.setCurrency(dto.getCurrency());
        transaction.setTax(dto.getAmount().multiply(BigDecimal.valueOf(0.10))); // 10% Tax
        return repository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return repository.findById(id);
    }

    public List<Transaction> getTransactionsByTax(BigDecimal tax) {
        return repository.findByTax(tax);
    }

    public Optional<Transaction> getTransactionByTax(BigDecimal tax) {
        return repository.findByTax(tax).stream().findFirst();
    }
}
