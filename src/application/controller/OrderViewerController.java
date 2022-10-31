package application.controller;

import application.Model.Order;

public class OrderViewerController {

    public void changeOrderState(Order pOrder, Order.State pState){
        pOrder.setCurrentState(pState);
    }

}
