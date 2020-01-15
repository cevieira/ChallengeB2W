package com.apistarwars.services;

import com.apistarwars.entity.Planeta;
import com.apistarwars.entity.PlanetaAPI;
import com.apistarwars.entity.Planetas;
import com.apistarwars.repository.PlanetaRepository;
import com.apistarwars.services.exceptions.ObjectAlreadyExistsException;
import com.apistarwars.services.exceptions.ObjectNotFoundException;
import com.apistarwars.services.exceptions.ObjectRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class PlanetaService {

    @Autowired
    private PlanetaRepository repository;

    public List<Planeta> findAll(){

        return repository.findAll();
    }

    public Planeta findById(String id){
        Planeta planeta = repository.findOne(id);
        if (planeta == null){
            throw new ObjectNotFoundException("Planeta com o id informado não encontrado.");
        }
        return planeta;
    }

    public Planeta findByNome(String nome){
        Planeta planeta = repository.findyByNome(nome);
        if (planeta == null){
            throw new ObjectNotFoundException("Planeta o com nome informado não encontrado.");
        }
        return planeta;
    }

    public Planeta gravar(Planeta planeta){
       Integer filmes;
       if(repository.findyByNome(planeta.getNome()) != null){
           throw new ObjectAlreadyExistsException("Já existe um planeta cadastrado com o nome informado.");
       }
       filmes = getPlanetaAPI(planeta.getNome());
       planeta.setQuantidadeFilmes(filmes);
       return repository.insert(planeta);
    }

    public void deletarPorId(String id){
        findById(id);
        repository.delete(id);
    }

    public void deletarPorNome(String nome){
       Planeta planeta = findByNome(nome);
       repository.delete(planeta.getId());
    }

    public Integer getPlanetaAPI(String nome){
        Integer filmes;
        String URL_PLANETSAPI = "https://swapi.co/api/planets/?search=" + nome;
        RestTemplate restTemplate = new RestTemplate();


        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "HTTPie/1.0.0-dev");

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<Planetas> planetas = restTemplate.exchange(URL_PLANETSAPI, HttpMethod.GET, entity, Planetas.class);

        List<PlanetaAPI> listaPlanetaAPI = planetas.getBody().getResults();

        if (listaPlanetaAPI.size() > 0){
            PlanetaAPI planetaAPI = listaPlanetaAPI.get(0);
            filmes = planetaAPI.getFilms().size();
            return filmes;
        } else {
            return 0;
        }

    }
}
