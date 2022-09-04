package service.impl;

import model.House;
import model.Room;
import model.Villa;
import repository.IServiceRepository;
import repository.impl.ServiceRepository;
import service.IServiceService;

import java.util.List;

public class ServiceService implements IServiceService {
    private IServiceRepository repository = new ServiceRepository();

    @Override
    public List<House> showHouse() {
        try {
            List<House> houseList = repository.showHouse();
            if (houseList.size() == 0) {
                return null;
            } else {
                return houseList;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Room> showRoom() {
        return null;
    }

    @Override
    public List<Villa> showVilla() {
        return null;
    }

    @Override
    public void createHouse(House house) {
        repository.createHouse(house);
    }

    @Override
    public void createVilla(Villa villa) {

    }

    @Override
    public void createRoom(Room room) {

    }
}
