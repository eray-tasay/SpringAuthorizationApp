package com.eraytasay.database.dto;

public class VendorSaveDto {
    private String m_username;
    private String m_password;
    private String m_company;

    @Override
    public String toString()
    {
        return "VendorSaveDto(username=%s, company=%s)".formatted(m_username, m_company);
    }

    public String getUsername()
    {
        return m_username;
    }

    public void setUsername(String username)
    {
        this.m_username = username;
    }

    public String getPassword()
    {
        return m_password;
    }

    public void setPassword(String password)
    {
        this.m_password = password;
    }

    public String getCompany()
    {
        return m_company;
    }

    public void setCompany(String company)
    {
        this.m_company = company;
    }
}
