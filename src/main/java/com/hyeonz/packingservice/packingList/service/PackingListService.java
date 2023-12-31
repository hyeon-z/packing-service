package com.hyeonz.packingservice.packingList.service;

import com.hyeonz.packingservice.packingList.domain.PackingList;

import java.util.List;
import java.util.Optional;

public interface PackingListService {

    PackingList createPackingList(PackingList packingList);

    List<PackingList> getAllPackingLists();

    Optional<PackingList> getPackingList(long id);

    PackingList updatePackingList(PackingList packingList);

    void deletePackingList(Long id);
}
