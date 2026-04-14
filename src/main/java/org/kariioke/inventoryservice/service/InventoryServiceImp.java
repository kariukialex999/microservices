package org.kariioke.inventoryservice.service;

import lombok.RequiredArgsConstructor;
import org.kariioke.inventoryservice.dto.InventoryItemRequest;
import org.kariioke.inventoryservice.dto.InventoryItemResponse;
import org.kariioke.inventoryservice.dto.StockUpdateRequest;
import org.kariioke.inventoryservice.exception.InsufficientStockException;
import org.kariioke.inventoryservice.exception.ItemNotFoundException;
import org.kariioke.inventoryservice.model.InventoryItem;
import org.kariioke.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryServiceImp implements InventoryService{

    private final InventoryRepository inventoryRepository;


    @Override
    public InventoryItemResponse addItem(InventoryItemRequest request) {
        InventoryItem item = new InventoryItem();
        item.setName(request.getName());
        item.setCategory(request.getCategory());
        item.setDescription(request.getDescription());
        item.setPrice(request.getPrice());
        item.setQuantity(request.getQuantity());

        return toResponse(inventoryRepository.save(item));
    }

    @Override
    public List<InventoryItemResponse> getAllItems() {
        return inventoryRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public InventoryItemResponse getItemById(Long id) {
        InventoryItem item = inventoryRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item with id " + id + " not found"));
        return toResponse(item);
    }

    @Override
    public InventoryItemResponse updateStock(Long id, StockUpdateRequest request) {
        InventoryItem item = inventoryRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item with id " + id + " not found"));
        item.setQuantity(request.getQuantity());
        return toResponse(inventoryRepository.save(item));
    }

    @Override
    public void deleteItem(Long id) {
        if(!inventoryRepository.existsById(id)) {
            throw new ItemNotFoundException("Item with " + id + " not found");
        }
        inventoryRepository.deleteById(id);
    }

    @Override
    public InventoryItemResponse reduceStock(Long id, int quantity) {
        InventoryItem item = inventoryRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item with id " + id + " not found"));
        
        if (item.getQuantity() < quantity) {
            throw new InsufficientStockException("Insufficient stock. Available: " + item.getQuantity() + ", Requested: " + quantity);
        }
        
        item.setQuantity(item.getQuantity() - quantity);
        return toResponse(inventoryRepository.save(item));
    }

    @Override
    public InventoryItemResponse restoreStock(Long id, int quantity) {
        InventoryItem item = inventoryRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item with id " + id + " not found"));
        
        item.setQuantity(item.getQuantity() + quantity);
        return toResponse(inventoryRepository.save(item));
    }

    private InventoryItemResponse toResponse(InventoryItem item) {
        InventoryItemResponse response = new InventoryItemResponse();
        response.setId(item.getId());
        response.setName(item.getName());
        response.setCategory(item.getCategory());
        response.setDescription(item.getDescription());
        response.setPrice(item.getPrice());
        response.setQuantity(item.getQuantity());
        response.setInStock(item.isInStock());
        response.setCreatedAt(item.getCreatedAt());
        response.setUpdatedAt(item.getUpdatedAt());
        return response;
    }
}
