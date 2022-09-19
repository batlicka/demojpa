package com.example.demojpa.data;

import com.example.demojpa.entity.Children;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildrenRepository extends CrudRepository<Children, Long> {
}
