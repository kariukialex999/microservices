package org.kariioke.inventoryservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "Response object for an inventory item")
public class InventoryItemResponse {
    
    @Schema(description = "Unique identifier for the item", example = "1")
    private Long id;
    
    @Schema(description = "Name of the inventory item", example = "Laptop")
    private String name;
    
    @Schema(description = "Category of the item", example = "Electronics")
    private String category;
    
    @Schema(description = "Detailed description of the item", example = "High-performance gaming laptop")
    private String description;
    
    @Schema(description = "Price of the item", example = "999.99")
    private BigDecimal price;
    
    @Schema(description = "Current quantity in stock", example = "50")
    private Integer quantity;
    
    @Schema(description = "Whether the item is in stock", example = "true")
    private boolean inStock;
    
    @Schema(description = "Timestamp when the item was created")
    private LocalDateTime createdAt;
    
    @Schema(description = "Timestamp when the item was last updated")
    private LocalDateTime updatedAt;

    public InventoryItemResponse() {}

    public InventoryItemResponse(Long id, String name, String category, String description, BigDecimal price, Integer quantity, boolean inStock, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.inStock = inStock;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
