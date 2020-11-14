package io.x99.priceengine.dto.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseSearchResponseDto {
    private int totalItems;
    private long totalPages;
    private int currentPage;
    private List<?> items;

    @edu.umd.cs.findbugs.annotations.SuppressWarnings("URF_UNREAD_FIELD")
    public int getTotalItems() {
        return totalItems = items.size();
    }
}
