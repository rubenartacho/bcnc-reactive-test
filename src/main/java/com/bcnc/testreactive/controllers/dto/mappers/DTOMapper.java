package com.bcnc.testreactive.controllers.dto.mappers;
/**
 * Interface for a generic DTO/DOM mapper
 * @param <DTO> The Data transfer object
 * @param <DOM> The Domain object
 */
public interface DTOMapper <DTO,DOM>{

        /**
         *
         * @param e The Data transfer object to map
         * @return A Domain object with the DAO data.
         */
        DOM getFromDTO(DTO e);

        /**
         *
         * @param e The Domain object to map
         * @return A Data transfer object with the DOM data.
         */
        DTO getFromDOM(DOM e);

}
