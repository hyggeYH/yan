package yan.com.e_auctions.controller.bidController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import yan.com.e_auctions.auth.service.UserService;
import yan.com.e_auctions.dto.AuctionDto;
import yan.com.e_auctions.dto.BidDto;
import yan.com.e_auctions.service.auctionService.AuctionService;
import yan.com.e_auctions.service.bidService.BidService;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BidController {

    private final AuctionService auctionService;
    private final BidService bidService;
    private final UserDetailsService userDetailsService;

    // Обработка GET запроса на страницу "Bid" для конкретного аукциона по его ID
    @GetMapping("/bid/{id}")
    public String getBidPage(@PathVariable("id") Long auctionId, Model model, Principal principal) {
        AuctionDto auction = auctionService.findAuctionById(auctionId);
        if (auction == null) {
            // Обработка случая, когда аукцион не найден
            return "redirect:/user-page"; // Например, перенаправление на страницу пользователя
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        model.addAttribute("auction", auction);
        return "bid";
    }

    @PostMapping("/api/bid")
    public ResponseEntity<BidDto> createBid(@RequestBody BidDto bidDto,
                                            Principal principal) {
        String username = principal.getName();
        bidDto.setBidderName(username);
        BidDto bid = bidService.createBid(bidDto);
        return new ResponseEntity<>(bid, HttpStatus.CREATED);
    }

    @GetMapping("/auctions/{auctionId}/bids")
    public ResponseEntity<List<BidDto>> getBidsByAuction(@PathVariable Long auctionId) {
        List<BidDto> bids = bidService.getBidsByAuctionId(auctionId);
        return ResponseEntity.ok(bids);
    }
}

