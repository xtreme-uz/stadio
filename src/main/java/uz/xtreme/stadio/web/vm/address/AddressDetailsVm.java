package uz.xtreme.stadio.web.vm.address;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Value;
import uz.xtreme.stadio.web.vm.image.ImageVm;

import java.math.BigDecimal;
import java.util.List;

@Value
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddressDetailsVm {
    Long id;
    String region;
    String street;
    String zipCode;
    BigDecimal lat;
    BigDecimal lng;
    String description;
    OwnerVm owner;
    List<ImageVm> images;
}
