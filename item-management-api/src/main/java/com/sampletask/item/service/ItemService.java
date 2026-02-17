package com.sampletask.item.service;

import com.sampletask.item.dto.CreateNewItemDTO;
import com.sampletask.item.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    ItemDTO getById(Long id);

    ItemDTO addNewItem(CreateNewItemDTO createNewItemDTO);
}
