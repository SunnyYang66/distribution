package org.mfoyou.agent.common.dao.domain;

import org.mfoyou.agent.utils.common.SerializableObject;

public class AgentTest extends SerializableObject {
    private Integer id;

    private String test;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test == null ? null : test.trim();
    }
}