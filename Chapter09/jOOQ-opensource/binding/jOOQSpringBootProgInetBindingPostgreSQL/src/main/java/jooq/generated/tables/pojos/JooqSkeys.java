/*
 * This file is generated by jOOQ.
 */
package jooq.generated.tables.pojos;


import java.io.Serializable;

import javax.annotation.processing.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.4",
        "schema version:1.1"
    },
    date = "2020-12-28T06:34:31.202Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqSkeys implements Serializable {

    private static final long serialVersionUID = -1845194525;

    private String skeys;

    public JooqSkeys() {}

    public JooqSkeys(JooqSkeys value) {
        this.skeys = value.skeys;
    }

    public JooqSkeys(
        String skeys
    ) {
        this.skeys = skeys;
    }

    public String getSkeys() {
        return this.skeys;
    }

    public void setSkeys(String skeys) {
        this.skeys = skeys;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("JooqSkeys (");

        sb.append(skeys);

        sb.append(")");
        return sb.toString();
    }
}