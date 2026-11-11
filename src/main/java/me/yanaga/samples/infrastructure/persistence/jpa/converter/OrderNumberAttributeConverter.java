package me.yanaga.samples.infrastructure.persistence.jpa.converter;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import me.yanaga.samples.domain.model.OrderNumber;

@Converter(autoApply = true)
public class OrderNumberAttributeConverter implements AttributeConverter<OrderNumber, Integer> {
    @Override
    public Integer convertToDatabaseColumn(OrderNumber attribute) {
        if (attribute != null ) {
            return attribute.toInteger();
        }
        return null;
    }

    @Override
    public OrderNumber convertToEntityAttribute(Integer dbData) {
        if (dbData != null) {
            return OrderNumber.of(dbData);
        }
        return null;
    }
}
