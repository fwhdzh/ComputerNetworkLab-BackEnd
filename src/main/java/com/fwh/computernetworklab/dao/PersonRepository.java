package com.fwh.computernetworklab.dao;

import com.fwh.computernetworklab.domain.Person;
import org.apache.ignite.springdata22.repository.IgniteRepository;
import org.apache.ignite.springdata22.repository.config.RepositoryConfig;

@RepositoryConfig(cacheName = "PersonCache")
public interface PersonRepository extends IgniteRepository<Person, Long> {

    /**
     * Find a person with given name in Ignite DB.
     * @param name Person name.
     * @return The person whose name is the given name.
     */
    Person findByUsername(String name);

}