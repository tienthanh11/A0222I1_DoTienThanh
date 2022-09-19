package service.impl;

import models.StatusStage;
import repository.ITypeRepository;
import repository.impl.StatusRepository;
import service.ITypeService;

import java.util.List;

public class StatusService implements ITypeService<StatusStage> {
    ITypeRepository<StatusStage> repository = new StatusRepository();

    @Override
    public List<StatusStage> findAll() {
        return repository.findAll();
    }
}
