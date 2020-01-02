package com.vash.boot_demo.dao;

import com.vash.boot_demo.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Integer> {

    Reader findByUsername(String username);

}
