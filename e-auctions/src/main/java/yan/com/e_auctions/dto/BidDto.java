package yan.com.e_auctions.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BidDto {
    private Long id;
    private Double amount;
    private LocalDateTime time;
    private Long auctionId;
    private String bidderName;
}
