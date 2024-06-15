package yan.com.e_auctions.service.bidService;

import yan.com.e_auctions.dto.BidDto;
import yan.com.e_auctions.entity.Bid;

import java.util.List;

public interface BidService {
    BidDto createBid(BidDto bidDto);

    List<BidDto> getBidsByAuctionId(Long auctionId);
}
