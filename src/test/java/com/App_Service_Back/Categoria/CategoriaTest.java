package com.App_Service_Back.Categoria;

import com.App_Service_Back.categoria.Categoria;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class CategoriaTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    @DisplayName("Verificar se a rota de categoria está respondendo corretamente")
    void index() throws Exception{
        mockMvc.perform(get("/categoria")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Verifica se está criando uma categoria")
    @Transactional
    @Rollback
    void create() throws Exception{
        Categoria categoriaExemplo = new Categoria();
        categoriaExemplo.setCategoria_nome("Jardinagem");
        categoriaExemplo.setCategoria_descricao("Corte de grama");

        String JsonRequest = objectMapper.writeValueAsString(categoriaExemplo);

        mockMvc.perform(post("/categoria")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonRequest)).andExpect(status().isCreated());

        TestTransaction.end();
    }

    @Test
    @DisplayName("Verifica se está alterando o registro corretamente")
    @Transactional
    @Rollback
    void update() throws Exception{
        Categoria categoriaExemplo = new Categoria();
        categoriaExemplo.setCategoria_nome("Pintora");
        categoriaExemplo.setCategoria_descricao("Servicus de Pintura");

        String JsonRequest = objectMapper.writeValueAsString(categoriaExemplo);

        String response = mockMvc.perform(post("/categoria")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonRequest)).andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();

        JsonNode jsonNode = objectMapper.readTree(response);
        Long id = jsonNode.get("categoria_id").asLong();

        Categoria categoriaUpdate = new Categoria();
        categoriaUpdate.setCategoria_nome("Pintura");
        categoriaUpdate.setCategoria_descricao("Serviços de Pintura");
        categoriaExemplo.setCategoria_id(id);

        String jsonUpdateRequest = objectMapper.writeValueAsString(categoriaUpdate);

        mockMvc.perform(put("/categoria/"+id).contentType(MediaType.APPLICATION_JSON).content(jsonUpdateRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categoria_nome").value("Pintura"));

        TestTransaction.end();
    }
}
