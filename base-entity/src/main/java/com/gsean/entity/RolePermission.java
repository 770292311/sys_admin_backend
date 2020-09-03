package com.gsean.entity;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Table(name = "`role_permission`")
public class RolePermission implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * ??id
     */
    @Column(name = "`role_id`")
    private Long roleId;

    /**
     * ??id
     */
    @Column(name = "`permission_id`")
    private Long permissionId;

    private static final long serialVersionUID = 1L;
}