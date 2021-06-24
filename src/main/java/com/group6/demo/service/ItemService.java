package com.group6.demo.service;

import com.group6.demo.entity.item.Item;
import com.group6.demo.entity.item.ItemDTO;
import com.group6.demo.entity.item.PageRequestDTO;
import com.group6.demo.entity.item.PageResultDTO;

import java.util.List;

public interface ItemService {

    Long register(ItemDTO itemDTO);

    PageResultDTO<ItemDTO, Item> getListByType(String type, PageRequestDTO pageRequestDTO);
    PageResultDTO<ItemDTO, Item> getList(PageRequestDTO pageRequestDTO);
    ItemDTO getItemById(Long id);
    void modifyItem(ItemDTO itemDTO);
    void removeItem(Long id);
    List<String> getItemSearchListAjax(String title);

    default Item dtoToEntity(ItemDTO dto){
        Item item = Item.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .thumbImg(dto.getThumbImg())
                .stock(dto.getStock())
                .price(dto.getPrice())
                .build();

        return item;
    }
    default ItemDTO entityToDto(Item dto){
        ItemDTO itemDTO = ItemDTO.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .thumbImg(dto.getThumbImg())
                .stock(dto.getStock())
                .price(dto.getPrice())
                .build();

        return itemDTO;
    }
}
