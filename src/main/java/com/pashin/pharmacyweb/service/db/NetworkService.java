package com.pashin.pharmacyweb.service.db;

import com.pashin.pharmacyweb.model.NetworkModel;
import com.pashin.pharmacyweb.repository.NetworkRepository;
import com.pashin.pharmacyweb.service.IDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NetworkService implements IDBService<NetworkModel, Long> {

    @Autowired
    private NetworkRepository networkRepository;

    @Override
    public NetworkModel add(NetworkModel element) {
        return networkRepository.saveAndFlush(element);
    }

    @Override
    public void deleteByID(Long id) {
        networkRepository.deleteById(id);
    }

    @Override
    public NetworkModel editElement(NetworkModel element) {
        return networkRepository.saveAndFlush(element);
    }

    @Override
    public NetworkModel getByID(Long id) {
        return networkRepository.getById(id);
    }

    @Override
    public List<NetworkModel> getAll() {
        return networkRepository.findAll();
    }
}
