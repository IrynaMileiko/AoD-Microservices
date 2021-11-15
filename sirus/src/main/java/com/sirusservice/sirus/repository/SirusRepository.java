package com.sirusservice.sirus.repository;

import com.sirusservice.sirus.entity.SirusNew;

import java.util.List;

public class SirusRepository {
    DbConnector connector = new DbConnector();

    public void update(List<SirusNew> newsList) {
        connector.connect();
        for(SirusNew sirusNew:newsList){
            if(!connector.isNew(sirusNew))
                connector.updateSirus(sirusNew);
        }
        connector.disconnect();
    }
}
