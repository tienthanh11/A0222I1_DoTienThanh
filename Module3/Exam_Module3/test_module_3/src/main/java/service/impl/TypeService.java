package service.impl;

import models.TypeStatus;
import repository.ITypeRepository;
import repository.impl.TypeRepository;
import service.ITypeService;

import java.util.List;

public class TypeService implements ITypeService<TypeStatus> {
    ITypeRepository<TypeStatus> repository = new TypeRepository();
    @Override
    public List<TypeStatus> findAll() {
        return repository.findAll();
    }
}
