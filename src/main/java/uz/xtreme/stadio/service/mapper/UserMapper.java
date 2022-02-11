package uz.xtreme.stadio.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.util.StringUtils;
import uz.xtreme.stadio.domain.User;
import uz.xtreme.stadio.web.vm.address.OwnerVm;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "fullName", source = ".", qualifiedByName = "getFullName")
    OwnerVm asOwnerVm(User user);

    @Named("getFullName")
    default String getFullName(User user) {
        String result = user.getUsername();

        if (StringUtils.hasText(user.getFirstName())) {
            result = user.getFirstName();

            if (StringUtils.hasText(user.getLastName())) {
                result += " " + user.getLastName();
            }
        }


        return result;
    }

}
