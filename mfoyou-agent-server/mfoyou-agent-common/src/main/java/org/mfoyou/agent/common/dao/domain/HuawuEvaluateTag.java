package org.mfoyou.agent.common.dao.domain;

import java.util.Date;
import org.mfoyou.agent.utils.common.SerializableObject;

public class HuawuEvaluateTag extends SerializableObject {
    private Integer evaluateTagId;

    private Integer evaluateTagType;

    private Integer evaluateTagScore;

    private String evaluateTagName;

    private Integer evaluateTagPrefab;

    private Integer evaluateTagUseTimes;

    private Date evaluateTagCreateTime;

    public Integer getEvaluateTagId() {
        return evaluateTagId;
    }

    public void setEvaluateTagId(Integer evaluateTagId) {
        this.evaluateTagId = evaluateTagId;
    }

    public Integer getEvaluateTagType() {
        return evaluateTagType;
    }

    public void setEvaluateTagType(Integer evaluateTagType) {
        this.evaluateTagType = evaluateTagType;
    }

    public Integer getEvaluateTagScore() {
        return evaluateTagScore;
    }

    public void setEvaluateTagScore(Integer evaluateTagScore) {
        this.evaluateTagScore = evaluateTagScore;
    }

    public String getEvaluateTagName() {
        return evaluateTagName;
    }

    public void setEvaluateTagName(String evaluateTagName) {
        this.evaluateTagName = evaluateTagName == null ? null : evaluateTagName.trim();
    }

    public Integer getEvaluateTagPrefab() {
        return evaluateTagPrefab;
    }

    public void setEvaluateTagPrefab(Integer evaluateTagPrefab) {
        this.evaluateTagPrefab = evaluateTagPrefab;
    }

    public Integer getEvaluateTagUseTimes() {
        return evaluateTagUseTimes;
    }

    public void setEvaluateTagUseTimes(Integer evaluateTagUseTimes) {
        this.evaluateTagUseTimes = evaluateTagUseTimes;
    }

    public Date getEvaluateTagCreateTime() {
        return evaluateTagCreateTime;
    }

    public void setEvaluateTagCreateTime(Date evaluateTagCreateTime) {
        this.evaluateTagCreateTime = evaluateTagCreateTime;
    }
}