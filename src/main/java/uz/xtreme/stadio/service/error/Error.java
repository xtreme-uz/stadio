package uz.xtreme.stadio.service.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public abstract class Error {
    @JsonProperty("type") private final ErrorType type;
    @JsonProperty("message_code") private final String messageCode;

    protected Error(ErrorType type, String messageCode) {
        this.type = type;
        this.messageCode = messageCode;
    }
}

