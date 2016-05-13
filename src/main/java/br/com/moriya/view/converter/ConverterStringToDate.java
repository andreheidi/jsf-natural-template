package br.com.moriya.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by andre on 5/11/16.
 */
@FacesConverter(value = "converterStringToDate")
public class ConverterStringToDate implements Converter {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Date date = null;
        if(s != null) {
            try {
                dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                date = dateFormat.parse(s);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        String date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if(o != null) {
            date = dateFormat.format(o);
        }
        return date;
    }
}
