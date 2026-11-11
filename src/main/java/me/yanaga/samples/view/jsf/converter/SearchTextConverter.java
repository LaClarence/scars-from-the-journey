package me.yanaga.samples.view.jsf.converter;

import me.yanaga.samples.view.SearchText;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = SearchText.class)
public class SearchTextConverter implements Converter<SearchText> {

    @Override
    public SearchText getAsObject(FacesContext context, UIComponent component, String value) {
        return SearchText.of(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, SearchText value) {
        return value == null ? "" : value.value();
    }

}
