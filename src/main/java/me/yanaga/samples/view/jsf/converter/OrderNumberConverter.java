package me.yanaga.samples.view.jsf.converter;

import me.yanaga.samples.domain.model.OrderNumber;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = OrderNumber.class)
public class OrderNumberConverter implements Converter<OrderNumber> {

    @Override
    public OrderNumber getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.isBlank()) {
            try {
                return OrderNumber.of(Integer.valueOf(value.trim()));
            } catch (Exception ex) {
                String message = String.format("Invalid Order number: %s", value);
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message), ex);
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, OrderNumber value) {
        if (value != null) {
            return value.toString();
        }
        return null;
    }

}
