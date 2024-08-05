package com.devsuperior.hr_worker.repository;

import com.devsuperior.hr_worker.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
