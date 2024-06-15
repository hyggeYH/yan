package yan.com.e_auctions.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuctionDto {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String name;
    private String email;
    private String product;
    private String description;
    private Double startingPrice;
}

