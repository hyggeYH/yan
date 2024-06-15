package yan.com.e_auctions.mapper;

import yan.com.e_auctions.dto.ResultDto;
import yan.com.e_auctions.entity.Result;

public class ResultMapper {
    public static ResultDto MapToResultDto(Result result){
        return new ResultDto(
                result.getId(),
                result.getAuction(),
                result.getUser(),
                result.getFinalPrice()
        );
    }

    public static Result MapToResult(ResultDto resultDto){
        return new Result(
                resultDto.getId(),
                resultDto.getAuction(),
                resultDto.getUser(),
                resultDto.getFinalPrice()
        );
    }
}
