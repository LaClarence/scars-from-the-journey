package me.yanaga.samples.view.jsf.converter;

import com.querydsl.core.annotations.QueryDelegate;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.dsl.ComparablePath;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringExpression;
import me.yanaga.samples.domain.model.Name;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = Name.class)
public class NameConverter implements Converter<Name> {

    @Override
    public Name getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.isEmpty()) {
            try {
                return Name.of(value);
            } catch (Exception ex) {
                throw new ConverterException(String.format("Invalid Name: %s", value), ex);
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Name value) {
        if (value != null) {
            return value.value();
        }
        return null;
    }

    @QueryDelegate(Name.class)
    public static StringExpression stringValue(ComparablePath<?> path) {
        return Expressions.stringOperation(Ops.STRING_CAST, path);
    }

}
