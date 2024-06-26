package ai.aecode.testweb.servicesimplement;

import ai.aecode.testweb.entities.ZodiacSign;
import ai.aecode.testweb.repositories.IZodiacSignRepository;
import ai.aecode.testweb.services.IZodiacSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZodiacSignServiceImplement implements IZodiacSignService {
    @Autowired
    private IZodiacSignRepository zR;
    @Override
    public void insert(ZodiacSign zodiacsign) {
        zR.save(zodiacsign);
    }

    @Override
    public List<ZodiacSign> list() {
        return zR.findAll();
    }

    @Override
    public void delete(int id_zodiac) {
        zR.deleteById(id_zodiac);
    }

    @Override
    public ZodiacSign listId(int id_zodiac) {
        return zR.findById(id_zodiac).orElse(new ZodiacSign());
    }
}
