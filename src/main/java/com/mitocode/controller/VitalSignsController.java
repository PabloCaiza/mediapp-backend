package com.mitocode.controller;

import com.mitocode.dto.VitalSignsDTO;
import com.mitocode.model.VitalSigns;
import com.mitocode.service.VitalSignsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/signs")
@RequiredArgsConstructor
public class VitalSignsController {

    private final VitalSignsService vitalSignsService;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;


    @GetMapping
    public ResponseEntity<List<VitalSignsDTO>> findAll() throws Exception {
        List<VitalSignsDTO> list = vitalSignsService.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VitalSignsDTO> findById(@PathVariable("id") Integer id) throws Exception {
        VitalSigns vitalSigns = vitalSignsService.findById(id);
        return ResponseEntity.ok(convertToDto(vitalSigns));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody VitalSignsDTO dto) throws Exception {
        VitalSigns save = vitalSignsService.save(convertToEntity(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<VitalSignsDTO> update(@PathVariable("id") Integer id, @RequestBody VitalSignsDTO vitalSignsDTO) throws Exception {
        vitalSignsDTO.setId(id);
        VitalSigns update = vitalSignsService.update(id, convertToEntity(vitalSignsDTO));
        return ResponseEntity.ok(convertToDto(update));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        vitalSignsService.delete(id);
        return ResponseEntity.noContent().build();
    }


    private VitalSignsDTO convertToDto(VitalSigns vitalSigns) {
        return modelMapper.map(vitalSigns, VitalSignsDTO.class);
    }

    private VitalSigns convertToEntity(VitalSignsDTO vitalSignsDTO) {
        return modelMapper.map(vitalSignsDTO, VitalSigns.class);
    }

}
