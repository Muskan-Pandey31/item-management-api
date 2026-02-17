package com.sampletask.item.service;

import com.sampletask.item.dto.CreateNewItemDTO;
import com.sampletask.item.dto.ItemDTO;
import com.sampletask.item.entity.Item;
import com.sampletask.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ItemServiceImplementation implements ItemService{
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    @Override
    public ItemDTO getById(Long id) {
        Item item = itemRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found by this id: " + id));
        return modelMapper.map(item, ItemDTO.class);
    }

    @Override
    public ItemDTO addNewItem(CreateNewItemDTO createNewItemDTO) {
        Item item = modelMapper.map(createNewItemDTO, Item.class);
        Item newItem = itemRepository.save(item);
        return modelMapper.map(newItem, ItemDTO.class);
    }

}
