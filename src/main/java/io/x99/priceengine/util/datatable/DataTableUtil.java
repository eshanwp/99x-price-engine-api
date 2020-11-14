package io.x99.priceengine.util.datatable;

import io.x99.priceengine.dto.search.BaseSearchRequestDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DataTableUtil {

    public static Pageable createPageRequest(final BaseSearchRequestDto searchDTO) {
        return PageRequest.of(
                searchDTO.getPageIndex(),
                searchDTO.getItemPerPage(),
                Sort.by(
                        searchDTO.getSortingDirection(),
                        searchDTO.getSortingField()
                )
        );
    }

    public static Long calculateTotalNumberOfPages(final int totalItemCount, final BaseSearchRequestDto baseSearchRequestDto) {
        return (long) Math.ceil((double) totalItemCount / baseSearchRequestDto.getItemPerPage());
    }
}
