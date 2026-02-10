package com.example.task.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.DTO.AddItemDTO;
import com.example.task.Response.SuccessResponse;
import com.example.task.Service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/addItem")
    public SuccessResponse<Object> addItem(@RequestBody List<AddItemDTO> addItemDTO){
        return itemService.addItem(addItemDTO);
    }

    @PutMapping("/updateItem")
    public SuccessResponse<Object> updateItem(@RequestParam("itemId")Integer itemId, @RequestBody AddItemDTO addItemDTO){
        return itemService.updateItem(itemId, addItemDTO);
    }

    @GetMapping("/getAllItems")
    public SuccessResponse<Object> getAllItems(){
        return itemService.getAllItems();
    }

    @GetMapping("/getItemsById")
    public SuccessResponse<Object> getItemsById(@RequestParam("itemId")Integer itemId){
        return itemService.getItemsById(itemId);
    }

    @DeleteMapping("/deleteItem")
    public SuccessResponse<Object> deleteItem(@RequestParam("itemId")Integer itemId){
        return itemService.deleteItem(itemId);
    }

}
