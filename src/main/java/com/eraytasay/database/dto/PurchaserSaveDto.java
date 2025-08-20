package com.eraytasay.database.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class PurchaserSaveDto {
    private String m_username;
    private String m_email;
    private String m_password;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    public String getUsername()
    {
        return m_username;
    }

    public void setUsername(String username)
    {
        this.m_username = username;
    }

    public String getEmail()
    {
        return m_email;
    }

    public void setEmail(String email)
    {
        this.m_email = email;
    }

    public String getPassword()
    {
        return m_password;
    }

    public void setPassword(String password)
    {
        this.m_password = password;
    }

    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }

    @Override
    public String toString()
    {
        return "PurchaserSaveDto(username=%s, email=%s, birthDate=%s)"
                .formatted(m_username, m_email, birthDate.toString());
    }
}
