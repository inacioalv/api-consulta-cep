package com.inacioalves.web.apiconsultacep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.inacioalves.web.apiconsultacep.clientFeign.CepService;
import com.inacioalves.web.apiconsultacep.model.Address;

@RestController
public class CepRestService {
	
	@Autowired
    private CepService cepService;

    @GetMapping("cep/{cep}")
    public ResponseEntity<Address> getCep(@PathVariable String cep) {

    	Address endereco = cepService.buscaEnderecoPorCep(cep);

        return endereco != null ? ResponseEntity.ok().body(endereco) : ResponseEntity.notFound().build(); 
    }

}
