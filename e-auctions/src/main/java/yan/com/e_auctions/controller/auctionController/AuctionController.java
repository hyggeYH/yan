package yan.com.e_auctions.controller.auctionController;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yan.com.e_auctions.dto.AuctionDto;
import yan.com.e_auctions.service.auctionService.AuctionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auction")
public class AuctionController {
    private final AuctionService service;

    @PostMapping
    public ResponseEntity<AuctionDto> createAuction(@RequestBody AuctionDto auctionDto) {
        AuctionDto auction = service.createAuction(auctionDto);
        return new ResponseEntity<>(auction, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AuctionDto>> getAllAuction() {
        return ResponseEntity.ok(service.findAllAuction());
    }

    @GetMapping("{id}")
    public ResponseEntity<AuctionDto> getAuction(@PathVariable Long id) {
        return ResponseEntity.ok(service.findAuctionById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<AuctionDto> updateAuction(@PathVariable Long id,
                                                    @RequestBody AuctionDto auctionDto) {
        AuctionDto auction = service.updateAuction(auctionDto, id);
        return ResponseEntity.ok(auction);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAuction(@PathVariable Long id) {
        service.deleteAuction(id);
        return ResponseEntity.ok("Deleted auction successfully.");
    }
}
