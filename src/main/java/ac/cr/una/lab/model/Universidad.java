/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.lab.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
/**
 *
 * @author Bryan
 */
@Entity
@Table(name = "universidades", catalog = "progralab4", uniqueConstraints = {
    @UniqueConstraint(columnNames = "Nombre"),
        @UniqueConstraint(columnNames = "Direccion"),
            @UniqueConstraint(columnNames = "Email"),
		@UniqueConstraint(columnNames = "Telefono")})

public class Universidad {
    private int id;
    private String nombre;
    private String direccion;
    private String email;
    private String telefono;

    /**
     *
     */
    public Universidad() {
    }

    /**
     *
     * @param id
     * @param name
     * @param direccion
     * @param email
     * @param telefono
     */
    public Universidad(int id, String name, String direccion, String email, String telefono) {
        this.id = id;
        this.nombre = name;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

    /**
     *
     * @return
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     *
     * @return
     */
    @Column(name = "nombre", unique = true, nullable = false, length = 50)
    public String getName() {
        return nombre;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.nombre = name;
    }
    
    /**
     *
     * @return
     */
    @Column(name = "direccion", unique = true, nullable = false, length = 50)
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return
     */
    @Column(name = "email", unique = true, nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     *
     * @return
     */
    @Column(name = "telefono", unique = true, nullable = false, length = 50)
    public String getTelefono() {
        return telefono;
    }

    /**
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.direccion);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.telefono);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Universidad other = (Universidad) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Universidad{" + "id=" + id + ", name=" + nombre+ ", direccion=" + direccion + ", email=" + email + ", telefono=" + telefono + '}';
    }
    
    
}
