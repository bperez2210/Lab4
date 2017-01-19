/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.lab.dao;

import ac.cr.una.lab.model.Universidad;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author Bryan
 */
public class UniversidadDAOHibernateImpl implements UniversidadDAO{
    
    private final Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Universidad findById(int id) {
        Universidad universidad = null;
        Query query = session.createQuery("from university where id = :id ");
        query.setParameter("id", id);

        if (query.list().size() > 0) {
            universidad = (Universidad) query.list().get(0);
        }

        return universidad;
    }

    /**
     *
     * @param universidad
     * @return
     */
    @Override
    public Universidad save(Universidad universidad) {
        session.beginTransaction();
        session.save(universidad);
        session.getTransaction().commit();

        return universidad;
    }
    
    /**
     *
     * @param universidad
     * @return
     */
    @Override
    public Universidad erase(Universidad universidad){
        session.delete(universidad);
        return universidad;
    }
    
    /**
     *
     * @param universidad
     * @return
     */
    @Override
    public Universidad update(Universidad universidad){
        session.update(universidad);
        return universidad;
    }
}
