package com.tutorial.basic.dao;

import com.tutorial.basic.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerDAO extends CrudRepository<Customer, Integer> {
    @Override
    List<Customer> findAll();

    @Override
    <S extends Customer> S save(S entity);

    @Override
    <S extends Customer> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Customer> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    Iterable<Customer> findAllById(Iterable<Integer> integers);

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(Customer entity);

    @Override
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    void deleteAll(Iterable<? extends Customer> entities);

    @Override
    void deleteAll();
}
