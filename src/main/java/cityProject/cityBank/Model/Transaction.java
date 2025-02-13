package cityProject.cityBank.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
public class Transaction implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)


        private Long id;
        private BigDecimal amount;
        private String currency;
        private BigDecimal tax;


}
