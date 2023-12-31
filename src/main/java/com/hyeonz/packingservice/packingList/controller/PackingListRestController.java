package com.hyeonz.packingservice.packingList.controller;

import com.hyeonz.packingservice.packingList.dto.PackingListCreateDto;
import com.hyeonz.packingservice.packingList.dto.PackingListUpdateDto;
import com.hyeonz.packingservice.packingList.domain.PackingList;
import com.hyeonz.packingservice.packingList.service.PackingListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/packingList")
public class PackingListRestController {
    private final PackingListService packingListService;

    public PackingListRestController(PackingListService packingListService) {
        this.packingListService = packingListService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public PackingList createPackingList(@RequestBody PackingListCreateDto packingListCreateDto) {
        LocalDate departureDate = LocalDate.parse(packingListCreateDto.getDepartureDate(), DateTimeFormatter.ISO_DATE);

        return packingListService.createPackingList(
                new PackingList(
                        packingListCreateDto.getTitle(),
                        packingListCreateDto.getDescription(),
                        departureDate
                )
        );
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<PackingList> getAllPackingLists() {
        return packingListService.getAllPackingLists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PackingList> getPackingList(@PathVariable long id) {
        Optional<PackingList> packingList = packingListService.getPackingList(id);

        if (packingList.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(packingList.get());
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public PackingList updatePackingList(@PathVariable Long id, @RequestBody PackingListUpdateDto packingListUpdateDto) {
        LocalDate departureDate = LocalDate.parse(packingListUpdateDto.getDepartureDate(), DateTimeFormatter.ISO_DATE);

        return packingListService.updatePackingList(
                new PackingList(
                        id,
                        packingListUpdateDto.getTitle(),
                        packingListUpdateDto.getDescription(),
                        departureDate
                ));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deletePackingList(@PathVariable Long id) {
        packingListService.deletePackingList(id);
    }
}
