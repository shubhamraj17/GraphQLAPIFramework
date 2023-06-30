package model.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TokenBalances {
    private String tokenId;
    private String amount;
    private String blockchain;
}
