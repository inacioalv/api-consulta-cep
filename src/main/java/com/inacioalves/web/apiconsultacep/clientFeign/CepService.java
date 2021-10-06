package com.inacioalves.web.apiconsultacep.clientFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.inacioalves.web.apiconsultacep.model.Address;

@FeignClient(url= "https://viacep.com.br/ws/" , name = "viacep")
public interface CepService {

    @GetMapping("{cep}/json")
    Address buscaEnderecoPorCep(@PathVariable("cep") String cep);
}