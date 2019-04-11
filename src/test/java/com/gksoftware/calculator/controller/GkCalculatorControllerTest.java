package com.gksoftware.calculator.controller;

import com.gksoftware.calculator.dataobjects.input.GkReceiptLineItemInputDO;
import com.gksoftware.calculator.dataobjects.output.GkReceiptLineItemOutputDO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GkCalculatorControllerTest {

    @Test
    public void calculateLineItems_DataCase1_Successful() throws Exception{

        List<GkReceiptLineItemInputDO> lineItemInputDOList = new ArrayList<GkReceiptLineItemInputDO>();
        lineItemInputDOList.add(new GkReceiptLineItemInputDO(5.99, "Truffle Gourmet Pasta", 1, "40133", 0));
        lineItemInputDOList.add(new GkReceiptLineItemInputDO(0.27, "Roll", 4, "300198", 35.0));
        lineItemInputDOList.add(new GkReceiptLineItemInputDO(2.89, "Chocolate", 3, "300858", 0));
        lineItemInputDOList.add(new GkReceiptLineItemInputDO(0.99, "Soft Drink", 0, "300158", 10.0));
        lineItemInputDOList.add(new GkReceiptLineItemInputDO(0.3, "Yogurt", 6, "300181", 0));

        GkCalculatorController calculatorController = new GkCalculatorController();
        List<GkReceiptLineItemOutputDO> resultingLineItems = calculatorController.calculateLineItems(lineItemInputDOList);

        for(GkReceiptLineItemOutputDO lineItemOutputDO:resultingLineItems ){

            if("40133".equals(lineItemOutputDO.getItemId())){
                Assert.assertTrue(5.99 == lineItemOutputDO.getTotal() );
            }else if("300198".equals(lineItemOutputDO.getItemId())){
                Assert.assertTrue(0.7 == lineItemOutputDO.getTotal() );
            }else if("300858".equals(lineItemOutputDO.getItemId())){
                Assert.assertTrue(8.67 == lineItemOutputDO.getTotal() );
            }else if("300158".equals(lineItemOutputDO.getItemId())){
                Assert.assertTrue(0 == lineItemOutputDO.getTotal() );
            }else if("300181".equals(lineItemOutputDO.getItemId())){
                Assert.assertTrue(1.8 == lineItemOutputDO.getTotal() );
            }
        }

    }

    @Test
    public void calculateLineItems_DataCase2_Failure() throws Exception{

        List<GkReceiptLineItemInputDO> lineItemInputDOList = new ArrayList<GkReceiptLineItemInputDO>();
        lineItemInputDOList.add(new GkReceiptLineItemInputDO(5.99, "Truffle Gourmet Pasta", 1, "40133", 0));
        lineItemInputDOList.add(new GkReceiptLineItemInputDO(0.27, "Roll", 4, "300198", 35.0));
        lineItemInputDOList.add(new GkReceiptLineItemInputDO(2.89, "Chocolate", 3, "300858", 0));
        lineItemInputDOList.add(new GkReceiptLineItemInputDO(0.99, "Soft Drink", 0, "300158", 10.0));
        lineItemInputDOList.add(new GkReceiptLineItemInputDO(0.3, "Yogurt", 6, "300181", 0));

        GkCalculatorController calculatorController = new GkCalculatorController();
        List<GkReceiptLineItemOutputDO> resultingLineItems = calculatorController.calculateLineItems(lineItemInputDOList);

        for(GkReceiptLineItemOutputDO lineItemOutputDO:resultingLineItems ){

            if("40133".equals(lineItemOutputDO.getItemId())){
                Assert.assertFalse(4.99 == lineItemOutputDO.getTotal() );
            }else if("300198".equals(lineItemOutputDO.getItemId())){
                Assert.assertFalse(0.6 == lineItemOutputDO.getTotal() );
            }else if("300858".equals(lineItemOutputDO.getItemId())){
                Assert.assertFalse(8.47 == lineItemOutputDO.getTotal() );
            }else if("300158".equals(lineItemOutputDO.getItemId())){
                Assert.assertTrue(0 == lineItemOutputDO.getTotal() );
            }else if("300181".equals(lineItemOutputDO.getItemId())){
                Assert.assertFalse(1.5 == lineItemOutputDO.getTotal() );
            }
        }

    }

    @Test (expected  = IllegalArgumentException.class)
    public void calculateLineItems_DataCase3_Failure() throws Exception{

        List<GkReceiptLineItemInputDO> lineItemInputDOList = new ArrayList<GkReceiptLineItemInputDO>();

        GkCalculatorController calculatorController = new GkCalculatorController();
        calculatorController.calculateLineItems(lineItemInputDOList);

    }
}
