package yan.com.e_auctions.service.auctionService.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yan.com.e_auctions.auth.model.User;
import yan.com.e_auctions.auth.repositories.UserRepository;
import yan.com.e_auctions.dto.AuctionDto;
import yan.com.e_auctions.entity.Auction;
import yan.com.e_auctions.exception.ResourceNotFoundException;
import yan.com.e_auctions.mapper.AuctionMapper;
import yan.com.e_auctions.repository.AuctionRepository;
import yan.com.e_auctions.service.auctionService.AuctionService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuctionServiceImpl implements AuctionService {
    private final AuctionRepository repository;
    private final UserRepository userRepository;

    @Override
    public AuctionDto createAuction(AuctionDto auctionDto) {
        Auction auction = AuctionMapper.MapToAuction(auctionDto);
        Auction saveAuction = repository.save(auction);
        return AuctionMapper.MapToAuctionDto(saveAuction);
    }

    @Override
    public List<AuctionDto> findAllAuction() {
        List<Auction> auctions = repository.findAll();
        return auctions
                .stream()
                .map(AuctionMapper::MapToAuctionDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuctionDto findAuctionById(Long auctionId) {
        Auction auction = repository.findById(auctionId)
                .orElseThrow(() -> new ResourceNotFoundException("Auction not found with this id: " + auctionId));
        return AuctionMapper.MapToAuctionDto(auction);
    }

    @Override
    public AuctionDto updateAuction(AuctionDto auctionDto, Long auctionId) {
        Auction auction = repository.findById(auctionId)
                .orElseThrow(() -> new ResourceNotFoundException("Auction not found with this id: " + auctionId));
        if(auctionDto.getStartTime() != null){
            auction.setStartTime(auctionDto.getStartTime());
        }
        if(auctionDto.getEndTime() != null){
            auction.setEndTime(auctionDto.getEndTime());
        }
        if(auctionDto.getName() != null){
            auction.setName(auctionDto.getName());
        }
        if(auctionDto.getEmail() != null){
            auction.setEmail(auctionDto.getEmail());
        }
        if(auctionDto.getProduct() != null){
            auction.setProduct(auctionDto.getProduct());
        }
        if(auctionDto.getDescription() != null){
            auction.setDescription(auctionDto.getDescription());
        }
        if(auctionDto.getStartingPrice() != null){
            auction.setStartingPrice(auctionDto.getStartingPrice());
        }
        Auction saveAuction = repository.save(auction);
        return AuctionMapper.MapToAuctionDto(saveAuction);
    }

    @Override
    public void deleteAuction(Long auctionId) {
        Auction auction = repository.findById(auctionId)
                .orElseThrow(() -> new ResourceNotFoundException("Auction not found with this id: " + auctionId));
        repository.delete(auction);
    }
}
