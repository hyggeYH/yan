package yan.com.e_auctions.service.bidService.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yan.com.e_auctions.dto.BidDto;
import yan.com.e_auctions.entity.Auction;
import yan.com.e_auctions.entity.Bid;
import yan.com.e_auctions.mapper.BidMapper;
import yan.com.e_auctions.repository.AuctionRepository;
import yan.com.e_auctions.repository.BidRepository;
import yan.com.e_auctions.service.bidService.BidService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BidServiceImpl implements BidService {
    private final BidRepository bidRepository;
    private final AuctionRepository auctionRepository;

//    @Override
//    public BidDto createBid(BidDto bidDto) {
//        Bid bid = BidMapper.MapToBid(bidDto);
//        Bid bidSaved = bidRepository.save(bid);
//        return BidMapper.MapToBidDto(bidSaved);
//    }

//    @Override
//    public List<BidDto> findAllBid() {
//        List<Bid> bids = bidRepository.findAll();
//        return bids.stream()
//                .map(BidMapper::MapToBidDto)
//                .collect(Collectors.toList());
//    }

    public BidDto createBid(BidDto bidDto) {
        Auction auction = auctionRepository.findById(bidDto.getAuctionId())
                .orElseThrow(() -> new RuntimeException("Auction not found"));

        Bid bid = new Bid();
        bid.setAmount(bidDto.getAmount());
        bid.setAuction(auction);
        bid.setTime(LocalDateTime.now());
        bid.setBidderName(bidDto.getBidderName());

        Bid savedBid = bidRepository.save(bid);
        return BidMapper.MapToBidDto(savedBid);
    }

    public List<BidDto> getBidsByAuctionId(Long auctionId) {
        List<Bid> bids = bidRepository.findByAuctionId(auctionId);
        return bids.stream()
                .map(BidMapper::MapToBidDto)
                .collect(Collectors.toList());
    }
}
