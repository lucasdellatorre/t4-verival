package com.bcopstein.Emprestimos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class EmprestimoControllerTests {
    @Autowired private MockMvc mockMvc;

    @Test
    public void emprestimoJurosSimples() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/emprestimo/jurosSimples?valor=20&parcelas=4&taxa=0.03");
        MvcResult result =  mockMvc.perform(request).andReturn();
 
        String jsonString = 
        "{"
         + "\"segurado\":true,"
         + "\"jurosCompostos\":false," 
         + "\"valor\":20.0," 
         + "\"taxa\":0.03,"
         + "\"nroParcelas\":4,"
         + "\"valorTotal\":24.4,"
         + "\"valorParcela\":6.1"
        + "}";

        Assertions.assertEquals(jsonString, result.getResponse().getContentAsString());
    }

    @Test
    public void emprestimoJurosCompostos() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/emprestimo/jurosCompostos?valor=10&parcelas=3&taxa=0.03");
        MvcResult result =  mockMvc.perform(request).andReturn();
 
        String jsonString = 
        "{"
         + "\"segurado\":true,"
         + "\"jurosCompostos\":true," 
         + "\"valor\":10.0,"
         + "\"taxa\":0.03,"
         + "\"nroParcelas\":3,"
         + "\"valorTotal\":11.84864,"
         + "\"valorParcela\":3.9495466666666665"
        + "}";

        Assertions.assertEquals(jsonString, result.getResponse().getContentAsString());
    }
}