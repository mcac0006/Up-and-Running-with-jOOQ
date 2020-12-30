/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.pojos;


import java.io.Serializable;

import javax.annotation.processing.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.4",
        "schema version:1.1"
    },
    date = "2020-12-29T07:38:31.604Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqDepartment implements Serializable {

    private static final long serialVersionUID = -41464091;

    private Long   departmentId;
    private String name;
    private String phone;
    private Short  code;
    private String officeCode;
    private String topic;
    private String depNetIpv4;

    public JooqDepartment() {}

    public JooqDepartment(JooqDepartment value) {
        this.departmentId = value.departmentId;
        this.name = value.name;
        this.phone = value.phone;
        this.code = value.code;
        this.officeCode = value.officeCode;
        this.topic = value.topic;
        this.depNetIpv4 = value.depNetIpv4;
    }

    public JooqDepartment(
        Long   departmentId,
        String name,
        String phone,
        Short  code,
        String officeCode,
        String topic,
        String depNetIpv4
    ) {
        this.departmentId = departmentId;
        this.name = name;
        this.phone = phone;
        this.code = code;
        this.officeCode = officeCode;
        this.topic = topic;
        this.depNetIpv4 = depNetIpv4;
    }

    public Long getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @NotNull
    @Size(max = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Size(max = 50)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Short getCode() {
        return this.code;
    }

    public void setCode(Short code) {
        this.code = code;
    }

    @NotNull
    @Size(max = 10)
    public String getOfficeCode() {
        return this.officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    @NotNull
    @Size(max = 100)
    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Size(max = 16)
    public String getDepNetIpv4() {
        return this.depNetIpv4;
    }

    public void setDepNetIpv4(String depNetIpv4) {
        this.depNetIpv4 = depNetIpv4;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JooqDepartment (");

        sb.append(departmentId);
        sb.append(", ").append(name);
        sb.append(", ").append(phone);
        sb.append(", ").append(code);
        sb.append(", ").append(officeCode);
        sb.append(", ").append(topic);
        sb.append(", ").append(depNetIpv4);

        sb.append(")");
        return sb.toString();
    }
}