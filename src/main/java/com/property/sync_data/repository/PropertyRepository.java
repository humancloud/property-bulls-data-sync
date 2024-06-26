package com.property.sync_data.repository;

import com.property.sync_data.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropertyRepository extends JpaRepository<Property, String> {

    Optional<Property> findByListingKey(String listingKey);

}
