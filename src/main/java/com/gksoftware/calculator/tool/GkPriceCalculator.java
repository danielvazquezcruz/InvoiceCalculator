package com.gksoftware.calculator.tool;

import com.gksoftware.calculator.dataobjects.input.GkReceiptLineItemInputDO;
import com.gksoftware.calculator.dataobjects.output.GkReceiptLineItemOutputDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class GkPriceCalculator {

    Logger logger = LoggerFactory.getLogger(GkPriceCalculator.class);

    /**
     *
     * @param lineItems
     * @return List<GkReceiptLineItemOutputDO>
     */
    public List<GkReceiptLineItemOutputDO> processLineItems(List<GkReceiptLineItemInputDO> lineItems){

        final String METHOD_NAME = "GkPriceCalculator:processLineItems";

        logger.info(METHOD_NAME + " Entering with input:" + lineItems);

        List <GkReceiptLineItemOutputDO> outputLineItemList = new ArrayList<GkReceiptLineItemOutputDO>();

        for(GkReceiptLineItemInputDO individualLineItem:lineItems){

            /*double finalItemPrice = ((100 - (individualLineItem.getPercentageDiscount() > 0 ?
                    individualLineItem.getPercentageDiscount():0)) * individualLineItem.getBasePrice()) / 100;*/

            GkReceiptLineItemOutputDO lineItemOutput = new GkReceiptLineItemOutputDO();
            lineItemOutput.setItemDescription(individualLineItem.getItemDescription());
            lineItemOutput.setItemId(individualLineItem.getItemId());
            lineItemOutput.setTotal(
                    ((100 - (individualLineItem.getPercentageDiscount() > 0 ? individualLineItem.getPercentageDiscount():0)) *
                            individualLineItem.getBasePrice() * individualLineItem.getUnits())/ 100);
            //lineItemOutput.setTotal(finalItemPrice * individualLineItem.getUnits());
            lineItemOutput.setTotal(new BigDecimal(Double.toString(lineItemOutput.getTotal())).setScale(2, RoundingMode.HALF_EVEN).doubleValue());
            outputLineItemList.add(lineItemOutput);
        }

        logger.info(METHOD_NAME + " Exiting with output: " + outputLineItemList);

        return outputLineItemList;
    }


}
