package com.st.springboot.thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.springboot.thymeleaf.entity.Data;

public interface DataRepository extends JpaRepository<Data, Integer> {

}
