package yan.com.e_auctions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yan.com.e_auctions.entity.Result;

public interface ResultRepository extends JpaRepository<Result, Long> {
}
