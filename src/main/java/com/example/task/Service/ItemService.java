package com.example.task.Service;

import java.util.List;

import com.example.task.DTO.AddItemDTO;
import com.example.task.Response.SuccessResponse;

public interface ItemService {

    SuccessResponse<Object> addItem(List<AddItemDTO> addItemDTO);

    SuccessResponse<Object> updateItem(Integer itemId, AddItemDTO addItemDTO);

    SuccessResponse<Object> getAllItems();

    SuccessResponse<Object> getItemsById(Integer itemId);

}
