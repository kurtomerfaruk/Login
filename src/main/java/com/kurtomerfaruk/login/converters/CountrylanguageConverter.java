package com.kurtomerfaruk.login.converters;

import com.kurtomerfaruk.login.entities.Countrylanguage;
import com.kurtomerfaruk.login.sessions.CountrylanguageFacade;
import com.kurtomerfaruk.login.beans.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "countrylanguageConverter")
public class CountrylanguageConverter implements Converter {

    @Inject
    private CountrylanguageFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    com.kurtomerfaruk.login.entities.CountrylanguagePK getKey(String value) {
        com.kurtomerfaruk.login.entities.CountrylanguagePK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new com.kurtomerfaruk.login.entities.CountrylanguagePK();
        key.setCountryCode(values[0]);
        key.setLanguage(values[1]);
        return key;
    }

    String getStringKey(com.kurtomerfaruk.login.entities.CountrylanguagePK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getCountryCode());
        sb.append(SEPARATOR);
        sb.append(value.getLanguage());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Countrylanguage) {
            Countrylanguage o = (Countrylanguage) object;
            return getStringKey(o.getCountrylanguagePK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Countrylanguage.class.getName()});
            return null;
        }
    }

}
