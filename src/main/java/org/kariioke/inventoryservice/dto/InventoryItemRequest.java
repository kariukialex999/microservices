package org.kariioke.inventoryservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Schema(description = "Request object for creating or updating an inventory item")
public class InventoryItemRequest {
    
    @NotBlank(message = "Name is required")
    @Schema(description = "Name of the inventory item", example = "Laptop")
    private String name;

    @NotBlank(message = "Category is required")
    @Schema(description = "Category of the item", example = "Electronics")
    private String category;

    @Schema(description = "Detailed description of the item", example = "High-performance gaming laptop")
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Schema(description = "Price of the item", example = "999.99")
    private BigDecimal price;

    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity cannot be negative")
    @Schema(description = "Quantity in stock", example = "50")
    private Integer quantity;

    public InventoryItemRequest() {}

    public InventoryItemRequest(String name, String category, String description, BigDecimal price, Integer quantity) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
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
}
