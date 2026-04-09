package org.kariioke.inventoryservice.service;

import org.kariioke.inventoryservice.dto.InventoryItemRequest;
import org.kariioke.inventoryservice.dto.InventoryItemResponse;
import org.kariioke.inventoryservice.dto.StockUpdateRequest;

import java.util.List;

public interface InventoryService {

    InventoryItemResponse addItem(InventoryItemRequest request);

    List<InventoryItemResponse> getAllItems();

    InventoryItemResponse getItemById(Long id);

    InventoryItemResponse updateStock(Long id, StockUpdateRequest request);

    void deleteItem(Long id);

    // Internal operations called by order-service via Feign
    InventoryItemResponse reduceStock(Long id, int quantity);
    InventoryItemResponse restoreStock(Long id, int quantity);
}
