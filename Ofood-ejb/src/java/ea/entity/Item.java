/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jesus
 */
@Entity
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findById", query = "SELECT i FROM Item i WHERE i.id = :id"),
    @NamedQuery(name = "Item.findByName", query = "SELECT i FROM Item i WHERE i.name = :name"),
    @NamedQuery(name = "Item.findByPrice", query = "SELECT i FROM Item i WHERE i.price = :price"),
    @NamedQuery(name = "Item.findByDescription", query = "SELECT i FROM Item i WHERE i.description = :description"),
    @NamedQuery(name = "Item.findByITEMCATEGORYid", query = "SELECT i FROM Item i WHERE i.iTEMCATEGORYid = :iTEMCATEGORYid")})
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "price")
    private String price;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEM_CATEGORY_id")
    private int iTEMCATEGORYid;
    @JoinColumn(name = "ORDER_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Order oRDERid;
    @JoinColumn(name = "RESTAURANT_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Restaurant rESTAURANTid;

    public Item() {
    }

    public Item(Integer id) {
        this.id = id;
    }

    public Item(Integer id, String name, String price, int iTEMCATEGORYid) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.iTEMCATEGORYid = iTEMCATEGORYid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getITEMCATEGORYid() {
        return iTEMCATEGORYid;
    }

    public void setITEMCATEGORYid(int iTEMCATEGORYid) {
        this.iTEMCATEGORYid = iTEMCATEGORYid;
    }

    public Order getORDERid() {
        return oRDERid;
    }

    public void setORDERid(Order oRDERid) {
        this.oRDERid = oRDERid;
    }

    public Restaurant getRESTAURANTid() {
        return rESTAURANTid;
    }

    public void setRESTAURANTid(Restaurant rESTAURANTid) {
        this.rESTAURANTid = rESTAURANTid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ea.entity.Item[ id=" + id + " ]";
    }
    
}
