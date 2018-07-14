package br.com.bernardes.lucas.controller;

import br.com.bernardes.lucas.entity.MyObject;
import br.com.bernardes.lucas.service.MyObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = MyObjectController.URI_RESOURCE)
public class MyObjectController {

    protected static final String URI_RESOURCE = "/api/myobject";
    @Autowired
    private MyObjectService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll() {
        return ResponseEntity
                .ok(this.service.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable String id) {
        Optional<MyObject> optional = this.service.getById(id);
        if (optional.isPresent()) {
            return ResponseEntity
                    .ok(optional.get());
        }
        return ResponseEntity
                .notFound().build();
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody MyObject myObject) {
        final MyObject response = this.service.save(myObject);
        return ResponseEntity
                .created(URI.create(String.format("%s/%s", MyObjectController.URI_RESOURCE, response.getId())))
                .body(response);
    }

    @Transactional
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable String id, @RequestBody MyObject myObject) {
        Boolean result = this.service.update(id, myObject);
        if (result) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        Boolean resultado = this.service.delete(id);
        if(resultado) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
