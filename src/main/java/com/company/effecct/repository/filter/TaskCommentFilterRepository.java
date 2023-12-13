package com.company.effecct.repository.filter;

import com.company.effecct.dto.request.task.TaskFilterDTO;
import com.company.effecct.dto.response.task.TaskMapDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author 'Gapirov Muhammadyusuf' on 12/13/2023
 * @project effecct
 * @contact '@GMuhammadyusuf'
 */
@Repository
@RequiredArgsConstructor
public class TaskCommentFilterRepository {
    private final EntityManager entityManager;


    public TaskMapDTO taskCommentFilter(TaskFilterDTO dto, int page, int size) {
        StringBuilder sqlQuery = new StringBuilder();

        StringBuilder countQuery =
                new StringBuilder(
                        """
                                        select count(p.id)
                                        from TaskCommentEntity as tc
                                inner join ProfileEntity as p on p.id = tc.profileId
                                inner join TaskEntity  as t on t.id = tc.taskId
                                where tc.id is not null""");

        String sql =
                """
                         select new com.company.effecct.dto.response.task.TaskMapDTO(
                         tc.id as tcId, tc.comment as comment, p.id as profileId, p.name as name, p.email as email,
                         t.id as taskId, t.content as content, t.priority as priority, t.status as status,
                         t.createdDate as createdDate
                         ) from TaskCommentEntity as tc
                        inner join ProfileEntity as p on p.id = tc.profileId
                        inner join TaskEntity  as t on t.id = tc.taskId
                        where tc.id is not null""";

        Map<String, Object> param = new HashMap<>();
        sqlQuery.append(sql);

        if (Optional.ofNullable(dto).isPresent()) {

            if (Optional.ofNullable(dto.getProfileId()).isPresent()) {
                sqlQuery.append(" and p.id = :profileId ");
                countQuery.append(" and p.id = :profileId ");
                param.put("profileId", dto.getProfileId());
            }

            if (Optional.ofNullable(dto.getTaskId()).isPresent()) {
                sqlQuery.append(" and t.id = :taskId ");
                countQuery.append(" and t.id = :taskId ");
                param.put("taskId", dto.getTaskId());
            }


            if (Optional.ofNullable(dto.getPriority()).isPresent()) {
                sqlQuery.append(" and t.priority = :priority ");
                countQuery.append(" and t.priority = :priority ");
                param.put("priority", dto.getPriority());
            }

            if (Optional.ofNullable(dto.getStatus()).isPresent()) {
                sqlQuery.append(" and t.status = :status ");
                countQuery.append(" and t.status = :status ");
                param.put("status", dto.getStatus());
            }
        }
        Query query = entityManager.createQuery(sqlQuery.toString(), TaskMapDTO.class);
        Query count = entityManager.createQuery(countQuery.toString(), Long.class);

        param.forEach(query::setParameter);
        param.forEach(count::setParameter);

        query.setFirstResult(page * size);
        query.setMaxResults(size);

        Long countAll = (Long) count.getResultList().get(0);
        List<TaskMapDTO> resList = query.getResultList();

        return new TaskMapDTO(countAll, resList);
    }


}
