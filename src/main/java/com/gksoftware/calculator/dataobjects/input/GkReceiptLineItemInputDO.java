package com.gksoftware.calculator.dataobjects.input;

public class GkReceiptLineItemInputDO {

    private double basePrice;
    private String itemDescription;
    private int units;
    private String itemId;
    private double percentageDiscount;


    public GkReceiptLineItemInputDO(double basePrice, String itemDescription, int units, String itemId, double percentageDiscount){

        this.basePrice = basePrice;
        this.itemDescription = itemDescription;
        this.units = units;
        this.itemId = itemId;
        this.percentageDiscount = percentageDiscount;

    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public double getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(double percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }
}
