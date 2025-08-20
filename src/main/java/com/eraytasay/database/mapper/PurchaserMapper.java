package com.eraytasay.database.mapper;

import com.eraytasay.database.dto.PurchaserSaveDto;
import com.eraytasay.database.dto.PurchaserDto;
import com.eraytasay.database.entity.Purchaser;
import com.eraytasay.database.view.IPurchaserView;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PurchaserMapper {
    public PurchaserDto toPurchaserDto(IPurchaserView purchaserView)
    {
        var purchaserDto = new PurchaserDto();

        purchaserDto.id = purchaserView.getId();
        purchaserDto.username = purchaserView.getUsername();
        purchaserDto.email = purchaserView.getEmail();
        purchaserDto.birthDate = purchaserView.getBirthDate();

        return purchaserDto;
    }

    public PurchaserDto toPurchaserDto(Purchaser purchaser)
    {
        var purchaserDto = new PurchaserDto();

        purchaserDto.id = purchaser.id;
        purchaserDto.username = purchaser.username;
        purchaserDto.email = purchaser.email;
        purchaserDto.birthDate = purchaser.birthDate;

        return purchaserDto;
    }

    public Purchaser toPurchaser(PurchaserSaveDto purchaserSaveDto, PasswordEncoder passwordEncoder)
    {
        var purchaser = new Purchaser();

        purchaser.username = purchaserSaveDto.getUsername();
        purchaser.email = purchaserSaveDto.getEmail();
        purchaser.birthDate = purchaserSaveDto.getBirthDate();
        purchaser.password = passwordEncoder.encode(purchaserSaveDto.getPassword());

        return purchaser;
    }
}
