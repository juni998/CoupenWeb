package com.group6.demo.service;

import com.group6.demo.entity.item.Item;
import com.group6.demo.entity.item.ItemDTO;
import com.group6.demo.entity.item.PageRequestDTO;
import com.group6.demo.entity.item.PageResultDTO;
import com.group6.demo.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

        Page<Item> result = itemRepository.findAll(pageable);

        Function<Item, ItemDTO> fn = (entity -> entityToDto(entity));

        return new PageResultDTO<>(result,fn);

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

        itemRepository.save(result);
    }

    @Override
    public void removeItem(Long id) {
        itemRepository.deleteById(id);
    }


}
