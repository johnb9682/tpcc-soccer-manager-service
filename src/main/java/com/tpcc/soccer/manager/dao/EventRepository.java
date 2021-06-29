package com.tpcc.soccer.manager.dao;


import org.springframework.data.repository.CrudRepository;
import com.tpcc.soccer.manager.entity.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {

}
