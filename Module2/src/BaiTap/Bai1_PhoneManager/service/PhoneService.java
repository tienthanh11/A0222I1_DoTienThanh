package BaiTap.Bai1_PhoneManager.service;

import BaiTap.Bai1_PhoneManager.exception.NotFoundException;
import BaiTap.Bai1_PhoneManager.model.AuthenticPhone;
import BaiTap.Bai1_PhoneManager.model.HandPhone;
import BaiTap.Bai1_PhoneManager.model.Phone;
import BaiTap.Bai1_PhoneManager.util.FileHelper;

import java.util.ArrayList;
import java.util.List;

public class PhoneService {
    private List<Phone> phones = new ArrayList<>();
    private FileHelper fileHelper = new FileHelper();
    private static final String PATH = "src\\BaiTap\\Bai1_PhoneManager\\data\\phone.csv";

    public PhoneService() {
        phones = mapToPhone();
    }

    public void create(Phone phone) {
        int lastId = 0;
        if(phones.size() > 0) {
            lastId = phones.get(phones.size() - 1).getId();
        }
        phone.setId(lastId + 1);
        phones.add(phone);
        fileHelper.write(PATH, phones, false);
    }

    public List<Phone> findAll() {
        return phones;
    }

    public void delete(int id) throws NotFoundException {
        for(int i = 0; i < phones.size(); i++) {
            if(phones.get(i).getId() == id) {
                phones.remove(i);
                fileHelper.write(PATH, phones, false);
               return;
            }
        }
        throw new NotFoundException(id + "is not exists");
    }

    public List<Phone> search(String name) {
        List<Phone> result = new ArrayList<>();

        for (Phone phone : phones) {
            if (phone.getName().contains(name)) {
                result.add(phone);
            }
        }
        return result;
    }

    private List<Phone> mapToPhone() {
        List<Phone> result = new ArrayList<>();
        List<String> lines = fileHelper.read(PATH);
        for (String line : lines) {
            String[] tmp = line.split(",");
            int id = Integer.parseInt(tmp[0]);
            String name = tmp[1];
            double price = Double.parseDouble(tmp[2]);
            String manufacturer = tmp[3];

            if(tmp[tmp.length -1].equals("0")) {
                int granteeByYear = Integer.parseInt(tmp[4]);
                String granteeByCode = tmp[5];
                AuthenticPhone authenticPhone = new AuthenticPhone(id, name, price, manufacturer, granteeByYear, granteeByCode);
                result.add(authenticPhone);
            } else {
                String country = tmp[4];
                String status = tmp[5];
                HandPhone handPhone = new HandPhone(id, name, price, manufacturer, country, status);
                result.add(handPhone);
            }
        }
        return result;
    }
}
