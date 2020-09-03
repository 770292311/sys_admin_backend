package com.gsean.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Table(name = "`user_role`")
public class UserRole implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * ??id
     */
    @Column(name = "`user_id`")
    private Long userId;

    /**
     * ??id
     */
    @Column(name = "`role_id`")
    private Long roleId;

    private static final long serialVersionUID = 1L;
}