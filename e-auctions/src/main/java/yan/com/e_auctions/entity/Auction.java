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
@Table(name = "auction")
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "startTime")
    private LocalDateTime startTime;
    @Column(name = "endTime")
    private LocalDateTime endTime;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Column(name = "product", nullable = false, length = 50)
    private String product;
    @Column(name = "description", nullable = false, length = 1000)
    private String description;
    @Column(name = "startingPrice")
    private Double startingPrice;
}
