package ac.una.lab.test;

import ac.cr.una.lab.dao.UniversidadDAO;
import ac.cr.una.lab.dao.UniversidadDAOHibernateImpl;
import ac.cr.una.lab.dao.UniversidadDAOJdbcImpl;
import ac.cr.una.lab.model.Universidad;
import ac.cr.una.lab.service.UniversidadService;
import ac.cr.una.lab.service.UniversidadServiceImpl;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bryan
 */
public class UniversidadDAOTest {
    
    private UniversidadDAO universidadDAO;
    private UniversidadService universidadService;

    /**
     *
     */
    public UniversidadDAOTest() {
    }

    /**
     *
     */
    @Test
    public void testFindById() {
        universidadDAO = mock(UniversidadDAOHibernateImpl.class);
        universidadService = new UniversidadServiceImpl(universidadDAO);
        Universidad universidad = new Universidad();
        universidad.setName("Universidad Nacional Costa Rica");
        universidad.setDireccion("Heredia");
        universidad.setEmail("progra3@gmail.com");
        when(universidadService.findById(1)).thenReturn(universidad);
        assertThat(universidad.getName(), is("Universidad Nacional Costa Rica"));
    }

    /**
     *
     */
    @Test
    public void testFindByIdJdbc() {
        universidadDAO = mock(UniversidadDAOJdbcImpl.class);
        universidadService = new UniversidadServiceImpl(universidadDAO);
        Universidad universidad = new Universidad();
        universidad.setName("Universidad Nacional Costa Rica");
        universidad.setDireccion("Heredia");
        universidad.setTelefono("8800-8879");
        when(universidadService.findById(1)).thenReturn(universidad);
        assertThat(universidad.getName(), is("Universidad Nacional Costa Rica"));
    }

    /**
     *
     */
    @Test
    public void testSave() {
        universidadDAO = mock(UniversidadDAOHibernateImpl.class);
        universidadService = new UniversidadServiceImpl(universidadDAO);
        Universidad universidad = new Universidad();
        universidad.setName("Universidad Nacional Costa Rica");
        universidad.setDireccion("Heredia");
        universidad.setTelefono("8800-8879");
        when(universidadDAO.save(any(Universidad.class)))
                .thenAnswer(new Answer<Universidad>() {
                    @Override
                    public Universidad answer(InvocationOnMock invocation) throws Throwable {
                        Universidad universidad = (Universidad) invocation.getArguments()[0];
                        universidad.setId(1);
                        return universidad;
                    }
                });
        assertNotNull(universidad.getId());
        universidad = universidadService.save(universidad);
        assertNotNull(universidad.getId());
        assertTrue(universidad.getId() > 0);
    }

    /**
     *
     */
    @Test
    public void testSaveJdbc() {
        universidadDAO = mock(UniversidadDAOJdbcImpl.class);
        universidadService = new UniversidadServiceImpl(universidadDAO);
        Universidad universidad = new Universidad();
        universidad.setName("Universidad Nacional Costa Rica");
        universidad.setDireccion("Heredia");
        universidad.setTelefono("8800-8879");
        when(universidadDAO.save(any(Universidad.class)))
                .thenAnswer(new Answer<Universidad>() {
                    @Override
                    public Universidad answer(InvocationOnMock invocation) throws Throwable {
                        Universidad universidad = (Universidad) invocation.getArguments()[0];
                        universidad.setId(1);
                        return universidad;
                    }
                });
        assertNotNull(universidad.getId());
        universidad = universidadService.save(universidad);
        assertNotNull(universidad.getId());
        assertTrue(universidad.getId() > 0);
    }
    
    /**
     *
     */
    @Test
    public void testUpdateData(){
        universidadDAO = mock(UniversidadDAOJdbcImpl.class);
        universidadService = new UniversidadServiceImpl(universidadDAO);
        Universidad universidad = new Universidad();
        universidad.setName("Universidad Costa Rica");
        universidad.setDireccion("San Pedro");
        universidad.setTelefono("8800-8879");
        when(universidadDAO.save(any(Universidad.class)))
                .thenAnswer(new Answer<Universidad>() {
                    @Override
                    public Universidad answer(InvocationOnMock invocation) throws Throwable {
                        Universidad universidad = (Universidad) invocation.getArguments()[0];
                        universidad.setId(1);
                        return universidad;
                    }
                });
        assertNotNull(universidad.getId());
        universidad = universidadService.save(universidad);
        System.out.println(universidad);
        universidad.setName("Universidad Latina");
        universidad.setDireccion("San Pedro");
        universidad.setEmail("latina@gmail.com");
        when(universidadService.update(universidad)).thenReturn(universidad);
        universidad = universidadService.save(universidad);
        System.out.println(universidad);
        when(universidadService.findById(1)).thenReturn(universidad);
         assertThat(universidad.getName(), is("Universidad Latina"));
    }
    
    /**
     *
     */
    @Test
    public void testEraseData(){
        universidadDAO = mock(UniversidadDAOJdbcImpl.class);
        universidadService = new UniversidadServiceImpl(universidadDAO);
        Universidad universidad = new Universidad();
        universidad.setName("Instituto Tecnologico de Costa Rica");
        universidad.setDireccion("Sede Zapote");
        universidad.setTelefono("8800-3535");
        when(universidadDAO.save(any(Universidad.class)))
                .thenAnswer(new Answer<Universidad>() {
                    @Override
                    public Universidad answer(InvocationOnMock invocation) throws Throwable {
                        Universidad universidad = (Universidad) invocation.getArguments()[0];
                        universidad.setId(1);
                        return universidad;
                    }
                });
        assertNotNull(universidad.getId());
        universidad = universidadService.erase(universidad);
        assertTrue(null==universidad);
    }
    
}
