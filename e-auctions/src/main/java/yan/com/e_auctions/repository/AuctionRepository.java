package yan.com.e_auctions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yan.com.e_auctions.entity.Auction;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
}
