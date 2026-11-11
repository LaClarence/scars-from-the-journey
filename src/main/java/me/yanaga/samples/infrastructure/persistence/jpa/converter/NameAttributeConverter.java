package me.yanaga.samples.infrastructure.persistence.jpa.converter;

import me.yanaga.samples.domain.model.Name;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class NameAttributeConverter implements AttributeConverter<Name, String> {

    @Override
    public String convertToDatabaseColumn(Name attribute) {
        if (attribute != null) {
            return attribute.toString();
        }
        return null;
    }

    @Override
    public Name convertToEntityAttribute(String dbData) {
        if (dbData != null) {
            return Name.of(dbData);
        }
        return null;
    }
}
