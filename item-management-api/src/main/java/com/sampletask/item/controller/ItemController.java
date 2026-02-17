package com.sampletask.item.controller;

import com.sampletask.item.dto.CreateNewItemDTO;
import com.sampletask.item.dto.ItemDTO;
import com.sampletask.item.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final ModelMapper modelMapper;

    @GetMapping("/ById/{id}")
    public ResponseEntity<ItemDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(itemService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ItemDTO> addNewItem(@RequestBody @Valid CreateNewItemDTO createNewItemDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.addNewItem(createNewItemDTO));
    }
}
