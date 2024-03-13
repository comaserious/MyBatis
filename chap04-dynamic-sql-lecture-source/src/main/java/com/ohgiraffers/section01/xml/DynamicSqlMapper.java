package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.MenuDto;
import com.ohgiraffers.common.SearchCriteria;

import java.util.List;
import java.util.Map;

public interface DynamicSqlMapper {
    List<MenuDto> selectMenuByPrice(Map<String, Integer> map);

    List<MenuDto> searchMenu(SearchCriteria searchCriteria);
}
