package com.pastwisko.controller;

import com.pastwisko.model.CopyPasta;
import com.pastwisko.service.CopyPastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CopyPasteController {

    private final CopyPastaService copyPastaService;

    @Autowired
    public CopyPasteController(CopyPastaService copyPastaService) {
        this.copyPastaService = copyPastaService;
    }

    @RequestMapping(value = "/pastas", method = RequestMethod.GET)
    public List<CopyPasta> list() {
        return copyPastaService.listAll();
    }

}
