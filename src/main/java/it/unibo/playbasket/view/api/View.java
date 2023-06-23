package it.unibo.playbasket.view.api;

/**
 * Interface for the view.
 */
public interface View {

    /**
     * Method that sets the opening view.
     */
    void setOpeningView();

    /**
     * Method that sets the main view.
     */
    void setMainView();

    /**
     * Method that sets the login page.
     */
    void setLoginView();

    /**
     * Method that sets the admin page.
     */
    void setAdminView();

    /**
     * Method that sets more stats page.
     */
    void setMoreStatsView();

    /**
     * Method that sets tesserati management page.
     */
    void setTesseratiView();

    /**
     * Method that sets societa management page.
     */
    void setSocietaView();

    /**
     * Method that sets palestre management page.
     */
    void setPalestreView();

    /**
     * Method that sets campionati management page.
     */
    void setCampionatiView();

    /**
     * Method that sets partite management page.
     */
    void setPartiteView();
}
