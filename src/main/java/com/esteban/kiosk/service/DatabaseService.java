package com.esteban.kiosk.service;

import com.esteban.kiosk.KioskApplication;
import com.esteban.kiosk.model.shared.IBaseModel;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DatabaseService<T extends IBaseModel> {
    private static final Logger LOGGER= LoggerFactory.getLogger(KioskApplication.class);
    public List<T> memoryDB = new ArrayList<T>();
    
    public List<T> getRecords() {
        return memoryDB;
    }

    public T getRecordById(long id) {
        T dbRecord = memoryDB.stream()
                .filter(u -> u.getId() == id)
                .findFirst().orElse(null);
        LOGGER.info(String.format("record %2$s located: %1$s", dbRecord, id));
        return memoryDB.get(memoryDB.indexOf(dbRecord));
    }

    public T getFirstRecord() {
        memoryDB.sort(Comparator.comparing(T::getId));
        var firstRecordInSortedList = memoryDB.get(0);
        LOGGER.info(String.format("getFirstRecord: %1$s", firstRecordInSortedList, memoryDB));
        return firstRecordInSortedList;
    }

    public void editRecord(T record) {
        var dbRecord = getRecordById(record.getId());
        LOGGER.info(String.format("record to Update: %1$s", dbRecord));
        var recordIndex = memoryDB.indexOf(dbRecord);
        var result = memoryDB.set(recordIndex, record);

        LOGGER.info(String.format("Updated: %1$s", result));
    }
}
