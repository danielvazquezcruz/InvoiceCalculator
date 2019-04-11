package com.gksoftware.calculator.controller;

import com.gksoftware.calculator.dataobjects.input.GkReceiptLineItemInputDO;
import com.gksoftware.calculator.dataobjects.output.GkReceiptLineItemOutputDO;
import com.gksoftware.calculator.tool.GkPriceCalculator;
import com.gksoftware.calculator.validation.RequestInfoValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("webapp/gkcalculator")
public class GkCalculatorController {

    Logger logger = LoggerFactory.getLogger(GkCalculatorController.class);
    /**
     *
     * @param lineItems
     * @return
     * @throws Exception
     */
    @RequestMapping(value ="calculateLineItems", method = RequestMethod.POST ,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GkReceiptLineItemOutputDO> calculateLineItems(@RequestBody List<GkReceiptLineItemInputDO> lineItems) throws Exception {

        final String METHOD_NAME = "GkCalculatorController:calculateLineItems";

        logger.info(METHOD_NAME + " Entering....");

        new RequestInfoValidator().validateRequestParameters(lineItems); //Validate Request

        GkPriceCalculator priceCalculator = new GkPriceCalculator();
        List<GkReceiptLineItemOutputDO> resultingLineItems = priceCalculator.processLineItems(lineItems);

        logger.info(METHOD_NAME + " Exiting....");
        return resultingLineItems;

    }

}
