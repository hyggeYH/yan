package yan.com.e_auctions.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "bid")
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "amount")
    private Double amount;
    @Column(name = "time")
    private LocalDateTime time = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "auction_id")
    private Auction auction; // Связь с сущностью Auction
    @Column(name = "bidderName")
    private String bidderName;
}
