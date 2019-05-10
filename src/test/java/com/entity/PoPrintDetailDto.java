package com.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 入库回执单信息明细
 */
public class PoPrintDetailDto implements Serializable {
    private static final long serialVersionUID = 4992764567452206593L;

    /**
     * 商品编码
     */
    private String skuCode;

    /**
     * 商品名称
     */
    private String skuName;

    /**
     * 商品条码
     */
    private String skuBarCode;

    /**
     * 应收数
     */
    private BigDecimal expectQty;

    /**
     * 实收数
     */
    private BigDecimal actualQty;

    /**
     * 进价
     */
    private BigDecimal inPrice;

    /**
     * 单位
     */
    private String uom;

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getSkuBarCode() {
        return skuBarCode;
    }

    public void setSkuBarCode(String skuBarCode) {
        this.skuBarCode = skuBarCode;
    }

    public BigDecimal getExpectQty() {
        return expectQty;
    }

    public void setExpectQty(BigDecimal expectQty) {
        this.expectQty = expectQty;
    }

    public BigDecimal getActualQty() {
        return actualQty;
    }

    public void setActualQty(BigDecimal actualQty) {
        this.actualQty = actualQty;
    }

    public BigDecimal getInPrice() {
        return inPrice;
    }

    public void setInPrice(BigDecimal inPrice) {
        this.inPrice = inPrice;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}
