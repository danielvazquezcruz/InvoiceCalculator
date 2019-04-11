package com.gksoftware.calculator.validation;

import com.gksoftware.calculator.dataobjects.input.GkReceiptLineItemInputDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RequestInfoValidator {

    Logger logger = LoggerFactory.getLogger(RequestInfoValidator.class);

    public void validateRequestParameters(List<GkReceiptLineItemInputDO> lineItems) throws IllegalArgumentException{

        final String METHOD_NAME = "RequestInfoValidator:validateRequestParameters";

        logger.info(METHOD_NAME + " Entering....");

        if(lineItems.size() == 0)
            throw new IllegalArgumentException("Request JSON has no line item information");


    }
}
