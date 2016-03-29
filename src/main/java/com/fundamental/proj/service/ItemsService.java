package com.fundamental.proj.service;

import com.fundamental.proj.model.Items;
import com.fundamental.proj.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sai on 3/9/16.
 */
@Service
public class ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;


    @Transactional
    public List<Items> getAllItems()
    {
        return itemsRepository.getAllItems();
    }

    @Transactional
    public List<Items> getAllItemsContainingSearchTerm(String searchTerm) { return itemsRepository.getAllItemsContainingSearchTerm(searchTerm); }

    @Transactional
    public void addItem(Items items)
    {
        itemsRepository.addItem(items);
    }

}
