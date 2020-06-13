package com.dtf.service.impl;

import com.dtf.dao.ItemsDao;
import com.dtf.domain.Items;
import com.dtf.service.ItemsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemsServicesImpl implements ItemsServices {
    @Autowired
    private ItemsDao itemsDao;

    public Items findById(Integer id) {
        return itemsDao.findById(id);
    }
}
