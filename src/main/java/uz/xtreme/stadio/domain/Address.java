package uz.xtreme.stadio.domain;

import lombok.*;
import org.springframework.data.util.ProxyUtils;
import uz.xtreme.stadio.core.model.Pk;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "address", indexes = {
        @Index(name = "address", columnList = "region")
})
public class Address extends Pk {
    @Column(name = "region") private String region;
    @Column(name = "street") private String street;
    @Column(name = "zip_code") private String zipCode;
    @Column(name = "lat") private BigDecimal lat;
    @Column(name = "lng") private BigDecimal lng;

    @OneToMany
    @OrderBy("position")
    @JoinColumn(name = "address_id")
    private List<Image> images = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "address_category",
            joinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_slug", referencedColumnName = "slug"),
            indexes = @Index(name = "product_product_id_category_slug_idx", columnList = "address_id, category_slug"))
    private List<Category> categories = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || ProxyUtils.getUserClass(this) != ProxyUtils.getUserClass(o))
            return false;
        Address address = (Address) o;
        return getId() != null && Objects.equals(getId(), address.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
