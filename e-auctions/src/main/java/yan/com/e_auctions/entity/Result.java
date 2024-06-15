package yan.com.e_auctions.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import yan.com.e_auctions.auth.model.User;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "auctionId", nullable = false)
    private Auction auction;
    @OneToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;


    @Column(name = "finalPrice")
    private Double finalPrice;
}
