package service.impl;

import models.MatBang;
import repository.IBaseRepository;
import repository.impl.MatBangRepository;
import service.IBaseService;
import utils.ValidData;

import java.util.List;
import java.util.Map;

public class MatBangService implements IBaseService<MatBang> {
    IBaseRepository<MatBang> repository = new MatBangRepository();

    @Override
    public List<MatBang> findAll(int limit, int offset) {
        return repository.findAll(limit, offset);
    }

    @Override
    public Map<String, String> save(MatBang matBang) {
        Map<String, String> map = ValidData.checkValid(matBang);
        if (map.isEmpty()) {
            repository.save(matBang);
        }
        return map;
    }

    @Override
    public void removeById(String id) {
        repository.removeById(id);
    }

    @Override
    public int count() {
        return repository.count();
    }

    @Override
    public List<MatBang> findBy(String name, String stage, String dateIn, String dateOut) {
        return repository.findBy(name, stage, dateIn, dateOut);
    }
}
