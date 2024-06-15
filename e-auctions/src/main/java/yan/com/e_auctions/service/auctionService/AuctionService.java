package yan.com.e_auctions.service.auctionService;

import yan.com.e_auctions.auth.model.User;
import yan.com.e_auctions.dto.AuctionDto;

import java.util.List;

public interface AuctionService {
    AuctionDto createAuction(AuctionDto auctionDto);

    List<AuctionDto> findAllAuction();

    AuctionDto findAuctionById(Long auctionId);

    AuctionDto updateAuction(AuctionDto auctionDto, Long auctionId);

    void deleteAuction(Long auctionId);
}
