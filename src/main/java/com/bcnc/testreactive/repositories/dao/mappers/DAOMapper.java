package com.bcnc.testreactive.repositories.dao.mappers;

/**
 * Interface for a generic DAO/DOM mapper
 * @param <DAO> The Data access object
 * @param <DOM> The Domain object
 */
public interface DAOMapper<DAO, DOM> {

    /**
     *
     * @param e The Data access object to map
     * @return A Domain object with the DAO data.
     */
    DOM getFromDAO(DAO e);

    /**
     *
     * @param e The Domain object to map
     * @return A Data access object with the DOM data.
     */
    DAO getFromDOM(DOM e);
}
