package ai.aecode.testweb.controllers;

import ai.aecode.testweb.dtos.ZodiacSignDTO;
import ai.aecode.testweb.entities.ZodiacSign;
import ai.aecode.testweb.services.IZodiacSignService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/zodiacsign")
public class ZodiacSignController {

    @Autowired
    private IZodiacSignService zsS;

    @PostMapping
    public void insert(@RequestBody ZodiacSignDTO dto){
        ModelMapper m=new ModelMapper();
        ZodiacSign z= m.map(dto,ZodiacSign.class);
        zsS.insert(z);
    }

    @GetMapping
    public List<ZodiacSignDTO> list() {
        return zsS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ZodiacSignDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){zsS.delete(id);}

    @GetMapping("/{id}")
    public ZodiacSignDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        ZodiacSignDTO dto=m.map(zsS.listId(id),ZodiacSignDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody ZodiacSignDTO dto) {
        ModelMapper m = new ModelMapper();
        ZodiacSign z = m.map(dto, ZodiacSign.class);
        zsS.insert(z);
    }
}
