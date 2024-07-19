package ai.aecode.testweb.servicesimplement;

import ai.aecode.testweb.entities.*;
import ai.aecode.testweb.repositories.*;
import ai.aecode.testweb.services.IUserAnswerService;
import ai.aecode.testweb.services.IUserResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserAnswerServiceImplement implements IUserAnswerService {
    @Autowired
    private IUserAnswerRepository uaR;
    @Autowired
    private IUserProfileRepository upR;

    @Autowired
    private IPersonTypeRepository ptR;

    @Autowired
    private IPerson_ZodiacRepository pzR;

    @Autowired
    private ISkillRepository sR;

    @Override
    public void insert(UserAnswer useranswer) {

        // Buscar el perfil del usuario por correo electrónico
        String email = useranswer.getUserProfile().getUser_email();
        UserProfile userProfile = upR.findByUserEmail(email);

        if (userProfile != null) {
            // Obtener las respuestas anteriores y eliminarlas
            List<UserAnswer> existingUserAnswers = uaR.findByUserProfile(userProfile);
            if (!existingUserAnswers.isEmpty()) {
                uaR.deleteAll(existingUserAnswers);
            }

            // Asociar el perfil del usuario existente a las nuevas respuestas
            useranswer.setUserProfile(userProfile);
        } else {
            throw new RuntimeException("No se encontró el perfil del usuario");
        }

        // Guardar las nuevas respuestas del usuario
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
        // Obtener el perfil del usuario por email
        UserProfile userProfile = upR.findByUserEmail(email);

        // Obtener las respuestas del usuario
        List<UserAnswer> userAnswers = uaR.findByUserProfile(userProfile);



        // Calcular los resultados
        double Manager = 0.0;
        double Developer = 0.0;
        double Executor = 0.0;

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

        }else if (signName.equals("Géminis")) {
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

        }else if (signName.equals("Cáncer")) {
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
                gender_executor = 70;
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
        double value_manager_pesos=(birthday_manager*percentage_age)+(gender_manager*percentage_gender);
        double value_developer_pesos=(birthday_developer*percentage_age)+(gender_developer*percentage_gender);
        double value_executor_pesos=(birthday_executor*percentage_age)+(gender_executor*percentage_gender);


        for (UserAnswer userAnswer : userAnswers) {
            for (Answer answer : userAnswer.getAnswer()) {
                Manager += answer.getValue_manager();
                Developer += answer.getValue_developer();
                Executor += answer.getValue_executor();
            }
        }
        double totalManager =value_manager_pesos * Manager;
        double totalDeveloper = value_developer_pesos * Developer;
        double totalExecutor = value_executor_pesos * Executor;

        double totalSum = totalManager + totalDeveloper + totalExecutor;
        double percentageManager = ((totalManager*100)/(totalSum));
        double percentageDeveloper = ((totalDeveloper*100)/(totalSum));
        double percentageExecutor = ((totalExecutor*100)/(totalSum));;

        // Redondear a un número entero utilizando Math.round
        int roundedPercentageManager = (int) Math.round(percentageManager);
        int roundedPercentageDeveloper = (int) Math.round(percentageDeveloper);
        int roundedPercentageExecutor = (int) Math.round(percentageExecutor);

        // Asignar los valores redondeados de vuelta a los porcentajes
        percentageManager = roundedPercentageManager;
        percentageDeveloper = roundedPercentageDeveloper;
        percentageExecutor = roundedPercentageExecutor;
        // Convertir los valores a enteros
        int finalPercentageManager = (int) percentageManager;
        int finalPercentageDeveloper = (int) percentageDeveloper;
        int finalPercentageExecutor = (int) percentageExecutor;


        // Determinar el tipo de persona (PersonType)
        String personTypeName = "";
        String personTypeDescription="";
        int d=20;
        double max_percentage = Math.max(percentageManager, Math.max(percentageDeveloper, percentageExecutor));

        // Determinar el tipo de persona basado en los porcentajes
        if (max_percentage == finalPercentageManager) {
            if (max_percentage - finalPercentageDeveloper <= d) {
                if (max_percentage - finalPercentageExecutor <= d) {
                    personTypeName = "Equilibrado";
                } else {
                    personTypeName = "Gestor - Desarrollador";
                }
            } else {
                if (max_percentage - finalPercentageExecutor <= d) {
                    personTypeName = "Gestor - Ejecutor";
                } else {
                    personTypeName = "Gestor";
                }
            }
        } else if (max_percentage == finalPercentageDeveloper) {
            if (max_percentage - finalPercentageManager <= d) {
                if (max_percentage - finalPercentageExecutor <= d) {
                    personTypeName = "Equilibrado";
                } else {
                    personTypeName = "Gestor - Desarrollador";
                }
            } else {
                if (max_percentage - finalPercentageExecutor <= d) {
                    personTypeName = "Ejecutor - Desarrollador";
                } else {
                    personTypeName = "Desarrollador";
                }
            }
        } else if (max_percentage == finalPercentageExecutor) {
            if (max_percentage - finalPercentageDeveloper <= d) {
                if (max_percentage - finalPercentageManager <= d) {
                    personTypeName = "Equilibrado";
                } else {
                    personTypeName = "Ejecutor - Desarrollador";
                }
            } else {
                if (max_percentage - finalPercentageManager <= d) {
                    personTypeName = "Gestor - Ejecutor";
                } else {
                    personTypeName = "Ejecutor";
                }
            }
        }


        // Obtener el tipo de persona desde la base de datos
        PersonType personType = ptR.findByPersonTypeName(personTypeName);

        // Buscar la descripción en la base de datos
        Person_Zodiac personZodiac = pzR.findByPersonTypeAndZodiacSign(personType, zodiacSign);

        // Verificar y asignar la descripción
        if (personZodiac != null) {
            personTypeDescription = personZodiac.getDescription();
        } else {
            personTypeDescription = "Descripción no encontrada";
        }

        double skill_peso_manager=(percentageManager*0.8)/(max_percentage);
        double skill_peso_developer=(percentageDeveloper*0.8)/(max_percentage);
        double skill_peso_executor=(percentageExecutor*0.8)/(max_percentage);

        /////////////////////////////////////////////////////////////

        // Crear mapas para almacenar las habilidades por respuesta
        Map<String, Integer> skillScoresManager = new HashMap<>();
        Map<String, Integer> skillScoresDeveloper = new HashMap<>();
        Map<String, Integer> skillScoresExecutor = new HashMap<>();

        // Calcular las habilidades finales por respuesta
        for (UserAnswer userAnswer : userAnswers) {
            for (Answer answer : userAnswer.getAnswer()) {
                double skill_manager = answer.getValue_skill_manager() * skill_peso_manager*100;
                double skill_developer = answer.getValue_skill_developer() * skill_peso_developer*100;
                double skill_executor = answer.getValue_skill_executor() * skill_peso_executor*100;

                ///////////////////////

                // Redondear a un número entero utilizando Math.round
                int roundedFinalSkillManager = (int) Math.round(skill_manager);
                int roundedFinalSkillDeveloper = (int) Math.round(skill_developer);
                int roundedFinalSkillExecutor = (int) Math.round(skill_executor);
                // Asignar los valores redondeados de vuelta a los porcentajes
                skill_manager = roundedFinalSkillManager;
                skill_developer = roundedFinalSkillDeveloper;
                skill_executor = roundedFinalSkillExecutor;

                // Convertir los valores a enteros
                int final_skill_manager = (int) skill_manager;
                int final_skill_developer = (int) skill_developer;
                int final_skill_executor = (int) skill_executor;


                ///////////////////////

                // Determinar el valor máximo para cada habilidad
                double maxSkillValue = Math.max(final_skill_manager, Math.max(final_skill_developer, final_skill_executor));

                String skillName = answer.getQuestion().getSkill().getSkill_name();

                // Asignar el puntaje final a la habilidad en base al máximo
                if (maxSkillValue == final_skill_manager) {
                    skillScoresManager.put(skillName, final_skill_manager);
                } else if (maxSkillValue == final_skill_developer) {
                    skillScoresDeveloper.put(skillName, final_skill_developer);
                } else {
                    skillScoresExecutor.put(skillName, final_skill_executor);
                }
            }
        }

        // Obtener las habilidades del Hemisferio Derecho e Izquierdo
        List<Skill> hemisferioDerecho = new ArrayList<>();
        List<Skill> hemisferioIzquierdo = new ArrayList<>();

        // Clasificar las habilidades en hemisferios
        for (Map.Entry<String, Integer> entry : skillScoresManager.entrySet()) {
            Skill skill = sR.findBySkillName(entry.getKey());
            if (skill != null) {
                skill.setFinal_score(entry.getValue());
                if (isHemisferioDerecho(skill.getSkill_name())) {
                    hemisferioDerecho.add(skill);
                } else {
                    hemisferioIzquierdo.add(skill);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : skillScoresDeveloper.entrySet()) {
            Skill skill = sR.findBySkillName(entry.getKey());
            if (skill != null) {
                skill.setFinal_score(entry.getValue());
                if (isHemisferioDerecho(skill.getSkill_name())) {
                    hemisferioDerecho.add(skill);
                } else {
                    hemisferioIzquierdo.add(skill);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : skillScoresExecutor.entrySet()) {
            Skill skill = sR.findBySkillName(entry.getKey());
            if (skill != null) {
                skill.setFinal_score(entry.getValue());
                if (isHemisferioDerecho(skill.getSkill_name())) {
                    hemisferioDerecho.add(skill);
                } else {
                    hemisferioIzquierdo.add(skill);
                }
            }
        }
        // Obtener las 3 habilidades más relevantes de cada hemisferio
        List<Skill> topSkillsDerecho = hemisferioDerecho.stream()
                .sorted(Comparator.comparingDouble(Skill::getFinal_score).reversed())
                .limit(3)
                .collect(Collectors.toList());

        List<Skill> topSkillsIzquierdo = hemisferioIzquierdo.stream()
                .sorted(Comparator.comparingDouble(Skill::getFinal_score).reversed())
                .limit(3)
                .collect(Collectors.toList());

        //////////////////////////////////////////////////////////////

        // Crear y devolver el objeto UserResult
        UserResult userResult = new UserResult();
        userResult.setUserProfile(userProfile);
        userResult.setPersonType(personType);
        userResult.setResult_manager(finalPercentageManager);
        userResult.setResult_developer(finalPercentageDeveloper);
        userResult.setResult_executor(finalPercentageExecutor);
        userResult.setPerson_type_description(personTypeDescription);

        // Agregar las skills al UserResult
        userResult.setSkillderecho(new HashSet<>(topSkillsDerecho));
        userResult.setSkillizquierdo(new HashSet<>(topSkillsIzquierdo));

        return userResult;
    }
    // Método auxiliar para determinar si una habilidad pertenece al Hemisferio Derecho
    private boolean isHemisferioDerecho(String skillName) {
        return skillName.equals("Creatividad") || skillName.equals("Resiliencia") ||
                skillName.equals("Pensamiento Crítico") || skillName.equals("Comunicación Efectiva") ||
                skillName.equals("Adaptabilidad") || skillName.equals("Coordinación y Organización");
    }

    // Método auxiliar para determinar si una habilidad pertenece al Hemisferio Izquierdo
    private boolean isHemisferioIzquierdo(String skillName) {
        return skillName.equals("Pensamiento Lógico") || skillName.equals("Precisión y Atención al Detalle") ||
                skillName.equals("Resolución de Problemas Técnicos") || skillName.equals("Manejo de Herramientas") ||
                skillName.equals("Planificación Estratégica") || skillName.equals("Gestión de Recursos");
    }
}
