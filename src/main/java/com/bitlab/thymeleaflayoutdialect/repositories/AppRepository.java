package com.bitlab.thymeleaflayoutdialect.repositories;

import com.bitlab.thymeleaflayoutdialect.models.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends JpaRepository<ApplicationRequest, Long> {
}
