package io.x99.priceengine.dto.search;

import lombok.Data;
import org.springframework.data.domain.Sort.Direction;

import java.io.Serializable;

@Data
public class BaseSearchRequestDto implements Serializable {

    private static final long serialVersionUID = -9013141090617397580L;
    private Integer pageIndex = 0;
    private String sortingField = "id";
    private Direction sortingDirection = Direction.ASC;
    private Integer itemPerPage = 10;
}
