package application.view;


public abstract class ViewController {
    /**
     * View that this view controller controls.
     */
    private View view;

    /**
     * Get the view controlled by the view controller.
     * @return The view controlled by the view controller.
     */
    public View getView() {
        return view;
    }

    /**
     * Set the view controlled by the view controller.
     * @param newView The new view.
     */
    public void setView(View newView) {
        view = newView;
    }
}
