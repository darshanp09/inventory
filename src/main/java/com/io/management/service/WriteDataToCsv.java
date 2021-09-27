package com.io.management.service;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.io.management.dao.ProductDao;
import com.io.management.model.Pro;
import com.io.management.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteDataToCsv {


    public void writeDataToCsvOnly(List<Pro> productList) throws IOException {
        List<Pro> products = productList;

        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);

        CsvSchema schema = CsvSchema.builder().setUseHeader(true)
                .addColumn("productScanCode")
                .addColumn("productName")
                .addColumn("productCategory")
                .addColumn("sunday")
                .addColumn("monday")
                .addColumn("tuesday")
                .addColumn("wednesday")
                .addColumn("thursday")
                .addColumn("friday")
                .addColumn("saturday")
                .addColumn("quantitySold")
                .addColumn("price")
                .addColumn("totalProductSale")
                .addColumn("quantityLeft")
                .addColumn("basePrice")
                .build();

        ObjectWriter writer = mapper.writerFor(Product.class).with(schema);

        writer.writeValues(new File("/Users/swaminarayan/Desktop/Inventory/src/main/resources/requestPrint.csv")).writeAll(products);

    }


    public List<Product> writeDataToCsv(List<Pro> productList) throws IOException {
        List<Pro> products = productList;

        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);

        CsvSchema schema = CsvSchema.builder().setUseHeader(true)
                .addColumn("productScanCode")
                .addColumn("productName")
                .addColumn("productCategory")
                .addColumn("sunday")
                .addColumn("monday")
                .addColumn("tuesday")
                .addColumn("wednesday")
                .addColumn("thursday")
                .addColumn("friday")
                .addColumn("saturday")
                .addColumn("quantitySold")
                .addColumn("price")
                .addColumn("totalProductSale")
                .addColumn("quantityLeft")
                .addColumn("basePrice")
                .build();

        ObjectWriter writer = mapper.writerFor(Product.class).with(schema);

        writer.writeValues(new File("/Users/swaminarayan/Desktop/Inventory/src/main/resources/salesData.csv")).writeAll(products);

        List<Product> saveProductBack = readDataFromCsv();

        return saveProductBack;

    }

    public List<Product> readDataFromCsv() {
        int count = 0;
        List<Product> products = new ArrayList<>();
        String file = "/Users/swaminarayan/Desktop/Inventory/src/main/resources/salesData.csv";
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                count++;
                if (count != 1) {
                    String[] splitedText = line.split(",");
                    Product product = new Product();
                    product.setProductScanCode(splitedText[0]);
                    product.setProductName(splitedText[1].replaceAll("\"",""));
                    product.setProductCategory(splitedText[2].replaceAll("\"",""));
                    product.setPrice(Double.parseDouble(splitedText[11]));
                    product.setQuantityLeft(Integer.parseInt(splitedText[13]));
                    product.setBasePrice(Double.parseDouble(splitedText[14]));
                    products.add(product);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return products;
    }
}
