package com.group6.demo.service;

import com.group6.demo.entity.item.*;
import com.group6.demo.repository.ItemRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class ItemServiceImpl implements ItemService{
    private final ItemRepository itemRepository;


    @Override
    public Long register(ItemDTO itemDTO) {
        Item item = dtoToEntity(itemDTO);
        itemRepository.save(item);

        return item.getId();
    }

    @Override
    public PageResultDTO<ItemDTO, Item> getListByType(String type, PageRequestDTO pageRequestDTO) {
        Pageable pageable = pageRequestDTO.getPageable(Sort.by("id").descending());
        Page<Item> result = itemRepository.findByType(type,pageable);

        Function<Item, ItemDTO> fn = (entity -> entityToDto(entity));

        return new PageResultDTO<>(result,fn);
    }


    @Override
    public PageResultDTO<ItemDTO, Item> getList(PageRequestDTO pageRequestDTO) {

        Pageable pageable = pageRequestDTO.getPageable(Sort.by("id").descending());
        BooleanBuilder booleanBuilder = getSearch(pageRequestDTO);
        Page<Item> result = itemRepository.findAll(booleanBuilder,pageable);
        Function<Item, ItemDTO> fn = (entity -> entityToDto(entity));
        return new PageResultDTO<>(result,fn);
    }

    private BooleanBuilder getSearch(PageRequestDTO pageRequestDTO) {
        String type = pageRequestDTO.getType();
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QItem qItem = QItem.item;
        String keyword = pageRequestDTO.getKeyword();

        BooleanExpression expression = qItem.id.gt(0L);
        booleanBuilder.and(expression);
        
        if (type == null || type.trim().length() == 0){
            return booleanBuilder;    
        }
        
        BooleanBuilder conditionBuilder = new BooleanBuilder();
        
        if (type.contains("title")){
            conditionBuilder.or(qItem.title.contains(keyword));
        }
        if (type.contains("writer")){
            conditionBuilder.or(qItem.writer.contains(keyword));
        }
        if (type.contains("content")){
            conditionBuilder.or(qItem.writer.contains(keyword));
        }
        if (type.contains("type")){
            conditionBuilder.or(qItem.type.contains(keyword));
        }
        
        booleanBuilder.and(conditionBuilder);
        return booleanBuilder;
    }


    @Override
    public ItemDTO getItemById(Long id) {

        Item item =  itemRepository.getById(id);
        ItemDTO itemDTO = entityToDto(item);
        return itemDTO;
    }

    @Override
    public void modifyItem(ItemDTO itemDTO) {
        Item result = itemRepository.getById(itemDTO.getId());
        result.changeTitle(itemDTO.getTitle());
        result.changeContent(itemDTO.getContent());
        result.setThumbImg(itemDTO.getThumbImg());
        itemRepository.save(result);
    }

    @Override
    public void removeItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public List<String> getItemSearchListAjax(String title) {
        List<Item> result =itemRepository.findByTitleContaining(title);
        List<String> list = new ArrayList<>();
        int flag = 0;
        for (Item items : result) {
            list.add(items.getTitle());
            flag++;
            System.out.println("items.getTitle() = " + items.getTitle());
            if (result.isEmpty() || flag >= 10){
                System.out.println("break");
                break;
            }
        }
        System.out.println(list.toString());
        return list;
    }


}
