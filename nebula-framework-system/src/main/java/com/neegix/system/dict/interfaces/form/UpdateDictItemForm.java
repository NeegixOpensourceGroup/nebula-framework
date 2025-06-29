package com.neegix.system.dict.interfaces.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/20/17:19
 * @Description:
 */
@Data
public class UpdateDictItemForm {
    @NotBlank(message = "名称不能为空")
    private String name;
    @NotBlank(message = "值不能为空")
    private String value;
    private Integer sort;
}
