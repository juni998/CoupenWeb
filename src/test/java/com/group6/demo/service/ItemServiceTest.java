package com.group6.demo.service;

import com.group6.demo.entity.item.Item;
import com.group6.demo.entity.item.ItemDTO;
import com.group6.demo.entity.item.PageRequestDTO;
import com.group6.demo.entity.item.PageResultDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    ItemService itemService;



    @Test
    public void registerItem() throws Exception{
        ItemDTO  itemDTO = ItemDTO.builder()
                .content("registerItem")
                .price(2000)
                .stock(77)
                .thumbImg("registerImg")
                .title("registerTitle")
                .writer("registerWriter")
                .build();

        itemService.register(itemDTO);
    }


    @Test
    public void getItemListByType() throws Exception{
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1).size(10).build();
        String type = "A";

        PageResultDTO<ItemDTO, Item> resultDTO = itemService.getListByType(type,pageRequestDTO);

        for (ItemDTO itemDTO: resultDTO.getDtoList()){
            System.out.println("===========TYPE=========");
            System.out.println(itemDTO.getContent());
            System.out.println(itemDTO.getId());
            System.out.println(itemDTO.getPrice());
        }
    }

    @Test
    public void getItemList() throws Exception{
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1).size(20).build();

        PageResultDTO<ItemDTO, Item> resultDTO = itemService.getList(pageRequestDTO);

        for (ItemDTO itemDTO: resultDTO.getDtoList()){
            System.out.println(itemDTO);
        }
    }

    @Test
    public void testList() throws Exception{
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(3).size(10).build();
        PageResultDTO<ItemDTO,Item> resultDTO = itemService.getList(pageRequestDTO);

        System.out.println("PREV : "+resultDTO.isPrev());
        System.out.println("NEXT : "+resultDTO.isNext());
        System.out.println("TOTAL : "+resultDTO.getTotalPage());

        System.out.println("==================");
        for (ItemDTO itemDTO : resultDTO.getDtoList()){
            System.out.println(itemDTO);
        }
        System.out.println("==================");
        resultDTO.getPageList().forEach(i -> System.out.println(i));
    }

}