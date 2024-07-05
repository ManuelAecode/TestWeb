package ai.aecode.testweb.servicesimplement;

import ai.aecode.testweb.entities.*;
import ai.aecode.testweb.repositories.*;
import ai.aecode.testweb.services.IUserAnswerService;
import ai.aecode.testweb.services.IUserResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserAnswerServiceImplement implements IUserAnswerService {
    @Autowired
    private IUserAnswerRepository uaR;
    @Autowired
    private IUserProfileRepository upR;

    @Autowired
    private IPersonTypeRepository ptR;

    @Autowired
    private ISkillRepository sR;

    @Override
    public void insert(UserAnswer useranswer) {
        uaR.save(useranswer);
    }

    @Override
    public List<UserAnswer> list() {
        return uaR.findAll();
    }

    @Override
    public void delete(int id_useranswer) {
        uaR.deleteById(id_useranswer);
    }

    @Override
    public UserAnswer listId(int id_useranswer) {
        return uaR.findById(id_useranswer).orElse(new UserAnswer());
    }

    @Override
    public UserResult processUserAnswersAndSaveResult(String email) {
        // Obtener el perfil del usuario por ID
        UserProfile userProfile = upR.findUser(email);

        // Obtener las respuestas del usuario
        List<UserAnswer> userAnswers = uaR.findByUserProfile(userProfile);



        // Calcular los resultados
        double Manager = 1.0;
        double Developer = 1.0;
        double Executor = 1.0;

        // Obtener el signo zodiacal del usuario
        ZodiacSign zodiacSign = userProfile.getZodiacsign();
        String signName = zodiacSign.getSign_name();

        // Obtener la fecha de nacimiento del usuario
        LocalDate birthday = userProfile.getUser_birthday();
        // Calcular la edad del usuario
        int age = Period.between(birthday, LocalDate.now()).getYears();

        // Definir los puntajes basados en la edad del usuario
        double birthday_manager = 0.0;
        double birthday_developer = 0.0;
        double birthday_executor = 0.0;

        //obtener el genero del usuario:
        String gender= userProfile.getUser_gender();
        //Definir los puntajes basados en el genero del usuario
        double gender_manager = 0.0;
        double gender_developer = 0.0;
        double gender_executor = 0.0;

        if(signName.equals("Aries")) {
            // Asignar los puntajes según la edad del usuario
            if (age >= 18 && age <= 25) {
                birthday_manager = 70;
                birthday_developer = 75;
                birthday_executor = 60;
            } else if (age > 25 && age <= 35) {
                birthday_manager = 80;
                birthday_developer = 65;
                birthday_executor = 65;
            } else if (age > 35) {
                birthday_manager = 90;
                birthday_developer = 60;
                birthday_executor = 75;
            }

            // Asignar los puntajes según el genero del usuario
            if(gender.equals("Masculino")){
                gender_manager = 75;
                gender_developer = 80;
                gender_executor = 70;
            }else if(gender.equals("Femenino")){
                gender_manager = 85;
                gender_developer = 75;
                gender_executor = 65;
            }
        } else if (signName.equals("Tauro")) {
            // Asignar los puntajes según la edad del usuario
            if (age >= 18 && age <= 25) {
                birthday_manager = 70;
                birthday_developer = 80;
                birthday_executor = 65;
            } else if (age > 25 && age <= 35) {
                birthday_manager = 80;
                birthday_developer = 75;
                birthday_executor = 70;
            } else if (age > 35) {
                birthday_manager = 90;
                birthday_developer = 65;
                birthday_executor = 80;
            }

            // Asignar los puntajes según el genero del usuario
            if(gender.equals("Masculino")){
                gender_manager = 75;
                gender_developer = 80;
                gender_executor = 65;
            }else if(gender.equals("Femenino")){
                gender_manager = 85;
                gender_developer = 75;
                gender_executor = 70;
            }

        }else if (signName.equals("Geminis")) {
            // Asignar los puntajes según la edad del usuario
            if (age >= 18 && age <= 25) {
                birthday_manager = 55;
                birthday_developer = 85;
                birthday_executor = 55;
            } else if (age > 25 && age <= 35) {
                birthday_manager = 70;
                birthday_developer = 75;
                birthday_executor = 60;
            } else if (age > 35) {
                birthday_manager = 85;
                birthday_developer = 60;
                birthday_executor = 75;
            }

            // Asignar los puntajes según el genero del usuario
            if(gender.equals("Masculino")){
                gender_manager = 70;
                gender_developer = 90;
                gender_executor = 65;
            }else if(gender.equals("Femenino")){
                gender_manager = 80;
                gender_developer = 70;
                gender_executor = 60;
            }

        }else if (signName.equals("Cancer")) {
            // Asignar los puntajes según la edad del usuario
            if (age >= 18 && age <= 25) {
                birthday_manager = 65;
                birthday_developer = 70;
                birthday_executor = 65;
            } else if (age > 25 && age <= 35) {
                birthday_manager = 75;
                birthday_developer = 65;
                birthday_executor = 70;
            } else if (age > 35) {
                birthday_manager = 90;
                birthday_developer = 55;
                birthday_executor = 80;
            }

            // Asignar los puntajes según el genero del usuario
            if(gender.equals("Masculino")){
                gender_manager = 70;
                gender_developer = 70;
                gender_executor = 60;
            }else if(gender.equals("Femenino")){
                gender_manager = 85;
                gender_developer = 75;
                gender_executor = 00;
            }


        }else if (signName.equals("Leo")) {
            // Asignar los puntajes según la edad del usuario
            if (age >= 18 && age <= 25) {
                birthday_manager = 75;
                birthday_developer = 70;
                birthday_executor = 65;
            } else if (age > 25 && age <= 35) {
                birthday_manager = 85;
                birthday_developer = 60;
                birthday_executor = 70;
            } else if (age > 35) {
                birthday_manager = 95;
                birthday_developer = 55;
                birthday_executor = 80;
            }

            // Asignar los puntajes según el genero del usuario
            if(gender.equals("Masculino")){
                gender_manager = 80;
                gender_developer = 70;
                gender_executor = 65;
            }else if(gender.equals("Femenino")){
                gender_manager = 90;
                gender_developer = 75;
                gender_executor = 70;
            }


        }else if (signName.equals("Virgo")) {
            // Asignar los puntajes según la edad del usuario
            if (age >= 18 && age <= 25) {
                birthday_manager = 70;
                birthday_developer = 85;
                birthday_executor = 70;
            } else if (age > 25 && age <= 35) {
                birthday_manager = 80;
                birthday_developer = 80;
                birthday_executor = 75;
            } else if (age > 35) {
                birthday_manager = 90;
                birthday_developer = 70;
                birthday_executor = 80;
            }

            // Asignar los puntajes según el genero del usuario
            if(gender.equals("Masculino")){
                gender_manager = 85;
                gender_developer = 80;
                gender_executor = 75;
            }else if(gender.equals("Femenino")){
                gender_manager = 75;
                gender_developer = 85;
                gender_executor = 70;
            }

        }else if (signName.equals("Libra")) {
            // Asignar los puntajes según la edad del usuario
            if (age >= 18 && age <= 25) {
                birthday_manager = 60;
                birthday_developer = 75;
                birthday_executor = 65;
            } else if (age > 25 && age <= 35) {
                birthday_manager = 75;
                birthday_developer = 70;
                birthday_executor = 70;
            } else if (age > 35) {
                birthday_manager = 90;
                birthday_developer = 60;
                birthday_executor = 75;
            }

            // Asignar los puntajes según el genero del usuario
            if(gender.equals("Masculino")){
                gender_manager = 75;
                gender_developer = 85;
                gender_executor = 70;
            }else if(gender.equals("Femenino")){
                gender_manager = 85;
                gender_developer =75;
                gender_executor = 65;
            }

        }else if (signName.equals("Escorpio")) {
            // Asignar los puntajes según la edad del usuario
            if (age >= 18 && age <= 25) {
                birthday_manager = 65;
                birthday_developer = 75;
                birthday_executor = 65;
            } else if (age > 25 && age <= 35) {
                birthday_manager = 75;
                birthday_developer = 65;
                birthday_executor = 70;
            } else if (age > 35) {
                birthday_manager = 90;
                birthday_developer = 60;
                birthday_executor = 80;
            }

            // Asignar los puntajes según el genero del usuario
            if(gender.equals("Masculino")){
                gender_manager = 70;
                gender_developer = 70;
                gender_executor = 60;
            }else if(gender.equals("Femenino")){
                gender_manager = 85;
                gender_developer = 75;
                gender_executor = 70;
            }

        }else if (signName.equals("Sagitario")) {
            // Asignar los puntajes según la edad del usuario
            if (age >= 18 && age <= 25) {
                birthday_manager = 70;
                birthday_developer = 80;
                birthday_executor = 65;
            } else if (age > 25 && age <= 35) {
                birthday_manager = 75;
                birthday_developer = 70;
                birthday_executor = 70;
            } else if (age > 35) {
                birthday_manager = 85;
                birthday_developer = 65;
                birthday_executor = 75;
            }

            // Asignar los puntajes según el genero del usuario
            if(gender.equals("Masculino")){
                gender_manager = 75;
                gender_developer = 80;
                gender_executor = 65;
            }else if(gender.equals("Femenino")){
                gender_manager = 85;
                gender_developer = 70;
                gender_executor = 70;
            }

        }else if (signName.equals("Capricornio")) {
            // Asignar los puntajes según la edad del usuario
            if (age >= 18 && age <= 25) {
                birthday_manager = 75;
                birthday_developer = 80;
                birthday_executor = 70;
            } else if (age > 25 && age <= 35) {
                birthday_manager = 85;
                birthday_developer = 70;
                birthday_executor = 75;
            } else if (age > 35) {
                birthday_manager = 95;
                birthday_developer = 65;
                birthday_executor = 80;
            }

            // Asignar los puntajes según el genero del usuario
            if(gender.equals("Masculino")){
                gender_manager = 80;
                gender_developer = 80;
                gender_executor = 65;
            }else if(gender.equals("Femenino")){
                gender_manager = 90;
                gender_developer = 75;
                gender_executor = 70;
            }

        }else if (signName.equals("Acuario")) {
            // Asignar los puntajes según la edad del usuario
            if (age >= 18 && age <= 25) {
                birthday_manager = 50;
                birthday_developer = 90;
                birthday_executor = 60;
            } else if (age > 25 && age <= 35) {
                birthday_manager = 65;
                birthday_developer = 85;
                birthday_executor = 65;
            } else if (age > 35) {
                birthday_manager = 80;
                birthday_developer = 70;
                birthday_executor = 80;
            }

            // Asignar los puntajes según el genero del usuario
            if(gender.equals("Masculino")){
                gender_manager = 65;
                gender_developer = 90;
                gender_executor = 70;
            }else if(gender.equals("Femenino")){
                gender_manager = 75;
                gender_developer = 65;
                gender_executor = 70;
            }

        }else if (signName.equals("Piscis")) {
            // Asignar los puntajes según la edad del usuario
            if (age >= 18 && age <= 25) {
                birthday_manager = 70;
                birthday_developer = 65;
                birthday_executor = 65;
            } else if (age > 25 && age <= 35) {
                birthday_manager = 75;
                birthday_developer = 60;
                birthday_executor = 70;
            } else if (age > 35) {
                birthday_manager = 90;
                birthday_developer = 55;
                birthday_executor = 75;
            }

            // Asignar los puntajes según el genero del usuario
            if(gender.equals("Masculino")){
                gender_manager = 75;
                gender_developer = 70;
                gender_executor = 60;
            }else if(gender.equals("Femenino")){
                gender_manager = 85;
                gender_developer = 70;
                gender_executor = 65;
            }
        }

        double percentage_age=0.55;
        double percentage_gender=0.45;

        //valores de los personajes segun edad y genero
        double value_manager=(birthday_manager*percentage_age)+(gender_manager*percentage_gender);
        double value_developer=(birthday_developer*percentage_age)+(gender_developer*percentage_gender);
        double value_executor=(birthday_executor*percentage_age)+(gender_executor*percentage_gender);


        for (UserAnswer userAnswer : userAnswers) {
            for (Answer answer : userAnswer.getAnswer()) {
                Manager *= answer.getValue_manager();
                Developer *= answer.getValue_developer();
                Executor *= answer.getValue_executor();
            }
        }
        double totalManager =value_manager * Manager;
        double totalDeveloper = value_developer * Developer;
        double totalExecutor = value_executor * Executor;

        double totalSum = totalManager + totalDeveloper + totalExecutor;
        double percentageManager = (totalManager*100)/(totalSum);
        double percentageDeveloper = (totalDeveloper*100)/(totalSum);
        double percentageExecutor = (totalExecutor*100)/(totalSum);;
        // Redondear a un decimal
        percentageManager = Math.round(percentageManager * 10.0) / 10.0;
        percentageDeveloper = Math.round(percentageDeveloper * 10.0) / 10.0;
        percentageExecutor = Math.round(percentageExecutor * 10.0) / 10.0;

        // Determinar el tipo de persona (PersonType)
        PersonType personType;
        String personTypeDescription;

        if (percentageManager > percentageDeveloper && percentageManager > percentageExecutor) {
            personType = ptR.findByPersonTypeName("Gestor");
            personTypeDescription = "Persona con habilidades predominantes de Gestor";
        } else if (percentageDeveloper > percentageManager && percentageDeveloper > percentageExecutor) {
            personType = ptR.findByPersonTypeName("Desarrollador");
            personTypeDescription = "Persona con habilidades predominantes de Desarrollador";
        } else {
            personType = ptR.findByPersonTypeName("Ejecutor");
            personTypeDescription = "Persona con habilidades predominantes de Ejecutor";
        }

        //SKILLS
        // Crear y guardar las Skills asociadas al UserResult
        Set<Skill> skills = new HashSet<>();
        for (UserAnswer userAnswer : userAnswers) {
            for (Answer answer : userAnswer.getAnswer()) {
                int maxValue = Math.max(answer.getValue_skill_manager(),
                        Math.max(answer.getValue_skill_developer(), answer.getValue_skill_executor()));
                Skill skill = new Skill();
                skill.setSkill_name(answer.getQuestion().getSkill().getSkill_name());
                skill.setFinal_score(maxValue);
                skills.add(skill);
            }
        }


        // Crear y devolver el objeto UserResult
        UserResult userResult = new UserResult();
        userResult.setUserProfile(userProfile);
        userResult.setPersonType(personType);
        userResult.setResult_manager(percentageManager);
        userResult.setResult_developer(percentageDeveloper);
        userResult.setResult_executor(percentageExecutor);
        userResult.setPerson_type_description(personTypeDescription);

        // Agregar las skills al UserResult
        userResult.setSkill(skills);
        return userResult;
    }
}
