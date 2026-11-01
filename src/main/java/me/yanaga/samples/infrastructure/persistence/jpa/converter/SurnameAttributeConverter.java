package me.yanaga.samples.infrastructure.persistence.jpa.converter;

import me.yanaga.samples.domain.model.Surname;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SurnameAttributeConverter implements AttributeConverter<Surname, String> {

    @Override
    public String convertToDatabaseColumn(Surname attribute) {
        if (attribute != null) {
            return attribute.toString();
        }
        return null;
    }

    @Override
    public Surname convertToEntityAttribute(String dbData) {
        if (dbData != null) {
            return Surname.of(dbData);
        }
        return null;
    }
}
