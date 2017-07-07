package com.pastwisko.service;

import com.pastwisko.model.CopyPasta;

import java.util.List;

public interface CopyPastaService extends CRUDService<CopyPasta> {

    List<CopyPasta> findByTag(int id);

}
