/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.lab.service;

import ac.cr.una.lab.dao.UniversidadDAO;
import ac.cr.una.lab.model.Universidad;
/**
 *
 * @author Bryan
 */
public class UniversidadServiceImpl implements UniversidadService{
    
    private UniversidadDAO universidadDAO;

    /**
     *
     */
    public UniversidadServiceImpl() {
    }

    /**
     *
     * @param universidadDAO
     */
    public UniversidadServiceImpl(UniversidadDAO universidadDAO) {
        this.universidadDAO = universidadDAO;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Universidad findById(int id) {
        return universidadDAO.findById(id);
    }

    /**
     *
     * @param universidad
     * @return
     */
    @Override
    public Universidad save(Universidad universidad) {
        return universidadDAO.save(universidad);
    }

    /**
     *
     * @return
     */
    public UniversidadDAO getUniversidadDAO() {
        return universidadDAO;
    }

    /**
     *
     * @param universidadDAO
     */
    public void setUniversidadDAO(UniversidadDAO universidadDAO) {
        this.universidadDAO = universidadDAO;
    }
    
    /**
     *
     * @param universidad
     * @return
     */
    @Override
    public Universidad update(Universidad universidad){
        return universidadDAO.update(universidad);
    }

    /**
     *
     * @param universidad
     * @return
     */
    @Override
    public Universidad erase(Universidad universidad){
        return universidadDAO.erase(universidad);
    }
    
}
