package com.pashin.pharmacyweb.service.db;

import com.pashin.pharmacyweb.model.NetworkModel;
import com.pashin.pharmacyweb.repository.NetworkRepository;
import com.pashin.pharmacyweb.service.IDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NetworkService implements IDBService<NetworkModel> {

    @Autowired
    private NetworkRepository networkRepository;

    @Override
    public NetworkModel add(NetworkModel element) {
        return networkRepository.saveAndFlush(element);
    }

    @Override
    public void deleteByID(long ID) {
        networkRepository.deleteById(ID);
    }

    @Override
    public NetworkModel editElement(NetworkModel element) {
        return networkRepository.saveAndFlush(element);
    }

    @Override
    public NetworkModel getByID(long ID) {
        return networkRepository.getById(ID);
    }

    @Override
    public List<NetworkModel> getAll() {
        return networkRepository.findAll();
    }
}
