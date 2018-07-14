package br.com.bernardes.lucas.service;

import br.com.bernardes.lucas.entity.MyObject;
import br.com.bernardes.lucas.repository.MyObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyObjectService {

    @Autowired
    private MyObjectRepository repository;

    public MyObjectService() {
    }

    public List<MyObject> getAll() {
        return this.repository.findAll();
    }

    public Optional<MyObject> getById(String id) {
        return this.repository.findById(id);
    }

    public Boolean update(String id, MyObject myObject) {
        Optional<MyObject> optional = this.repository.findById(id);
        if (optional.isPresent()) {
            MyObject resultado = optional.get();
            resultado.setName(myObject.getName());
            resultado.setDate(myObject.getDate());
            resultado.setDescription(myObject.getDescription());
            this.repository.save(resultado);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public MyObject save(MyObject myObject) {
        return this.repository.save(myObject);
    }

    public Boolean delete(String id) {
        Optional<MyObject> myObject = this.repository.findById(id);
        if(myObject.isPresent()) {
            this.repository.delete(myObject.get());
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
