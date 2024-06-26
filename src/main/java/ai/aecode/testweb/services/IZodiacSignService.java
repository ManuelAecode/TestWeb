package ai.aecode.testweb.services;

import ai.aecode.testweb.entities.ZodiacSign;

import java.util.List;

public interface IZodiacSignService {
    public void insert(ZodiacSign zodiacsign);
    List<ZodiacSign> list();
    public void delete(int id_zodiac);
    public ZodiacSign listId(int id_zodiac);
}
