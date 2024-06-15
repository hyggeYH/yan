package yan.com.e_auctions.mapper;

import yan.com.e_auctions.dto.BidDto;
import yan.com.e_auctions.entity.Bid;

public class BidMapper {
    public static BidDto MapToBidDto(Bid bid){
        return new BidDto(
                bid.getId(),
                bid.getAmount(),
                bid.getTime(),
                bid.getAuction().getId(),
                bid.getBidderName()
        );
    }

    public static Bid MapToBid(BidDto bidDto){
        return new Bid(
                bidDto.getId(),
                bidDto.getAmount(),
                bidDto.getTime(),
                null,
                bidDto.getBidderName()
        );
    }
}
