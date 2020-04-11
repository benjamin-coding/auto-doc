package com.minwait.autodoc.controller;

import com.minwait.autodoc.controller.base.ApiBaseController;
import com.minwait.autodoc.entity.User;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * TestLoginController
 *
 * @author by xunmi
 * 2020/3/11 10:07
 * @version 1.0
 */
public class TestUserController extends ApiBaseController {


    @Test
    public void testPage() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users")
                .param("name", "")
                .param("username", "")
                .param("number", "1")
                .param("size", "10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("user_page",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestParameters(
                                parameterWithName("name").description("姓名"),
                                parameterWithName("username").description("用户名"),
                                parameterWithName("number").description("当前页码"),
                                parameterWithName("size").description("每页显示")
                        ),
                        responseFields(
                                fieldWithPath("status").description("状态码"),
                                fieldWithPath("message").description("状态描述"),
                                subsectionWithPath("data.dataList").description("数据列表"),
                                fieldWithPath("data.totalPages").description("总页数"),
                                fieldWithPath("data.totalElements").description("总数"),
                                fieldWithPath("data.number").description("页码，实际显示需要+1"),
                                fieldWithPath("data.size").description("每页显示")
                        )
                ));
    }


    @Test
    public void testGet() throws Exception {
        this.mockMvc.perform(RestDocumentationRequestBuilders.get("/users/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("user_get",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                parameterWithName("id").description("用户id")
                        ),
                        responseFields(
                                fieldWithPath("status").description("状态码"),
                                fieldWithPath("message").description("状态描述"),
                                fieldWithPath("data.id").description("用户id"),
                                fieldWithPath("data.name").description("姓名"),
                                fieldWithPath("data.username").description("用户名"),
                                fieldWithPath("data.password").description("密码")
                        )
                ));
    }

    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setName("demo");
        user.setUsername("admin");
        user.setPassword("1");
        this.mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("user_save",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        requestFields(
                                fieldWithPath("name").description("姓名"),
                                fieldWithPath("username").description("用户名"),
                                fieldWithPath("password").description("密码")
                        ),
                        responseFields(
                                fieldWithPath("status").description("状态码"),
                                fieldWithPath("message").description("状态描述"),
                                fieldWithPath("data").description("用户").type("User")
                        )
                ));
    }


    @Test
    public void testDelete() throws Exception {
        this.mockMvc.perform(RestDocumentationRequestBuilders.delete("/users/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("user_delete",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        pathParameters(
                                parameterWithName("id").description("用户id")
                        ),
                        responseFields(
                                fieldWithPath("status").description("状态码"),
                                fieldWithPath("message").description("状态描述")
                        )
                ));
    }
}
