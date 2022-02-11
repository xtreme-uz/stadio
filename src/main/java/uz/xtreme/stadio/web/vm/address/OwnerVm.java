package uz.xtreme.stadio.web.vm.address;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Value;

import java.util.List;

@Value
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OwnerVm {
    long id;
    String fullName;
    List<String> phoneNumbers;
    String email;
}
