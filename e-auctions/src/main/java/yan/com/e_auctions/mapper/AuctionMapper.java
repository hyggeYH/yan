package yan.com.e_auctions.mapper;

import yan.com.e_auctions.dto.AuctionDto;
import yan.com.e_auctions.entity.Auction;

public class AuctionMapper {
    public static AuctionDto MapToAuctionDto(Auction auction) {
        return new AuctionDto(
                auction.getId(),
                auction.getStartTime(),
                auction.getEndTime(),
                auction.getName(),
                auction.getEmail(),
                auction.getProduct(),
                auction.getDescription(),
                auction.getStartingPrice()
        );
    }

    public static Auction MapToAuction(AuctionDto auctionDto) {
        return new Auction(
                auctionDto.getId(),
                auctionDto.getStartTime(),
                auctionDto.getEndTime(),
                auctionDto.getName(),
                auctionDto.getEmail(),
                auctionDto.getProduct(),
                auctionDto.getDescription(),
                auctionDto.getStartingPrice()
        );
    }
}
