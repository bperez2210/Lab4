/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.lab.dao;

import ac.cr.una.lab.model.Universidad;
/**
 *
 * @author Bryan
 */
public interface UniversidadDAO {
    
    /**
     *
     * @param id
     * @return
     */
    public Universidad findById(int id);

    /**
     *
     * @param universidad
     * @return
     */
    public Universidad save(Universidad universidad);

    /**
     *
     * @param universidad
     * @return
     */
    public Universidad update(Universidad universidad);

    /**
     *
     * @param universidad
     * @return
     */
    public Universidad erase(Universidad universidad);
}
