package com.eraytasay.database.dto;

public class ProductSaveDto {
    private String m_name;
    private double m_price;
    private String m_vendorUsername;

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public double getPrice()
    {
        return m_price;
    }

    public void setPrice(double price)
    {
        m_price = price;
    }

    public String getVendorUsername()
    {
        return m_vendorUsername;
    }

    public void setVendorUsername(String vendorUsername)
    {
        m_vendorUsername = vendorUsername;
    }

    @Override
    public String toString()
    {
        return "ProductSaveDto(name=%s, price=%s, vendorUsername= %s)".formatted(m_name, m_price, m_vendorUsername);
    }
}
