package com.mitocode.service.impl;

import com.mitocode.model.VitalSigns;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.VitalSignsRepo;
import com.mitocode.service.VitalSignsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VitalSignsServiceImpl extends CRUDImpl<VitalSigns, Integer> implements VitalSignsService {
    private final VitalSignsRepo vitalSignsRepo;

    @Override
    protected IGenericRepo<VitalSigns, Integer> getRepo() {
        return vitalSignsRepo;
    }
}
