package ai.aecode.testweb.services;

import ai.aecode.testweb.entities.Skill;

import java.util.List;

public interface ISkillService {
    public void insert(Skill question);
    List<Skill> list();
    public void delete(int id_skill);
    public Skill listId(int id_skill);
}
