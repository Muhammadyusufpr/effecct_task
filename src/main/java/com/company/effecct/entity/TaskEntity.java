package com.company.effecct.entity;

import com.company.effecct.enums.TaskPriority;
import com.company.effecct.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/11/2023
 * @project effecct
 * @contact '@GMuhammadyusuf'
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @Column
    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @Column
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column
    private LocalDateTime createdDate;


}
