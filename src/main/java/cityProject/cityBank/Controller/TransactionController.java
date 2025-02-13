package cityProject.cityBank.Controller;

import cityProject.cityBank.Model.Transaction;
import cityProject.cityBank.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/transactions")
class TransactionController {
    @Autowired
    private TransactionService service;

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transactionDTO) {
        return service.saveTransaction(transactionDTO);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return service.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable Long id) {
        return service.getTransactionById(id).orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    @GetMapping("/tax/{tax}")
    public List<Transaction> getTransactionsByTax(@PathVariable BigDecimal tax) {
        return service.getTransactionsByTax(tax);
    }

    @GetMapping("/tax/one/{tax}")
    public Transaction getTransactionByTax(@PathVariable BigDecimal tax) {
        return service.getTransactionByTax(tax).orElseThrow(() -> new RuntimeException("Transaction with given tax not found"));
    }
}
