package com.example.task.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.task.DTO.AddItemDTO;
import com.example.task.Model.Item;
import com.example.task.Repository.ItemRepository;
import com.example.task.Response.SuccessResponse;
import com.example.task.Service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public SuccessResponse<Object> addItem(List<AddItemDTO> addItemDTOList) {
        SuccessResponse<Object> response = new SuccessResponse<>();

        List<Item> items = addItemDTOList.stream().map(addItemDTO -> {
            Item item = new Item();
            item.setName(addItemDTO.getName());
            item.setDescription(addItemDTO.getDescription());
            item.setPrice(addItemDTO.getPrice());
            item.setCategory(addItemDTO.getCategory());
            return item;
        }).toList();

        itemRepository.saveAll(items);
        response.setStatusMessage("Items added successfully");
        response.setData(items);
        return response;

    }

    @Override
    public SuccessResponse<Object> updateItem(Integer itemId, AddItemDTO addItemDTO) {
        SuccessResponse<Object> response = new SuccessResponse<>();
        Item item = itemRepository.findById(itemId).orElseThrow(()->new RuntimeException("Item not found"));
        item.setName(addItemDTO.getName());
        item.setDescription(addItemDTO.getDescription());
        item.setPrice(addItemDTO.getPrice());
        item.setCategory(addItemDTO.getCategory());

        itemRepository.save(item);
        return response;
    }

    @Override
    public SuccessResponse<Object> getAllItems() {
        SuccessResponse<Object> response = new SuccessResponse<>();
        response.setData(itemRepository.findAll());
        response.setStatusMessage("All Items retrieved successfully");
        return response;
    }

    @Override
    public SuccessResponse<Object> getItemsById(Integer itemId) {
        SuccessResponse<Object> response = new SuccessResponse<>();
        Item item = itemRepository.findById(itemId).orElseThrow(()->new RuntimeException("Item not found"));
        response.setStatusMessage("Item retrieved successfully");
        response.setData(item);
        return response;
    }

    @Override
    public SuccessResponse<Object> deleteItem(Integer itemId) {
        SuccessResponse<Object> response = new SuccessResponse<>();
        Item item = itemRepository.findById(itemId).orElseThrow(()->new RuntimeException("Item not found"));  
        itemRepository.delete(item);
        response.setStatusMessage("Item deleted successfully");
        return response;  
    }

}
