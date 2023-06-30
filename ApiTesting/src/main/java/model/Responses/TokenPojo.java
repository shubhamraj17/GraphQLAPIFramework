package model.Responses;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.sql.Time;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenPojo {
    private String id;
    private String address;
    private String chainId;
    private String name;
    private String symbol;
    private String type;
    private String totalSupply;
    private Integer decimals;
    private String baseURI;
    private Time lastTransferTimestamp;
    private Integer lastTransferBlock;
    private String lastTransferHash;
    private ContractMetaDeta contractMetaDeta;
    private Logo logo;
    private TokenBalances tokenBalances;
    private PageInfo pageInfo;
}
