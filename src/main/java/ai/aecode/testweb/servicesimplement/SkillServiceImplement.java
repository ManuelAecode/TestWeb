package ai.aecode.testweb.servicesimplement;

import ai.aecode.testweb.entities.Skill;
import ai.aecode.testweb.repositories.ISkillRepository;
import ai.aecode.testweb.services.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImplement implements ISkillService {
    @Autowired
    private ISkillRepository sR;
    @Override
    public void insert(Skill question) {
        sR.save(question);
    }

    @Override
    public List<Skill> list() {
        return sR.findAll();
    }

    @Override
    public void delete(int id_skill) {
        sR.deleteById(id_skill);
    }

    @Override
    public Skill listId(int id_skill) {
        return sR.findById(id_skill).orElse(new Skill());
    }
}
