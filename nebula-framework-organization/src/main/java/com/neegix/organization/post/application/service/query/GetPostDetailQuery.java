package com.neegix.organization.post.application.service.query;

import com.neegix.cqrs.query.Query;
import com.neegix.organization.post.interfaces.vo.PostVO;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2025/05/27/11:51
 * @Description:
 */
@Data
public class GetPostDetailQuery implements Query<PostVO> {

    private Long id;

    public GetPostDetailQuery(Long id) {
        this.id = id;
    }
}
