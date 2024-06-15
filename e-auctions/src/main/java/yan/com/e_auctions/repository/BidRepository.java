package yan.com.e_auctions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yan.com.e_auctions.entity.Bid;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {
    List<Bid> findByAuctionId(Long auctionId);
}
