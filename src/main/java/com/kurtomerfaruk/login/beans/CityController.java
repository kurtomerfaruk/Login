package com.kurtomerfaruk.login.beans;

import com.kurtomerfaruk.login.entities.City;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "cityController")
@ViewScoped
public class CityController extends AbstractController<City> {

    @Inject
    private CountryController countryCodeController;

    public CityController() {
        // Inform the Abstract parent controller of the concrete City?cap_first Entity
        super(City.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        countryCodeController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Country controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCountryCode(ActionEvent event) {
        if (this.getSelected() != null && countryCodeController.getSelected() == null) {
            countryCodeController.setSelected(this.getSelected().getCountryCode());
        }
    }
}
