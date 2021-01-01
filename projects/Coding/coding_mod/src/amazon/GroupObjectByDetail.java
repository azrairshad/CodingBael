package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given Order id and items:

 O1: [A, B]
 O2: [B, C]
 O3: [D, E]

 Output: [[O1, O2], [O3]]
 */

public class GroupObjectByDetail {

    public class Order{
        Long orderId;
        List<Item> items;
    }

    public class Item{
        Long itemId;
        String desc;
    }


    public HashMap<Long,List<Order>> groupOrdersByItems(List<Order> orders){

        HashMap<Long,List<Order>> groupOrders = new HashMap<>();

        //time complexity o * i
        //space complexity o
        for (Order o : orders ) {
            for (Item i:o.items ) {
                List<Order> ordersByItems = groupOrders.get(i.itemId);
                if(ordersByItems == null) {
                    ordersByItems = new ArrayList<>();
                    groupOrders.put(i.itemId,ordersByItems);
                }
                ordersByItems.add(o);
            }

        }
        return  groupOrders;
    }


    public HashMap<Long,List<Order>> groupOrdersByItems2(List<Order> orders){

        HashMap<Long,List<Order>> groupOrders = new HashMap<>();

        //time complexity o * i
        //space complexity o
        List<String> ordersByItems = new ArrayList<>();
        for (Order o : orders ) {
            for (Item i:o.items ) {
               ordersByItems.add(i.itemId+":"+o.orderId);
            }
        }
        return  groupOrders;
    }
}


