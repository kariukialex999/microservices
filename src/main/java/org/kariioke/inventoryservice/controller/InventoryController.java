package org.kariioke.inventoryservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.kariioke.inventoryservice.dto.InventoryItemRequest;
import org.kariioke.inventoryservice.dto.InventoryItemResponse;
import org.kariioke.inventoryservice.dto.StockUpdateRequest;
import org.kariioke.inventoryservice.service.InventoryServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@Tag(name = "Inventory Management", description = "APIs for managing inventory items and stock")
public class InventoryController {

    private final InventoryServiceImp inventoryService;

    public InventoryController(InventoryServiceImp inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    @Operation(summary = "Add a new inventory item", description = "Creates a new inventory item with the provided details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    public ResponseEntity<InventoryItemResponse> addItem(@Valid @RequestBody InventoryItemRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inventoryService.addItem(request));
    }

    @GetMapping
    @Operation(summary = "Retrieve all inventory items", description = "Fetches all items in the inventory")
    @ApiResponse(responseCode = "200", description = "Items retrieved successfully")
    public ResponseEntity<List<InventoryItemResponse>> getAllItems() {
        return ResponseEntity.ok(inventoryService.getAllItems());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get item by ID", description = "Retrieves a specific inventory item by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item found"),
            @ApiResponse(responseCode = "404", description = "Item not found")
    })
    public ResponseEntity<InventoryItemResponse> getItemById(@PathVariable Long id) {
        return ResponseEntity.ok(inventoryService.getItemById(id));
    }

    @PutMapping("/{id}/stock")
    @Operation(summary = "Update item stock", description = "Updates the stock quantity for an item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Stock updated successfully"),
            @ApiResponse(responseCode = "404", description = "Item not found"),
            @ApiResponse(responseCode = "400", description = "Invalid quantity")
    })
    public ResponseEntity<InventoryItemResponse> updateStock(@PathVariable Long id, @Valid @RequestBody StockUpdateRequest request) {
        return ResponseEntity.ok(inventoryService.updateStock(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete inventory item", description = "Removes an item from the inventory")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Item deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Item not found")
    })
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        inventoryService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
