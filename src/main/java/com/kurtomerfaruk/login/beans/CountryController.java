package com.kurtomerfaruk.login.beans;

import com.kurtomerfaruk.login.entities.Country;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "countryController")
@ViewScoped
public class CountryController extends AbstractController<Country> {

    @Inject
    private CountrylanguageController countrylanguageListController;
    @Inject
    private CityController cityListController;

    public CountryController() {
        // Inform the Abstract parent controller of the concrete Country?cap_first Entity
        super(Country.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Countrylanguage entities
     * that are retrieved from Country?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Countrylanguage page
     */
    public String navigateCountrylanguageList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Countrylanguage_items", this.getSelected().getCountrylanguageList());
        }
        return "/countrylanguage/index";
    }

    /**
     * Sets the "items" attribute with a collection of City entities that are
     * retrieved from Country?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for City page
     */
    public String navigateCityList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("City_items", this.getSelected().getCityList());
        }
        return "/city/index";
    }

}
