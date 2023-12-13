package com.company.effecct.repository;

import com.company.effecct.dto.response.task.TaskCommentMapperDTO;
import com.company.effecct.entity.TaskCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/11/2023
 * @project effecct
 * @contact '@GMuhammadyusuf'
 */
public interface TaskCommentRepository extends JpaRepository<TaskCommentEntity, Long> {

    Optional<TaskCommentEntity> findByProfileId(Long profileId);

    @Query("select tc.id as tcId, t.id as taskId, t.content as content, t.priority as priority," +
            " t.status as status, p.id as profileId, p.name as name, p.email as email, tc.comment as comment " +
            " from TaskCommentEntity as tc " +
            " inner join TaskEntity as t on t.id = tc.taskId " +
            " inner join ProfileEntity as p on tc.profileId = p.id" +
            " where p.id =?1")
    List<TaskCommentMapperDTO> findByProfileIdNative(Long profileId);


}
