package com.example.demotest.myapp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author liqingyuan
 * @since 2022-12-31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 作业
     */
    private String name;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 作业状态
     */
    private String status;

    /**
     * 作业内容
     */
    private String content;

    private Integer studentId;
    private Integer fraction;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Operation{" +
            "name = " + name +
            ", id = " + id +
            ", status = " + status +
            ", content = " + content +
            ", studentId = " + studentId +
        "}";
    }
}
