package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Input {
    private String blockchain;
    private Integer limit;
    private String cursor;
    private Filter filter;
}
