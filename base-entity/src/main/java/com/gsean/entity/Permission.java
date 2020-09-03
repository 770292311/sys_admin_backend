package com.gsean.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Table(name = "`permission`")
public class Permission implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 名称
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 路径
     */
    @Column(name = "`uri`")
    private String uri;

    /**
     * 父权限 id
     */
    @Column(name = "`parrent_id`")
    private Integer parrentId;

    /**
     * 排序
     */
    @Column(name = "`sort`")
    private Integer sort;

    @Column(name = "`create_time`")
    private LocalDateTime createTime;

    @Column(name = "`modify_time`")
    private LocalDateTime modifyTime;

    @Column(name = "`is_deleted`")
    private Byte isDeleted;

    private static final long serialVersionUID = 1L;
}