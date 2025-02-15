package com.example.ViaggiAzienda.mapper;

import com.example.ViaggiAzienda.entities.Viaggio;
import com.example.ViaggiAzienda.entitiesDTO.ViaggioDTO;
import org.springframework.stereotype.Component;

@Component
public class ViaggioMapper {

    public static ViaggioDTO toDTO(Viaggio viaggio){
        ViaggioDTO viaggioDTO = new ViaggioDTO();
        viaggioDTO.setId(viaggio.getId());
        viaggioDTO.setDestinazione(viaggio.getDestinazione());
        viaggioDTO.setStatoViaggio(viaggio.getStatoViaggio());
        viaggioDTO.setData(viaggio.getData());
        return viaggioDTO;
    }

    public static Viaggio toEntity(ViaggioDTO viaggioDTO){
        Viaggio viaggio = new Viaggio();
        viaggio.setId(viaggioDTO.getId());
        viaggio.setDestinazione(viaggioDTO.getDestinazione());
        viaggio.setStatoViaggio(viaggioDTO.getStatoViaggio());
        viaggio.setData(viaggioDTO.getData());
        return viaggio;
    }
}
