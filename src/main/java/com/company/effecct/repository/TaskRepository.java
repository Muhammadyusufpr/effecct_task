package com.company.effecct.repository;

import com.company.effecct.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/11/2023
 * @project effecct
 * @contact '@GMuhammadyusuf'
 */
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {



}
