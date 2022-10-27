package Controller;

import Model.Order;

public class OrderViewerController {

    public void changeOrderState(Order pOrder, Order.State pState){
        pOrder.setCurrentState(pState);
    }

}
