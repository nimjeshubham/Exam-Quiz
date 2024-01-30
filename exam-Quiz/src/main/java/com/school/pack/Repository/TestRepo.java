package com.school.pack.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.pack.Model.Test;

public interface TestRepo extends JpaRepository<Test, Integer>{

}
