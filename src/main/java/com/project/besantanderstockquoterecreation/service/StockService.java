package com.project.besantanderstockquoterecreation.service;

import com.project.besantanderstockquoterecreation.exceptions.BusinessException;
import com.project.besantanderstockquoterecreation.exceptions.NotFoundException;
import com.project.besantanderstockquoterecreation.mapper.StockMapper;
import com.project.besantanderstockquoterecreation.model.Stock;
import com.project.besantanderstockquoterecreation.model.dto.StockDTO;
import com.project.besantanderstockquoterecreation.repository.StockRepository;
import com.project.besantanderstockquoterecreation.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO dto) {

        Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(), dto.getDate());
        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }

        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        dto.setId(stock.getId());
        return mapper.toDto(stock);
    }

    @Transactional
    public StockDTO update(StockDTO dto) {

        Optional<Stock> optionalStock = repository.findByStockUpdate(dto.getName(), dto.getDate(), dto.getId());
        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }

        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        dto.setId(stock.getId());
        return mapper.toDto(stock);
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findAll() {
        return  mapper.toDto(repository.findAll());
    }

    @Transactional(readOnly = true)
    public StockDTO  findById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public StockDTO delete(Long id) {
        StockDTO dto = this.findById(id);
        repository.deleteById(dto.getId());
        return dto;
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findByToday() {
        return repository.findByToday(LocalDate.now()).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }
}
