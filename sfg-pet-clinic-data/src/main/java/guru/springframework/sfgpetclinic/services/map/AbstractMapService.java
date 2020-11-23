package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class AbstractMapService <T extends BaseEntity,ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T save( T object) {
        if(object != null) {
            object.setId(getNextId());
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object can not be null");
        }
        return object;
    }


    private Long getNextId(){

        Long nextId = null;

        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }

        return nextId;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    T findById(ID id) {
        return map.get(id);
    }
}
