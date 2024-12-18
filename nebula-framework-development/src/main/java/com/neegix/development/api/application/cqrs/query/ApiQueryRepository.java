package com.neegix.development.api.application.cqrs.query;
import com.neegix.application.query.IPageableQueryRepository;
import com.neegix.development.api.application.dto.ApiDTO;
import com.neegix.development.api.interfaces.vo.ApiVO;

import java.util.Optional;

/**
  * This file is auto-generated by nebula-framework-generator.
  * The auto-generation plugin was developed using IntelliJ IDEA Community Edition.
  * Thanks to JetBrains for their outstanding contributions to the developer community.
  * <p>
  * The code generated by this tool is owned by the user of the tool.
  * The tool itself is copyrighted by <a href="https://www.neegix.com">https://www.neegix.com</a>.
  *
  * @author <a href="https://www.neegix.com">https://www.neegix.com</a>
  * @version 1.0.0
  * @since 2024-11-22 11:43:14
  */

public interface ApiQueryRepository extends IPageableQueryRepository<Long, ApiDTO, ApiVO> {
   Optional<ApiDTO> findByAccess(String name);
}
