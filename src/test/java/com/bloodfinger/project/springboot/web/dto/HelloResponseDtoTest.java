package com.bloodfinger.project.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok_function_test(){
        String name = "양재우";
        int amount = 10;

        HelloResponseDto dto = new HelloResponseDto(name , amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
