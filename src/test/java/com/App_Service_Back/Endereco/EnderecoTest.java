package com.App_Service_Back.Endereco;

import com.App_Service_Back.categoria.Categoria;
import com.App_Service_Back.endereco.Endereco;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.transaction.TestTransaction;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EnderecoTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Verificar se a rota de endereco está respondendo corretamente")
    void index() throws Exception{
        mockMvc.perform(get("/endereco")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
    @Test
    @DisplayName("Verifica se está criando um endereço")
    @Transactional
    @Rollback
    void create() throws Exception{
        Endereco enderecoExemplo = new Endereco();
        enderecoExemplo.setEndereco_rua("Rua Teste");
        enderecoExemplo.setEndereco_cep("88806080");
        enderecoExemplo.setEndereco_numero(8);
        enderecoExemplo.setEndereco_complemento("casa");
        enderecoExemplo.setEndereco_cidade("Criciúma");
        enderecoExemplo.setEndereco_estado("Santa Catarina");
        enderecoExemplo.setEndereco_bairro("Pio Corrêa");

        String JsonRequest = objectMapper.writeValueAsString(enderecoExemplo);

        mockMvc.perform(post("/endereco")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonRequest)).andExpect(status().isCreated());

        TestTransaction.end();
    }

    @Test
    @DisplayName("Verifica se está alterando o registro corretamente")
//    @Transactional
//    @Rollback
    void update() throws Exception{
        Endereco enderecoExemplo = new Endereco();
        enderecoExemplo.setEndereco_rua("Rua Abacate");
        enderecoExemplo.setEndereco_cep("888060dddd80");
        enderecoExemplo.setEndereco_numero(1);
        enderecoExemplo.setEndereco_complemento("casa");
        enderecoExemplo.setEndereco_cidade("Crizima");
        enderecoExemplo.setEndereco_estado("Santa ");
        enderecoExemplo.setEndereco_bairro("Pio Corrêa");

        String JsonRequest = objectMapper.writeValueAsString(enderecoExemplo);

        String response = mockMvc.perform(post("/endereco")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonRequest)).andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();

        JsonNode jsonNode = objectMapper.readTree(response);
        Long id = jsonNode.get("endereco_id").asLong();

        Endereco enderecoUpdate = new Endereco();
        enderecoUpdate.setEndereco_rua("Rua Teste");
        enderecoUpdate.setEndereco_cep("88806080");
        enderecoUpdate.setEndereco_numero(3);
        enderecoUpdate.setEndereco_complemento("casa");
        enderecoUpdate.setEndereco_cidade("Criciúma");
        enderecoUpdate.setEndereco_estado("Santa Catarina");
        enderecoUpdate.setEndereco_bairro("Pio Corrêa");
        enderecoUpdate.setEndereco_id(id);

        String jsonUpdateRequest = objectMapper.writeValueAsString(enderecoUpdate);

        mockMvc.perform(put("/endereco/"+id).contentType(MediaType.APPLICATION_JSON).content(jsonUpdateRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.endereco_cep").value("88806080"));

//        TestTransaction.end();
    }
}
