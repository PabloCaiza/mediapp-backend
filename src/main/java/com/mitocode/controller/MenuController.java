package com.mitocode.controller;

import com.mitocode.dto.MenuDTO;
import com.mitocode.model.Menu;
import com.mitocode.service.IMenuService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
public class MenuController {

    private final IMenuService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping("/user")
    public ResponseEntity<List<MenuDTO>> getMenusByUser(){
        List<Menu> menus = service.getMenusByUsername();

        List<MenuDTO> menuDTOS = menus.stream().map( e -> modelMapper.map(e, MenuDTO.class)).toList();

        return ResponseEntity.ok(menuDTOS);
    }
}
