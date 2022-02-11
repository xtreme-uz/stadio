package uz.xtreme.stadio.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import uz.xtreme.stadio.service.MessageService;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageSource messageSource;

    @Override
    public String getMessageText(String code, String[] args, Locale locale) {
        return messageSource.getMessage(code, args, locale);
    }

}
