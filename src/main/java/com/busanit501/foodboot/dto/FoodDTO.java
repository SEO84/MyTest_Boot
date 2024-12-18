package com.busanit501.foodboot.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {

    private  Long fno;
    @NotEmpty
    @Size(min = 3, max = 100)
    private  String fname;
    @NotEmpty
    private  String fdesc;
    @NotEmpty
    private  String chef;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}
