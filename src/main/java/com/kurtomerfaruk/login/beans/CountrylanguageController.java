package com.kurtomerfaruk.login.beans;

import com.kurtomerfaruk.login.entities.Countrylanguage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "countrylanguageController")
@ViewScoped
public class CountrylanguageController extends AbstractController<Countrylanguage> {

    @Inject
    private CountryController countryController;

    public CountrylanguageController() {
        // Inform the Abstract parent controller of the concrete Countrylanguage?cap_first Entity
        super(Countrylanguage.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getCountrylanguagePK().setCountryCode(this.getSelected().getCountry().getCode());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setCountrylanguagePK(new com.kurtomerfaruk.login.entities.CountrylanguagePK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        countryController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Country controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCountry(ActionEvent event) {
        if (this.getSelected() != null && countryController.getSelected() == null) {
            countryController.setSelected(this.getSelected().getCountry());
        }
    }
}
