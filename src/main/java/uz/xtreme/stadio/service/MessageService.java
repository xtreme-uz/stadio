package uz.xtreme.stadio.service;

import java.util.Locale;

public interface MessageService {
    String getMessageText(String code, String[] args, Locale locale);
}
