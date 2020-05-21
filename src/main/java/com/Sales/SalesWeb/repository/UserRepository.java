package com.Sales.SalesWeb.repository;

import com.Sales.SalesWeb.model.Order;
import com.Sales.SalesWeb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailOrPerson_PersonPhone(String email, String phone);

}
