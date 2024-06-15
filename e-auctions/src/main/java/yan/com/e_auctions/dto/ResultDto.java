package yan.com.e_auctions.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import yan.com.e_auctions.auth.model.User;
import yan.com.e_auctions.entity.Auction;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto {
    private Long id;
    private Auction auction;
    private User user;
    private Double finalPrice;
}
