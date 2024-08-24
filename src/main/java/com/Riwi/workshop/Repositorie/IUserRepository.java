package com.Riwi.workshop.Repositorie;

import com.Riwi.workshop.Entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository <Event,String> {
}
