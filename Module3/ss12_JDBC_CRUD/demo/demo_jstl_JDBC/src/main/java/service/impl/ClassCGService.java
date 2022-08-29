package service.impl;

import model.ClassCG;
import repository.IClassCGRepository;
import repository.impl.ClassCGRepository;
import service.IClassCGService;

import java.util.List;

public class ClassCGService implements IClassCGService {
    private IClassCGRepository classCGRepository = new ClassCGRepository();

    @Override
    public List<ClassCG> findByAll() {
        return classCGRepository.findByAll();
    }
}
