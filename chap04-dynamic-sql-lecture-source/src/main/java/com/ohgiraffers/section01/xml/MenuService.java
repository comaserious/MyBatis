package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.MenuDto;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getSqlSession;


public class MenuService {

    private DynamicSqlMapper mapper;

    public void selectMenuByPrice(int price){
        SqlSession session = getSqlSession();
        mapper = session.getMapper(DynamicSqlMapper.class);
        /*필기. 기본자료형으로는 조건문의 값을 비교할 수 없으며 hashmap 의 key 혹은 dto의
        *      getter를 이용하여 값을 확인할 수 있다*/

        Map<String ,Integer> map = new HashMap<>();
        map.put("price",price);

        List<MenuDto> menuList  =mapper.selectMenuByPrice(map);

        if(menuList!=null && menuList.size()>0){
            for(MenuDto menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("검색결과가 존재하지 않습니다");
        }
        session.close();

    }

    public void searchMenu(SearchCriteria searchCriteria) {

        SqlSession session = getSqlSession();
        mapper = session.getMapper(DynamicSqlMapper.class);

        List<MenuDto> menuList = mapper.searchMenu(searchCriteria);


        if(menuList!=null&&menuList.size()>0    ){
            for(MenuDto menu : menuList){
                System.out.println(menu);
            }
        }else{
            System.out.println("검색 결과가 존재 하지 않습니다");
        }



    }
}
