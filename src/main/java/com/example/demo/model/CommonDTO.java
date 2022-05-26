package com.example.demo.model;

import com.example.demo.paging.Criteria;
import com.example.demo.paging.PaginationInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonDTO extends Criteria {
    /** 페이징 정보 */
    private PaginationInfo paginationInfo;
}
