package com.back.global.jpa.entity;

import com.back.global.global.GlobalConfig;
import com.back.standard.modelType.CanGetModelTypeCode;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public abstract class BaseEntity implements CanGetModelTypeCode {
    public abstract int getId();

    public abstract LocalDateTime getCreateDate();

    public abstract LocalDateTime getModifyDate();

    @Override
    public String getModelTypeCode() {
        return this.getClass().getSimpleName();
    }

    protected void publishEvent(Object event) {
        GlobalConfig.getEventPublisher().publish(event);
    }
}