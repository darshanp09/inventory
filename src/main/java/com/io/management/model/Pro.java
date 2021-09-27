package com.io.management.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pro {

    private int ProductId;
    private String productScanCode;
    private String productName;
    private String productCategory;
    private int sunday;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;
    private int saturday;
    private int quantitySold;
    private double price;
    private double totalProductSale;
    private int quantityLeft;
    private double basePrice;

}
