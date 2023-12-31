package com.hyeonz.packingservice.pack.repository;

import com.hyeonz.packingservice.pack.domain.Category;
import com.hyeonz.packingservice.pack.domain.Pack;

import java.util.List;
import java.util.Optional;

public interface PackRepository {
    List<Pack> findAll();

    Pack insert(Pack pack);

    Pack update(Pack pack);

    Pack updateChecked(Long id, boolean checked);

    Optional<Pack> findById(long id);

    List<Pack> findByPackingListId(long packingListId);

    List<Pack> findByCategory(Category category);

    void deleteById(long id);

    void deleteAll();
}
