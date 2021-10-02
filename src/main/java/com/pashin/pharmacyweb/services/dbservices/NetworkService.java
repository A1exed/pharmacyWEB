package com.pashin.pharmacyweb.services.dbservices;

import com.pashin.pharmacyweb.entities.NetworkEntity;
import com.pashin.pharmacyweb.repositories.NetworkRepository;
import com.pashin.pharmacyweb.services.IDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NetworkService implements IDBService<NetworkEntity> {

    @Autowired
    private NetworkRepository networkRepository;

    @Override
    public NetworkEntity add(NetworkEntity element) {
        return networkRepository.saveAndFlush(element);
    }

    @Override
    public void deleteByID(long ID) {
        networkRepository.deleteById(ID);
    }

    @Override
    public NetworkEntity editElement(NetworkEntity element) {
        return networkRepository.saveAndFlush(element);
    }

    @Override
    public NetworkEntity getByID(long ID) {
        return networkRepository.getById(ID);
    }

    @Override
    public List<NetworkEntity> getAll() {
        return networkRepository.findAll();
    }
}
