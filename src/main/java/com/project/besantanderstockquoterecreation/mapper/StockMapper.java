package com.project.besantanderstockquoterecreation.mapper;

import com.project.besantanderstockquoterecreation.model.Stock;
import com.project.besantanderstockquoterecreation.model.dto.StockDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockMapper {
    public Stock toEntity(StockDTO dto) {
        Stock stock = new Stock();
        stock.setId(dto.getId());
        stock.setDate(dto.getDate());
        stock.setName(dto.getName());
        stock.setPrice(dto.getPrice());
        stock.setVariation(dto.getVariation());
        return stock;
    }

    public StockDTO toDto(Stock stock) {

        StockDTO dto = new StockDTO();
        dto.setId(stock.getId());
        dto.setDate(stock.getDate());
        dto.setName(stock.getName());
        dto.setPrice(stock.getPrice());
        dto.setVariation(stock.getVariation());
        return dto;
    }

    public List<StockDTO> toDto(List<Stock> listStock){

        return  listStock.stream().map(this::toDto).collect(Collectors.toList());
    }
}
